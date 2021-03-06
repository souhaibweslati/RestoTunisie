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

import service.dao.CarteDAO;
import domain.Carte;

public class PanelCarte extends JPanel {

	private static final long serialVersionUID = 1L;
	private boolean DEBUG = false;
	private MenuPanel menu;
     public PanelCarte(int id_resto) {
    	 
          super(new GridLayout(1, 0));
          
          CarteDAO Cartedao = new CarteDAO();
          List<Carte> Cartes = Cartedao.findAllByID(id_resto);
          
          final JTable table = new JTable(new MyTableModel(Cartes));
          table.setPreferredScrollableViewportSize(new Dimension(400,80));
          table.setFillsViewportHeight(true);
          table.setShowGrid(false);
          table.setOpaque(false);
          this.setSize(400,80);
          // Create the scroll pane and add the table to it.
          JScrollPane scrollPane = new JScrollPane(table);
          // Add the scroll pane to this panel.
          add(scrollPane);
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
    					 if(menu!= null)
    						 remove(menu);
         	            int idcarte=Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
         	            System.out.println("test"+idcarte);
         	            menu = new MenuPanel(idcarte);
         	            add(menu);
         	            setVisible(true);
         	           revalidate();
         	        } 
    			}
    		});
     }


     static class MyTableModel extends AbstractTableModel {
		private static final long serialVersionUID = 1L;
		private String[] columnNames = {"id","nom_carte"};
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
//     private static void createAndShowGUI() {
//          // Create and set up the window.
//          JFrame frame = new JFrame("PanelCarte");
//          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//          // Create and set up the content pane.
//          PanelCarte newContentPane = new PanelCarte(1);
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