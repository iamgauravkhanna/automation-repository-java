package utils;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

	public WebDriver webDriverObj = null;

	public HashMap<String, String> baseTestHashMapObj = new HashMap<String, String>();

	private BrowserFactory browserFactoryObj;

	public BaseTest() {

		System.out.println("Calling Base Test......");

		System.setProperty("current.date.time", JavaUtil.getTimeStamp());

		String outputDirectory = System.getProperty("user.dir") + "\\results\\test-output_" + JavaUtil.getTimeStamp()
				+ "_" + JavaUtil.generateRandomString();

		System.setProperty("logsDirectory", outputDirectory);

		JavaUtil.createDirectory(outputDirectory);

		LogUtils.info("Initalizing Log4j Properties File...");

		PropertyConfigurator.configure("log4j.properties");

		baseTestHashMapObj.put("logsDirectory", outputDirectory);

		baseTestHashMapObj.put("User", "Gaurav.Khanna");

		createTestDataMap();

		System.out.println("Start Up Completed");

		LogUtils.info("BeforeTest Method of BaseTest");

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

	@BeforeMethod
	public void setUp() {

		browserFactoryObj = new BrowserFactory();

		webDriverObj = browserFactoryObj.getBrowser();

	}

	@AfterMethod
	public void cleanUp() {

		LogUtils.info("========= Closing Browser =========");

		webDriverObj.manage().deleteAllCookies();

		webDriverObj.quit();

		JavaUtil.writeToFileApacheCommonIO(new File(
				baseTestHashMapObj.get("logsDirectory") + "\\" + "TestData_" + JavaUtil.getTimeStamp() + ".txt"),
				baseTestHashMapObj.toString());

	}

}