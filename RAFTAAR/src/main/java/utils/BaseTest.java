package utils;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.PropertyConfigurator;

public class BaseTest {

	protected BaseTest() {

		SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");

		System.setProperty("current.date.time", dateFormat1.format(new Date()));

		String outputDirectory = System.getProperty("user.dir") + "\\results\\test-output_"
				+ dateFormat1.format(new Date());

		System.setProperty("logsDirectory", outputDirectory);

		LogUtils.info(outputDirectory);

		File dir = new File(outputDirectory);

		// attempt to create the directory here
		boolean successful = dir.mkdir();

		if (successful) {

			// creating the directory succeeded
			LogUtils.info("directory was created successfully");

		} else {

			// creating the directory failed
			LogUtils.info("failed trying to create the directory");
		}

		LogUtils.info("Initalizing Log4j Properties File...");

		PropertyConfigurator.configure("log4j.properties");

	}

}