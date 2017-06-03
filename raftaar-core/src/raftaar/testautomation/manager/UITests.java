package raftaar.testautomation.manager;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.log4j.Logger;

import raftaar.testautomation.utlities.WebPage;

public class UITests {

	public TestDriver TestDriverObject = new TestDriver();
	public static Logger log = Logger.getLogger(UITests.class);

	public static String dateTime = new SimpleDateFormat("yyyyMMddhhmm").format(new Date());
	public static String OutputDirectory = System.getProperty("user.dir") + "\\reports\\" + "test-output-" + dateTime
			+ ".html";
	public static String OutputDirectory1 = "test-output-" + dateTime + ".html";
	public static Reporter reporterObject;
	/*
	 * public static ExtentReports extentReport = new
	 * ExtentReports(OutputDirectory, false); public static ExtentTest
	 * extentReportTestObject; public static ExtentTest extentReportTestChild;
	 */
	// public static com.aventstack.extentreports.ExtentReports extentReport =
	// new ExtentReports();
	// public static ExtentHtmlReporter extentHtmlReporterObj = new
	// ExtentHtmlReporter(OutputDirectory);
	public static ExtentHtmlReporter extentHtmlReporterObj = new ExtentHtmlReporter(OutputDirectory1);
	// create ExtentReports and attach reporter(s)
	ExtentReports extentReportsObj = new ExtentReports();
	public static ExtentTest extentTestObj;

	public void testCase() throws Exception {

		log.info("Running Test Case : " + TestManager.MyDataDicitonary.get("testcaseid") + " \n");

		extentReportsObj.attachReporter(extentHtmlReporterObj);

		// extentTestObj =
		// extentReportsObj.startTest(TestManager.MyDataDicitonary.get("testcaseid"));

		extentTestObj = extentReportsObj.createTest(TestManager.MyDataDicitonary.get("testcaseid"));

		TestDriverObject.runTestCase(TestManager.MyDataDicitonary.get("testcaseid"));

		System.out.println("\n Report Path : " + OutputDirectory1);

		Iterator<String> iterator = TestManager.MyDataDicitonary.keySet().iterator();

		while (iterator.hasNext()) {
			String key = iterator.next().toString();
			String value = TestManager.MyDataDicitonary.get(key).toString();
			log.info("Key = " + key + " and  Value =  " + value + " \n");
			/*
			 * extentReportTestObject.log(LogStatus.UNKNOWN, "DataDictionary",
			 * "Key = " + key + " and  Value =  " + value + " \n");
			 * extentReportTestObject.log(LogStatus.UNKNOWN, "DataDictionary",
			 * "Step Name", "Key = " + key + " and  Value =  " + value + " \n");
			 */
		}

		// extentReport.endTest(extentReportTestObject);

		extentReportsObj.flush();

		WebPage.screenShotCounter = 0;

		log.info("Test Case Ends....");
	}

	@AfterTest
	public void afterMethod() throws IOException {

		Iterator<String> iterator = TestManager.MyDataDicitonary.keySet().iterator();

		while (iterator.hasNext()) {
			String key = iterator.next().toString();
			String value = TestManager.MyDataDicitonary.get(key).toString();
			log.info("Key = " + key + " and  Value =  " + value + " \n");
		}

		WebPage.screenShotCounter = 0;

	}

	public void put(HashMap<String, String> parameters) {

		TestManager.MyDataDicitonary.putAll(parameters);
	}
}