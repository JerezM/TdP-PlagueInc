package infectado;

import java.awt.Point;

public class InfectadoAlphaDyingState implements InfectadoAlphaState{

	private InfectadoAlpha infectadoAlpha;
	
	public InfectadoAlphaDyingState(InfectadoAlpha infectado) {
		this.infectadoAlpha=infectado;
	}
	public void recibirAtaque(int a) {
		
		int vida= infectadoAlpha.getVida();
		if (vida-a != 0) {
			
			infectadoAlpha.setVida(vida-a);	
		}
		else {
				infectadoAlpha.setEstado(EstadosInfectado.MUERTO.getEstado());
		}
	}

	public void atacar() {
		
		infectadoAlpha.setEstado(EstadosInfectado.ATACANDO.getEstado());
		//PREG
	}

	public Point desplazarse() {
		
		infectadoAlpha.setEstado(EstadosInfectado.DESPLAZANDOSE.getEstado());
		//PREG	
		return null;
	}

}
