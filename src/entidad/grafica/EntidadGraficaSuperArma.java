package entidad.grafica;

import javax.swing.ImageIcon;

public class EntidadGraficaSuperArma implements EntidadGraficaPremio {

	private ImageIcon imagenArma;
	
	public EntidadGraficaSuperArma() {
		
		imagenArma=new ImageIcon();
	}
	public ImageIcon getSprite() {
		
		return imagenArma;
	}

}
