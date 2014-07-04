package guiView.Admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import guiAdmin.ImporterImage;
import guiView.RestoTunisie;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class HomeAdmin extends JFrame {

	private static final long serialVersionUID = 1L;

	static HomeAdmin acceuil = null;
	DefaultListModel<String> model;
	static JButton gestionResto = new JButton("Gestion Resto");
	static JButton GestionCarte = new JButton("Gestion Carte");
	static JButton gestionMenu = new JButton("Gestion Menu");
	static JButton listCommande = new JButton("Gestion Commande");
	static JButton close = new JButton("Close");
	public HomeAdmin() {
		
		setTitle("Home Admin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel contentPanel = new ImporterImage("Image/background_resto2.jpg",
				0, 0);
		setContentPane(contentPanel);
		
		this.add(gestionResto);
		this.add(GestionCarte);
		this.add(gestionMenu);
		this.add(listCommande);
		this.add(close);
		close.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		gestionResto.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Restaurateur restaurateur = new Restaurateur();
				restaurateur.loadView();
			}
		});
		
		gestionMenu.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				AddMenuAdmin addMenuAdmin = new AddMenuAdmin();
				addMenuAdmin.loadView();
			}
		});
		
		GestionCarte.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				AddCarteAdmin addCarteAdmin = new AddCarteAdmin();
				addCarteAdmin.loadView();
			}
		});
		
		listCommande.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				CommandeListAmin commandeListAmin = new CommandeListAmin();
				commandeListAmin.loadView();
			}
		});
	}

	public static void main(String args[]) {
		acceuil = new HomeAdmin();
		acceuil.setSize(1280, 600);
		acceuil.setVisible(true);

	}
}
