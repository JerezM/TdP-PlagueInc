package main.logica.model.jugador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.atomic.AtomicInteger;

public class JugadorListenerImpl implements KeyListener, JugadorListener {

    private static JugadorListenerImpl instance;

    private final AtomicInteger ultimoMovimiento = new AtomicInteger();

    private JugadorListenerImpl() {

        synchronized(ultimoMovimiento) {
            int quieto = MovimientosJugador.QUIETO.getMovimiento();
            ultimoMovimiento.lazySet(quieto);
        }

    }

    public static JugadorListenerImpl getInstance() {
        if( instance == null ) {
			instance = new JugadorListenerImpl();
		}
		
		return instance;
    }

    @Override
    public void keyPressed(KeyEvent e) {

        if(e.getKeyCode() == KeyEvent.VK_SPACE) {
            synchronized(ultimoMovimiento) {
                int disparando = MovimientosJugador.DISPARANDO.getMovimiento();
                ultimoMovimiento.lazySet(disparando);
            }           
        }

        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            synchronized(ultimoMovimiento) {
                int movDerecha = MovimientosJugador.QUIETO.getMovimiento();
                ultimoMovimiento.lazySet(movDerecha);
            }
        }

        if(e.getKeyCode() == KeyEvent.VK_LEFT){
			synchronized(ultimoMovimiento) {
                int movIzquierda = MovimientosJugador.QUIETO.getMovimiento();
                ultimoMovimiento.lazySet(movIzquierda);
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        
        if(e.getKeyCode() == KeyEvent.VK_SPACE) {
            synchronized(ultimoMovimiento) {
                int quieto = MovimientosJugador.DISPARANDO.getMovimiento();
                ultimoMovimiento.lazySet(quieto);
            }           
        }

        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            synchronized(ultimoMovimiento) {
                int quieto = MovimientosJugador.DISPARANDO.getMovimiento();
                ultimoMovimiento.lazySet(quieto);
            }
        }

        if(e.getKeyCode() == KeyEvent.VK_LEFT){
			synchronized(ultimoMovimiento) {
                int quieto = MovimientosJugador.DISPARANDO.getMovimiento();
                ultimoMovimiento.lazySet(quieto);
            }
        }

    }

    @Override
    public int getUltimoMovimientoJugador() {
        
        int movimientoJugador;
        synchronized(ultimoMovimiento) {
            movimientoJugador = ultimoMovimiento.get();
        }

        return movimientoJugador;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {}
}
