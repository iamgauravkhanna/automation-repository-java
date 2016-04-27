/*********************************
 
Title  : Oracle Database Connectivity
Author : Gaurav Khanna

 *********************************/

package webdriverScripts.others;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class OracleDatabaseConnectivity {

	@Test
	public void testoracleDatabaseConnectivity() throws SQLException {

		//
		System.out.println("-------- Oracle JDBC Connection Testing ------");

		try {

			// Causes the class "oracle.jdbc.driver.OracleDriver" to be
			// dynamically loaded (at runtime).
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {

			//
			System.out.println("Oracle JDBC Driver not found !!");

			//
			e.printStackTrace();

			//
			return;
		}

		//
		System.out.println("Oracle JDBC Driver Registered!");

		// Declaring Connection type variable
		Connection connection = null;

		try {
			// Create Connection Object
			connection = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:orcl", "gaurav",
					"password");

		} catch (SQLException e) {

			//
			System.out.println("Connection Failed! Check output console");

			//
			e.printStackTrace();

			//
			return;
		}

		if (connection != null) {

			//
			System.out.println("Database Connection Successful !! ");

		} else {

			//
			System.out.println("Connection Failed !!");
		}

		// Set Auto Commit to False
		connection.setAutoCommit(false);

		// Declaring Statement type variable
		Statement stmt = connection.createStatement();

		// Storing result in Result Set type variable
		ResultSet rset = (ResultSet) stmt
				.executeQuery("select * from user_tables");

		// Extracting data from result set
		while (rset.next()) {
			System.out.println(rset.getString(1));
			System.out.println(rset.getString(2));
		}

		// Closing Statement and Connection
		stmt.close();
		connection.close();
	}
}
