package entidad.grafica;

import javax.swing.ImageIcon;

public class EntidadGraficaCuarentenaObligatoria implements EntidadGraficaPremio {

	private ImageIcon imagenCuarentena;
	
	public EntidadGraficaCuarentenaObligatoria () {
		
		imagenCuarentena= new ImageIcon();
	}
	public ImageIcon getSprite() {
		
		return imagenCuarentena;
	}

}
