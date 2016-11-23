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
	public void firstTest() throws Exception {

		F1.runTestCase("Test.Case.001");
	}

}