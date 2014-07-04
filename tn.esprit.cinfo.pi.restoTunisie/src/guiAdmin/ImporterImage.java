package guiAdmin;

import java.awt.*;
import java.awt.Image;

import javax.swing.*;
public class ImporterImage extends JPanel {
	private static final long serialVersionUID = 1L;
	int x,y,hauteur;
	int choix=0;
	Boolean apresinsertion=false;
	private ImageIcon INTERFACE,LECTEUR,CARTE;
	public ImporterImage(String nom,int x,int y) {
		this.x=x;
		this.y=y;
		choix=0;
		apresinsertion=false;
		INTERFACE = new ImageIcon(nom) ;
		LECTEUR = new ImageIcon("lecteur.png") ;
		CARTE = new ImageIcon("carte.png") ;
	}
	public ImporterImage(Boolean apresinsertion,String nom,String lecteur,String carte,int x,int y,int hauteur) {
		this.x=x;
		this.y=y;
		this.apresinsertion=apresinsertion;
		apresinsertion=true;
		choix=1;
		this.hauteur=hauteur;
		INTERFACE = new ImageIcon(nom) ;
		LECTEUR = new ImageIcon(lecteur) ;
		CARTE = new ImageIcon(carte) ;
	}
	public ImporterImage(String nom,String lecteur,String carte,int x,int y,int hauteur) {
		this.x=x;
		this.y=y;
		apresinsertion=false;
		choix=1;
		this.hauteur=hauteur;
		INTERFACE = new ImageIcon(nom) ;
		LECTEUR = new ImageIcon(lecteur) ;
		CARTE = new ImageIcon(carte) ;
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g) ;
		
		Image im = INTERFACE.getImage();
		g.drawImage(im,x,y,this) ;
		Image lect = LECTEUR.getImage();
		Image car = CARTE.getImage();
		if(choix==1){		
			if(apresinsertion==true)
				g.drawImage(car,141,-107-hauteur,this) ;
			else
				g.drawImage(car,141,42-hauteur,this) ;
			g.drawImage(lect,35,0,this) ;
		}
	}
}