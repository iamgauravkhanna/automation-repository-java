package utiliities;
import Exception.FilloException;
import Fillo.Connection;
import Fillo.Fillo;
import Fillo.Recordset;

public class Fillo_Test {
	
	// Reference :  

	public static void main(String[] args) throws FilloException {

		Fillo fillo = new Fillo();

		Connection connection = fillo
				.getConnection("C:\\GK\\Selenium\\iAutomation\\testCases\\testcase.xlsx");

		String strQuery = "Select * from Employer where description IS NULL";

		Recordset recordset = connection.executeQuery(strQuery);

		while (recordset.next()) {

			System.out.println(recordset.getField("description"));

		}

		recordset.close();

		connection.close();

	}

}
