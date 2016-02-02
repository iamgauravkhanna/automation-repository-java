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
	Logger log = Logger.getLogger("devpinoyLogger");

	@Parameters({ "browser", "testcaseid" })
	@BeforeClass(alwaysRun = true)
	public void beforeMethod(@Optional("firefox") String browser, @Optional("Test.Case.001") String testcaseid) {
		TestManager.MyDataDicitonary.put("browser", browser);
		TestManager.MyDataDicitonary.put("testcaseid", testcaseid);
	}

	@Test
	public void testCase() throws Exception {

		log.debug("This is the message for log file");
		
		myDriver.runTestCase(TestManager.MyDataDicitonary.get("testcaseid"));
	}

}