package raftaar.testautomation.testcases;

import org.testng.annotations.Test;

import raftaar.testautomation.framework.Framework;

public class RunTestCase {

	Framework F1 = new Framework();

	@Test
	public void firstTC() throws Exception {

		F1.runTestCase("Test.Case.002");
	}

}