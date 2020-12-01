package infectado;

import java.awt.Point;

public class InfectadoAlphaNormalState implements InfectadoAlphaState{
	
	private InfectadoAlpha infectadoAlpha;
	
	public InfectadoAlphaNormalState (InfectadoAlpha infectado) {
		this.infectadoAlpha= infectado;
	}
	
	public void recibirAtaque(int a) {
		
		infectadoAlpha.setVida( infectadoAlpha.getVida()-a);
		int vida=infectadoAlpha.getVida();
		
		if (vida<20) {
			infectadoAlpha.changeState( new InfectadoAlphaDyingState(infectadoAlpha));
		}	
	}
	
	public void atacar() {
		infectadoAlpha.setEstado(EstadosInfectado.ATACANDO.getEstado());
	};
	public Point desplazarse() {
		
		infectadoAlpha.setEstado(EstadosInfectado.DESPLAZANDOSE.getEstado());
	return null;
	}
}

