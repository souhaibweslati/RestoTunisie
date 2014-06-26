package service.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domain.Resto;
import utilities.MysqlUtilities;

public class RestoDAO {
	
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

}
