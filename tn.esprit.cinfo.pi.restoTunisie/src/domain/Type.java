package domain;

public class Type {
	
	private int id_type;
	private String nom_type;
	
	public Type() {
	}

	public Type(int id_type, String nom_type) {
		super();
		this.id_type = id_type;
		this.nom_type = nom_type;
	}

	public int getId_type() {
		return id_type;
	}

	public void setId_type(int id_type) {
		this.id_type = id_type;
	}

	public String getNom_type() {
		return nom_type;
	}

	public void setNom_type(String nom_type) {
		this.nom_type = nom_type;
	}

	@Override
	public String toString() {
		return "Type [id_type=" + id_type + ", nom_type=" + nom_type + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_type;
		result = prime * result
				+ ((nom_type == null) ? 0 : nom_type.hashCode());
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
		Type other = (Type) obj;
		if (id_type != other.id_type)
			return false;
		if (nom_type == null) {
			if (other.nom_type != null)
				return false;
		} else if (!nom_type.equals(other.nom_type))
			return false;
		return true;
	}
	
	
}
