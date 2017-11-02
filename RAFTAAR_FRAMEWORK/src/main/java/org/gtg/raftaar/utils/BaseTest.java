package org.gtg.raftaar.utils;

import org.apache.log4j.PropertyConfigurator;

public class BaseTest {

	protected BaseTest() {

		LogUtils.info("Initalizing Log4j Properties File");
		
		PropertyConfigurator.configure("log4j.properties");
		
	}

}