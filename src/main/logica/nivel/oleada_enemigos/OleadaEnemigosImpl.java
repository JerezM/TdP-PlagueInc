package main.logica.nivel.oleada_enemigos;

import main.logica.nivel.oleada_enemigos.state.OleadaEnemigosLvl1;
import main.logica.nivel.oleada_enemigos.state.OleadaEnemigosState;

public class OleadaEnemigosImpl implements OleadaEnemigos {

    private static OleadaEnemigosImpl instance;

    private OleadaEnemigosState state;

    private OleadaEnemigosImpl() {
        state = null;
    }

    public static OleadaEnemigosImpl getInstance() {
        if( instance == null ) {
			instance = new OleadaEnemigosImpl();
		}
		
		return instance;
    }

    @Override
    public boolean hasNextLevel() {
        boolean hasNext = (state == null);
        
        if (!hasNext) {
            hasNext = state.hasNextLevel();
        }

        return hasNext;
    }

    @Override
    public void empezarOleadaProximoNivel() {
        if (state == null) {
            state = OleadaEnemigosLvl1.getInstance();
        }
        else {
            state.empezarOleadaProximoNivel();
        }
    }

    /**
     * Instancia el atributo state con el state parametrizado.
     * @param state Simboliza la oleada de enemigos(nivel) el cual va a estar esta clase.
     */
    public void cambiarNivel(OleadaEnemigosState state) {
        this.state = state;
    }

    @Override
    public boolean isLevelComplete() {
        boolean isComplete;

        if (state != null) {
            isComplete = state.isLevelComplete();
        }
        else {
            isComplete = false;
        }

        return isComplete;
    }

    @Override
    public void update() {
        state.update();
    }
    
}
