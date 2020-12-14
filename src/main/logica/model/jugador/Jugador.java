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
     * @param movimientoJugador Movimiento a realizarse por el jugador.
     */
    public void update(int movimientoJugador) {
        entidadGrafica.actualizarSprite(movimientoJugador);
        movimientoActual = movimientoJugador;

        int movIzq = MovimientosJugador.MOV_IZQUIERDA.getMovimiento();
        int movDer = MovimientosJugador.MOV_DERECHA.getMovimiento();
        int disparando = MovimientosJugador.DISPARANDO.getMovimiento();
       
        if(movimientoActual == movIzq || movimientoActual == movDer) {
            this.desplazarce(movimientoActual);
        }
        else if(movimientoActual == disparando) {
            this.disparar();
        }

        ImageIcon sprite = entidadGrafica.getSprite();
        uiUpdater.updateLabel(id, posicion, sprite);
    }

    /**
     * Se encarga de desplazar al jugador hacia el lado indicado por el valor parametrizado.
     * @param movimientoJugador Movimiento el cual el jugador debe realizar.
     */
    protected void desplazarce(int movimientoJugador) {
        int posX = (int) posicion.getX();
        int posY = (int) posicion.getY();
        
        if ( movimientoJugador == MovimientosJugador.MOV_DERECHA.getMovimiento() ) {
            posX += velocidadDesplazamiento;
            
            int mapaWidth = MapaProperties.WIDTH.getValor(); 
            if (posX > (mapaWidth -5) ) posX = mapaWidth -5;
        }
        else if ( movimientoJugador == MovimientosJugador.MOV_IZQUIERDA.getMovimiento() ) {
            posX -= velocidadDesplazamiento;

            if (posX < 5) posX = 5;
        }

        posicion.setLocation(posX, posY);
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
