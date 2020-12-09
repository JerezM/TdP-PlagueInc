package premio;

import java.util.Timer;
import java.util.TimerTask;

import entidad.grafica.EntidadGraficaCuarentenaObligatoria;

public class CuarentenaObligatoria extends EfectoTemporal{

	public CuarentenaObligatoria(int posX,int posY) {
		
		super(posX,posY);
		duracion=1000;
		velocidad=10;
		entidadGrafica= new EntidadGraficaCuarentenaObligatoria();
		//falta posx e posY. Preguntar por posInicial.
	}

	public void efecto() {
		
		//GameMaster
		Timer timer = new Timer();
		TimerTask tarea = new TimerTask() {

			public void run() {
			
				//detener enemigos
			}	
		};
		timer.schedule(tarea,10000);		
	}
	
	int getVelocidad() {
		
		return velocidad;
	}
}
