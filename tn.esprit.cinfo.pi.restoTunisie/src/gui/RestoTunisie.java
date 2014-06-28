package gui;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class RestoTunisie extends JFrame {

	private static final long serialVersionUID = 1L;

	static RestoTunisie acceuil = null;
	
	public RestoTunisie() {
		setTitle("Resto Tunisie");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel contentPanel = new ImporterImage("Image/background_resto.jpg",
				0, 0);
		setContentPane(contentPanel);

	}

	public static void main(String args[]) {

		acceuil = new RestoTunisie();
		acceuil.setSize(970, 600);
		
		JMenuBar menuBar = new JMenuBar();

		final JMenu consultation = new JMenu("Consulter Resto");
		menuBar.add(consultation);

		JMenu commande = new JMenu("Passer une commande");
		menuBar.add(commande);

		JMenu avis = new JMenu("Avis");
		menuBar.add(avis);

		JMenu aide = new JMenu("?");
		menuBar.add(aide);

		acceuil.setJMenuBar(menuBar);
		acceuil.setVisible(true);
		
		
		final PanelResto Resto = new PanelResto();
		final PanelCommande Commande = new PanelCommande();
		final PanelCarte carte = new PanelCarte(1);
		consultation.addMenuListener(new MenuListener() {
			
			public void menuSelected(MenuEvent e) {
				acceuil.add(Resto);
				acceuil.add(carte);
				System.out.println("selected");
				//
			}

			public void menuDeselected(MenuEvent e) {
				acceuil.remove(Commande);
				System.out.println("Des resto");
				//acceuil.setVisible(false);
			}

			public void menuCanceled(MenuEvent e) {
				// TODO Auto-generated method stub

			}
		});
		commande.addMenuListener(new MenuListener() {
			
			public void menuSelected(MenuEvent e) {
			//	acceuil.add(Commande);
				acceuil.setVisible(true);
				
				System.out.println("selectedcommande");

			}

			public void menuDeselected(MenuEvent e) {
				acceuil.remove(Resto);
				System.out.println("Des commande");
				// TODO Auto-generated method stub

			}

			public void menuCanceled(MenuEvent e) {
				// TODO Auto-generated method stub

			}

		});
		// // // File->New, N - Mnemonic
		// // JMenuItem newMenuItem = new JMenuItem("New", KeyEvent.VK_N);
		// // JMenuItem newMenuItem2 = new JMenuItem("New2", KeyEvent.VK_N);
		// // newMenuItem.addActionListener(menuListener);
		// // fileMenu.add(newMenuItem);
		// // fileMenu.add(newMenuItem2);
	}
}
