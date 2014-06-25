package service.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import service.dao.interfaces.ObjectDAO;
import utilities.MysqlUtilities;
import domain.Carte;

public class CarteDAO implements ObjectDAO<Carte> {

	public List<Carte> findAll() {
		List<Carte> cartes = new ArrayList<Carte>();
		Connection connection = MysqlUtilities.giveMeConnectionConfigured();
		try {
			Statement statement = connection.createStatement();
			ResultSet rset = statement.executeQuery("SELECT * FROM `carte`");
			while (rset.next()) {
				Carte carte = new Carte();
				carte.setId_carte(rset.getInt("id_carte"));
				carte.setNom_carte(rset.getString("nom_carte"));
				cartes.add(carte);
			}
			for (Carte carte : cartes) {
				System.out.println(carte.getId_carte() + "  "
						+ carte.getNom_carte());
			}
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cartes;
	}

	public Carte findById(int id_carte) {
		PreparedStatement statement = null;
		ResultSet rset = null;
		Connection con = null;
		Carte carte = null;
		try {
			con = MysqlUtilities.giveMeConnectionConfigured();
			statement = con
					.prepareStatement("SELECT * FROM `carte` where id_carte =?");
			statement.setInt(1, id_carte);
			rset = statement.executeQuery();

			while (rset.next()) {
				carte = new Carte();
				carte.setId_carte(rset.getInt("id_carte"));
				carte.setNom_carte(rset.getString("nom_carte"));
			}

			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return carte;
	}

	public int save(Carte carte) {
		return 0;
	}

	public int removeAll() {
		return 0;
	}

	public int removeById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static void main(String[] args) {
		CarteDAO carteDAO = new CarteDAO();
		System.out.println(carteDAO.findById(3).getNom_carte());
	}

}
