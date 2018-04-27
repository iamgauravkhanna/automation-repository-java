package utils;

import org.apache.log4j.PropertyConfigurator;

public class BaseTest {

	protected BaseTest() {

		System.setProperty("current.date.time", JavaUtils.getTimeStamp());

		String outputDirectory = System.getProperty("user.dir") + "\\results\\test-output_" + JavaUtils.getTimeStamp();

		System.setProperty("logsDirectory", outputDirectory);

		JavaUtils.createDirectory(outputDirectory);

		LogUtils.info("Initalizing Log4j Properties File...");

		PropertyConfigurator.configure("log4j.properties");

	}

}