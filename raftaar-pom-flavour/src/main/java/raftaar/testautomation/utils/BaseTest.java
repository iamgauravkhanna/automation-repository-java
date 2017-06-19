package raftaar.testautomation.utils;

import org.apache.log4j.PropertyConfigurator;

public class BaseTest {

	protected BaseTest() {

		PropertyConfigurator.configure("log4j.properties");

	}

}
