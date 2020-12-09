package disparos;

import java.awt.Point;

public class DisparoPwrUpArmaSimple extends DisparoArmaSimple{

	public DisparoPwrUpArmaSimple(Point posCreacion) {
		super(posCreacion);
		poderAtaque = DisparoPwrUpArmaSimpleProperties.PODER_ATAQUE.getValor();
		VelocidadDesplazamiento = DisparoPwrUpArmaSimpleProperties.VELOCIDAD_DESPLAZAMIENTO.getValor();
		entidadGrafica = new EntidadGraficaDisparoNormalArmaSimple(); 
		desplazarse();
	}
	
}
