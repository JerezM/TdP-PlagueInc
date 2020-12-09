package Disparos;

import java.awt.Point;

public class DisparoNormalArmaSimple extends DisparoArmaSimple {

	public DisparoNormalArmaSimple(Point posCreacion) {
		super(posCreacion);
		poderAtaque=DisparoNormalArmaSimpleProperties.PODER_ATAQUE.getValor();
		VelocidadDesplazamiento=DisparoNormalArmaSimpleProperties.VELOCIDAD_DESPLAZAMIENTO.getValor();
		//A EntidadGrafica debo asignarle de nuevo el valor respectivo
		desplazarse();
	}
	
	
}
