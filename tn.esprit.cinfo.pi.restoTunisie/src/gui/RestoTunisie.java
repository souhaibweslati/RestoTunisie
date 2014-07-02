package gui;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class RestoTunisie extends JFrame {

	private static final long serialVersionUID = 1L;

	static RestoTunisie acceuil = null;
	
	public RestoTunisie() {
		setTitle("Resto Tunisie");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel contentPanel = new ImporterImage("Image/background_resto2.jpg",
				0, 0);
		setContentPane(contentPanel);
		revalidate();

	}

	public static void main(String args[]) {
		acceuil = new RestoTunisie();
		acceuil.setSize(1280, 600);
		
//		JMenuBar menuBar = new JMenuBar();
//
//		final JMenu consultation = new JMenu("Consulter Resto");
//		menuBar.add(consultation);
//
//		JMenu commande = new JMenu("Passer une commande");
//		menuBar.add(commande);
//
//		JMenu avis = new JMenu("Avis");
//		menuBar.add(avis);
//
//		JMenu aide = new JMenu("?");
//		menuBar.add(aide);
//		acceuil.setJMenuBar(menuBar);
		
		final PanelResto resto = new PanelResto();
		resto.setBackground(Color.white);
		resto.setBounds(10, 10, 500, 100);
		acceuil.add(resto);
		acceuil.setVisible(true);

	}
}
