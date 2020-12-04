package main.logica.entidad_grafica;

import javax.swing.ImageIcon;

public class EntidadGraficaMapa extends EntidadGrafica {
    
    private static EntidadGraficaMapa instance;

    private String[] mapas;
    private int nivelActual;

    private EntidadGraficaMapa() {

        this.inicializarAtributos();

    }

    public static EntidadGraficaMapa getInstance() {
        if( instance == null ) {
			instance = new EntidadGraficaMapa();
		}
		
		return instance;
    }

    /**
     * Consulta la imagen que representa el mapa en el nivel actual.
     */
    @Override
    public ImageIcon getSprite() {
        return spriteIcon;
    }

    /**
     * Se encarga de inicializar el atributo mapas.
     */
    protected void inicializarAtributos() {
        mapas = new String[2];
        nivelActual = 0;

        mapas[0] = "";//Añadir paths de las imagenes para los escenarios
        mapas[1] = "";

		this.spriteIcon = new ImageIcon(this.getClass().getResource( mapas[nivelActual] ));
		this.spriteIcon.setImage( this.spriteIcon.getImage());

    }
}
