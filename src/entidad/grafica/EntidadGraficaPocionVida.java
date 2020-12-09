package entidad.grafica;

import javax.swing.ImageIcon;

public class EntidadGraficaPocionVida implements EntidadGraficaPremio{

	public ImageIcon imagenPocion;
	
	public EntidadGraficaPocionVida() {
		
		imagenPocion= new ImageIcon();		
	}
	
	public ImageIcon getSprite() {
		// TODO Auto-generated method stub
		return imagenPocion;
	}

}
