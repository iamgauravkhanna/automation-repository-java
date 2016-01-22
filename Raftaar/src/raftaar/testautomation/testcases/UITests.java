package raftaar.testautomation.testcases;

import org.testng.annotations.Test;

import raftaar.testautomation.manager.TestDriver;

public class UITests {

	static TestDriver myDriver = new TestDriver();

	@Test
	public void testCase() throws Exception {

		myDriver.runTestCase("Test.Case.008");
	}

}