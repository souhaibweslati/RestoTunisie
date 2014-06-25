package domain;

public class Commande {
	
	private int id_commande;
	private String commande;
	Client client;
	Resto resto;
	
	public Commande() {
	}
	
	
	public Commande(int id_commande, String commande) {
		super();
		this.id_commande = id_commande;
		this.commande = commande;
	}
	
	public Commande(String commande) {
		super();
		this.commande = commande;
	}
	
	
	public Commande(int id_commande, String commande, Client client, Resto resto) {
		super();
		this.id_commande = id_commande;
		this.commande = commande;
		this.client = client;
		this.resto = resto;
	}


	public int getId_commande() {
		return id_commande;
	}

	public void setId_commande(int id_commande) {
		this.id_commande = id_commande;
	}

	public String getCommande() {
		return commande;
	}

	public void setCommande(String commande) {
		this.commande = commande;
	}
	
	
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Resto getResto() {
		return resto;
	}

	public void setResto(Resto resto) {
		this.resto = resto;
	}

	@Override
	public String toString() {
		return "Commande [id_commande=" + id_commande + ", commande="
				+ commande + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((commande == null) ? 0 : commande.hashCode());
		result = prime * result + id_commande;
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
		Commande other = (Commande) obj;
		if (commande == null) {
			if (other.commande != null)
				return false;
		} else if (!commande.equals(other.commande))
			return false;
		if (id_commande != other.id_commande)
			return false;
		return true;
	}
	
	
}
