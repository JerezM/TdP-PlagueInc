package disparos;

public enum DisparoInfectadoProperties {
	
	PODER_ATAQUE(20),
	VELOCIDAD_DESPLAZAMIENTO(15);
	
	private int valor;
	
	private DisparoInfectadoProperties(int val) {
		valor=val;
	}
	
	public int getValor() {
		return valor;
	}
	
}
