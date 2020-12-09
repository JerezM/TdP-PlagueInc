package Disparos;

public enum DisparoPwrUpArmaSimpleProperties {


	PODER_ATAQUE(80),
	VELOCIDAD_DESPLAZAMIENTO(35);
	
	private int valor;
	
	private DisparoPwrUpArmaSimpleProperties(int val) {
		valor=val;
	}
	
	public int getValor() {
		return valor;
	}
	
	
}
