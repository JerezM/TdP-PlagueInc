package infectado;

public class InfectadoAlphaFactory implements InfectadoFactory{

	private Infectado infectadoAlpha;
	
	private InfectadoAlphaFactory(int posicionCreacion) {
	
			infectadoAlpha= new InfectadoAlpha(posicionCreacion);
	}
	
	public Infectado crearEnemigo() {
		
		return infectadoAlpha;
	}
}
