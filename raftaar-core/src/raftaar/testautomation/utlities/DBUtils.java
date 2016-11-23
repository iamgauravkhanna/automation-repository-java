package raftaar.testautomation.utlities;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.Test;

import raftaar.testautomation.manager.TestManager;
import raftaar.testautomation.manager.UITests;

public class DBUtils {

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	static final String DB_URL = "jdbc:oracle:thin:@phixdevproduct.cq66g54vnu5m.us-east-1.rds.amazonaws.com:1521:phix";
	static final String QUERY = "";

	// Database credentials
	static final String USER = "PHIX_QA08_001_REPLICA";
	static final String PASS = "pr1vate";
	static String [] columns = null;
	static HashMap<String, String> dataMap = new HashMap<>();
		static int rowCount = 0;
		static int i = 0;
		
		static ResultSet result = null;
		static ResultSetMetaData resultInfo;

	public static int runSelectQuery(String FileLocation) throws Exception {

		Connection conn = null;
		Statement stmt = null;
		String connectionString= null;

		// STEP 2: Register JDBC driver
		Class.forName(JDBC_DRIVER);

		//String connectionString = "jdbc:oracle:thin:PHIX_QA08_001/pr1vate@phixdevproduct.cq66g54vnu5m.us-east-1.rds.amazonaws.com:1521:phix";
		
		
		connectionString = TestManager.MyDataDicitonary.get("DBConnection") ;
		
		UITests.log.info(FileLocation);
		
		//String sql = FileUtils.readFileToString(new File("C://Selenium//Raftaar//assets//sql//GetConfigElementKeyStatus.sql"));
		String sql = FileUtils.readFileToString(new File(System.getProperty("user.dir") + "/" +FileLocation));
		
		// STEP 3: Open a connection
		System.out.println("Connecting to a selected database...");
		//conn = DriverManager.getConnection(DB_URL, USER, PASS);
		conn = getConnection(connectionString);
		System.out.println("Connected database successfully...");

		// STEP 4: Execute a query
		System.out.println("Creating statement...");
		stmt = conn.createStatement();

		// Extract records without any condition.
		System.out.println("Fetching records without condition...");
		
		ResultSet rs = stmt.executeQuery(sql);

/*		while (rs.next()) {
			// Retrieve by column name
			String  KeyName = rs.getString("KeyName");
			String KeyValue = rs.getString("KeyValue");
			String ConfigKeyEnabled = rs.getString("ConfigKeyEnabled");
			String ConfigKeyDisabled = rs.getString("ConfigKeyDisabled");
			String ConfigKeyStatus = rs.getString("ConfigKeyStatus");

			// Display values
			System.out.print("KeyName is : " + KeyName);
			System.out.print("KeyValue is : " + KeyValue);
			System.out.print("ConfigKeyEnabled is : " + ConfigKeyEnabled);
			System.out.print("ConfigKeyDisabled is : " + ConfigKeyDisabled);
			System.out.print("ConfigKeyStatus is : " + ConfigKeyStatus);
			
			
		}*/
		
		UITests.log.info("Success");
		
		//ResultSetMetaData rsmd = rs.getMetaData();
		resultInfo = rs.getMetaData();
		//int col = rsmd.getColumnCount();
		
		//System.out.println("Coloumn Count : " +  col);
/*		
	
		for (int i = 1 ; i <= col ; i++){
			String arg1 = rsmd.getColumnName(i);
			System.out.println("args 1 : " + arg1);
			//String arg2 = rs.getString(arg1);
			//System.out.println("args 2 : " + arg2);
			//TestManager.MyDataDicitonary.put(arg1, arg2);
			//}
			columns[i] = arg1; 			
		}

		for( int u = 0; u <= columns.length - 1; u++)
		{
		    // get element number 0 and 1 and put it in a variable, 
		    // and the next time get element      1 and 2 and put this in another variable. 
			TestManager.MyDataDicitonary.put(columns[u], rs.getString(columns[u]));
		}*/
		
		

			dataMap.put("db_column_count", Integer.toString(resultInfo.getColumnCount()));
			System.out.println("resultInfo : " + resultInfo.getColumnCount());
			while (rs.next())
			{
				rowCount++;
				int rowNo = rs.getRow();
				
				System.out.println("Row Count");

				for (i = 1; i <= resultInfo.getColumnCount(); i++)
				{
					String columnName = resultInfo.getColumnLabel(i).toLowerCase();
					String value = "";

					if (resultInfo.getColumnTypeName(i).equalsIgnoreCase("SYS.XMLTYPE"))
						value = rs.getSQLXML(i).getString();
					else
						value = rs.getString(i);

					//if (value == null) value = "NULL";
					
					System.out.println(value);
					TestManager.MyDataDicitonary.put(columnName, value);
					UITests.log.info("Putting columnName as : " + columnName + " and value as : " + value);

				}
			}
		
		//UITests.log.info("Result Set Meta Data : " + rsmd + "\n");
		
		// Select all records having ID equal or greater than 101
/*		System.out.println("Fetching records with condition...");
		sql = "SELECT id, first, last, age FROM Registration" + " WHERE id >= 101 ";
		rs = stmt.executeQuery(sql);

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
		}*/
		rs.close();

		return i-1;
				}


		

	/**
	 * Creates a connection to the database. It will try upto 10 times if there are exceptions connecting to database server.
	 * 
	 * @param connectionString {@link String} connection string to the database including authentication information
	 * @return {@link Connection} connection to the database which can be used to run select, update, delete queries
	 * @throws Exception
	 */
	public static Connection getConnection(String connectionString) throws Exception
	{

		String url = connectionString;
		Connection conn = null;

		/*
		if (knownDBConnections.containsKey(connectionString))
		{
			conn = knownDBConnections.get(connectionString);
			if (conn.isValid(60)) return conn;
			else
				knownDBConnections.remove(conn);
		}*/

		// Notice, do not import com.mysql.jdbc.* or you will have problems!
		if (url.toLowerCase().contains("mysql"))
		{
			// for decoding & from %26
			url = URLDecoder.decode(url, "UTF-8");
			// The newInstance() call is a work around for some
			// broken Java implementations
			// https://dev.mysql.com/doc/connector-j/en/connector-j-usagenotes-connect-drivermanager.html
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		}

		String username = "";
		String password = "";
		Properties connectionInfo = new Properties();
		if (connectionString.contains("@"))
		{

			String authInfo = connectionString.split("\\@")[0];
			authInfo = authInfo.substring(authInfo.lastIndexOf(':') + 1, authInfo.length());
			username = URLDecoder.decode(authInfo.split("\\/")[0], "UTF-8");
			password = URLDecoder.decode(authInfo.split("\\/")[1], "UTF-8");
			url = connectionString.replace(authInfo, "");

			if (url.toLowerCase().contains("mysql"))
			{
				url = url.replace("@", "//");
			}

			connectionInfo.put("user", username);
			connectionInfo.put("password", password);
			// connectionInfo.put("dontTrackOpenResources", true);
		}

		// System.gc();
		try
		{
			return DriverManager.getConnection(url, connectionInfo);
		} catch (Exception e)
		{
			throw new Exception("Connection failed for url " + url + " from connection string '" + connectionString + "'. \n"
					+ "Exception received was " + e.getMessage() + "\n" + e.getStackTrace());
		}
	}
	
}
