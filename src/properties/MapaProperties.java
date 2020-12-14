package properties;

public enum MapaProperties {
    
    WIDTH(FrameProperties.WIDTH.getValor()),
    HEIGHT(FrameProperties.HEIGHT.getValor());

    private int valor;

    private MapaProperties(int valor){
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}
