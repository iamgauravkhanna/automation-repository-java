/*********************************
 
Title  : Creating Table
Author : Gaurav Khanna

 *********************************/

package learning_jdbc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

import org.testng.annotations.Test;

public class CreateTable {

	@Test
	public void testcreateTable() throws SQLException, ClassNotFoundException, IOException {

		// Causes the class "oracle.jdbc.driver.OracleDriver" to dynamically
		Class.forName("oracle.jdbc.driver.OracleDriver");

		// Declaring Connection type variable
		Connection connection = null;

		//
		Statement stmt;

		// Create Connection Object
		connection = DriverManager.getConnection(
				"jdbc:oracle:thin:@ec2-db-product-phix-dev-qa-03.internal.hcphix.com:1521:perfphix", "FID_SCRUB_04SEP",
				"pr1vate");

		if (connection != null) {

			//
			System.out.println("Database Connection Successful !! ");

			//
			System.out.println("Creating table in given database...");

			//
			stmt = connection.createStatement();

			ClassLoader classLoaderObj = getClass().getClassLoader();

			File fileObj = new File(classLoaderObj.getResource("create_table.sql").getFile());

			BufferedReader bufferedReaderObj = new BufferedReader(new FileReader(fileObj));

			StringBuilder stringBuilderObj = new StringBuilder();

			String line;

			while ((line = bufferedReaderObj.readLine()) != null) {

				stringBuilderObj.append(line);
				
			}

			bufferedReaderObj.close();

			String sqlQuery = stringBuilderObj.toString();

			System.out.println("Query => " + sqlQuery);

			stmt.executeQuery(sqlQuery);

			//
			System.out.println("Created table in given database...");

		}

		connection.close();
	}

}
