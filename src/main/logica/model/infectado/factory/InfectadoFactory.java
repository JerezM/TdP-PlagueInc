package main.logica.model.infectado.factory;

import java.awt.Point;
import java.util.Random;

import main.logica.model.infectado.Infectado;
import main.logica.model.infectado.InfectadoAlpha;
import main.logica.model.infectado.InfectadoBeta;

public class InfectadoFactory {
    
    private static InfectadoFactory instance;

    private int cantTiposInfectados;

    private InfectadoFactory() {
        cantTiposInfectados = 2;
    }

    public static InfectadoFactory getInstance() {
        if( instance == null ) {
			instance = new InfectadoFactory();
		}
		
		return instance;
    }

    /**
     * Genera un Infectado Alpha/Beta de eleccion aleatoria en la posicion parametrizada.
     * @param posicionCreacion La posicion en la cual se creara el infectado.
     * @return Una referencia al infectado creado.
     */
    public Infectado createInfectado(Point posicionCreacion) {
        Random rnd = new Random();
        int tipoInfectado = rnd.nextInt( cantTiposInfectados );
        
        Infectado infectadoCreado;

        if (tipoInfectado == 0) {
            infectadoCreado = new InfectadoAlpha(posicionCreacion);
        }
        else {
            infectadoCreado = new InfectadoBeta(posicionCreacion);
        }

        return infectadoCreado;
    }

    /**
     * Genera un Infectado Alpha en la posicion parametrizada.
     * @param posicionCreacion La posicion en la cual se creara el infectado.
     * @return Una referencia al infectado creado.
     */
    public Infectado createInfectadoAlpha(Point posicionCreacion) {
        return new InfectadoAlpha(posicionCreacion);
    }

    /**
     * Genera un Infectado Beta en la posicion parametrizada.
     * @param posicionCreacion La posicion en la cual se creara el infectado.
     * @return Una referencia al infectado creado.
     */
    public Infectado createInfectadoBeta(Point posicionCreacion) {
        return new InfectadoBeta(posicionCreacion);
    }
}
