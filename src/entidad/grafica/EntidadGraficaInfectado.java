package entidad.grafica;

import javax.swing.ImageIcon;

public class EntidadGraficaInfectado implements EntidadGrafica {
	
	private ImageIcon sprite;

	public EntidadGraficaInfectado() {
		sprite=null;
	}
	
	public ImageIcon getSprite() {
		return sprite;
	}
	
	public void actualizarSprite(int nuevoEstado) {
		//falta contenedor de imagenes.
	}
	
}
