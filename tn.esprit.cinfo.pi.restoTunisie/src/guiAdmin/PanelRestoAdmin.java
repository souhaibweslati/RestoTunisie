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

import service.dao.RestoDAO;
import domain.Resto;

public class PanelRestoAdmin extends JPanel  {

	private static final long serialVersionUID = 1L;
	public JTable table;
	private PanelRestoAdmin id_resto;
	public JScrollPane scrollPane;
	public int id;
	static JButton deleteResto = new JButton("Delete Resto");
	public static PanelRestoAdmin restotablo = new PanelRestoAdmin();
	
	public PanelRestoAdmin() {

	}

	public void refreshview() {

		RestoDAO restodao = new RestoDAO();
		List<Resto> restos = restodao.findAll();

		table = new JTable(new MyTableModel(restos));

		table.setPreferredScrollableViewportSize(new Dimension(400, 100));
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
		add(deleteResto);
		
		repaint();
		setVisible(true);

		table.addMouseListener(new MouseListener() {

			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if (table.getSelectedRow() > -1) {
					// print first column value from selected row
					if (id_resto != null)
						remove(id_resto);

					id = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
					System.out.println("test" + id);
					setVisible(true);
					revalidate();
				}
			}
		});
		
		deleteResto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RestoDAO restoDao = new RestoDAO();
				restoDao.removeById(id);
				scrollPane.remove(table);
				remove(scrollPane);
				refreshview();
				repaint();
			}

		});
		
	}

	
	static class MyTableModel extends AbstractTableModel {
		private static final long serialVersionUID = 1L;
		private String[] columnNames = { "id", "nom", "lieu", "forechette" };
		ArrayList<Resto> restos = null;

		MyTableModel(List<Resto> restos) {
			this.restos = (ArrayList<Resto>) restos;
		}

		public int getColumnCount() {
			return columnNames.length;
		}

		public int getRowCount() {
			return restos.size();
		}

		public String getColumnName(int col) {
			return columnNames[col];
		}

		public Object getValueAt(int row, int col) {

			Resto object = restos.get(row);
			switch (col) {

			case 0:
				return object.getId_resto();
			case 1:
				return object.getName_resto();
			case 2:
				return object.getPlace_resto();
			case 3:
				return object.getFourchette();

			default:
				return "unknown";
			}

		}

		/**
		 * Create the GUI and show it. For thread safety, this method should be
		 * invoked from the event-dispatching thread.
		 */

		// private static void createAndShowGUI() {
		// // Create and set up the window.
		// JFrame frame = new JFrame("PanelResto");
		// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//
		// // Create and set up the content pane.
		// PanelRestoAdmin newContentPane = new PanelRestoAdmin();
		// newContentPane.setOpaque(true); // content panes must be opaque
		// frame.setContentPane(newContentPane);
		//
		// // Display the window.
		// frame.pack();
		// frame.setVisible(true);
		//
		// }

	}
}