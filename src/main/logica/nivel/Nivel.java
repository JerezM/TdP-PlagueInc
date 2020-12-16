package main.logica.nivel;

import main.logica.nivel.mapa.Mapa;
import main.logica.nivel.oleada_enemigos.OleadaEnemigos;
import main.logica.nivel.oleada_enemigos.OleadaEnemigosImpl;

public class Nivel {
    
    private static Nivel instance;

    private Mapa mapa;
    private OleadaEnemigos oleadaEnemigos;

    private Nivel() {
        mapa = Mapa.getInstance();
        oleadaEnemigos = OleadaEnemigosImpl.getInstance();
    }

    public static Nivel getInstance() {
        if( instance == null ) {
			instance = new Nivel();
		}
		
		return instance;
    }

    /**
     * Se encarga de inicializar el mapa en su aspecto logico para el nivel inicial.
     */
    public void inicializarPartida() {
        this.inicializarMapaLvl1();
    }

    /**
     * Se encarga de inicializar el mapa en el nivel inicial.
     */
    private void inicializarMapaLvl1() {
        mapa.inicializarMapaLvl1();
    }

    /**
     * Consulta si todavia hay niveles para jugar.
     * @return True en caso de que haya niveles, falso en caso de que ya se hayan jugado todos los niveles.
     */
    public boolean hasNextLevel() {
        return oleadaEnemigos.hasNextLevel();
    }

    /**
     * Se encarga de inicializar el mapa y la oleada de enemigos para el proximo nivel disponible.
     */
    public void startNextLevel() {
        oleadaEnemigos.empezarOleadaProximoNivel();
    }

    /**
     * Consulta si el nivel actual se encuentra completado.
     * @return True en caso de que el nivel actual este completado, falso en caso contrario.
     */
    public boolean isLevelComplete() {
        return oleadaEnemigos.isLevelComplete();
    }

    /**
     * Se encarga de actualizar la oleada de enemigos en caso de que se generen nuevos infectados.
     */
    public void update() {
        oleadaEnemigos.update();
    }
}
