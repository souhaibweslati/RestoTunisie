package service.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import service.dao.interfaces.ObjectDAO;
import utilities.MysqlUtilities;
import domain.Client;
import domain.Commande;
import domain.Resto;

public class CommandeDAO implements ObjectDAO<Commande> {

	public List<Commande> findAll() {
		List<Commande> commandes = new ArrayList<Commande>();
		PreparedStatement statement = null;
		ResultSet rset = null;
		Connection con = null;
		try {
			con = MysqlUtilities.giveMeConnectionConfigured();
			statement = con
					.prepareStatement("select * from commande join client on commande.id_client = client.id_client join resto on commande.id_resto = resto.id_resto");
			rset = statement.executeQuery();
			while (rset.next()) {
				Commande commande = new Commande();
				Client client = new Client(rset.getString("nom_client"),rset.getString("adresse_mail"), rset.getString("tel"));
				Resto resto = new Resto(rset.getString("name_resto"),rset.getString("place_resto"),rset.getInt("fourchette_resto"));
				commande.setId_commande(rset.getInt("id_commande"));
				commande.setCommande(rset.getString("commande"));
				commande.setResto(resto);
				commande.setClient(client);
				commandes.add(commande);
			}
			for (Commande commande : commandes) {
				System.out.println("" + commande.getId_commande() + " "
						+ commande.getCommande() + " "
						+ commande.getClient().getNom_client() + " "
						+ commande.getClient().getAdresse_mail() + " "
						+ commande.getClient().getTel() + " "
						+ commande.getResto().getName_resto());
			}

			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return commandes;
	}

	public Commande findById(int id) {
		return null;
	}

	public int save(Commande commande) {
		PreparedStatement updateStatement = null;
		PreparedStatement insertStatement = null;
		int rset = 0;
		Connection con = null;

		try {
			con = MysqlUtilities.giveMeConnectionConfigured();
			updateStatement = con.prepareStatement("update commande set commande=? AND id_resto=? And id_client=? where id_commande=?");
			insertStatement = con.prepareStatement("INSERT INTO commande (id_resto,id_client,commande) VALUES (?,?,?)");

			
			updateStatement.setString(1,commande.getCommande());
			updateStatement.setInt(2,commande.getResto().getId_resto());
			updateStatement.setInt(3, commande.getResto().getId_resto());
			updateStatement.setInt(4, commande.getId_commande());
			
			insertStatement.setInt(1,commande.getResto().getId_resto());
			insertStatement.setInt(2,commande.getClient().getId_client());
			insertStatement.setString(3, commande.getCommande());
			
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
		return 0;
	}

	public int removeById(int id_commande) {
		PreparedStatement deleteStatement = null;
		int rset = 0;
		Connection con = null;

		try {
			con = MysqlUtilities.giveMeConnectionConfigured();
			deleteStatement = con
					.prepareStatement("DELETE FROM `commande` WHERE id_commande=?");

			deleteStatement.setInt(1, id_commande);
			rset = deleteStatement.executeUpdate();
			System.out.println("c bon");

			deleteStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public static void main(String[] args) {
		CommandeDAO commandeDAO = new CommandeDAO();
		Resto resto = new Resto();
		resto.setId_resto(45);
		Client client = new Client();
		client.setId_client(16);
		Commande commande = new Commande("jdida", client, resto);
		commandeDAO.save(commande);
	}

}
