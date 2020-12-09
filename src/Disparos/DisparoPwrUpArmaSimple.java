package Disparos;

import java.awt.Point;

public class DisparoPwrUpArmaSimple extends DisparoArmaSimple{

	public DisparoPwrUpArmaSimple(Point posCreacion) {
		super(posCreacion);
		poderAtaque=DisparoPwrUpArmaSimpleProperties.PODER_ATAQUE.getValor();
		VelocidadDesplazamiento=DisparoPwrUpArmaSimpleProperties.VELOCIDAD_DESPLAZAMIENTO.getValor();
		//A EntidadGrafica debo asignarle de nuevo el valor respectivo
		desplazarse();
	}
	
}
