package main.logica.game_master;

import main.logica.nivel.NivelController;
import main.logica.nivel.NivelControllerImpl;

public class GameMaster extends Thread {
    
    private static GameMaster instance;

    private NivelController nivelController;

    private GameMaster() {
        nivelController = NivelControllerImpl.getInstance();
    }

    public static GameMaster getInstance() {
        if( instance == null ) {
			instance = new GameMaster();
		}
		
		return instance;
    }

    public void inicializarPartida() {
        nivelController.generarMapa();
    }
}
