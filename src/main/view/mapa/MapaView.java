package main.view.mapa;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MapaView extends JPanel {
    
    private static MapaView instance;

    private ImageIcon imagenMapa;

    private MapaView() {}

    public static MapaView getInstance() {
        if( instance == null ) {
			instance = new MapaView();
		}
		
		return instance;
    }

    public void inicializarImagenMapa(ImageIcon imagenMapa) {
        this.imagenMapa = imagenMapa;
        this.repaint();
    }

    public void paint(Graphics g) {
        g.drawImage(imagenMapa.getImage(), 0, 0, getWidth(), getHeight(),this);
        setOpaque(false);
        super.paint(g);
    }

}
