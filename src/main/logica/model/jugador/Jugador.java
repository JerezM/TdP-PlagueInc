package main.logica.model.jugador;

import java.awt.Point;

import javax.swing.ImageIcon;

import main.logica.entidad_grafica.EntidadGraficaJugador;
import main.view.ui_updater.UIUpdater;
import properties.JugadorProperties;
import properties.MapaProperties;

public abstract class Jugador {

    private int width, height;
    private int id;
    private UIUpdater uiUpdater;

    protected int vida;
    protected int velocidadDesplazamiento;
    protected Point posicion;
    protected int movimientoActual;
    protected EntidadGraficaJugador entidadGrafica;
    

    protected Jugador() {

        vida = JugadorProperties.VIDA.getValor();
        velocidadDesplazamiento = JugadorProperties.VELOCIDAD_DESPLAZAMIENTO.getValor();

        movimientoActual = MovimientosJugador.QUIETO.getMovimiento();

        entidadGrafica = EntidadGraficaJugador.getInstance();

        int posXCreacion = JugadorProperties.POS_CREACION_EJE_X.getValor();
        int posYCreacion = JugadorProperties.POS_CREACION_EJE_Y.getValor();
        posicion = new Point(posXCreacion, posYCreacion);

        width = JugadorProperties.WIDTH.getValor();
        height = JugadorProperties.HEIGHT.getValor();
        ImageIcon sprite = entidadGrafica.getSprite();

        uiUpdater = UIUpdater.getInstance();
        id = this.hashCode();
        uiUpdater.generarLabel(id, posicion, width, height, sprite);

    }

    /**
     * Acutaliza el model del jugador con respecto al movimiento parametrizado.
     * @param movimientoNuevo Movimiento a realizarse por el jugador.
     */
    public void update(int movimientoNuevo) {

        int quieto = MovimientosJugador.QUIETO.getMovimiento();
        int movIzq = MovimientosJugador.MOV_IZQUIERDA.getMovimiento();
        int movDer = MovimientosJugador.MOV_DERECHA.getMovimiento();
        int disparando = MovimientosJugador.DISPARANDO.getMovimiento();

        if ( (movimientoActual != quieto) && (movimientoNuevo == quieto) ) {
            this.cambiarSprite(movimientoNuevo);
            movimientoActual = movimientoNuevo;
        }
        else if ( (movimientoActual != disparando) && (movimientoNuevo == disparando) ) {
            this.cambiarSprite(movimientoNuevo);
            this.disparar();
            movimientoActual = movimientoNuevo;
        }
        else if ( (movimientoActual == movimientoNuevo) && (movimientoActual == disparando) ) {
            this.disparar();
        }   
        else if ( ((movimientoActual == quieto) || (movimientoActual == disparando)) && ((movimientoNuevo == movDer) || (movimientoNuevo == movIzq)) ) {
            this.cambiarSprite(movimientoNuevo);
            this.desplazarce(movimientoNuevo);
            movimientoActual = movimientoNuevo;
        }
        else if ( (movimientoActual == movimientoNuevo) && ((movimientoActual == movDer) || (movimientoActual == movIzq)) ) {
            this.desplazarce(movimientoNuevo);
            movimientoActual = movimientoNuevo;
        }
        else if ( (movimientoActual == movDer) && (movimientoNuevo == movIzq) ) {
            this.cambiarSprite(movimientoNuevo);
            this.desplazarce(movimientoNuevo);
            movimientoActual = movimientoNuevo;
        }
        else if ( (movimientoActual == movIzq) && (movimientoNuevo == movDer) ) {
            this.cambiarSprite(movimientoNuevo);
            this.desplazarce(movimientoNuevo);
            movimientoActual = movimientoNuevo;
        }

    }

    /**
     * Se encarga de cambiar el sprite por el cual represente el movimiento parametrizado.
     * @param movimientoNuevo El nuevo movimiento realizado por el jugador.
     */
    protected void cambiarSprite(int movimientoNuevo) {
        ImageIcon sprite = entidadGrafica.actualizarSprite(movimientoNuevo);
        uiUpdater.updateSpriteLabel(id, sprite);
    }

    /**
     * Se encarga de desplazar al jugador hacia el lado indicado por el valor parametrizado.
     * @param movimientoNuevo Movimiento el cual el jugador debe realizar.
     */
    protected void desplazarce(int movimientoNuevo) {
        int posX = (int) posicion.getX();
        int posY = (int) posicion.getY();
        
        if ( movimientoNuevo == MovimientosJugador.MOV_DERECHA.getMovimiento() ) {
            posX += velocidadDesplazamiento;
            
            int mapaWidth = MapaProperties.WIDTH.getValor(); 
            if (posX > (mapaWidth -33) ) posX = mapaWidth -33;
        }
        else if ( movimientoNuevo == MovimientosJugador.MOV_IZQUIERDA.getMovimiento() ) {
            posX -= velocidadDesplazamiento;

            if (posX < 5) posX = 5;
        }

        posicion.setLocation(posX, posY);
        uiUpdater.updatePosicionLabel(id, posicion);
    }

    /**
     * Se encarga de generar un proyectil en la posicion actual del jugador.
     */
    protected abstract void disparar();

    /**
     * Consulta la vida del jugador.
     * @return La vida actual del jugador.
     */
    public int getVida() {
        return vida;
    }
}
