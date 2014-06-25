package test;

import service.dao.CarteDAO;
import domain.Carte;
import domain.Resto;

public class TestAddCarte {
	
	static CarteDAO carteDAO = new CarteDAO();
	static Resto resto = new Resto();
	static Carte carte2 = new Carte("carte7",resto);
	
	public static void main(String[] args) {
		//System.out.println(carteDAO.findById(3).getNom_carte());
		resto.setId_resto(1);
		carteDAO.save(carte2);
		System.out.println("insertion avec succés");
	}
	
}
