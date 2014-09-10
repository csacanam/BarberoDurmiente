package vista;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import modelo.Barberia;

public class PanelPrincipal extends JPanel implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Barberia barberia;

	private int xCabezaPos;
	private int yCabezaPos;
	private int widthCabeza;
	private int heightCabeza;

	//Indica si hay un cliente nuevo o no
	private boolean clienteNuevo;
	//Contador de clientes nuevos
	private int contadorClientesNuevos;
	//Contador de segundo
	private int contadorSegundos;
	

	public PanelPrincipal(Barberia barberia) {
		this.barberia = barberia;
		contadorClientesNuevos=0;
		contadorSegundos=0;
		xCabezaPos = 200;
		yCabezaPos = 130;
		widthCabeza = 30;
		heightCabeza = 30;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// SILLAS DE ESPERA

		// Primera silla
		if (barberia.getSillasDeEspera()[4].isOcupada() == true) {
			g.setColor(new Color(255, 0, 0));
			g.fillOval(20, 20, 30, 30);

		} else {
			g.setColor(new Color(0, 255, 0));
			g.fillOval(20, 20, 30, 30);
		}

		// Segunda silla
		if (barberia.getSillasDeEspera()[3].isOcupada() == true) {
			g.setColor(new Color(255, 0, 0));
			g.fillOval(60, 20, 30, 30);

		} else {
			g.setColor(new Color(0, 255, 0));
			g.fillOval(60, 20, 30, 30);
		}

		// Tercera silla
		if (barberia.getSillasDeEspera()[2].isOcupada() == true) {
			g.setColor(new Color(255, 0, 0));
			g.fillOval(100, 20, 30, 30);

		} else {
			g.setColor(new Color(0, 255, 0));
			g.fillOval(100, 20, 30, 30);
		}

		// Cuarta silla
		if (barberia.getSillasDeEspera()[1].isOcupada() == true) {
			g.setColor(new Color(255, 0, 0));
			g.fillOval(140, 20, 30, 30);

		} else {
			g.setColor(new Color(0, 255, 0));
			g.fillOval(140, 20, 30, 30);
		}

		// Quinta silla
		if (barberia.getSillasDeEspera()[0].isOcupada() == true) {
			g.setColor(new Color(255, 0, 0));
			g.fillOval(180, 20, 30, 30);

		} else {
			g.setColor(new Color(0, 255, 0));
			g.fillOval(180, 20, 30, 30);
		}

		// Silla de barbería
		if (barberia.getSillaDeBarberia().isOcupada() == false) {
			g.fillRect(220, 20, 30, 30);
		} else {
			g.setColor(new Color(255, 0, 0));
			g.fillRect(220, 20, 30, 30);
		}

		// BARBERO
		g.setColor(new Color(0, 0, 0));
		g.drawString("Barbero", xCabezaPos - 10, yCabezaPos + heightCabeza + 20);
		if (barberia.getBarbero().isDormido() == false) {
			g.setColor(new Color(0, 0, 255));
			g.fillOval(xCabezaPos, yCabezaPos, widthCabeza, heightCabeza);
		} else {
			g.setColor(new Color(173, 173, 173));
			g.fillOval(xCabezaPos, yCabezaPos, widthCabeza, heightCabeza);

		}
		


		// CLIENTE NUEVO
		g.setColor(new Color(0, 0, 0));
		g.drawString("Clientes", 12, 280);
		if (clienteNuevo == true) {
			g.setColor(new Color(139, 69, 19));
			g.fillOval(20, 220, 30, 30);

			if (barberia.haySillasDeEsperaDisponibles() == false) {
				g.setColor(new Color(255, 0, 0));
				g.fillOval(20, 220, 30, 30);
				g.drawString("No hay espacio", 60, 240);
			}

		} else {
			g.setColor(new Color(255, 255, 255));
			g.fillOval(20, 220, 30, 30);
		}
		
		//CONTADOR
		g.setColor(new Color(0,0,0));
		g.drawString("Segundos:" + contadorSegundos, xCabezaPos - 10, yCabezaPos + heightCabeza + 100);
		

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			if (barberia.hayClienteNuevo() == true) {
				System.out.println("Cliente "+ contadorClientesNuevos);
				contadorClientesNuevos++;
				// Llega un cliente nuevo
				clienteNuevo = true;
				repaint();
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				clienteNuevo = false;
				barberia.llegaCliente();
				repaint();
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}


			}else{


				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			contadorSegundos++;
			repaint();

		}

	}

}
