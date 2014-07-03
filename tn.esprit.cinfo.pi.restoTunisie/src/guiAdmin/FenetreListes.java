package guiAdmin;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FenetreListes extends JFrame {
	private JComboBox liste1;
	private JComboBox liste2;
 
	//...
 
	private JPanel buildContentPane(){
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
 
		Object[] elements = new Object[]{"Element 1", "Element 2", "Element 3", "Element 4", "Element 5"};
 
		liste1 = new JComboBox(elements);
 
		panel.add(liste1);
 
		//JButton bouton = new JButton(new CopierAction(this, "Copier"));
 
		//panel.add(bouton);
 
		liste2 = new JComboBox(elements);
 
		panel.add(liste2);
 
		//JButton bouton2 = new JButton(new SupprimmerAction(this, "Enlever"));
 
		//panel.add(bouton2);
 
		//JButton bouton3 = new JButton(new ViderAction(this, "Vider"));
 
		//panel.add(bouton3);
 
		return panel;
	}
 
	public JComboBox getListe1(){
		return liste1;
	}
 
	public JComboBox getListe2(){
		return liste2;
	}
	
	
	
	public static void main(String[] args) {
		FenetreListes fenetreListes = new FenetreListes();
		fenetreListes.buildContentPane();
	}
}