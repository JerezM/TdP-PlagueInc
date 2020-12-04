package main.logica.game_master;

public interface GameMasterController {
    
    /**
     * Se encarga de inicializar el mapa y al jugador en su aspecto logico.
     */
    public void inicializarPartida();

    /**
     * Se encarga de generar la Oleada de enemigos.
     */
    public void generarOleadaEnemigos();
}
