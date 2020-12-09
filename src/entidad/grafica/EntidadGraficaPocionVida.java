package entidad.grafica;

import javax.swing.ImageIcon;

public class EntidadGraficaPocionVida implements EntidadGraficaPremio{

	public ImageIcon imagenPocion;
	
	public EntidadGraficaPocionVida() {
		
		imagen_pocion= new ImageIcon();		
	}
	
	public ImageIcon getSprite() {
		// TODO Auto-generated method stub
		return imagen_pocion;
	}

}
