package raftaar.testautomation.framework;

import raftaar.testautomation.manager.TestManager;
import raftaar.testautomation.testcases.UITests;

public class JarExample {

	public static void main(String[] args) throws Exception {

		String c, d;

		String a = args[0];
		String b = args[1];
		/*
		 * String c = args[2]; String d = args[3];
		 */
		/*
		 * a = "Firefox"; b = "Test.Case.035";
		 */
		c = "jdbc:oracle:thin:PHIX_QA08_001/pr1vate@phixdevproduct.cq66g54vnu5m.us-east-1.rds.amazonaws.com:1521:phix";
		d = "local";
		TestManager.MyDataDicitonary.put("browser", a);
		TestManager.MyDataDicitonary.put("testcaseid", b);
		TestManager.MyDataDicitonary.put("DBConnection", c);
		TestManager.MyDataDicitonary.put("RemoteURL", d);

		System.out.println("Starting Test Case");
		UITests testObject = new UITests();
		testObject.testCase();
	}

}
