package premio;

public class EfectoTemporalFactory implements PremioFactory {
	
	private static EfectoTemporalFactory instance;
	
	private EfectoTemporalFactory () {
	}
	
	public static EfectoTemporalFactory getInstance() {
		if(instance == null) {
			instance= new EfectoTemporalFactory();
		}
		return instance;
	}
	
	public Premio createPremio(int posX, int posY) {
		return new Premio(posX,posY);
	}
	

}
