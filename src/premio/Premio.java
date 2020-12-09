package premio;

import java.awt.Point;

import entidad.EntidadModel;
import entidad.grafica.EntidadGrafica;
import jugador.JugadorCollider;

public abstract class Premio extends EntidadModel implements JugadorCollider {

	protected int velocidad;
	protected EntidadGrafica entidadGrafica;
	protected Point posActual;
	protected int posX;
	protected int posY;
	
	public Premio(int posX, int posY) {
		
		super();
		
		
	}
	
	abstract void efecto();
	abstract void efecto(Jugador jugador);
	abstract int getVelocidad();
}
