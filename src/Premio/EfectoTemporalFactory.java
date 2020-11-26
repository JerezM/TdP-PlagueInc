package Premio;

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
	
	public Premio createPremio() {
		return new Premio();
	}
	

}
