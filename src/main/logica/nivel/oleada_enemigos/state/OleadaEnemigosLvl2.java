package main.logica.nivel.oleada_enemigos.state;

import properties.OleadaEnemigosLvl2Properties;

public class OleadaEnemigosLvl2 extends OleadaEnemigosState {

    private static OleadaEnemigosLvl2 instance;

    private OleadaEnemigosLvl2() {
        super();
        
        this.cantEnemigosActivos = OleadaEnemigosLvl2Properties.CANTIDAD_ENEMIGOS_ACTIVOS.getValor();
        this.cantOleadas = OleadaEnemigosLvl2Properties.CANTIDAD_OLEADAS.getValor();

        this.generarInfectados();
    }

    public static OleadaEnemigosLvl2 getInstance() {
        if( instance == null ) {
			instance = new OleadaEnemigosLvl2();
		}
		
		return instance;
    }

    @Override
    public boolean hasNextLevel() {
        return false;//El juego actualmente cuenta unicamente con 2 niveles.
    }

    @Override
    public void empezarOleadaProximoNivel() {
        System.out.println("El juego no posee mas niveles.");
    }
    
}
