package main.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.view.mapa.MapaView;

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

        setTitle("PlagueInc");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(300, 25, 755, 637);
        setResizable(false);

		contentPane = MapaView.getInstance();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        
    }
    
}
