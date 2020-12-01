package premio;

import entidad.EntidadModel;
import entidad.grafica.EntidadGrafica;
import jugador.JugadorCollider;

public abstract class Premio extends EntidadModel implements JugadorCollider {

	protected int velocidad;
	protected EntidadGrafica entidad_grafica;
	public Premio() {
		super();
	}
	abstract int getVelocidad();
}
