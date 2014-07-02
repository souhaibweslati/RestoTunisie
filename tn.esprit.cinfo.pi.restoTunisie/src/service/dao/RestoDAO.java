package service.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domain.Client;
import domain.Resto;
import service.dao.interfaces.ObjectDAO;
import utilities.MysqlUtilities;

public class RestoDAO implements ObjectDAO<Resto> {
	
	public List<Resto> findAll() {
		List<Resto> restos = new ArrayList<Resto>();
		Connection connection = MysqlUtilities.giveMeConnectionConfigured();
		try {
			Statement statement = connection.createStatement();
			ResultSet rset = statement.executeQuery("SELECT * FROM `resto`");
			while (rset.next()) {
				Resto resto = new Resto();
				resto.setId_resto(rset.getInt("id_resto"));
				resto.setName_resto(rset.getString("name_resto"));
				resto.setPlace_resto(rset.getString("place_resto"));
				resto.setFourchette(rset.getInt("fourchette_resto"));
				restos.add(resto);
			}
			for (Resto resto : restos) {
				System.out.println(+resto.getId_resto()+" "+resto.getName_resto()+" "+resto.getPlace_resto()+" "+resto.getFourchette());
			}
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return restos;
	}

	public Resto findById(int id) {
		return null;
	}

	public int save(Resto resto) {

		PreparedStatement updateStatement = null;
		PreparedStatement insertStatement = null;
		int rset = 0;
		Connection con = null;

		try {
			con = MysqlUtilities.giveMeConnectionConfigured();
			updateStatement = con
					.prepareStatement("update resto set name_resto=?,place_resto=?,fourchette_resto=? where id_resto=?");
			insertStatement = con
					.prepareStatement("INSERT INTO resto (name_resto,place_resto,fourchette_resto) VALUES (?,?,?)");

			updateStatement.setString(1, resto.getName_resto());
			updateStatement.setString(2, resto.getPlace_resto());
			updateStatement.setInt(3, resto.getFourchette());
			updateStatement.setInt(4, resto.getId_resto());

			insertStatement.setString(1, resto.getName_resto());
			insertStatement.setString(2, resto.getPlace_resto());
			insertStatement.setInt(3, resto.getFourchette());

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

	public int removeById(int id_resto) {
		PreparedStatement deleteStatement = null;
		int rset = 0;
		Connection con = null;

		try {
			con = MysqlUtilities.giveMeConnectionConfigured();
			deleteStatement = con
					.prepareStatement("DELETE FROM `resto` WHERE id_resto=?");

			deleteStatement.setInt(1, id_resto);
			rset = deleteStatement.executeUpdate();
			System.out.println("c bon");

			deleteStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
}
