package raftaar.testautomation.testcases;

import org.testng.annotations.Test;

import raftaar.testautomation.framework.Framework;

public class RunTestCase {

	Framework F1 = new Framework();

/*	@Test
	public void firstTC() throws Exception {

		F1.runTestCase("Bodgeit.Workflow");
	}

	@Test
	public void secondTC() throws Exception {

		F1.runTestCase("Test.Case.001");
	}

	@Test
	public void thirdTC() throws Exception {

		F1.runTestCase("Test.Case.002");
	}*/

	@Test
	public void fourthTC() throws Exception {

		F1.runTestCase("Broker.Employer.53602.013");
	}

}