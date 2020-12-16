package properties;

public enum OleadaEnemigosLvl1Properties {
    
    CANTIDAD_ENEMIGOS_ACTIVOS(2),//dificultad del nivel
    CANTIDAD_OLEADAS(2);//duracion del nivel

    private int valor;

    private OleadaEnemigosLvl1Properties(int valor){
        this.valor = valor;
        
    }

    public int getValor() {
        return valor;
    }
}
