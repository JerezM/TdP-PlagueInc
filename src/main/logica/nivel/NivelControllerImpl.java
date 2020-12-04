package main.logica.nivel;

public class NivelControllerImpl implements NivelController {

    private static NivelControllerImpl instance;

    //private Nivel nivel;

    private NivelControllerImpl() {
        //nivel = Nivel.getInstance();
    }

    public static NivelControllerImpl getInstance() {
        if( instance == null ) {
			instance = new NivelControllerImpl();
		}
		
		return instance;
    }

    @Override
    public void generarMapa() {
        //nivel.generarMapa();
    }
    
}
