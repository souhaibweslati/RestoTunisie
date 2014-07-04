package guiView;

import gui.ImporterImage;

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

import service.dao.ClientDAO;
import service.dao.CommandeDAO;
import service.dao.RestoDAO;
import domain.Client;
import domain.Commande;
import domain.Resto;

public class AddCommandeClient extends JFrame {

	private static final long serialVersionUID = 1L;

	static AddCommandeClient acceuil = null;
	static JTextField nameCommande = new JTextField(6);
	DefaultListModel<String> model;
	static JButton saveCommande = new JButton("Passé Commande");
	static Label labelCommande = new Label("Add new commande");
	private JComboBox listeClient;
	private JComboBox listeResto;
	public int idSelectedClient;
	public int idSelectedResto;

	public AddCommandeClient() {

		ClientDAO daoClient = new ClientDAO();
		List<Client> clients = daoClient.findAll();

		String[] nomClient = new String[clients.size()];
		final int[] idClient = new int[clients.size()];

		for (int i = 0; i < clients.size(); i++) {

			nomClient[i] = clients.get(i).getNom_client();
			idClient[i] = clients.get(i).getId_client();
		}

		RestoDAO daoResto = new RestoDAO();
		List<Resto> restos = daoResto.findAll();

		String[] nomResto = new String[restos.size()];
		final int[] idResto = new int[restos.size()];

		for (int i = 0; i < restos.size(); i++) {

			nomResto[i] = restos.get(i).getName_resto();
			idResto[i] = restos.get(i).getId_resto();
		}

		listeClient = new JComboBox(nomClient);
		listeResto = new JComboBox(nomResto);

		setTitle("Add Commande");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel contentPanel = new ImporterImage("Image/background_resto2.jpg",
				0, 0);
		setContentPane(contentPanel);
		this.add(labelCommande);

		this.add(listeClient);
		this.add(listeResto);
		this.add(nameCommande);

		listeClient.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// liste.getSelectedItem();
				idSelectedClient = idClient[listeClient.getSelectedIndex()];

				System.out.println(idSelectedClient);
			}
		});

		listeResto.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// liste.getSelectedItem();
				idSelectedResto = idResto[listeResto.getSelectedIndex()];

				System.out.println(idSelectedResto);
			}
		});

		saveCommande.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				CommandeDAO commandeDAO = new CommandeDAO();

				Resto resto = new Resto();
				resto.setId_resto(idSelectedResto);
				
				Client client = new Client();
				client.setId_client(idSelectedClient);
				
				Commande commande = new Commande(nameCommande.getText(),client,resto);
				
				commandeDAO.save(commande);
				nameCommande.setText("");

			}

		});

		this.add(saveCommande);
	}

	public static void main(String args[]) {
		acceuil = new AddCommandeClient();
		acceuil.setSize(1280, 600);
		acceuil.setVisible(true);

	}
}
