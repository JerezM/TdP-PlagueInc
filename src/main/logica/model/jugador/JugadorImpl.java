package main.logica.model.jugador;

public class JugadorImpl extends Jugador {
    
    private static JugadorImpl instance;

    private JugadorImpl() {
        super();
    }

    public static JugadorImpl getInstance() {
        if( instance == null ) {
			instance = new JugadorImpl();
		}
		
		return instance;
    }
}
