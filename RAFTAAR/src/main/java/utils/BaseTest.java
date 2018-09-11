package utils;

import java.io.File;
import java.util.HashMap;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.TestNG;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {

	public static HashMap<String, String> baseTesthashMapObj;

	public WebDriver webDriverObj;

	protected BaseTest() {
		
		System.out.println("Calling Base Test......");

		System.setProperty("current.date.time", JavaUtil.getTimeStamp());

		String outputDirectory = System.getProperty("user.dir") + "\\results\\test-output_" + JavaUtil.getTimeStamp();

		System.setProperty("logsDirectory", outputDirectory);

		JavaUtil.createDirectory(outputDirectory);

		LogUtils.info("Initalizing Log4j Properties File...");

		PropertyConfigurator.configure("log4j.properties");

		baseTesthashMapObj = new HashMap<String, String>();
		
		baseTesthashMapObj.put("logsDirectory", outputDirectory);

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

	@BeforeTest
	public void setUpDriver() {

		DriverUtil driverUtilObj = new DriverUtil();
		webDriverObj = driverUtilObj.intializeDriver();

	}

	@BeforeClass
	public void storeDriver(ITestContext ctx) {
		ctx.setAttribute("webDriverObj", webDriverObj);
	}

}