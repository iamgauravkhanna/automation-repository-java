package raftaar.testautomation.testcases;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import raftaar.testautomation.manager.TestDriver;
import raftaar.testautomation.manager.TestManager;

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

}