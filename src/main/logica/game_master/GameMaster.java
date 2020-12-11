package main.logica.game_master;

import main.logica.model.jugador.JugadorController;
import main.logica.nivel.NivelController;

public class GameMaster extends Thread {
    
    private static GameMaster instance;

    private NivelController nivelController;
    private JugadorController jugadorController;

    private GameMaster() {
        nivelController = NivelController.getInstance();
        jugadorController = JugadorController.getInstance();
    }

    public static GameMaster getInstance() {
        if( instance == null ) {
			instance = new GameMaster();
		}
		
		return instance;
    }

    public void inicializarPartida() {
        nivelController.inicializarPartida();
        jugadorController.generarJugador();
    }
}
