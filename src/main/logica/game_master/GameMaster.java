package main.logica.game_master;

import java.util.LinkedList;
import java.util.List;

import main.logica.model.EntidadModel;
import main.logica.model.jugador.JugadorController;
import main.logica.model.jugador.JugadorListener;
import main.logica.model.jugador.JugadorListenerImpl;
import main.logica.nivel.NivelController;

public class GameMaster extends Thread {

    private static GameMaster instance;

    private NivelController nivelController;
    private JugadorController jugadorController;
    private JugadorListener jugadorListener;

    private List<EntidadModel> entidades;

    private GameMaster() {

        nivelController = NivelController.getInstance();
        jugadorController = JugadorController.getInstance();
        jugadorListener = JugadorListenerImpl.getInstance();

        entidades = new LinkedList<EntidadModel>();
    }

    public static GameMaster getInstance() {
        if (instance == null) {
            instance = new GameMaster();
        }

        return instance;
    }

    /**
     * Se encarga de inicializar el mapa y el jugador en su aspecto logico.
     */
    public void inicializarPartida() {
        nivelController.inicializarPartida();
        jugadorController.generarJugador();
    }

    /**
     * Se encarga de generar los enemigos para que empiece el nivel.
     */
    public void empezarNivel() {
        this.run();
    }

    @Override
    public void run() {

        boolean jugadorVivo = jugadorController.isAlive();
        List<EntidadModel> entidadesActuales;
        int frames = 0;

        while (jugadorVivo && nivelController.hasNextLevel()) {// Mientras queden niveles por jugar y el jugador este vivo

            nivelController.startNextLevel();

            while (jugadorVivo && !nivelController.isLevelComplete()) {// Mientras no haya completado el nivel y el jugador este vivo

                entidadesActuales = new LinkedList<EntidadModel>(entidades);
                 
                for(EntidadModel entidad : entidadesActuales) { entidad.update(); }
                 

                int movimientoJugador = this.getUltimoMovimientoJugador();
                System.out.println("frame: " + frames++);
                jugadorController.update(movimientoJugador);
                
                try {
                    GameMaster.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //masterCollider.checkCollisions();

                nivelController.update();

                jugadorVivo = jugadorController.isAlive();
            }
        }

        if(jugadorVivo) {
            System.out.println("YOU WIN!!");
        }
        else {
            System.out.println("YOU LOSE!!");
        }

    }

    /**
     * Se encarga de agregar la entidad parametrizada a la lista de entidades activas.
     * @param entidad Entidad a agregar.
     */
    public synchronized void addEntidad(EntidadModel entidad) {
        entidades.add(entidad);
    }

    /**
     * Se encarga de remover la entidad parametrizada de la lista de entidades activas.
     * @param entidad Entidad a remover.
     */
    public synchronized void removeEntidad(EntidadModel entidad) {
        entidades.remove(entidad);
    }

    /**
     * Consulta cual fue el ultimo movimiento realizado por el jugador.
     * @return Un entero el cual representa el movimiento realizado.
     */
    private int getUltimoMovimientoJugador() {
        return jugadorListener.getUltimoMovimientoJugador();
    }
}
