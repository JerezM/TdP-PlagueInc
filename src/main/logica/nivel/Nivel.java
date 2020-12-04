package main.logica.nivel;

import main.logica.nivel.mapa.Mapa;

public class Nivel {
    
    private static Nivel instance;

    private Mapa mapa;

    private Nivel() {
        mapa = Mapa.getInstance();
    }

    public static Nivel getInstance() {
        if( instance == null ) {
			instance = new Nivel();
		}
		
		return instance;
    }

    /**
     * Se encarga de inicializar el mapa y la oleada de enemigos en su aspecto logico para el nivel inicial.
     */
    public void inicializarPartida() {
        this.inicializarMapaLvl1();
    }

    /**
     * Se encarga de inicializar el mapa en el nivel inicial.
     */
    protected void inicializarMapaLvl1() {
        mapa.inicializarMapaLvl1();
    }

    /**
     * Se encarga de inicializar la oleada de enemigos en el nivel inicial.
     */
    protected void inicializarOleadaEnemigosLvl1() {

    }
}
