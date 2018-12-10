package utils;

import java.io.File;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.TestNG;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {

	/*
	 * public static ThreadLocal<ConcurrentHashMap<String, String>>
	 * baseTestHashMapObj = new ThreadLocal<ConcurrentHashMap<String, String>>(){
	 * 
	 * @Override protected ConcurrentHashMap<String, String> initialValue() { return
	 * baseTestHashMapObj.get(); }
	 * 
	 * };
	 */

	// public HashMap<String, String> baseTestHashMapObj = new HashMap<String,
	// String>();

	public WebDriver webDriverObj;

	public DriverUtil driverUtilObj;

	public HashMap<String, String> baseTestHashMapObj = new HashMap<String, String>();

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

	@BeforeTest
	public void setUp() {

		driverUtilObj = new DriverUtil(baseTestHashMapObj);
		webDriverObj = driverUtilObj.intializeDriver();

	}

	@AfterMethod(alwaysRun = true)
	public void cleanUp() {

		JavaUtil.writeToFileApacheCommonIO(new File(
				baseTestHashMapObj.get("logsDirectory") + "\\" + "TestData_" + JavaUtil.getTimeStamp() + ".txt"),
				baseTestHashMapObj.toString());

	}

}