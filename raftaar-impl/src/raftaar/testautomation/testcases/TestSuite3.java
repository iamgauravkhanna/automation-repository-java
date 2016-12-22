package raftaar.testautomation.testcases;

import org.testng.annotations.Test;

import raftaar.testautomation.impl.TestDriver;

/**
 * This is the beginning point of Framework
 * 
 */
public class TestSuite3 {

	TestDriver F1 = new TestDriver();

	@Test
	public void Test30() throws Exception {

		F1.runTestCase("Test.Case.030");
	}

}