package raftaar.testautomation.framework;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

import raftaar.testautomation.manager.TestManager;
import raftaar.testautomation.testcases.UITests;
import raftaar.testautomation.utlities.JavaUtils;

public class Framework {

	public Map<String, String> hashMapObj;

	public static void main(String[] args) throws Exception {

		Properties prop = new Properties();
		
		InputStream input = null;
		
		String a;

		input = new FileInputStream(System.getProperty("user.dir") + "\\" + "config.properties");

		// load a properties file
		prop.load(input);

		// get the property value and print it out
		a = prop.getProperty("testcaseid");
		
		UITests.log.debug(a);

		Framework F = new Framework();

		F.runTestCase(a);

	}

	public void runTestCase(String testCaseID) throws Exception {

		TestManager.MyDataDicitonary.put("testcaseid", testCaseID);

		Properties prop = new Properties();

		FileInputStream input = null;

		input = new FileInputStream(System.getProperty("user.dir") + "\\" + "config.properties");

		// load a properties file
		prop.load(input);

		JavaUtils.readPropertyAndStoreinMap(System.getProperty("user.dir") + "\\" + "config.properties",
				TestManager.MyDataDicitonary);

		UITests.log.debug("Starting Test Case : " + TestManager.MyDataDicitonary.get("testcaseid"));

		UITests testObject = new UITests();

		testObject.testCase();
	}

}