package gui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import service.dao.MenuDAO;
import domain.Menu;

public class MenuPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private boolean DEBUG = false;
	
     public MenuPanel(int id_carte) {
    	 
          super(new GridLayout(1, 0));
          
          MenuDAO menudao = new MenuDAO();
          List<Menu> menus = menudao.findAllById(id_carte);
          
          final JTable table = new JTable(new MyTableModel(menus));
          table.setPreferredScrollableViewportSize(new Dimension(400,80));
          table.setFillsViewportHeight(true);
          table.setShowGrid(false);
          table.setOpaque(false);
          this.setSize(400,80);
          // Create the scroll pane and add the table to it.
          JScrollPane scrollPane = new JScrollPane(table);
          // Add the scroll pane to this panel.
          add(scrollPane);
          revalidate();
     }


     static class MyTableModel extends AbstractTableModel {
		private static final long serialVersionUID = 1L;
		private String[] columnNames = {"id","nom_Menu","prix"};
          ArrayList<Menu> Menus = null;

          MyTableModel(List<Menu> Menus) {
               this.Menus = (ArrayList<Menu>) Menus;
          }

          public int getColumnCount() {
               return columnNames.length;
          }

          public int getRowCount() {
               return Menus.size();
          }

          public String getColumnName(int col) {
               return columnNames[col];
          }

		public Object getValueAt(int row, int col) {
			
	              Menu object = Menus.get(row);
	              switch (col) {
	              case 0:
	                   return object.getId_menu();
	              case 1:
	                   return object.getNom_menu();
	              case 2:
	                   return object.getPrix();
	             
	              default:
	                   return "unknown";
	              }
     }

     /**
      * Create the GUI and show it. For thread safety, this method should be
      * invoked from the event-dispatching thread.
      */
//     private static void createAndShowGUI() {
//          // Create and set up the window.
//          JFrame frame = new JFrame("PanelMenu");
//          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//          // Create and set up the content pane.
//          PanelMenu newContentPane = new PanelMenu(1);
//          newContentPane.setOpaque(true); // content panes must be opaque
//          frame.setContentPane(newContentPane);
//
//          // Display the window.
//          frame.pack();
//          frame.setVisible(true);
//          
//     }
     
}
}