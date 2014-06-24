package domain;

public class Client {
	
	private int id_client;
	private String nom_client;
	private String adresse_mail;
	private String tel;
	
	public Client(){
	}

	public Client(int id_client, String nom_client, String adresse_mail,
			String tel) {
		super();
		this.id_client = id_client;
		this.nom_client = nom_client;
		this.adresse_mail = adresse_mail;
		this.tel = tel;
	}

	public int getId_client() {
		return id_client;
	}

	public void setId_client(int id_client) {
		this.id_client = id_client;
	}

	public String getNom_client() {
		return nom_client;
	}

	public void setNom_client(String nom_client) {
		this.nom_client = nom_client;
	}

	public String getAdresse_mail() {
		return adresse_mail;
	}

	public void setAdresse_mail(String adresse_mail) {
		this.adresse_mail = adresse_mail;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "Client [id_client=" + id_client + ", nom_client=" + nom_client
				+ ", adresse_mail=" + adresse_mail + ", tel=" + tel + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((adresse_mail == null) ? 0 : adresse_mail.hashCode());
		result = prime * result + id_client;
		result = prime * result
				+ ((nom_client == null) ? 0 : nom_client.hashCode());
		result = prime * result + ((tel == null) ? 0 : tel.hashCode());
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
		Client other = (Client) obj;
		if (adresse_mail == null) {
			if (other.adresse_mail != null)
				return false;
		} else if (!adresse_mail.equals(other.adresse_mail))
			return false;
		if (id_client != other.id_client)
			return false;
		if (nom_client == null) {
			if (other.nom_client != null)
				return false;
		} else if (!nom_client.equals(other.nom_client))
			return false;
		if (tel == null) {
			if (other.tel != null)
				return false;
		} else if (!tel.equals(other.tel))
			return false;
		return true;
	}
	
	
	
	
}
