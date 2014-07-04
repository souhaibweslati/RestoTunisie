package guiView.Admin;

import guiAdmin.ImporterImage;
import guiAdmin.PanelCommandeAdmin;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CommandeListAmin extends JFrame {

	private static final long serialVersionUID = 1L;

	static CommandeListAmin acceuil = null;
	public PanelCommandeAdmin resto;
	static JButton close = new JButton("Close");
	
	public CommandeListAmin() {
		setTitle("Commande List Admin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel contentPanel = new ImporterImage("Image/background_resto2.jpg",
				0, 0);
		setContentPane(contentPanel);
		revalidate();

	}
	
	public void loadView(){
		acceuil = new CommandeListAmin();
		close.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				acceuil.remove(resto);
				acceuil.dispose();
				
			}
		});
		acceuil.setSize(1280, 600);
		resto = new PanelCommandeAdmin();
		resto.setBackground(Color.white);
		resto.setBounds(10, 10, 500, 100);
		acceuil.add(resto);
		acceuil.add(close);
		acceuil.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		CommandeListAmin commandeListAmin = new CommandeListAmin();
		commandeListAmin.loadView();
	}

}
