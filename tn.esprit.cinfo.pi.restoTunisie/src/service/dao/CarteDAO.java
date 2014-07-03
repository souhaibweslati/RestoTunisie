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
import domain.Resto;

public class CarteDAO implements ObjectDAO<Carte> {

	public List<Carte> findAll() {
		List<Carte> cartes = new ArrayList<Carte>();
		Connection connection = MysqlUtilities.giveMeConnectionConfigured();
		
		try {
			Statement statement = connection.createStatement();
			ResultSet rset = statement.executeQuery("SELECT * From carte");
			
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
	
	public List<Carte> findAllByID(int id_resto) {
		List<Carte> cartes = new ArrayList<Carte>();
		PreparedStatement statement = null;
		ResultSet rset = null;
		Connection con = null;
		try {
			con = MysqlUtilities.giveMeConnectionConfigured();
			statement = con.prepareStatement("SELECT carte.id_carte ,carte.nom_carte , resto.id_resto FROM `carte` LEFT JOIN resto on carte.id_resto = resto.id_resto where resto.id_resto =?");
			statement.setInt(1, id_resto);
			rset = statement.executeQuery();
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
			statement = con.prepareStatement("SELECT * FROM `carte` where id_carte =?");
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
		PreparedStatement updateStatement = null;
		PreparedStatement insertStatement = null;
		int rset = 0;
		Connection con = null;

		try {
			con = MysqlUtilities.giveMeConnectionConfigured();
			updateStatement = con.prepareStatement("update carte set nom_carte=? AND id_resto=? where id_carte=?");
			insertStatement = con.prepareStatement("INSERT INTO carte (nom_carte,id_resto) VALUES (?,?)");

			
			updateStatement.setString(1,carte.getNom_carte());
			updateStatement.setInt(2,carte.getResto().getId_resto());
			updateStatement.setInt(3, carte.getId_carte());
			
			
			insertStatement.setString(1,carte.getNom_carte());
			insertStatement.setInt(2,carte.getResto().getId_resto());
			
			rset = updateStatement.executeUpdate();
			if (rset == 0)
				rset = insertStatement.executeUpdate();

			System.out.println("c bon");
			updateStatement.close();
			insertStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int removeAll() {
		PreparedStatement deleteStatement = null;
		// @SuppressWarnings("unused")
		int rset = 0;
		Connection con = null;

		try {
			con = MysqlUtilities.giveMeConnectionConfigured();
			deleteStatement = con.prepareStatement("DELETE FROM carte");
			rset = deleteStatement.executeUpdate();
			System.out.println("c bon");

			deleteStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int removeById(int id) {
		PreparedStatement deleteStatement = null;
		int rset = 0;
		Connection con = null;

		try {
			con = MysqlUtilities.giveMeConnectionConfigured();
			deleteStatement = con
					.prepareStatement("DELETE FROM `carte` WHERE id_carte=?");

			deleteStatement.setInt(1, id);
			rset = deleteStatement.executeUpdate();
			System.out.println("c bon");

			deleteStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public static void main(String[] args) {
		CarteDAO carteDAO = new CarteDAO();
		carteDAO.findAllByID(1);
	}
}
