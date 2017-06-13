package raftaar.testautomation.utils;

import org.apache.log4j.PropertyConfigurator;

public class BaseTest {

	protected BaseTest() {

		System.out.println("BaseTest Parent Constructor Called");

		PropertyConfigurator.configure("log4j.properties");

	}

}
