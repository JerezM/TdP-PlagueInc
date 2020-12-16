package main.logica.nivel.oleada_enemigos.state;

import main.logica.nivel.oleada_enemigos.OleadaEnemigosImpl;
import properties.OleadaEnemigosLvl1Properties;

public class OleadaEnemigosLvl1 extends OleadaEnemigosState {

    private static OleadaEnemigosLvl1 instance;

    private static final OleadaEnemigosImpl oleadaImpl = OleadaEnemigosImpl.getInstance();

    private OleadaEnemigosLvl1() {
        super();
        
        this.cantEnemigosActivos = OleadaEnemigosLvl1Properties.CANTIDAD_ENEMIGOS_ACTIVOS.getValor();
        this.cantOleadas = OleadaEnemigosLvl1Properties.CANTIDAD_OLEADAS.getValor();

        this.generarInfectados();
    }

    public static OleadaEnemigosLvl1 getInstance() {
        if( instance == null ) {
			instance = new OleadaEnemigosLvl1();
		}
		
		return instance;
    }

    @Override
    public boolean hasNextLevel() {
        return true;//Posee proximo nivel ya que este es el nivel uno y el juego posee dos niveles
    }

    @Override
    public void empezarOleadaProximoNivel() {
        oleadaImpl.cambiarNivel( OleadaEnemigosLvl2.getInstance() );
    }
    
}
