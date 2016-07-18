package raftaar.testautomation.testcases;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.log4j.Logger;

import raftaar.testautomation.manager.TestDriver;
import raftaar.testautomation.manager.TestManager;
import raftaar.testautomation.utlities.WebPage;

public class UITests {

	public TestDriver TestDriverObject = new TestDriver();
	public static Logger log = Logger.getLogger(UITests.class);

	public static String dateTime = new SimpleDateFormat("yyyyMMddhhmm").format(new Date());
	public static String OutputDirectory = System.getProperty("user.dir") + "\\" + "test-output-" + dateTime + ".html";
	public static Reporter reporterObject ;
	public static ExtentReports extentReport = new ExtentReports(OutputDirectory, false);
	public static ExtentTest extentReportTestObject;

	@Test
	public void testCase() throws Exception {

		log.info("Running Test Case : " + TestManager.MyDataDicitonary.get("testcaseid") + " \n");

		extentReportTestObject = extentReport.startTest(TestManager.MyDataDicitonary.get("testcaseid"));

		TestDriverObject.runTestCase(TestManager.MyDataDicitonary.get("testcaseid"));

		System.out.println("Test Case Finish");

		System.out.println("Report Path : " + OutputDirectory);

		Iterator iterator = TestManager.MyDataDicitonary.keySet().iterator();
		

		while (iterator.hasNext()) {
			String key = iterator.next().toString();
			String value = TestManager.MyDataDicitonary.get(key).toString();
			log.info("Key = " + key + " and  Value =  " + value + " \n");
			extentReportTestObject.log(LogStatus.UNKNOWN, "DataDictionary",
					"Key = " + key + " and  Value =  " + value + " \n");
		}

		

		extentReport.endTest(extentReportTestObject);

		extentReport.flush();

		WebPage.screenShotCounter = 0;

		System.out.println("Test Case Ends....");
	}

	@AfterClass
	public void afterMethod() throws IOException {

		Iterator iterator = TestManager.MyDataDicitonary.keySet().iterator();

		while (iterator.hasNext()) {
			String key = iterator.next().toString();
			String value = TestManager.MyDataDicitonary.get(key).toString();
			log.info("Key = " + key + " and  Value =  " + value + " \n");
		}

		WebPage.screenShotCounter = 0;

		System.out.println("Blah Blah Blah Test Case");

	}

	public void put(HashMap<String, String> parameters) {

		TestManager.MyDataDicitonary.putAll(parameters);
	}
}