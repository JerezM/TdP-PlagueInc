package properties;

public enum OleadaEnemigosLvl2Properties {
    
    CANTIDAD_ENEMIGOS_ACTIVOS(3),//dificultad del nivel
    CANTIDAD_OLEADAS(2);//duracion del nivel

    private int valor;

    private OleadaEnemigosLvl2Properties(int valor){
        this.valor = valor;
        
    }

    public int getValor() {
        return valor;
    }
}
