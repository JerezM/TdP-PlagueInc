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

    /**
     * Acutaliza el model del jugador con respecto al movimiento parametrizado.
     * @param movimientoJugador Movimiento a realizarse por el jugador.
     */
    public void update(int movimientoJugador) {
        jugador.update(movimientoJugador);
    }

    /**
     * Consulta si el jugador se encuentra vivo actualmente.
     * @return True en caso de que el jugador este vivo, false en caso contrario.
     */
    public boolean isAlive() {
        int vidaJugador = jugador.getVida();
        boolean estaVivo = (vidaJugador > 0);

        return estaVivo;
    }
}
