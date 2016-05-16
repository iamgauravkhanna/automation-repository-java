package raftaar.testautomation.framework;

import org.testng.annotations.Test;

public class ImplementTestCase {

	Framework F1 = new Framework();

	@Test
	public void firstTC() throws Exception {

		F1.runTestCase("Test.Case.001");
	}
}
