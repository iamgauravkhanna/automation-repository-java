package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class DatabaseUtils {

	Connection connectionObj;
	Statement statementObj;
	ResultSet resultSetObj;
	ResultSetMetaData resultSetMetaDataObj;
	Map<String, Object> resultMap = new HashMap<String, Object>();

	public DatabaseUtils() {

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

		try {

			connectionObj = DriverManager.getConnection(
					"jdbc:oracle:thin:@hostname:port:sid",
					"username", "password");

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		DatabaseUtils databaseUtilsObj = new DatabaseUtils();

		databaseUtilsObj.runQuery("SELECT * FROM SYSTEM_CONFIG WHERE id = 49050662");

	}

	public void runQuery(String query) {

		try {

			statementObj = connectionObj.createStatement();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		try {

			resultSetObj = statementObj.executeQuery(query);

		} catch (SQLException e) {

			e.printStackTrace();
		}

		try {

			resultSetMetaDataObj = resultSetObj.getMetaData();

		} catch (SQLException e) {

			e.printStackTrace();

		}

		int columnsNumber = 0;

		try {

			columnsNumber = resultSetMetaDataObj.getColumnCount();

		} catch (SQLException e) {

			e.printStackTrace();

		}

		try {

			while (resultSetObj.next()) {

				// Map<String, Object> tmpMap = new HashMap<String, Object>();

				for (int i = 1; i < columnsNumber; i++) {

					resultMap.put(resultSetMetaDataObj.getColumnName(i), resultSetObj.getObject(i));
				}

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		int counter = 1;

		for (Entry<String, Object> entry : resultMap.entrySet()) {

			LogUtils.info("Entry #" + counter + " : " + entry.getKey() + " => " + entry.getValue());

			counter++;
		}

	}

	public void closeConnection() {

		try {

			connectionObj.close();

		} catch (SQLException e) {

			e.printStackTrace();

		}

	}
}
