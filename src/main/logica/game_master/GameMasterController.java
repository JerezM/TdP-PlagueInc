package main.logica.game_master;


public class GameMasterController {

    private static GameMasterController instance;

    private GameMaster gameMaster;

    private GameMasterController() {
        gameMaster = GameMaster.getInstance();
    }

    public static GameMasterController getInstance() {
        if( instance == null ) {
			instance = new GameMasterController();
		}
		
		return instance;
    }

    /**
     * Se encarga de inicializar el mapa y el jugador en su aspecto logico.
     */
    public void inicializarPartida() {
        gameMaster.inicializarPartida();
    }

    /**
     * Se encarga de generar la oleada de enemigos para que empieze el nivel.
     */
    public void generarOleadaEnemigos() {
        // TODO Auto-generated method stub

    }
    
}
