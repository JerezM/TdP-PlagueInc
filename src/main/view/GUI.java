package main.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.view.mapa.MapaView;
import properties.FrameProperties;

@SuppressWarnings("serial")
public class GUI extends JFrame {

    private static GUI instance;
    private JPanel contentPane;

    /**
     * Create the frame.
     */
    private GUI() {
        this.initComponents();
	}
	
	public static GUI getInstance() {
		if( instance == null ) {
			instance = new GUI();
		}
		
		return instance;
    }
    
    private void initComponents() {

        this.setTitle("PlagueInc");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        int posXCreacion = FrameProperties.POS_X_CREACION.getValor();
        int posYCreacion = FrameProperties.POS_Y_CREACION.getValor();
    
        this.setLocation(posXCreacion, posYCreacion);
        this.setResizable(false);

		contentPane = MapaView.getInstance();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
        this.setContentPane(contentPane);
        this.pack();
        
    }
    
}
