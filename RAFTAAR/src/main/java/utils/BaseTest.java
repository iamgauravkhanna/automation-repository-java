package utils;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.PropertyConfigurator;

public class BaseTest {

	protected BaseTest() {

		LogUtils.info("Initalizing Log4j Properties File...");

		PropertyConfigurator.configure("log4j.properties");

		// String out = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss").format(new Date());

		DateFormat dateFormat = new SimpleDateFormat("dd_MMM_yyyy__hh_mm_ssaa");

		String outputDirectory = "//test-output///html///screenshots///" + dateFormat.format(new Date());

		File dir = new File(outputDirectory);

		// attempt to create the directory here
		boolean successful = dir.mkdir();

		if (successful) {
			// creating the directory succeeded
			System.out.println("directory was created successfully");
		} else {
			// creating the directory failed
			System.out.println("failed trying to create the directory");
		}
	}

}