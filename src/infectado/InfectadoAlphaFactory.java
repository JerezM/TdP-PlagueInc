package infectado;

public class InfectadoAlphaFactory implements InfectadoFactory{

	public Infectado crearEnemigo() {
		
		return new InfectadoAlpha(1);
	}
}
