package premio;

import entidad.grafica.*;

public class PocionVida extends ObjetoPrecioso{
	
	private int premioVida;
	
	public PocionVida(int posX, int posY) {
		
		super(posX,posY);
		entidad_grafica= new EntidadGraficaPocionVida();
		velocidad= 10;
		premioVida=20;
	}
	
	public int getVida() {
		return premioVida;
	}

	public void efecto(Jugador jugador) {
	
		jugador.setVida(premioVida);
	}

	public int getVelocidad() {
		return velocidad ;
	}
	
	public Point moverse() {
		
	}
	
	

}
