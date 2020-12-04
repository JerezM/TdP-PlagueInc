package main.logica.nivel.mapa;

import javax.swing.ImageIcon;

import main.logica.entidad_grafica.EntidadGraficaMapa;

public class Mapa {
    
    private static Mapa instance;

    private EntidadGraficaMapa entidadGrafica;
    private ImageIcon mapaActual;

    //private MapaViewController mapaViewController;

    private Mapa() {
        entidadGrafica = EntidadGraficaMapa.getInstance();
        //mapaViewController = MapaViewController.getInstance();
    }

    public static Mapa getInstance() {
        if( instance == null ) {
			instance = new Mapa();
		}
		
		return instance;
    }

    /**
     * Se encarga de generar el mapa en su nivel inicial, a la vez que se encarga de inicializar su componente grafico.
     */
    public void inicializarMapaLvl1() {

        mapaActual = entidadGrafica.getSprite();
        //mapaViewController.generarComponenteGraficoMapa(mapaActual);

    }
}
