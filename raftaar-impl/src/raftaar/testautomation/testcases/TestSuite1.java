package raftaar.testautomation.testcases;

import org.testng.annotations.Test;

import raftaar.testautomation.framework.Framework;
import test.testautomation.TestDriver;

/**
 * This is the beginning point of Framework
 * 
 */

public class TestSuite1 {

	@Test
	public void Test1() throws Exception {

		Framework.runTestCase("Test.Case.001","NativeApp");
	}

}