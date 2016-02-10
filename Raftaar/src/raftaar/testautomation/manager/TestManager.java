package raftaar.testautomation.manager;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *  @author Gaurav Khanna
 */

import java.util.HashMap;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import raftaar.testautomation.testcases.UITests;
import raftaar.testautomation.utlities.JavaUtils;
import raftaar.testautomation.utlities.WebPage;

public class TestManager {

	// public ExcelUtils excelFile = new
	// ExcelUtils(System.getProperty("user.dir") + "\\assets\\testcase.xlsx");
	public static HashMap<String, String> MyDataDicitonary = new HashMap<>();
	public int SheetCount;
	public String sheetName;
	public String StepOutcome;
	public String tsid;
	public String summary;
	public String testid;
	public String description;
	public String keyword;
	public By locator;
	public String value;
	public String data;
	public String iterations;
	public String flags;
	public String parent;
	//Logger log = Logger.getLogger("TestManager");
	WebPage d = new WebPage();
	// static final Logger logger =
	// LogManager.getLogger(TestRunner.class.getName());

	/**
	 * This is a Javadoc example. It explains the working of Javadoc comments.
	 * 
	 * @param String
	 *            text The above line is used to document what the parameters
	 *            that are passed to the method do. Each parameter gets its
	 *            own @param block.
	 * 
	 * @return void This explains what the output / result of the method is. In
	 *         this case, it's void.
	 */
	public void runTestStep(String testcaseid, String summary, String description, String parent, String object,
			String action, String data, String iterations, String flags) throws Exception {

		//configure log4j properties file
	    PropertyConfigurator.configure("Log4j.properties");
		
		// System.out.println(tsid);
		// System.out.println(testid);
		// System.out.println(description);
		// System.out.println(keyword);
		// System.out.println(loc);
		// System.out.println("Value is : " + value);
		// System.out.println("Data is " + data);
		// System.out.println(iterations);
		// System.out.println(flags);

		if (data.contains("#")) {
			//System.out.println("Parameterized value found");
			data = JavaUtils.replaceVariablesInString(data, TestManager.MyDataDicitonary);
			//System.out.println("Data is :" + data);
			//logger.info("This is Logger Info");
		}
		
		if (object.contains("#")) {
			//System.out.println("Parameterized value found");
			object = JavaUtils.replaceVariablesInString(object, TestManager.MyDataDicitonary);
			//System.out.println("Data is :" + data);
			//logger.info("This is Logger Info");
		}

		// locator = locatorValue(object);

		/*
		 * if (data.contains("#")) { // System.out.println(
		 * "Parameterized data found" + data); data =
		 * JavaUtils.replaceVariablesInString(data,
		 * TestRunner.MyDataDicitonary); // System.out.println(data); }
		 */

		// Create json object and print step meta into to console
		HashMap<String, String> stepJsonMetaInfo = new HashMap<>();
		// HashMap<Integer, HashMap<String, String>> TestCase = new HashMap<>();

		stepJsonMetaInfo.put("testcaseid", testcaseid);
		stepJsonMetaInfo.put("summary", summary);
		stepJsonMetaInfo.put("description", description);
		stepJsonMetaInfo.put("parent", parent);
		stepJsonMetaInfo.put("action", action);
		stepJsonMetaInfo.put("object", object);
		stepJsonMetaInfo.put("data", data);
		stepJsonMetaInfo.put("iterations", iterations);
		stepJsonMetaInfo.put("flags", flags);
		// TestCase.put(1, stepJsonMetaInfo);

		UITests.log.info("STEP Meta Info : " + stepJsonMetaInfo.toString() + "\n");
		//System.out.println("STEP Meta Info : " + stepJsonMetaInfo.toString() + "\n");
		// System.out.println("Test Case Info : " + TestCase.toString() + "\n");

		// Log.info("STEP Meta Info : " + stepJsonMetaInfo.toString() + "\n");
		/*
		 * logger.error("This is error"); logger.info("This is my test case");
		 */
		// logger.info("# # # # # # # # # # # # # # # # # # # # # # # # # # #
		// ");
		// logger.info("STEP Meta Info : " + stepJsonMetaInfo.toString() +
		// "\n");
		/* logger.info("TEST Has Started"); */

		StepOutcome = d.ExecuteKeyword(action, parent, object, data);
		
		UITests.log.info("Step Outcome : " + StepOutcome + "\n");
		//System.out.println("Step Outcome : " + StepOutcome + "\n");

	}

	
}
