package utils;

import java.sql.*;

import org.testng.annotations.Test;

public class MySQLDatabaseManager {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String url = "jdbc:mysql://localhost:3306/";
	String dbName = "lead";
	String driver = "com.mysql.jdbc.Driver";
	String userName = "root";
	String password = "root";

	@Test
	public void establishConnection() {

		try {
			Class.forName(driver).newInstance();// create object of Driver
			conn = DriverManager
					.getConnection(url + dbName, userName, password);
			System.out.println("Success");
		} catch (Exception e) {

			System.out.println("Exception");

		}
	}

	public void selectQuery() {

		String username = "user@javachap.com";
		String password = "javachap";
		// Check the db
		try {
			pstmt = conn
					.prepareCall("select * from user where USR_EMAIL=? and USD_PASSWORD=?");
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
		} catch (Exception e) {
			// report some error
		}

	}

	public void closeConn() throws SQLException {
		if (conn != null && !conn.isClosed()) {
			conn.close();
		}
	}

}
