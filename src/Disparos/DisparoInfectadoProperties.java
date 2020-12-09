package Disparos;

public enum DisparoInfectadoProperties {
	
	PODER_ATAQUE(10),
	VELOCIDAD_DESPLAZAMIENTO(20);
	
	private int valor;
	
	private DisparoInfectadoProperties(int val) {
		valor=val;
	}
	
	public int getValor() {
		return valor;
	}
	
}
