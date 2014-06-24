package domain;

public class Resto {
	
	private int id_resto;
	private String name_resto;
	private String place_resto;
	private String fourchette;
	
	public Resto() {
	}

	public Resto(int id_resto, String name_resto, String place_resto,
			String fourchette) {
		super();
		this.id_resto = id_resto;
		this.name_resto = name_resto;
		this.place_resto = place_resto;
		this.fourchette = fourchette;
	}

	public int getId_resto() {
		return id_resto;
	}

	public void setId_resto(int id_resto) {
		this.id_resto = id_resto;
	}

	public String getName_resto() {
		return name_resto;
	}

	public void setName_resto(String name_resto) {
		this.name_resto = name_resto;
	}

	public String getPlace_resto() {
		return place_resto;
	}

	public void setPlace_resto(String place_resto) {
		this.place_resto = place_resto;
	}

	public String getFourchette() {
		return fourchette;
	}

	public void setFourchette(String fourchette) {
		this.fourchette = fourchette;
	}

	@Override
	public String toString() {
		return "Resto [id_resto=" + id_resto + ", name_resto=" + name_resto
				+ ", place_resto=" + place_resto + ", fourchette=" + fourchette
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((fourchette == null) ? 0 : fourchette.hashCode());
		result = prime * result + id_resto;
		result = prime * result
				+ ((name_resto == null) ? 0 : name_resto.hashCode());
		result = prime * result
				+ ((place_resto == null) ? 0 : place_resto.hashCode());
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
		Resto other = (Resto) obj;
		if (fourchette == null) {
			if (other.fourchette != null)
				return false;
		} else if (!fourchette.equals(other.fourchette))
			return false;
		if (id_resto != other.id_resto)
			return false;
		if (name_resto == null) {
			if (other.name_resto != null)
				return false;
		} else if (!name_resto.equals(other.name_resto))
			return false;
		if (place_resto == null) {
			if (other.place_resto != null)
				return false;
		} else if (!place_resto.equals(other.place_resto))
			return false;
		return true;
	}
	
	
}
