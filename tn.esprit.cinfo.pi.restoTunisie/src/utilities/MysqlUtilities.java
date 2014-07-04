package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlUtilities {

	private static Connection myConnection;
	private static String url = "jdbc:mysql://localhost:3306/restoTunisie?allowMultiQueries=true";
	private static String user = "root";
	private static String password = "";

	public static Connection giveMeConnectionConfigured() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Loaded");
			myConnection = DriverManager.getConnection(url, user, password);
			System.out.println("Connection to Database is established");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return myConnection;
	}
	
	public static void main(String[] args) {
		giveMeConnectionConfigured();
	}
	
	
}
