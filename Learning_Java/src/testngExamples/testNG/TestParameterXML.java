package testngExamples.testNG;

import java.io.*;
import java.sql.*;
import java.util.Properties;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestParameterXML {

	Connection con;

	@Test
	@Parameters({ "dbconfig", "poolsize" })
	public void createConnection(String dbconfig, int poolsize) {

		System.out.println("dbconfig : " + dbconfig);
		System.out.println("poolsize : " + poolsize);

		Properties prop = new Properties();
		InputStream input = null;

		try {
			// get properties file from project classpath
			input = getClass().getClassLoader().getResourceAsStream(dbconfig);

			prop.load(input);

			String drivers = prop.getProperty("jdbc.driver");
			String connectionURL = prop.getProperty("jdbc.url");
			String username = prop.getProperty("jdbc.username");
			String password = prop.getProperty("jdbc.password");

			System.out.println("drivers : " + drivers);
			System.out.println("connectionURL : " + connectionURL);
			System.out.println("username : " + username);
			System.out.println("password : " + password);

			Class.forName(drivers);
			con = DriverManager.getConnection(connectionURL, username, password);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}