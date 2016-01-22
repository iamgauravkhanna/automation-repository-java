package raftaar.testautomation.manager;

import java.util.HashMap;
import org.openqa.selenium.By;
import raftaar.testautomation.utlities.ExcelUtils;

public class TestDriver {

	public ExcelUtils excelFile = new ExcelUtils(System.getProperty("user.dir") + "\\assets\\testcase.xlsx");

	public int SheetCount;
	public String sheetName;
	public String testcaseid;
	public String summary;
	public String description;
	public String parent;
	public String object;
	public String action;
	public String data;
	public String iterations;
	public String flags;
	public By loc;
	public String baseTestCaseID;

	TestManager tm = new TestManager();

	// public WebPage d = new WebPage();

	public HashMap<String, String> testStepDetails = new HashMap<>();

	public HashMap<Integer, HashMap<String, String>> testCaseDetails = new HashMap<>();

	public HashMap<String, HashMap<Integer, HashMap<String, String>>> testCases = new HashMap<>();

	/**
	 * This is a Javadoc example. It explains the working of Javadoc comments.
	 * 
	 * @param String
	 * 
	 * @return void This explains what the output / result of the method is. In
	 *         this case, it's void.
	 * 
	 * @throws Exception
	 */

	public void runTestCase(String testCaseId) throws Exception {

		// System.out.println("Dicitionary Values are : " +
		// TestManager.MyDataDicitonary.entrySet());

		// XmlUtils xu = new XmlUtils();
		// String x = xu.readParameters();

		// TestManager.MyDataDicitonary.putAll(params);

		// System.out.println("Value of Parameters File : " + x);
		// System.out.println("Dicitionary Values after explicit : " +
		// TestManager.MyDataDicitonary.entrySet());

		// System.out.println("Entering runTestCase Class");

		readTestCase(testCaseId);

	}

	public void readTestCase(String testCaseId) throws Exception {

		HashMap<String, HashMap<Integer, HashMap<String, String>>> myHashMap = createTestCaseMap();

		HashMap<Integer, HashMap<String, String>> myHashMapObject = myHashMap.get(testCaseId);

		// System.out.println("Printing Values of TestCase Hash Map : " +
		// myHashMap.entrySet());

		// System.out.println(myHashMap.size());
		// System.out.println(myHashMap.keySet());

		// System.out.println(myHashMap.entrySet());

		for (int k = 0; k < myHashMapObject.size(); k++) {
			HashMap<String, String> myHashMapObj = myHashMap.get(testCaseId).get(k);

			String a = myHashMapObj.get("testcaseid");
			String b = myHashMapObj.get("summary");
			String c = myHashMapObj.get("description");
			String d = myHashMapObj.get("parent");
			String e1 = myHashMapObj.get("object");
			String f = myHashMapObj.get("action");
			String g = myHashMapObj.get("data");
			String h = myHashMapObj.get("iterations");
			String i = myHashMapObj.get("flags");
			/*
			 * if((e.getKey())=="testcaseid"); {a = testcaseid}
			 * TestDriver.runTestStep(tsid, testid, testCaseId, keyword,
			 * testCaseId, loc, value, testCaseId, testCaseId, testCaseId);
			 */

			System.out.println("Executing STEP : " + c + "\n");

			tm.runTestStep(a, b, c, d, e1, f, g, h, i);

			// System.out.println(myHashMapObj.keySet());

		}

	}

	public HashMap<String, HashMap<Integer, HashMap<String, String>>> createTestCaseMap() throws Exception {

		// System.out.println("Sheet Count : " + excelFile.getSheetCount());
		SheetCount = excelFile.getSheetCount();

		for (int i = 0; i < SheetCount; i++) {

			//System.out.println("Sheet Count : " + i);

			sheetName = excelFile.getSheetName(i);

			//System.out.println("Sheet Name : " + sheetName);

			if (sheetName.equals("Sheet1")) {

				//System.out.println("Test Sheet Found");

				//System.out.println("Total Number of Rows in Excel : " + excelFile.getRowCount(sheetName));

				int o = 0;

				for (int j = 2; j <= excelFile.getRowCount(sheetName); j++) {

					testcaseid = excelFile.getCellData(sheetName, 0, j);

					summary = excelFile.getCellData(sheetName, 1, j);

					description = excelFile.getCellData(sheetName, 2, j);

					parent = excelFile.getCellData(sheetName, 3, j);

					object = excelFile.getCellData(sheetName, 4, j);

					action = excelFile.getCellData(sheetName, 5, j);

					data = excelFile.getCellData(sheetName, 6, j);

					iterations = excelFile.getCellData(sheetName, 7, j);

					flags = excelFile.getCellData(sheetName, 8, j);

					if (j == 2) {
						baseTestCaseID = testcaseid;
					}

					if ((!(j == 2))) {
						if ((!(testcaseid.isEmpty()))) {
							baseTestCaseID = testcaseid;
							//System.out.println("New Test Case Found at row number : " + j);
							o = 0;
							testCaseDetails = new HashMap<>();

						}

					}

					testStepDetails.put("testcaseid", testcaseid);
					testStepDetails.put("summary", summary);
					testStepDetails.put("description", description);
					testStepDetails.put("parent", parent);
					testStepDetails.put("object", object);
					testStepDetails.put("action", action);
					testStepDetails.put("data", data);
					testStepDetails.put("iterations", iterations);
					testStepDetails.put("flags", flags);

					//System.out.println("Row Number : " + j);

					//System.out.println("TEST STEP Details Info : " + testStepDetails.toString() + "\n");

					//System.out.println("Putting Value in HashMap");

					//System.out.println("Value of Step Number : " + o);

					testCaseDetails.put(o, testStepDetails);

					testCases.put(baseTestCaseID, testCaseDetails);

					testStepDetails = new HashMap<>();

					// testCaseDetails = new HashMap<>();

					o++;
				}
			//	System.out.println("Inner For Loop is Complete");
			}

		//	System.out.println("Outer For Loop is Complete");

		}
		//System.out.println("TEST CASE Details Info : " + testCaseDetails.toString() + "\n");

		//System.out.println("TEST CASE Info : " + testCases.toString() + "\n");
		return testCases;

	}
}
