package main.view.ui_updater;

import java.awt.Image;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import main.view.mapa.MapaViewControllerImpl;
import main.view.mapa.MapaViewUpdaterController;

public class UIUpdater {
    
    private static UIUpdater instance;

    private Map<Integer, JLabel> labelsActuales;
    private MapaViewUpdaterController mapaViewController;

    private UIUpdater() {
        mapaViewController = MapaViewControllerImpl.getInstance();
        labelsActuales = new HashMap<Integer, JLabel>();
    }

    public static UIUpdater getInstance() {
        if( instance == null ) {
			instance = new UIUpdater();
		}
		
		return instance;
    }

    /**
     * Se encarga de generar el label con los valores parametrizados.
     * @param id ID el cual identificara el label(en este caso se utilizara el hashcode).
     * @param posicion Posicion de creacion del label.
     * @param width Width del label.
     * @param height Heigth del label.
     * @param sprite Imagen que poseera el label.
     */
    public void generarLabel(int id, Point posicion, int width, int height, ImageIcon sprite) {
        JLabel label = new JLabel();

        int posX = (int) posicion.getX();
        int posY = (int) posicion.getY();
        
        label.setBounds(posX, posY, width, height);

        this.pintarLabel(label, sprite);
        
        labelsActuales.put(id, label);

        mapaViewController.agregarLabel(label);
    }

    /**
     * Se encarga de actualizar la posicion del label identificado por el id parametrizado.
     * @param id ID el cual identificara el label(en este caso se utilizara el hashcode).
     * @param posicion Posicion nueva que poseera el label.
     */
    public void updatePosicionLabel(int id, Point posicion) {
        JLabel label = labelsActuales.get(id);

        label.setLocation(posicion);
    }

    /**
     * Se encarga de actualizar el sprite del label identifica por el id parametrizado.
     * @param id ID el cual identificara el label(en este caso se utilizara el hashcode).
     * @param sprite Imagen nueva que poseera el label.
     */
    public void updateSpriteLabel(int id, ImageIcon sprite) {
        JLabel label = labelsActuales.get(id);

        this.pintarLabel(label, sprite);
    }

    /**
     * Se encarga de pintar en el label el sprite parametrizado.
     * @param label label a pintar.
     * @param sprite sprite que poseera el label.
     */
    private void pintarLabel(JLabel label, ImageIcon sprite) {
        label.setIcon(sprite);
        Image image = sprite.getImage();

		if (image != null) {  
			Image newimg = image.getScaledInstance(label.getWidth(), label.getHeight(), java.awt.Image.SCALE_SMOOTH);
			sprite.setImage(newimg);
			label.repaint();
		}
    }
}
