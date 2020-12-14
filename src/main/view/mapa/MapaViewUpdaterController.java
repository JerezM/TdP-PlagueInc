package main.view.mapa;

import javax.swing.JLabel;

public interface MapaViewUpdaterController {
    
    /**
     * Se encarga de agregar el label parametrizado como un componente del mapa.
     * @param label Label a agregar.
     */
    public void agregarLabel(JLabel label);

    /**
     * Se encarga de actualizar el mapa para que se puedan visualizar los cambios realizados.
     */
    public void updateView();
}
