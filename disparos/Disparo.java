package disparos;

import java.awt.Point;

import javax.swing.ImageIcon;

public abstract class Disparo {

	protected int poderAtaque;
	protected int VelocidadDesplazamiento;
	protected Point posCreacion,posActual;
	protected EntidadGraficaDisparo entidadGrafica;

	public Disparo(Point posCreacion) {
		this.posCreacion=posCreacion;
		posActual=null;
		entidadGrafica=null;
		poderAtaque=0;
		VelocidadDesplazamiento=0;
	}

	public abstract Point desplazarse();

	public ImageIcon getSprite() {
		return entidadGrafica.getSprite();
	}
	public int getPoderAtaque() {
		return poderAtaque;
	}
	public void setPoderAtaque(int poderAtaque) {
		this.poderAtaque = poderAtaque;
	}
	public int getVelocidadDesplazamiento() {
		return VelocidadDesplazamiento;
	}
	public void setVelocidadDesplazamiento(int velocidadDesplazamiento) {
		VelocidadDesplazamiento = velocidadDesplazamiento;
	}
	public Point getPosCreacion() {
		return posCreacion;
	}
	public void setPosCreacion(Point posCreacion) {
		this.posCreacion = posCreacion;
	}

}
