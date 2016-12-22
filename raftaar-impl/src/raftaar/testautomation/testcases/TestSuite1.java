package raftaar.testautomation.testcases;

import org.testng.annotations.Test;

import raftaar.testautomation.framework.Framework;

/**
 * This is the beginning point of Framework
 * 
 */
public class TestSuite1 {

	@Test
	public void Test3() throws Exception {

		Framework F1 = new Framework();

		F1.runTestCase("Test.Case.003");
	}

}