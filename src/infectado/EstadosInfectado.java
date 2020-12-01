package infectado;

public enum EstadosInfectado {
		
	DESPLAZANDOSE(0),
	ATACANDO(1),
	FREEZE(2),
	MUERTO(3);
	
	private int estado;

    private EstadosInfectado(int estado){
        this.estado = estado;
    }

    public int getEstado() {
        return estado;
    }
	
}
