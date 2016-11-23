package raftaar.testautomation.testcases;

import org.testng.annotations.Test;

import raftaar.testautomation.framework.Framework;

/**
 * This is the beginning point of Framework
 * 
 */
public class TestSuite1 {

	Framework F1 = new Framework();

	@Test
	public void Test3() throws Exception {

		F1.runTestCase("Test.Case.003");
	}

	@Test
	public void Test4() throws Exception {

		F1.runTestCase("Test.Case.004");
	}

}