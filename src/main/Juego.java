package main;

import main.logica.game_master.GameMasterController;
import main.logica.model.jugador.JugadorListenerImpl;
import main.view.GUI;

public class Juego {
    public static void main(String[] args) {

        GameMasterController gameMasterController = GameMasterController.getInstance();
        gameMasterController.inicializarPartida();

        GUI frame = GUI.getInstance();
        frame.setVisible(true);

        frame.addKeyListener(JugadorListenerImpl.getInstance());
        
        gameMasterController.empezarNivel();
    }    
}
