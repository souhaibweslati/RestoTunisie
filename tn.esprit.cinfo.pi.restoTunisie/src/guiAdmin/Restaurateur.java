package guiAdmin;


import gui.PanelResto;
import gui.PanelRestoAdmin;

import java.awt.Color;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import service.dao.RestoDAO;
import domain.Resto;

public class Restaurateur extends JFrame {

	private static final long serialVersionUID = 1L;
	
	static Restaurateur acceuil = null;
	static JTextField nameResto = new JTextField(6);
	private static JTextField placeResto = new JTextField(6);
	private static JTextField Fourchette = new JTextField(6);
	static JButton saveResto =new JButton("Save");
	static Label labelResto = new Label("Add New Resto");
	static Label labelName = new Label("nameResto");
	static Label labelPlace = new Label("placeResto");
	static Label labelFourchette = new Label("Fourchette");
	public static PanelRestoAdmin restotablo = new PanelRestoAdmin(); 
	
	public Restaurateur() {
		setTitle("Restaurateur Insert Resto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel contentPanel = new ImporterImage("Image/background_resto2.jpg",
				0, 0);
		setContentPane(contentPanel);
		this.add(labelResto);
		this.add(labelName);
		this.add(nameResto);
		this.add(labelPlace);
		this.add(placeResto);
		this.add(labelFourchette);
		this.add(Fourchette);
		saveResto.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				RestoDAO dao = new RestoDAO();
				Resto resto = new Resto(nameResto.getText(),placeResto.getText(),Integer.parseInt(Fourchette.getText()));
				dao.save(resto);
				nameResto.setText("");
				placeResto.setText("");
				Fourchette.setText("");
				restotablo.scrollPane.remove(restotablo.table);
				restotablo.remove(restotablo.scrollPane);
				restotablo.remove(restotablo);
				restotablo.refreshview();
				
				//acceuil.remove(restotablo);
				//restotablo = new PanelRestoAdmin();
				restotablo.repaint();
				acceuil.add(restotablo);
				acceuil.repaint();
				acceuil.revalidate();
				
			
			}
			
		});
		this.add(saveResto);
	}
	

	public static void main(String args[]) {

		acceuil = new Restaurateur();
		restotablo.refreshview();
		acceuil.add(restotablo);
		acceuil.setSize(1280, 600);
		acceuil.setVisible(true);
		
	}
}