package utils;

import java.io.File;
import java.util.HashMap;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

	public WebDriver webDriverObj ;

	public HashMap<String, String> testDataMap = new HashMap<String, String>();

	private BrowserFactory browserFactoryObj;

	private String outputDirectory;
	
	public ThreadLocal<WebDriver> webDriverPool = new ThreadLocal<WebDriver>();

	public BaseTest() {

		System.setProperty("current.date.time", JavaUtil.getTimeStamp());

		String fileSeperator = System.getProperty("file.separator");

		outputDirectory = System.getProperty("user.dir") + fileSeperator + "test-results" + fileSeperator + "logs"
				+ fileSeperator + "test-output_" + JavaUtil.getTimeStamp() + "_" + JavaUtil.generateRandomString();

		System.setProperty("logsDirectory", outputDirectory);

		JavaUtil.createDirectory(outputDirectory);

		PropertyConfigurator.configure("log4j.properties");

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

		LogUtils.info("============ setUp() begins ============");

		TestDataWriter.getInstance().putKey("logsDirectory", outputDirectory);

		TestDataWriter.getInstance().putKey("User", "Gaurav.Khanna");

		// createTestDataMap();

		browserFactoryObj = new BrowserFactory();

		webDriverPool.set(browserFactoryObj.getBrowser());

		/*
		 * if (DriverManager.getDriver() == null) {
		 * 
		 * DriverManager.setWebDriver(DriverFactory.createInstance()); }
		 */

		testDataMap.putAll(TestDataWriter.getInstance().getDataDictionary());

		LogUtils.info("============ setUp() ends ============");

	}

	@AfterMethod
	public void cleanUp() {

		TestDataWriter.getInstance().putAllKeys(testDataMap);

		LogUtils.info("========= Closing Browser =========");

		webDriverPool.get().manage().deleteAllCookies();

		webDriverPool.get().quit();

		testDataMap.putAll(TestDataWriter.getInstance().getDataDictionary());

	}

	@AfterTest
	public void tearDown() {

		LogUtils.info("====== Finally All Tests Are Executed ======");

	}

}