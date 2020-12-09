package premio;

import java.util.Timer;
import java.util.TimerTask;

import entidad.grafica.EntidadGraficaSuperArma;

public class SuperArma extends EfectoTemporal{
	
	public SuperArma(int posX, int posY) {
		
		super(posX,posY);
		velocidad=20;
		duracion=1500;
		//posActual; FALTA
		this.posX=posX;
		this.posY=posY;
		entidadGrafica= new EntidadGraficaSuperArma();
		
	}

	public void efecto(Jugador jugador) {
		
		Timer timer = new Timer();
		TimerTask tarea = new TimerTask() {
		ArmaSimpleNormalState estadoNormal= jugador.getArma().getState();
		
			public void run() {
			
				jugador.getArma().changeState(new ArmaSimplePwrUpState());
			}	
		};
		
		timer.schedule(tarea,10000);
		jugador.getArma().changeState(estadoNormal);
	}
	

	int getVelocidad() {
		
		return velocidad;
	}
}
