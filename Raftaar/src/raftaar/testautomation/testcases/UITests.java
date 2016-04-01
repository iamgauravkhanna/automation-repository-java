package raftaar.testautomation.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.apache.log4j.Logger;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import raftaar.testautomation.manager.TestDriver;
import raftaar.testautomation.manager.TestManager;
import raftaar.testautomation.utlities.WebPage;

public class UITests {

	static TestDriver TestDriverObject = new TestDriver();
	public static Logger log = Logger.getLogger(UITests.class);
	static String OutputDirectory = System.getProperty("user.dir") + "\\TestResults.html" ;
	
	public static  ExtentReports extentReport = new ExtentReports(OutputDirectory , true);
	public static ExtentTest extentReportTestObject ;

/*	@Parameters({ "browser", "testcaseid", "DBConnection" })
	@BeforeClass(alwaysRun = true)
	public void beforeMethod(@Optional("firefox") String browser, @Optional("Test.Case.001") String testcaseid,
			@Optional("firefox") String DBConnection) {
		TestManager.MyDataDicitonary.put("browser", browser);
		TestManager.MyDataDicitonary.put("testcaseid", testcaseid);
		TestManager.MyDataDicitonary.put("DBConnection", DBConnection);
		TestManager.MyDataDicitonary.put("RemoteURL", "local");

	}*/

	@Test
	public void testCase() throws Exception {
		
		log.info("Running Test Case : " + TestManager.MyDataDicitonary.get("testcaseid") + " \n");
		
		extentReportTestObject= extentReport.startTest(TestManager.MyDataDicitonary.get("testcaseid"));
		
		TestDriverObject.runTestCase(TestManager.MyDataDicitonary.get("testcaseid"));
		
		
		
		System.out.println("Test Case Finish");
		
		System.out.println("Report Path : " + OutputDirectory );
		
		Iterator iterator = TestManager.MyDataDicitonary.keySet().iterator();

		while (iterator.hasNext()) {
			String key = iterator.next().toString();
			String value = TestManager.MyDataDicitonary.get(key).toString();
			log.info("Key = " + key + " and  Value =  " + value + " \n");
			extentReportTestObject.log(LogStatus.INFO, "DataDictionary", "Key = " + key + " and  Value =  " + value + " \n");
		}

		extentReport.endTest(extentReportTestObject);
		
		extentReport.flush();
		
		WebPage.screenShotCounter = 0;
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
		
		System.out.println("Starting Test Case");

	}

}