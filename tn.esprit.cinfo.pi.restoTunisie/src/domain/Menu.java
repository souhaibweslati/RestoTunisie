package domain;

public class Menu {
	
	private int id_menu;
	private String nom_menu;
	private String prix;
	Carte carte;
	
	
	public Menu() {
	}
	
	public Menu(String nom_menu, String prix) {
		super();
		this.nom_menu = nom_menu;
		this.prix = prix;
	}

	public Menu(int id_menu, String nom_menu, String prix) {
		super();
		this.id_menu = id_menu;
		this.nom_menu = nom_menu;
		this.prix = prix;
	}
	
	public Menu(String nom_menu, String prix, Carte carte) {
		super();
		this.nom_menu = nom_menu;
		this.prix = prix;
		this.carte = carte;
	}

	public Carte getCarte() {
		return carte;
	}

	public void setCarte(Carte carte) {
		this.carte = carte;
	}

	public int getId_menu() {
		return id_menu;
	}

	public void setId_menu(int id_menu) {
		this.id_menu = id_menu;
	}

	public String getNom_menu() {
		return nom_menu;
	}

	public void setNom_menu(String nom_menu) {
		this.nom_menu = nom_menu;
	}

	public String getPrix() {
		return prix;
	}

	public void setPrix(String prix) {
		this.prix = prix;
	}

	@Override
	public String toString() {
		return "Menu [id_menu=" + id_menu + ", nom_menu=" + nom_menu
				+ ", prix=" + prix + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_menu;
		result = prime * result
				+ ((nom_menu == null) ? 0 : nom_menu.hashCode());
		result = prime * result + ((prix == null) ? 0 : prix.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Menu other = (Menu) obj;
		if (id_menu != other.id_menu)
			return false;
		if (nom_menu == null) {
			if (other.nom_menu != null)
				return false;
		} else if (!nom_menu.equals(other.nom_menu))
			return false;
		if (prix == null) {
			if (other.prix != null)
				return false;
		} else if (!prix.equals(other.prix))
			return false;
		return true;
	}
	
	

}
