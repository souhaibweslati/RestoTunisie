package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import service.dao.RestoDAO;
import domain.Resto;

public class PanelResto extends JPanel {

	private static final long serialVersionUID = 1L;
	private boolean DEBUG = false;
     public PanelResto() {
    	 
          super(new GridLayout(1, 0));
          
          RestoDAO restodao = new RestoDAO();
          List<Resto> restos = restodao.findAll();
          
          JTable table = new JTable(new MyTableModel(restos));
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
		private String[] columnNames = { "id", "nom", "lieu",
                    "forechette"};
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
     private static void createAndShowGUI() {
          // Create and set up the window.
          JFrame frame = new JFrame("PanelResto");
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

          // Create and set up the content pane.
          PanelResto newContentPane = new PanelResto();
          newContentPane.setOpaque(true); // content panes must be opaque
          frame.setContentPane(newContentPane);

          // Display the window.
          frame.pack();
          frame.setVisible(true);
          
     }

     public static void main(String[] args) {
          // Schedule a job for the event-dispatching thread:
          // creating and showing this application's GUI.
          javax.swing.SwingUtilities.invokeLater(new Runnable() {
               public void run() {
                    createAndShowGUI();
               }
          });
     }
}
}