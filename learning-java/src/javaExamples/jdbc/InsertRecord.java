/*********************************
 
Title  : Inserting Records
Author : Gaurav Khanna

 *********************************/

package javaExamples.jdbc;

import java.sql.*;
import org.testng.annotations.Test;

public class InsertRecord {

	@Test
	public void testinsertRecord() throws SQLException, ClassNotFoundException {

		// Causes the class "oracle.jdbc.driver.OracleDriver" to be

		Class.forName("oracle.jdbc.driver.OracleDriver");

		//
		System.out.println("Oracle JDBC Driver Registered!");

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
			System.out.println("Inserting records into the table...");

			stmt = connection.createStatement();

			String sql = "INSERT INTO Registration "
					+ "VALUES (100, 'Zara', 'Ali', 18)";

			stmt.executeUpdate(sql);

			sql = "INSERT INTO Registration "
					+ "VALUES (101, 'Mahnaz', 'Fatma', 25)";

			stmt.executeUpdate(sql);

			sql = "INSERT INTO Registration "
					+ "VALUES (102, 'Zaid', 'Khan', 30)";

			stmt.executeUpdate(sql);

			sql = "INSERT INTO Registration "
					+ "VALUES(103, 'Sumit', 'Mittal', 28)";

			//
			stmt.executeUpdate(sql);

			//
			System.out.println("Inserted records into the table...");

		}
		connection.close();
	}

}
