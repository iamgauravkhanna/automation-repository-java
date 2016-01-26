package testCases;

import org.testng.annotations.Test;

import testMethods.KeywordMethods;
import utils.ExcelUsingApachePOI;



public class TestCaseRunner {

	@Test
	public void testdriverApp() {

		// Declaring excelUsingApachePOI Object
		ExcelUsingApachePOI excelObject;

		// Declaring KeywordMethod Object
		KeywordMethods keywordAppObj = new KeywordMethods();

		//
		String testExecution;

		//
		String testSheetName;

		//
		excelObject = new ExcelUsingApachePOI(System.getProperty("user.dir")
				+ "\\src\\testData\\core.xlsx");

		// Column Start from 0 and Row starts from 1

		//
		int rowCount = excelObject.getRowCount("Suite1");

		//
		for (int i = 2; i <= rowCount; i++) {

			//
			testSheetName = excelObject.getCellData("Suite1", "TCID", i);

			//
			System.out.println("Test Case ID :" + testSheetName);

			//
			testExecution = excelObject.getCellData("Suite1", 2, i);

			//
			System.out.println("Test Execution Status :" + testExecution);

			//
			keywordAppObj.testRun(excelObject, testExecution, testSheetName);
		}

	}

}
