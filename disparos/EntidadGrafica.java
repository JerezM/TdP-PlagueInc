package disparos;

import javax.swing.ImageIcon;

public class EntidadGrafica {

    protected ImageIcon spriteIcon;

    public EntidadGrafica() {}

    /**
     * Consulta el sprite actual.
     * @return El sprite actual que contiene la entidad grafica.
     */
    public ImageIcon getSprite() {
        return spriteIcon;
    }
    
}
