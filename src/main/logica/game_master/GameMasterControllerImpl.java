package main.logica.game_master;


public class GameMasterControllerImpl implements GameMasterController {

    private static GameMasterControllerImpl instance;

    private GameMaster gameMaster;

    private GameMasterControllerImpl() {
        gameMaster = GameMaster.getInstance();
    }

    public static GameMasterControllerImpl getInstance() {
        if( instance == null ) {
			instance = new GameMasterControllerImpl();
		}
		
		return instance;
    }

    @Override
    public void inicializarPartida() {
        gameMaster.inicializarPartida();
    }

    @Override
    public void generarOleadaEnemigos() {
        // TODO Auto-generated method stub

    }
    
}
