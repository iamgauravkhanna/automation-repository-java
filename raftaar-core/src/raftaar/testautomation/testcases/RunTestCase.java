package raftaar.testautomation.testcases;

import org.testng.annotations.Test;

import raftaar.testautomation.framework.Framework;

/**
 * This is the beginning point of Framework
 * 
 */
public class RunTestCase {

	Framework F1 = new Framework();

	@Test
	public void firstTest() throws Exception {

		F1.runTestCase("Regression.Workflow.002");
	}

}