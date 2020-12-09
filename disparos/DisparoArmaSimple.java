package disparos;

import java.awt.Point;

public class DisparoArmaSimple extends Disparo {
	//Falta implementacion de metodos de infectado Collider
	public DisparoArmaSimple(Point posCreacion) {
		super(posCreacion);
	}

	@Override
	public Point desplazarse() {
		int posyNueva = (int) (posActual.getY() + VelocidadDesplazamiento);
		int posxActual = (int) posActual.getX();
		Point posNueva = new Point(posxActual,posyNueva);
		posNueva.setLocation(posNueva);
		posActual = posNueva;

		return posActual;
	}
	
}
