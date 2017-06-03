package webTests;

import org.testng.annotations.Test;

import raftaar.testautomation.framework.Framework;

/**
 * This is the beginning point of Framework
 * 
 */

public class TestSuite2 {

	@Test
	public void Test001() throws Exception {

		Framework.runTestCase("Test.Case.001");
	}

}