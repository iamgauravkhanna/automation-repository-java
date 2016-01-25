package raftaar.testautomation.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import raftaar.testautomation.manager.TestDriver;
import raftaar.testautomation.manager.TestManager;

public class UITests {

	static TestDriver myDriver = new TestDriver();

	@Parameters({ "browser", "testcaseid" })
	@BeforeClass(alwaysRun = true)
	public void beforeMethod(@Optional("firefox") String browser, @Optional("Test.Case.001") String testcaseid) {
		TestManager.MyDataDicitonary.put("browser", browser);
		TestManager.MyDataDicitonary.put("testcaseid", testcaseid);
	}

	@Test
	public void testCase() throws Exception {

		myDriver.runTestCase(TestManager.MyDataDicitonary.get("testcaseid"));
	}

}