package main.logica.entidad_grafica;

import javax.swing.ImageIcon;

public class EntidadGraficaJugador extends EntidadGrafica {
    
    private static EntidadGraficaJugador instance;

    private String[] sprites;

    private EntidadGraficaJugador() {

        sprites = new String[4];
        sprites[0] = "";//QUIETO
        sprites[1] = "";//MOV_IZQ
        sprites[2] = "";//MOV_DER
        sprites[3] = "";//DISPARANDO

        this.spriteIcon = new ImageIcon( this.getClass().getResource( sprites[0] ) );
		this.spriteIcon.setImage( this.spriteIcon.getImage() );

    }

    public static EntidadGraficaJugador getInstance() {
        if( instance == null ) {
			instance = new EntidadGraficaJugador();
		}
		
		return instance;
    }

    /**
     * Actualiza el sprite actual por el correspondiente al movimiento parametrizado.
     * @param movimiento Indica el movimiento que se esta efectuando actualmente.
     * @return El nuevo sprite que representa el movimiento parametrizado.
     */
    public ImageIcon actualizarSprite(int movimiento) {
        return spriteIcon;
    }

}
