package properties;

public enum JugadorProperties {
    
    VIDA(100),
    VELOCIDAD_DESPLAZAMIENTO(25),
    WIDTH(33),
    HEIGHT(33),
    POS_CREACION_EJE_X(361),
    POS_CREACION_EJE_Y(600);

    private int valor;

    private JugadorProperties(int valor){
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}
