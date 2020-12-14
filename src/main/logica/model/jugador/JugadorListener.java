package main.logica.model.jugador;

public interface JugadorListener {
    
    /**
     * Consulta el ultimo movimiento realizado por el jugador
     * @return El ultimo movimiento que realizo el jugador.
     */
    public int getUltimoMovimiento();
}
