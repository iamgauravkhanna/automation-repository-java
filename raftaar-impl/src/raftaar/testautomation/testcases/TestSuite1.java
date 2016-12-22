package raftaar.testautomation.testcases;

import org.testng.annotations.Test;

import raftaar.testautomation.impl.TestDriver;

/**
 * This is the beginning point of Framework
 * 
 */
public class TestSuite1 {

	TestDriver F1 = new TestDriver();

	@Test
	public void Test3() throws Exception {

		F1.runTestCase("Test.Case.003");
	}

	@Test
	public void Test4() throws Exception {

		F1.runTestCase("Test.Case.004");
	}

}