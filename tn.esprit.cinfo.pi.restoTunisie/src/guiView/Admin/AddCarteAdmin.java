package guiView.Admin;

import guiAdmin.ImporterImage;
import guiAdmin.PanelCarteAdmin;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import service.dao.CarteDAO;
import service.dao.RestoDAO;
import domain.Carte;
import domain.Resto;



public class AddCarteAdmin extends JFrame {

	private static final long serialVersionUID = 1L;

	static AddCarteAdmin acceuil = null;
	static JTextField nameCarte = new JTextField(6);
	DefaultListModel<String> model;
	static JButton saveCarte = new JButton("Save");
	static Label labelCarte = new Label("Add new carte");
	private JComboBox liste;
	public int idSelected ;
	static PanelCarteAdmin carteAdmin = new PanelCarteAdmin();
	public AddCarteAdmin() {
		
		
		
		RestoDAO dao = new RestoDAO();
		List<Resto> restos = dao.findAll();
		
		String[] nomResto = new String[restos.size()];
		final int[] idResto = new int[restos.size()];
		
		for (int i = 0; i < restos.size(); i++) {
		
			nomResto[i]=restos.get(i).getName_resto();
			idResto[i]=restos.get(i).getId_resto();
		}
		
		liste = new JComboBox(nomResto);
		
		setTitle("Add Carte");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel contentPanel = new ImporterImage("Image/background_resto2.jpg",
				0, 0);
		setContentPane(contentPanel);
		this.add(labelCarte);
		this.add(nameCarte);
		this.add(liste);
		
		
		
		liste.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//liste.getSelectedItem();
				idSelected=idResto[liste.getSelectedIndex()];
				
				System.out.println(idSelected);
			}
		});
		saveCarte.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				CarteDAO dao = new CarteDAO();
				
				Resto resto = new Resto();
				resto.setId_resto(idSelected);
				Carte carte = new Carte(nameCarte.getText(),resto);
				dao.save(carte);
				carteAdmin.scrollPane.remove(carteAdmin.table);
				carteAdmin.remove(carteAdmin.scrollPane);
				carteAdmin.remove(carteAdmin);
				carteAdmin.refreshview();
				nameCarte.setText("");

			}

		});

		this.add(saveCarte);
		this.add(carteAdmin);
	}

	public static void main(String args[]) {
		acceuil = new AddCarteAdmin();
		acceuil.setSize(1280, 600);
		acceuil.setVisible(true);

	}
}
