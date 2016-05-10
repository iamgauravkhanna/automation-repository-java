package raftaar.testautomation.framework;

import raftaar.testautomation.manager.TestManager;
import raftaar.testautomation.testcases.UITests;

public class Framework {

	public static void main(String[] args) throws Exception {

		String a, b, c, d;

		a = "Firefox";
		b = "Test.Case.001";
		c = "jdbc:oracle:thin:username/password@localhost:1521:xe";
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
