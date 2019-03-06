package utils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverFactory {

	private static Logger logger = LogManager.getLogger(DriverFactory.class);

	static WebDriver createInstance() {

		WebDriver driver = null;

		DesiredCapabilities desiredCapabilitiesObj;

		try {

			String chromeDriverPath = "src/test/resources/drivers/chrome-driver/2.46/chromedriver.exe";

			LogUtils.info("Path of Chrome Driver : " + chromeDriverPath);

			System.setProperty("webdriver.chrome.driver", chromeDriverPath);

			desiredCapabilitiesObj = new DesiredCapabilities();

			desiredCapabilitiesObj = DesiredCapabilities.chrome();

			desiredCapabilitiesObj.setBrowserName("chrome");

			driver = new ChromeDriver(desiredCapabilitiesObj);

			logger.debug(driver);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return driver;
	}
}