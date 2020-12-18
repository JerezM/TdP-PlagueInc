package main.logica.model.jugador;

public enum MovimientosJugador {
    
    QUIETO(0),
    MOV_IZQUIERDA(1),
    MOV_DERECHA(2),
    DISPARANDO(3);

    private int movimiento;

    private MovimientosJugador(int movimiento) {
        this.movimiento = movimiento;
    }

    public int getMovimiento() {
        return movimiento;
    }

}
