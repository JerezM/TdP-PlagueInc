package main.logica.nivel;

public class NivelController {

    private static NivelController instance;

    private Nivel nivel;

    private NivelController() {
        nivel = Nivel.getInstance();
    }

    public static NivelController getInstance() {
        if( instance == null ) {
			instance = new NivelController();
		}
		
		return instance;
    }

    /**
     * Se encarga de inicializar el mapa y la oleada de enemigos en su aspecto logico para el nivel 1.
     */
    public void inicializarPartida() {
        nivel.inicializarPartida();
    }
    
}
