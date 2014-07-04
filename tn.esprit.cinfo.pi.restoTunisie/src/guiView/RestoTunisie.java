package guiView;

import gui.ImporterImage;
import gui.PanelResto;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class RestoTunisie extends JFrame {

	private static final long serialVersionUID = 1L;

	static RestoTunisie acceuil = new RestoTunisie();
	PanelResto resto ;
	static JButton close = new JButton("Close");

	public RestoTunisie() {
		setTitle("Resto Tunisie");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel contentPanel = new ImporterImage("Image/background_resto2.jpg",
				0, 0);
		setContentPane(contentPanel);
		
		

	}

	public void loadView() {
		
		
		acceuil.setSize(1280, 600);
		close.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				acceuil.remove(resto);
				acceuil.dispose();
				
			}
		});
		resto = new PanelResto();
		acceuil.add(resto);
		acceuil.add(close);
		acceuil.setVisible(true);
		

	}

	public static void main(String args[]) {
		acceuil = new RestoTunisie();
		acceuil.loadView();

	}
}
