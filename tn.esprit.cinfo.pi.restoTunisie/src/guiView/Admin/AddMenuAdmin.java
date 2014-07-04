package guiView.Admin;

import gui.MenuPanel;
import guiAdmin.ImporterImage;
import guiAdmin.PanelCarteAdmin;
import guiAdmin.PanelMenuAdmin;

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
import service.dao.MenuDAO;
import service.dao.RestoDAO;
import domain.Carte;
import domain.Menu;
import domain.Resto;



public class AddMenuAdmin extends JFrame {

	private static final long serialVersionUID = 1L;

	static AddMenuAdmin acceuil = null;
	static JTextField nameMenu = new JTextField(6);
	static JTextField prixMenu = new JTextField(6);
	DefaultListModel<String> model;
	static JButton saveMenu = new JButton("Save");
	static Label labelMenu = new Label("Add new Menu");
	static Label labelNomMenu = new Label("Nom Menu");
	static Label labelPrixMenu = new Label("Prix Menu");
	private JComboBox liste;
	public int idSelected ;
	public PanelMenuAdmin menuAdmin = new PanelMenuAdmin();
	public AddMenuAdmin() {
		
		
		
		CarteDAO dao = new CarteDAO();
		List<Carte> cartes = dao.findAll();
		
		String[] nomCarte = new String[cartes.size()];
		final int[] idCarte = new int[cartes.size()];
		
		for (int i = 0; i < cartes.size(); i++) {
		
			nomCarte[i]=cartes.get(i).getNom_carte();
			idCarte[i]=cartes.get(i).getId_carte();
		}
		
		liste = new JComboBox(nomCarte);
		
		setTitle("Add Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel contentPanel = new ImporterImage("Image/background_resto2.jpg",
				0, 0);
		setContentPane(contentPanel);
		this.add(labelMenu);
		this.add(labelNomMenu);
		this.add(nameMenu);
		this.add(labelPrixMenu);
		this.add(prixMenu);
		this.add(liste);
		
		
		
		liste.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//liste.getSelectedItem();
				idSelected=idCarte[liste.getSelectedIndex()];
				
				System.out.println(idSelected);
			}
		});
		saveMenu.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				MenuDAO dao = new MenuDAO();
				
				Carte carte = new Carte();
				carte.setId_carte(idSelected);
				Menu menu = new Menu(nameMenu.getText(),prixMenu.getText(), carte);
				dao.save(menu);
				menuAdmin.scrollPane.remove(menuAdmin.table);
				menuAdmin.remove(menuAdmin.scrollPane);
				menuAdmin.remove(menuAdmin);
				menuAdmin.refreshview();
				nameMenu.setText("");
				prixMenu.setText("");

			}

		});

		this.add(saveMenu);
		this.add(menuAdmin);
	}

	public static void main(String args[]) {
		acceuil = new AddMenuAdmin();
		acceuil.setSize(1280, 600);
		acceuil.setVisible(true);

	}
}
