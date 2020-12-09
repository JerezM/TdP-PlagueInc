package disparos;

import java.awt.Point;

public class DisparoInfectado extends Disparo {

	public DisparoInfectado(Point posCreacion) {
		super(posCreacion);
		poderAtaque = DisparoInfectadoProperties.PODER_ATAQUE.getValor();
		VelocidadDesplazamiento = DisparoInfectadoProperties.VELOCIDAD_DESPLAZAMIENTO.getValor();
		entidadGrafica = new EntidadGraficaDisparoInfectado();
		desplazarse();
	}

	public Point desplazarse() {
		int posyNueva = (int) (posActual.getY() - VelocidadDesplazamiento);
		int posxActual = (int) posActual.getX();
		Point posNueva = new Point(posxActual,posyNueva);
		posNueva.setLocation(posNueva);
		posActual = posNueva;
		
		return posActual;
	}
	
}
