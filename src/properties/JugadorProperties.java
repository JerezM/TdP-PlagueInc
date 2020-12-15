package properties;

public enum JugadorProperties {
    
    VIDA(100),
    VELOCIDAD_DESPLAZAMIENTO(15),
    WIDTH(33),
    HEIGHT(33),
    POS_CREACION_EJE_X((MapaProperties.WIDTH.getValor() / 2) - 33),
    POS_CREACION_EJE_Y(MapaProperties.HEIGHT.getValor() - 66);

    private int valor;

    private JugadorProperties(int valor){
        this.valor = valor;
        
    }

    public int getValor() {
        return valor;
    }
}
