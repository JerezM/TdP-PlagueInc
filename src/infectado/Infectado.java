package infectado;

import java.awt.Point;

import javax.swing.ImageIcon;

import entidad.grafica.*;
import premio.*;

public abstract class Infectado {

	protected int velocidadDesplazamiento;
	protected int vida;
	protected int rangoAlcanceAtaque;
	protected int poderAtaque;
	protected int accionActual;
	protected Point posActual;
	protected int posCreacion;
	protected EntidadGrafica entidadGrafica;
	protected PremioFactory premioFactory;
	protected int estado;
	protected InfectadoVisitor visitor;
	
	public Infectado (int posicionCreacion) {
		
		this.vida= 100;
		this.posCreacion= posicionCreacion;
		this.posActual= new Point(posicionCreacion, 0); 
		this.velocidadDesplazamiento= 20;
		this.rangoAlcanceAtaque= 10;
		this.poderAtaque=24;
		this.premioFactory= PremioFactoryImpl.getInstance();
		// accion actual puede ser desplazamiento o atacando
	//.accionActual= EstadosInfectado.getEstado();
		this.visitor= new InfectadoVisitorImpl(this);
	}
	
	abstract void recibirAtaque (int poderAtaqueRecibido); // ABSTRACT 
	
	abstract void atacar();
	
	public  Point desplazarse() {
		
		double posYActual= posActual.getY();
		double posYNueva=posYActual+ velocidadDesplazamiento;
		double posXActual= posActual.getX();
		posActual.setLocation(posXActual,posYActual);
		 
		return posActual.getLocation();
	}
	
	public Premio lanzarPremio() {
	
		return premioFactory.createPremio();
	} 
	
	public int getVida() {
		return vida;
	}
	public void setVida(int v) {
		vida=v;
	}
	
	abstract ImageIcon getSprite();
	
	abstract void actualizarSprite(int nuevoEstado) ;	
}
