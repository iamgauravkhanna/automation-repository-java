/*********************************
 
Title  : Creating Table
Author : Gaurav Khanna

 *********************************/

package javaExamples.jdbc;

import java.sql.*;
import org.testng.annotations.Test;

public class CreateTable {

	@Test
	public void testcreateTable() throws SQLException, ClassNotFoundException {

		// Causes the class "oracle.jdbc.driver.OracleDriver" to dynamically
		Class.forName("oracle.jdbc.driver.OracleDriver");

		// Declaring Connection type variable
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
			System.out.println("Creating table in given database...");

			//
			stmt = connection.createStatement();

			String sql = "CREATE TABLE REGISTRATION "
					+ "(id INTEGER not NULL, " + " first VARCHAR(255), "
					+ " last VARCHAR(255), " + " age INTEGER, "
					+ " PRIMARY KEY ( id ))";

			stmt.executeUpdate(sql);

			//
			System.out.println("Created table in given database...");

		}

		connection.close();
	}

}
