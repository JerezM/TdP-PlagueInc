package main.logica.nivel;

public class Nivel {
    
    private static Nivel instance;

    private Nivel() {}

    public static Nivel getInstance() {
        if( instance == null ) {
			instance = new Nivel();
		}
		
		return instance;
    }
}
