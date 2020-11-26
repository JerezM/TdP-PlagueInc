package Premio;

import java.util.ArrayList;
import java.util.Random;

public class PremioFactoryImpl implements PremioFactory{

	private static PremioFactoryImpl instance;
	private ArrayList<PremioFactory> factories;
	
	private PremioFactoryImpl() {
		
		factories= new ArrayList<PremioFactory>();
		factories.add(factories.size(), ObjetoPreciosoFactory.getInstance());
		factories.add(factories.size(), EfectoTemporalFactory.getInstance());
	}

	public static PremioFactoryImpl getInstance() {
		
		if (PremioFactoryImpl.instance == null) {
			instance= new PremioFactoryImpl ();
		}
		return instance;
	}

	public Premio createPremio() {
		
		int size= factories.size();
		Random r= new Random();
		int indice=0+r.nextInt(size);
		PremioFactory factory= factories.get(indice);
		Premio premio = factory.createPremio();
	
		return premio;
	}
	
}
