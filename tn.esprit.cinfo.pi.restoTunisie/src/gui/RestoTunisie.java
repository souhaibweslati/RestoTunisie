package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class RestoTunisie extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public RestoTunisie() {
		setTitle("Resto Tunisie");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		JLabel background = new JLabel(new ImageIcon(
				"Image/background_resto.jpg"));
		add(background);
		background.setLayout(new FlowLayout());

	}

	public static void main(String args[]) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RestoTunisie frame = new RestoTunisie();
					frame.setVisible(true);
					frame.setSize(970, 600);

					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					JMenuBar menuBar = new JMenuBar();

					// File Menu, F - Mnemonic
					JMenu fileMenu = new JMenu("Consulter Carte");
					fileMenu.setMnemonic(KeyEvent.VK_F);
					menuBar.add(fileMenu);

//					// File->New, N - Mnemonic
//					JMenuItem newMenuItem = new JMenuItem("New", KeyEvent.VK_N);
//					JMenuItem newMenuItem2 = new JMenuItem("New2", KeyEvent.VK_N);
//					newMenuItem.addActionListener(menuListener);
//					fileMenu.add(newMenuItem);
//					fileMenu.add(newMenuItem2);
					
					// File Menu, F - Mnemonic
					JMenu commande = new JMenu("Passer une commande");
					fileMenu.setMnemonic(KeyEvent.VK_F);
					menuBar.add(commande);
					
					// File Menu, F - Mnemonic
					JMenu avis = new JMenu("Avis");
					fileMenu.setMnemonic(KeyEvent.VK_F);
					menuBar.add(avis);

					frame.setJMenuBar(menuBar);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
