package infectado;

public class InfectadoBetaFactory implements InfectadoFactory{

	private Infectado infectadoBeta;
	
	public InfectadoBetaFactory() {
	
		infectadoBeta= new InfectadoBeta(posicionCreacion);
	}

	@Override
	public Infectado crearEnemigo() {
		// TODO Auto-generated method stub
		return null;
	}
}
