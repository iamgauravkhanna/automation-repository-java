package mobileTests;

import org.testng.annotations.Test;

import raftaar.testautomation.framework.Framework;

// This is entry point where we define Test Case IDs
public class TestSuite1 {

	@Test(enabled = true)
	public void Test1001() throws Exception {

		Framework.runTestCase("Test.Case.1001");
	}
	
	@Test (enabled=false)
	public void Test1002() throws Exception {

		Framework.runTestCase("Test.Case.1002");
	}

}