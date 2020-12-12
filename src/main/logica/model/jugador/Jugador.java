package main.logica.model.jugador;

import java.awt.Point;

import javax.swing.ImageIcon;

import main.logica.entidad_grafica.EntidadGraficaJugador;
import properties.JugadorProperties;

public class Jugador {

    private int width, height;

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

        //SE COMUNICA CON EL UI UPDATER PARA PASARLE LAS STATS

    }

}
