/*********************************
 
Title  : Deleting Records
Author : Gaurav Khanna

 *********************************/

package jdbcExamples;

import java.sql.*;
import org.testng.annotations.Test;

public class DeleteRecord {

	@Test
	public void testdeleteRecord() throws SQLException, ClassNotFoundException {

		// Causes the class "oracle.jdbc.driver.OracleDriver" to be

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
			System.out.println("Creating statement...");

			//
			stmt = connection.createStatement();

			//
			String sql = "DELETE FROM Registration " + "WHERE id = 101";

			//
			String sql1 = "SELECT id, first, last, age FROM Registration";

			//
			stmt.executeQuery(sql);

			//
			ResultSet rs = stmt.executeQuery(sql1);

			//
			while (rs.next()) {

				// Retrieve by column name
				int id = rs.getInt("id");
				int age = rs.getInt("age");
				String first = rs.getString("first");
				String last = rs.getString("last");

				// Display values
				System.out.print("ID: " + id);
				System.out.print(", Age: " + age);
				System.out.print(", First: " + first);
				System.out.println(", Last: " + last);

			}
		}
		connection.close();
	}

}
