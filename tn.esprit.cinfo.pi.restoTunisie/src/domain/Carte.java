package domain;

public class Carte {
	
	private int id_carte;
	private String nom_carte;
	Resto resto;
	 
	public Carte() {
	}
	
	public Carte(int id_carte,String nom_carte) {
		super();
		this.id_carte = id_carte;
		this.nom_carte = nom_carte;
	}
	

	public Carte(String nom_carte) {
		super();
		this.nom_carte = nom_carte;
	}
	
	
	public Carte(String nom_carte, Resto resto) {
		super();
		this.nom_carte = nom_carte;
		this.resto = resto;
	}

	public int getId_carte() {
		return id_carte;
	}

	public void setId_carte(int id_carte) {
		this.id_carte = id_carte;
	}

	public String getNom_carte() {
		return nom_carte;
	}

	public void setNom_carte(String nom_carte) {
		this.nom_carte = nom_carte;
	}
	
	
	public Resto getResto() {
		return resto;
	}

	public void setResto(Resto resto) {
		this.resto = resto;
	}

	@Override
	public String toString() {
		return "Carte [id_carte=" + id_carte + ", nom_carte=" + nom_carte + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_carte;
		result = prime * result
				+ ((nom_carte == null) ? 0 : nom_carte.hashCode());
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
		Carte other = (Carte) obj;
		if (id_carte != other.id_carte)
			return false;
		if (nom_carte == null) {
			if (other.nom_carte != null)
				return false;
		} else if (!nom_carte.equals(other.nom_carte))
			return false;
		return true;
	}
	
	

}
