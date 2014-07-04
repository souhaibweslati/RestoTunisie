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
import domain.Menu;
import domain.Resto;

public class MenuDAO implements ObjectDAO<Menu> {

	public List<Menu> findAll() {
		List<Menu> menus = new ArrayList<Menu>();
		Connection connection = MysqlUtilities.giveMeConnectionConfigured();
		
		try {
			Statement statement = connection.createStatement();
			ResultSet rset = statement.executeQuery("SELECT * From menu");
			
			while (rset.next()) {
				Menu menu = new Menu();
				menu.setId_menu(rset.getInt("id_Menu"));
				menu.setNom_menu(rset.getString("nom_Menu"));
				menu.setPrix(rset.getString("prix"));

				menus.add(menu);
			}
			
			for (Menu menu : menus) {
				System.out.println(menu.getNom_menu()+""+menu.getPrix());
			}
			
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return menus;
	}

	public List<Menu> findAllById(int id_carte) {
		List<Menu> menus = new ArrayList<Menu>();
		PreparedStatement statement = null;
		ResultSet rset = null;
		Connection con = null;
		
		try {
			con = MysqlUtilities.giveMeConnectionConfigured();
			statement = con.prepareStatement("select menu.id_menu,menu.nom_menu,menu.prix from menu where menu.id_carte=?");
			statement.setInt(1, id_carte);
			rset = statement.executeQuery();
			while (rset.next()) {
				Menu menu = new Menu();
				menu.setId_menu(rset.getInt("id_Menu"));
				menu.setNom_menu(rset.getString("nom_Menu"));
				menu.setPrix(rset.getString("prix"));
				menus.add(menu);
			}
			
			for (Menu menu : menus) {
				System.out.println(menu.getNom_menu()+""+menu.getPrix());
			}
			
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return menus;
	}


	public int save(Menu menu) {
		PreparedStatement updateStatement = null;
		PreparedStatement insertStatement = null;
		int rset = 0;
		Connection con = null;

		try {
			con = MysqlUtilities.giveMeConnectionConfigured();
			updateStatement = con.prepareStatement("update menu set nom_menu=? AND prix=? And id_carte=? where id_menu=?");
			insertStatement = con.prepareStatement("INSERT INTO menu (nom_menu,prix,id_carte) VALUES (?,?,?)");

			
			updateStatement.setString(1,menu.getNom_menu());
			updateStatement.setString(2,menu.getPrix());
			updateStatement.setInt(3,menu.getCarte().getId_carte());
			updateStatement.setInt(4, menu.getId_menu());
			
			
			insertStatement.setString(1,menu.getNom_menu());
			insertStatement.setString(2,menu.getPrix());
			insertStatement.setInt(3, menu.getCarte().getId_carte());
			
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
		// TODO Auto-generated method stub
		return 0;
	}

	public int removeById(int id_menu) {
		PreparedStatement deleteStatement = null;
		int rset = 0;
		Connection con = null;

		try {
			con = MysqlUtilities.giveMeConnectionConfigured();
			deleteStatement = con
					.prepareStatement("DELETE FROM `menu` WHERE id_menu=?");

			deleteStatement.setInt(1, id_menu);
			rset = deleteStatement.executeUpdate();
			System.out.println("c bon");

			deleteStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	
	public Menu findById(int id) {
		return null;
	}
	
}
