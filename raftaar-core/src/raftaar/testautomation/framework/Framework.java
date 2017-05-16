package raftaar.testautomation.framework;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.testng.TestNG;
import org.testng.collections.Lists;

import raftaar.testautomation.manager.TestManager;
import raftaar.testautomation.manager.UITests;
import raftaar.testautomation.utlities.JavaUtils;
import raftaar.testautomation.utlities.LoadProperties;

public class Framework {

	public Map<String, String> hashMapObj;

	public Framework() throws Exception {

		System.out.println("Framework Constructor Called");

		Properties prop = new Properties();

		InputStream input = null;

		String a;

		Map m = LoadProperties.getProperties();

		a = (String) m.get("testngSuiteFiles");
		
		System.out.println("Testng Suite File ==> "+a);

		TestNG tng = new TestNG();

		List<String> suites = Lists.newArrayList();

		suites.add(a);

		tng.setTestSuites(suites);

		tng.run();

		a = prop.getProperty("testngSuiteFiles");

		UITests.log.info(a);

		// runTestCase("testCaseID");

	}

	public static void runTestCase(String testCaseID) throws Exception {

		System.out.println("Test Case ID " + testCaseID);

		TestManager.MyDataDicitonary.put("testcaseid", testCaseID);

		Properties prop = new Properties();

		FileInputStream input = null;

		input = new FileInputStream(System.getProperty("user.dir") + "\\" + "config.properties");

		// load a properties file
		prop.load(input);

		JavaUtils.readPropertyAndStoreinMap(System.getProperty("user.dir") + "\\" + "config.properties",
				TestManager.MyDataDicitonary);

		UITests.log.info("Starting Test Case : " + TestManager.MyDataDicitonary.get("testcaseid"));

		UITests testObject = new UITests();

		testObject.testCase();
	}

}