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
import properties.MapaProperties;

public abstract class OleadaEnemigosState {
    
    protected InfectadoFactory factoryInfectados;
    protected List<Infectado> enemigosActivos;
    protected int cantEnemigosActivos;//dificultad
    protected int cantOleadas;//duracion
    protected int oleadasCompletadas;//variable para testeas que se haya completado la oleada

    /**
     * Indica las posibles posiciones donde es posible crear un infectado.
     * Map<index, Entry<posX, existe>>
     * index: Simplemente para organizar.
     * posX: Indica la posicion en el ejeX en la que se puede crear correspondiente al index.
     * existe: booleano el cual indica si hay un infectado creado en esa posicion actualmente.
     */
    protected Map<Integer, Entry<Integer, Boolean>> posicionesInfectados;

    protected OleadaEnemigosState() {
        factoryInfectados = InfectadoFactory.getInstance();
        enemigosActivos = new LinkedList<Infectado>();
        oleadasCompletadas = 0;
        posicionesInfectados = new HashMap<Integer, Entry<Integer, Boolean>>();
        this.inicializarPosicionesInfectados();
    }

    /**
     * Se encarga de inicializar el atributo posicionesInfectados.
     */
    protected void inicializarPosicionesInfectados() {

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

            for (Infectado infectado : enemigosActivos) {
                /*if (!infectado.isAlive()) {
                    int posXInfectado = infectado.getPosicion().getX();
                    enemigosActivos.remove(infectado);
                    posicionesInfectados.get(indexInfectado).setValue(false);
                }*/
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

                    enemigosActivos.add( factoryInfectados.createInfectado(posCreacion) );
                    entry.setValue(true);
                }
            }        
             
        }
        
    }
}
