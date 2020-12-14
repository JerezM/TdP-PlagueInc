package properties;

public enum FrameProperties {
    
    WIDTH(755),
    HEIGHT(637),
    POS_X_CREACION(300),
    POS_Y_CREACION(25);

    private int valor;

    private FrameProperties(int valor){
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}
