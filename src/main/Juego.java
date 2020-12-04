package main;

import main.logica.game_master.GameMasterController;

public class Juego {
    public static void main(String[] args) {

        GameMasterController gameMasterController = GameMasterController.getInstance();
        gameMasterController.inicializarPartida();
        
    }    
}
