package main.view.mapa;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import properties.MapaProperties;

@SuppressWarnings("serial")
public class MapaView extends JPanel {
    
    private static MapaView instance;

    private ImageIcon imagenMapa;

    private MapaView() {
        int widthMapa = MapaProperties.WIDTH.getValor();
        int heightMapa = MapaProperties.HEIGHT.getValor();

        this.setPreferredSize(new Dimension(widthMapa, heightMapa));
    }

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
