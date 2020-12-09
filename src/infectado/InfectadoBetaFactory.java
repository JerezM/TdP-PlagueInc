package infectado;

public class InfectadoBetaFactory implements InfectadoFactory{

	@Override
	public Infectado crearEnemigo() {
		
		return new InfectadoBeta(1);
	}
}
