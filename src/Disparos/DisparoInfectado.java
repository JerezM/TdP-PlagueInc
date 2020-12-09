package Disparos;

import java.awt.Point;

public class DisparoInfectado extends Disparo {

	public DisparoInfectado(Point posCreacion) {
		super(posCreacion);
		poderAtaque=DisparoInfectadoProperties.PODER_ATAQUE.getValor();
		VelocidadDesplazamiento=DisparoInfectadoProperties.VELOCIDAD_DESPLAZAMIENTO.getValor();
		//A EntidadGrafica debo asignarle de nuevo el valor respectivo
		desplazarse();
	}
	
}
