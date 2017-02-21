/*********************************
 
Title  : Droping Table
Author : Gaurav Khanna

 *********************************/

package javaExamples.jdbc;

import java.sql.*;
import org.testng.annotations.Test;

public class DropTable {

	@Test
	public void testdropTable() throws SQLException, ClassNotFoundException {

		//
		Class.forName("oracle.jdbc.driver.OracleDriver");

		//
		Connection connection = null;

		//
		Statement stmt;

		// Create Connection Object
		connection = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:orcl", "gaurav", "gaurav");

		if (connection != null) {

			//
			System.out.println("Database Connection Successful !! ");

			//
			System.out.println("Droping Table...");

			//
			stmt = connection.createStatement();

			//
			String sql = "DROP TABLE REGISTRATION";

			//
			stmt.executeUpdate(sql);

			//
			System.out.println("Table dropped successfully...");

		}

		//
		connection.close();
	}

}
