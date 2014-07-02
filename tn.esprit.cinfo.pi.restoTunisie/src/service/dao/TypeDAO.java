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
import domain.Type;
import domain.Resto;

public class TypeDAO implements ObjectDAO<Type> {

	public List<Type> findAll() {
		List<Type> Types = new ArrayList<Type>();
		Connection connection = MysqlUtilities.giveMeConnectionConfigured();
		
		try {
			Statement statement = connection.createStatement();
			ResultSet rset = statement.executeQuery("SELECT * From type");
			
			while (rset.next()) {
				Type type = new Type();
				type.setId_type(rset.getInt("id_Type"));
				type.setNom_type(rset.getString("nom_Type"));
				Types.add(type);
			}
			
			for (Type type : Types) {
				System.out.println(type.getNom_type());
			}
			
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Types;
	}
	
	public List<Type> findAllByID(int id_resto) {
		List<Type> Types = new ArrayList<Type>();
		PreparedStatement statement = null;
		ResultSet rset = null;
		Connection con = null;
		try {
			con = MysqlUtilities.giveMeConnectionConfigured();
			statement = con.prepareStatement("SELECT Type.id_Type ,Type.nom_Type , resto.id_resto FROM `Type` LEFT JOIN resto on Type.id_resto = resto.id_resto where resto.id_resto =?");
			statement.setInt(1, id_resto);
			rset = statement.executeQuery();
			while (rset.next()) {
			
			}
			
			for (Type Type : Types) {
			
			}
			
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Types;
	}

	public Type findById(int id_Type) {
		PreparedStatement statement = null;
		ResultSet rset = null;
		Connection con = null;
		Type Type = null;
		try {
			con = MysqlUtilities.giveMeConnectionConfigured();
			statement = con.prepareStatement("SELECT * FROM `type` where id_type =?");
			statement.setInt(1, id_Type);
			rset = statement.executeQuery();

			while (rset.next()) {
				Type = new Type();
				Type.setId_type(rset.getInt("id_Type"));
				Type.setNom_type(rset.getString("nom_Type"));
			}

			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Type;
	}

	

	
	

	public int save(Type t) {
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
	
	public static void main(String[] args) {
		TypeDAO typeDAO = new TypeDAO();
		typeDAO.findAll();
	}
}
