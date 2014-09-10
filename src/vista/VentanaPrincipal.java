package vista;

import java.awt.Color;
import javax.swing.JFrame;
import modelo.Barberia;

public class VentanaPrincipal extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public VentanaPrincipal(){
		setSize(300,350);
		setTitle("Barbero Durmiente");

	}
	
	public static void main(String[]args){
		Barberia barberia = new Barberia();
		VentanaPrincipal ventana= new VentanaPrincipal();
		PanelPrincipal panel = new PanelPrincipal(barberia);
		panel.setOpaque(true);
		panel.setBackground(Color.WHITE);
		ventana.getContentPane().add(panel);
		ventana.setVisible(true);
		
		//Iniciar hilos del barbero y del panel
		barberia.getBarbero().start();;
		new Thread(panel).start();
	}


}
