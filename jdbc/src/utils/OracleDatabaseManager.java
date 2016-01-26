package utils;

import java.sql.*;

public class OracleDatabaseManager {

	private static Connection connectionObj = null;
	public static String driver = "net.sourceforge.jtds.jdbc.Driver";
	public static String dbConnectionUrl = "jdbc:jtds:sqlserver://102.106.10.107;DatabaseName=monitor";
	public static String dbUserName = "sa";
	public static String dbPassword = "abcd";
	public static String mysqldriver = "com.mysql.jdbc.Driver";
	public static String mysqluserName = "root";
	public static String mysqlpassword = "asbcd";
	public static String mysqlurl = "jdbc:mysql://102.164.153.991/r_dm";

	// Establishing Connection
	public void establishConnection() throws SQLException,
			ClassNotFoundException {

		try {
			Class.forName(driver);
			connectionObj = DriverManager.getConnection(dbConnectionUrl,
					dbUserName, dbPassword);

			if (!connectionObj.isClosed())
				System.out.println("Successfully connected to SQL server");

		} catch (Exception e) {

			System.err.println("Exception: " + e.getMessage());

		}

	}

	// Creating Database
	public void createDatabase() {
	}
}
