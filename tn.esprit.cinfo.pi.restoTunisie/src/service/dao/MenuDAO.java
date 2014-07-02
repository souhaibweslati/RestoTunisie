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
import domain.Menu;

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


	public int save(Menu t) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int removeAll() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int removeById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	public Menu findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String[] args) {
		MenuDAO dao = new MenuDAO();
		dao.findAllById(2);
	}
	
}
