package raftaar.testautomation.testcases;

import java.util.Map.Entry;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import raftaar.testautomation.manager.TestDriver;
import raftaar.testautomation.manager.TestManager;
import raftaar.testautomation.utlities.WebPage;

public class UITests {

	static TestDriver myDriver = new TestDriver();
	public static Logger log = Logger.getLogger(UITests.class);

	@Parameters({ "browser", "testcaseid", "DBConnection" })
	@BeforeClass(alwaysRun = true)
	public void beforeMethod(@Optional("firefox") String browser, @Optional("Test.Case.001") String testcaseid,
			@Optional("firefox") String DBConnection) {
		TestManager.MyDataDicitonary.put("browser", browser);
		TestManager.MyDataDicitonary.put("testcaseid", testcaseid);
		TestManager.MyDataDicitonary.put("DBConnection", DBConnection);

	}

	@Test
	public void testCase() throws Exception {

		// configure log4j properties file
		// PropertyConfigurator.configure("Log4j.properties");

		log.info("Running Test Case : " + TestManager.MyDataDicitonary.get("testcaseid"));

		myDriver.runTestCase(TestManager.MyDataDicitonary.get("testcaseid"));
	}

	@AfterClass
	public void afterMethod(){
		
		System.out.println("----------------------------------------");
		
		System.out.println(" Key : Value ");
		
		for (Entry<String, String> entry : TestManager.MyDataDicitonary.entrySet()) {
			System.out.println("----------------------------------------");
			
		    System.out.println(entry.getKey()+" : "+entry.getValue());
		    
		    WebPage.screenShotCounter = 0;
		}
		
	}
	
}