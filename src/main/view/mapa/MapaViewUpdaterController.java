package main.view.mapa;

import javax.swing.JLabel;

public interface MapaViewUpdaterController {
    
    /**
     * Se encarga de agregar el label parametrizado como un componente del mapa.
     * @param label Label a agregar.
     */
    public void agregarLabel(JLabel label);

}
