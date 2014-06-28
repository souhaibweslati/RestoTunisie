package gui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import service.dao.CarteDAO;
import domain.Carte;

public class PanelCarte extends JPanel {

	private static final long serialVersionUID = 1L;
	private boolean DEBUG = false;
     public PanelCarte(int id_resto) {
    	 
          super(new GridLayout(1, 0));
          
          CarteDAO Cartedao = new CarteDAO();
          List<Carte> Cartes = Cartedao.findAllByID(id_resto);
          
          JTable table = new JTable(new MyTableModel(Cartes));
          table.setPreferredScrollableViewportSize(new Dimension(500,100));
          table.setSize(500, 100);
          table.setFillsViewportHeight(true);
          table.setShowGrid(false);
          table.setOpaque(false);
          this.setSize(500,100);
          // Create the scroll pane and add the table to it.
          JScrollPane scrollPane = new JScrollPane(table);
          // Add the scroll pane to this panel.
          add(scrollPane);
     }


     static class MyTableModel extends AbstractTableModel {
		private static final long serialVersionUID = 1L;
		private String[] columnNames = { "id", "nom_carte"};
          ArrayList<Carte> Cartes = null;

          MyTableModel(List<Carte> Cartes) {
               this.Cartes = (ArrayList<Carte>) Cartes;
          }

          public int getColumnCount() {
               return columnNames.length;
          }

          public int getRowCount() {
               return Cartes.size();
          }

          public String getColumnName(int col) {
               return columnNames[col];
          }

		public Object getValueAt(int row, int col) {
			
	              Carte object = Cartes.get(row);
	              switch (col) {
	              case 0:
	                   return object.getId_carte();
	              case 1:
	                   return object.getNom_carte();
	              
	              default:
	                   return "unknown";
	              }
     }

     /**
      * Create the GUI and show it. For thread safety, this method should be
      * invoked from the event-dispatching thread.
      */
     private static void createAndShowGUI() {
          // Create and set up the window.
          JFrame frame = new JFrame("PanelCarte");
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

          // Create and set up the content pane.
          PanelCarte newContentPane = new PanelCarte(1);
          newContentPane.setOpaque(true); // content panes must be opaque
          frame.setContentPane(newContentPane);

          // Display the window.
          frame.pack();
          frame.setVisible(true);
          
     }
     
}
}