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
import domain.Client;

public class ClientDAO implements ObjectDAO<Client> {

	public List<Client> findAll() {

		List<Client> clients = new ArrayList<Client>();
		Connection connection = MysqlUtilities.giveMeConnectionConfigured();
		try {
			Statement statement = connection.createStatement();
			ResultSet rset = statement.executeQuery("SELECT * FROM `client`");
			while (rset.next()) {
				Client client = new Client();
				client.setId_client(rset.getInt("id_client"));
				client.setNom_client(rset.getString("nom_client"));
				client.setTel(rset.getString("tel"));
				client.setAdresse_mail(rset.getString("adresse_mail"));
				clients.add(client);
			}
			for (Client client : clients) {
				System.out.println(client.getNom_client());
				System.out.println(client.getAdresse_mail());
				System.out.println(client.getTel());
			}
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clients;
	}

	public Client findById(int id_client) {
		PreparedStatement statement = null;
		ResultSet rset = null;
		Connection con = null;
		Client client = null;
		try {
			con = MysqlUtilities.giveMeConnectionConfigured();
			statement = con
					.prepareStatement("SELECT * FROM `client` where id_client =?");
			statement.setInt(1, id_client);
			rset = statement.executeQuery();

			while (rset.next()) {
				client = new Client();
				client.setNom_client(rset.getString("nom_client"));
				client.setAdresse_mail(rset.getString("adresse_mail"));
				client.setTel(rset.getString("tel"));
			}

			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return client;
	}

	public int save(Client client) {

		PreparedStatement updateStatement = null;
		PreparedStatement insertStatement = null;
		int rset = 0;
		Connection con = null;

		try {
			con = MysqlUtilities.giveMeConnectionConfigured();
			updateStatement = con
					.prepareStatement("update client set nom_client=?,adresse_mail=?,tel=? where id_client=?");
			insertStatement = con
					.prepareStatement("INSERT INTO client (nom_client,adresse_mail,tel) VALUES (?,?,?)");

			updateStatement.setString(1, client.getNom_client());
			updateStatement.setString(2, client.getAdresse_mail());
			updateStatement.setString(3, client.getTel());
			updateStatement.setInt(4, client.getId_client());

			insertStatement.setString(1, client.getNom_client());
			insertStatement.setString(2, client.getAdresse_mail());
			insertStatement.setString(3, client.getTel());

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
			deleteStatement = con.prepareStatement("DELETE FROM client");
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
					.prepareStatement("DELETE FROM `client` WHERE id_client=?");

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
		ClientDAO clientDAO = new ClientDAO();
		Client client = new Client("sarra", "souhaib.weslati@gmail.com",
				"29446363");
		clientDAO.save(client);
		// clientDAO.removeById(12);

	}

}
