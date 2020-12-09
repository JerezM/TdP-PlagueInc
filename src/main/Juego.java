package main;

import main.logica.game_master.GameMasterController;
import main.view.GUI;

public class Juego {
    public static void main(String[] args) {

        GameMasterController gameMasterController = GameMasterController.getInstance();
        gameMasterController.inicializarPartida();

        GUI frame = GUI.getInstance();
        frame.setVisible(true);
        
    }    
}
