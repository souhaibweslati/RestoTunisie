package test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


//import domain.User;
import utilities.MysqlUtilities;

public class TestMyConnection {
	public static void main(String[] args) {
		Connection connection = MysqlUtilities.giveMeConnectionConfigured();
		try {
			Statement statement = connection.createStatement();
			String sql = "SELECT * FROM `carte`";
			statement.execute(sql);
			
			ResultSet rs = statement.executeQuery("SELECT * FROM `client`");
			while (rs.next()){
				System.out.println(rs.getString(2));
			}
			/*User user = new User("Aymen", "Ghoul");
			String sql2 = "insert into `user` (firstname,lastname) values('"
					+ user.getFirstName() + "','" + user.getLastName() + "')";*/
			//statement.execute(sql2);
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
