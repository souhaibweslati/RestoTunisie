package guiView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import guiAdmin.ImporterImage;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;




public class HomeClient extends JFrame {

	private static final long serialVersionUID = 1L;

	static HomeClient acceuil = null;
	DefaultListModel<String> model;
	static JButton consulterResto = new JButton("Consulter Resto");
	static JButton passeCommande = new JButton("Passé commande");
	static JButton close = new JButton("Close");
	public HomeClient() {
		
		
		
		setTitle("Home Client");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel contentPanel = new ImporterImage("Image/background_resto2.jpg",
				0, 0);
		setContentPane(contentPanel);
		
		this.add(consulterResto);
		this.add(passeCommande);
		this.add(close);
		close.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		consulterResto.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				RestoTunisie restoTunisie = new RestoTunisie();
				restoTunisie.loadView();

				
			}
		});
		
		passeCommande.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				AddCommandeClient restoTunisie = new AddCommandeClient();
				restoTunisie.loadView();

				
			}
		});
		
	}

	public static void main(String args[]) {
		acceuil = new HomeClient();
		acceuil.setSize(1280, 600);
		acceuil.setVisible(true);

	}
}
