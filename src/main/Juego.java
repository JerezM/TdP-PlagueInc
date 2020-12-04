package main;

import main.logica.game_master.GameMasterController;
import main.logica.game_master.GameMasterControllerImpl;

public class Juego {
    public static void main(String[] args) {
        GameMasterController gameMasterController = GameMasterControllerImpl.getInstance();
        gameMasterController.inicializarPartida();
    }    
}
