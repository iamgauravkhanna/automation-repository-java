package utils;

import java.io.File;
import java.util.HashMap;

import org.apache.log4j.PropertyConfigurator;
import org.testng.TestNG;

public class BaseTest {

	public static HashMap<String, String> baseTesthashMapObj;

	protected BaseTest() {

		System.setProperty("current.date.time", JavaUtils.getTimeStamp());

		String outputDirectory = System.getProperty("user.dir") + "\\results\\test-output_" + JavaUtils.getTimeStamp();

		System.setProperty("logsDirectory", outputDirectory);

		JavaUtils.createDirectory(outputDirectory);

		LogUtils.info("Initalizing Log4j Properties File...");

		PropertyConfigurator.configure("log4j.properties");

		baseTesthashMapObj = new HashMap<String, String>();

		createTestDataMap();

	}

	private void createTestDataMap() {

		File folder = new File("./src/main/resources/");

		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {

			if (listOfFiles[i].isFile()) {

				LogUtils.info("File #" + i + " " + listOfFiles[i].getName());

			} else if (listOfFiles[i].isDirectory()) {

				LogUtils.info("Directory " + listOfFiles[i].getName());

			}

		}

	}
	
	
}