package Disparos;

import javax.swing.ImageIcon;

public class EntidadGraficaDisparo implements EntidadGrafica {

	private ImageIcon sprite;

	public EntidadGraficaDisparo(ImageIcon s) {
		sprite=s;
	}
	
	public ImageIcon getSprite() {
		return sprite;
	}
	
	
}
