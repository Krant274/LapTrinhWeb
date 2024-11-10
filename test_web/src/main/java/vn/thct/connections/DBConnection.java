package vn.thct.connections;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	private static String serverName = "localhost";

	private static String dbName = "test_web";

	private static String portNumber = "1433";

	private static String userID = "sa";

	private static String password = "r00t.R00T";

	public static Connection getDatabaseConnection() throws Exception {

		String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;

		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

		return DriverManager.getConnection(url, userID, password);

	}

	public static void main(String[] args) {
		try {
			new DBConnection();
			System.out.println(DBConnection.getDatabaseConnection());
			
		} catch(Exception e) {
			e.printStackTrace();
		}	
		
	}
	
}
