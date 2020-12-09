package Disparos;

public enum DisparoNormalArmaSimpleProperties {
	
	PODER_ATAQUE(40),
	VELOCIDAD_DESPLAZAMIENTO(25);
	
	private int valor;
	
	private DisparoNormalArmaSimpleProperties(int val) {
		valor=val;
	}
	
	public int getValor() {
		return valor;
	}
	
}
