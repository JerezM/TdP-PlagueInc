package main.view.mapa;

import javax.swing.ImageIcon;

public class MapaViewControllerImpl implements MapaViewController {

    private static MapaViewControllerImpl instance;

    private MapaView mapaView;

    private MapaViewControllerImpl() {
        mapaView = MapaView.getInstance();
    }

    public static MapaViewControllerImpl getInstance() {
        if( instance == null ) {
			instance = new MapaViewControllerImpl();
		}
		
		return instance;
    }

    @Override
    public void inicializarComponenteGraficoMapa(ImageIcon imagenMapa) {
        mapaView.inicializarImagenMapa(imagenMapa);
    }
    
}
