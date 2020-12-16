package main.logica.nivel.oleada_enemigos.state;

import java.util.LinkedList;
import java.util.List;

import main.logica.model.infectado.Infectado;
import main.logica.model.infectado.factory.InfectadoFactory;

public abstract class OleadaEnemigosState {
    
    protected InfectadoFactory factoryInfectados;
    protected List<Infectado> enemigosActivos;
    protected int cantEnemigosActivos;//dificultad
    protected int cantOleadas;//duracion
    protected int oleadasCompletadas;//variable para testeas que se haya completado la oleada

    protected OleadaEnemigosState() {
        factoryInfectados = InfectadoFactory.getInstance();
        enemigosActivos = new LinkedList<Infectado>();
        oleadasCompletadas = 0;
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
                    enemigosActivos.remove(infectado);
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
        /*
        creacion del objeto rnd
        for (int i = 0; i < cantEnemigosActivos; i++) {
            obtener posicion random y si esta separada de la creada previamente se crea el infectado, 
            sino se obtienen nuevamente una posX random. Tener en cuanta tambien el distanciamiento de 33 entre cada infectado.
            enemigosActivos.add( factoryInfectados.createInfectado() );
        }
        */
    }
}
