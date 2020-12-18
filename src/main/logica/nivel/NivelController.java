package main.logica.nivel;

public class NivelController {

    private static NivelController instance;

    private Nivel nivel;

    private NivelController() {
        nivel = Nivel.getInstance();
    }

    public static NivelController getInstance() {
        if( instance == null ) {
			instance = new NivelController();
		}
		
		return instance;
    }

    /**
     * Se encarga de inicializar el mapa y la oleada de enemigos en su aspecto logico para el nivel 1.
     */
    public void inicializarPartida() {
        nivel.inicializarPartida();
    }
    
    /**
     * Consulta si todavia hay niveles para jugar.
     * @return True en caso de que haya niveles, falso en caso de que ya se hayan jugado todos los niveles.
     */
    public boolean hasNextLevel() {
        return nivel.hasNextLevel();
    }

    /**
     * Se encarga de inicializar el proximo nivel disponible.
     */
    public void startNextLevel() {
        nivel.startNextLevel();
    }

    /**
     * Consulta si el nivel actual se encuentra completado.
     * @return True en caso de que el nivel actual este completado, falso en caso contrario.
     */
    public boolean isLevelComplete() {
        return nivel.isLevelComplete();
    }

    /**
     * Se encarga de actualizar la oleada de enemigos en caso de que se generen nuevos infectados.
     */
    public void update() {
        nivel.update();
    }
}
