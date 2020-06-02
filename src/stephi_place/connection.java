package stephi_place;

import java.sql.Connection;
import java.sql.DriverManager;

public class connection {
	static Connection con;
	
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projet_java", "root", "");
		}catch(Exception ex) {
			System.out.println(""+ex);
		}
		return con;
	}
}