package main.logica.model.jugador;

public class JugadorController {
    
    private static JugadorController instance;

    private Jugador jugador;

    private JugadorController() {}

    public static JugadorController getInstance() {
        if( instance == null ) {
			instance = new JugadorController();
		}
		
		return instance;
    }

    /**
     * Se encarga de inicializar el model logico del jugador.
     */
    public void generarJugador() {
        jugador = JugadorImpl.getInstance();
    }
}
