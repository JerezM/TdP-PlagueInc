package disparos;

import java.awt.Point;

public class DisparoNormalArmaSimple extends DisparoArmaSimple {

	public DisparoNormalArmaSimple(Point posCreacion) {
		super(posCreacion);
		poderAtaque = DisparoNormalArmaSimpleProperties.PODER_ATAQUE.getValor();
		VelocidadDesplazamiento = DisparoNormalArmaSimpleProperties.VELOCIDAD_DESPLAZAMIENTO.getValor();
		entidadGrafica = new EntidadGraficaDisparoNormalArmaSimple();
		desplazarse();
	}
	
	
}
