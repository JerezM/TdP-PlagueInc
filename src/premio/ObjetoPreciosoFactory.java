package premio;

public class ObjetoPreciosoFactory implements PremioFactory{

	private static ObjetoPreciosoFactory instance;
	
	private ObjetoPreciosoFactory() {
		
	}
	
	public static ObjetoPreciosoFactory getInstance() {
		
		if(instance == null) {
			instance= new ObjetoPreciosoFactory();
		}
		return instance;
	}
	
	public Premio createPremio(int posX, int posY) {
		return new Premio(posX,posY);
	}
}
