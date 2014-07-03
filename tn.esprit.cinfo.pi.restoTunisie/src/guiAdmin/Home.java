package guiAdmin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Home extends JFrame {
	
	static JButton saveCarte = new JButton("Close");
	static JButton saveCarte2 = new JButton("Close");
	static Home acceuil = null;
	
	
	public Home() {
	}
	
	
	
	public void Plan(){
		saveCarte.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		acceuil.add(saveCarte);
		acceuil.add(saveCarte2);
	}
	
	
	public static void main(String[] args) {
		acceuil = new Home();
		acceuil.Plan();
		acceuil.setSize(1280, 600);
		acceuil.setVisible(true);
	}
	

}
