package dbconnectivity;

import java.sql.*;

public final class ConnectionProvider {


	public static Connection getConnection() {
		Connection con = null;
		
		try {
			Class.forName(DBInfo.DATABASE_DRIVER);
			con = DriverManager.getConnection(DBInfo.DATABASE_URL, DBInfo.DATABASE_USER, DBInfo.DATABASE_PASS);
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
