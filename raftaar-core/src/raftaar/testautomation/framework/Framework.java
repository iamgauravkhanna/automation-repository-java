package raftaar.testautomation.framework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
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
		String a, b, c, d;

		input = new FileInputStream(System.getProperty("user.dir") + "\\" + "config.properties");

		// load a properties file
		prop.load(input);

		// get the property value and print it out
		a = prop.getProperty("browser");
		b = prop.getProperty("testcaseid");
		c = prop.getProperty("database");
		d = prop.getProperty("remortUrl");

		TestManager.MyDataDicitonary.put("browser", a);
		TestManager.MyDataDicitonary.put("testcaseid", b);
		TestManager.MyDataDicitonary.put("DBConnection", c);
		TestManager.MyDataDicitonary.put("remoteURL", d);
		System.out.println("Starting Test Case");
		UITests testObject = new UITests();
		testObject.testCase();
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

		System.out.println("Starting Test Case : " + TestManager.MyDataDicitonary.get("testcaseid"));

		UITests testObject = new UITests();

		testObject.testCase();
	}

}