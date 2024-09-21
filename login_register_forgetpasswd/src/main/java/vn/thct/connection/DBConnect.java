package vn.thct.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	private final String serverName = "localhost";

	private final String dbName = "login_register";

	private final String portNumber = "1433";

	private final String userID = "sa";

	private final String password = "Mssql123@";

	public Connection getConnection() throws Exception {

		String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;

		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

		return DriverManager.getConnection(url, userID, password);

	}
}
