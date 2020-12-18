package main.logica.nivel.oleada_enemigos.state;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;
import java.awt.Point;

import main.logica.model.infectado.Infectado;
import main.logica.model.infectado.factory.InfectadoFactory;
import main.logica.nivel.oleada_enemigos.entry.EntryImpl;
import properties.JugadorProperties;
import properties.MapaProperties;

public abstract class OleadaEnemigosState {
    
    protected InfectadoFactory factoryInfectados;

    protected int cantEnemigosActivos;//dificultad
    protected int cantOleadas;//duracion
    protected int oleadasCompletadas;//variable para testeas que se haya completado la oleada

    /**
     * Lista la cual guarda referencia de los infectados activos actualmente.
     * Cada entrada poseer un integer y un infectado:
     * Integer: Guarda el index para saber en que posicion del mapa se encuentra el infectado.
     * Infectado: Referencia al infectado correspondiente.
     * 
     * Para saber mas sobre el index y la posicion de los enemigos mirar {@link #posicionesInfectados}
     */
    protected List<Entry<Integer, Infectado>> enemigosActivos;

    /**
     * Indica las posibles posiciones donde es posible crear un infectado.
     * Map< index, Entry< posX, existe>>
     * index: Simplemente para organizar.
     * posX: Indica la posicion en el ejeX en la que se puede crear correspondiente al index.
     * existe: booleano el cual indica si hay un infectado creado en esa posicion actualmente.
     */
    protected Map<Integer, Entry<Integer, Boolean>> posicionesInfectados;

    protected OleadaEnemigosState() {
        factoryInfectados = InfectadoFactory.getInstance();
        enemigosActivos = new LinkedList<Entry<Integer, Infectado>>();

        posicionesInfectados = new HashMap<Integer, Entry<Integer, Boolean>>();
        this.inicializarPosicionesInfectados();

        this.oleadasCompletadas = 0;
    }

    /**
     * Se encarga de inicializar el atributo posicionesInfectados.
     */
    protected void inicializarPosicionesInfectados() {
        int posXInicial = 5;
        int distanciamientoEntreInfectado = JugadorProperties.WIDTH.getValor() + 10;

        int cantCeldas = ((MapaProperties.WIDTH.getValor() - JugadorProperties.WIDTH.getValor()) - posXInicial) / 
                         (distanciamientoEntreInfectado);
        //Despues reemplazar el jugadorProperties por el InfectadoProperties          
        
        int posX = posXInicial;

        for (int index = 1; index <= cantCeldas; index++) {
            Entry<Integer, Boolean> entry = new EntryImpl<Integer, Boolean>(posX, false);
            
            posicionesInfectados.put(index, entry);

            posX += distanciamientoEntreInfectado;
        }
    }

    /**
     * Consulta si el state tiene un nivel a continuacion del actual.
     * @return True en caso de que tenga proximo nivel, false en caso contrario.
     */
    public abstract boolean hasNextLevel();

    /**
     * Inicializa la oleada correspondiente al nivel proximo del actual.
     */
    public abstract void empezarOleadaProximoNivel();

    /**
     * Consulta si la oleada del nivel actual ya ha sido completada.
     * @return  True en caso de que se haya completado el nivel, false en caso contrario.
     */
    public boolean isLevelComplete() {
        boolean isComplete = (oleadasCompletadas == cantOleadas);

        return isComplete;
    }

    /**
     * Se encarga de insertar o eliminar enemigos de la oleada actual segun corresponda.
     */
    public void update() {
        
        if (!enemigosActivos.isEmpty()) {//Si hay enemigos "vivos"

            for (Entry<Integer, Infectado> entry : enemigosActivos) {
                Infectado infectado = entry.getValue();
                int indexInfectado = entry.getKey();

                if (true/*!infectado.isAlive()*/) {
                    enemigosActivos.remove(entry);//elimino al infectado de la lista de infectados activos
                    posicionesInfectados.get(indexInfectado).setValue(false);//Libero su posicion en el mapa.
                }
            }

            if (enemigosActivos.isEmpty() && (oleadasCompletadas < cantOleadas)) {
                oleadasCompletadas++;
                this.generarInfectados();
            }
        }
        else {
            System.out.println("Nivel completado: "+ (oleadasCompletadas == cantOleadas) );
        }
        
    }

    /**
     * Se encarga de generar los infectados para la oleada del nivel correspondiente.
     */
    protected void generarInfectados() {
        
        Random rnd = new Random();
        int posY = 0;
        int indexPosicion;
        boolean encontroLugar;

        for (int i = 0; i < cantEnemigosActivos; i++) {

            encontroLugar = false;
            while (!encontroLugar) {

                indexPosicion = rnd.nextInt(posicionesInfectados.size()) + 1;
                Entry<Integer, Boolean> entry = posicionesInfectados.get(indexPosicion);

                if (entry.getValue() == false) {//Si no hay un infectado en esta posicion

                    encontroLugar = true;
                    int posX = entry.getKey();
                    Point posCreacion = new Point(posX, posY);

                    Infectado infectadoNuevo = factoryInfectados.createInfectado(posCreacion);
                    enemigosActivos.add( new EntryImpl<Integer, Infectado>(indexPosicion, infectadoNuevo) );
                    entry.setValue(true);//indica que se ha generado un infectado en esta posicion.
                }
            }        
             
        }
        
    }
}
