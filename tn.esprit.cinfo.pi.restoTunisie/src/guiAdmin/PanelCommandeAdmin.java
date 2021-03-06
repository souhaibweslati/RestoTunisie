package guiAdmin;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import service.dao.CommandeDAO;
import domain.Commande;

public class PanelCommandeAdmin extends JPanel {

	private static final long serialVersionUID = 1L;
	public JTable table;
	private PanelCommandeAdmin id_commande;
	public JScrollPane scrollPane;
	public int id;
	static JButton deleteCommande = new JButton("Delete Commande");

	public PanelCommandeAdmin() {
		refreshview();
	}

	public void refreshview() {

		CommandeDAO commandeDao = new CommandeDAO();
		List<Commande> commandes = commandeDao.findAll();

		table = new JTable(new MyTableModel(commandes));

		table.setPreferredScrollableViewportSize(new Dimension(800, 100));
		table.setFillsViewportHeight(true);
		table.setShowGrid(false);
		table.setOpaque(false);
		// this.setSize(300,100);
		table.revalidate();
		table.repaint();
		table.setVisible(true);
		// Create the scroll pane and add the table to it.
		scrollPane = new JScrollPane(table);
		// Add the scroll pane to this panel.
		scrollPane.revalidate();
		scrollPane.repaint();
		scrollPane.setVisible(true);

		add(scrollPane);
		add(deleteCommande);
		revalidate();
		repaint();
		setVisible(true);

		table.addMouseListener(new MouseListener() {

			public void mouseReleased(MouseEvent e) {

			}

			public void mousePressed(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {

			}

			public void mouseEntered(MouseEvent e) {

			}

			public void mouseClicked(MouseEvent e) {
				if (table.getSelectedRow() > -1) {
					// print first column value from selected row
					if (id_commande != null)
						remove(id_commande);

					id = Integer.parseInt(table.getValueAt(
							table.getSelectedRow(), 0).toString());
					System.out.println("test" + id);
					setVisible(true);
					revalidate();
				}
			}
		});

		deleteCommande.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CommandeDAO commandeDAO = new CommandeDAO();
				commandeDAO.removeById(id);
				scrollPane.remove(table);
				remove(scrollPane);
				refreshview();
				repaint();
			}

		});
	}

	static class MyTableModel extends AbstractTableModel {
		private static final long serialVersionUID = 1L;
		private String[] columnNames = { "id", "Commande","Name Client","Mail Client","Tel client","Name Resto" };
		ArrayList<Commande> commandes = null;

		MyTableModel(List<Commande> commandes) {
			this.commandes = (ArrayList<Commande>) commandes;
		}

		public int getColumnCount() {
			return columnNames.length;
		}

		public int getRowCount() {
			return commandes.size();
		}

		public String getColumnName(int col) {
			return columnNames[col];
		}

		public Object getValueAt(int row, int col) {

			Commande object = commandes.get(row);
			switch (col) {

			case 0:
				return object.getId_commande();
			case 1:
				return object.getCommande();
			case 2:
				return object.getClient().getNom_client();
			case 3:
				return object.getClient().getAdresse_mail();
			case 4:
				return object.getClient().getTel();
			case 5:
				return object.getResto().getName_resto();

			default:
				return "unknown";
			}

		}

	}
	

}