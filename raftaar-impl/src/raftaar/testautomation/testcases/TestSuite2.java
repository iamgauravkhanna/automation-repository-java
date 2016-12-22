package raftaar.testautomation.testcases;

import org.testng.annotations.Test;

import raftaar.testautomation.impl.TestDriver;

/**
 * This is the beginning point of Framework
 * 
 */
public class TestSuite2 {

	TestDriver F1 = new TestDriver();

	@Test
	public void Test1() throws Exception {

		F1.runTestCase("Test.Case.001");
	}

	@Test
	public void Test2() throws Exception {

		F1.runTestCase("Test.Case.002");
	}

	@Test
	public void Test29() throws Exception {

		F1.runTestCase("Test.Case.029");
	}

}