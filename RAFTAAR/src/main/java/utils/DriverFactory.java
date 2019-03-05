package utils;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverFactory {

	private WebDriver webDriver;

	private final String operatingSystem = System.getProperty("os.name").toUpperCase();

	private final String systemArchitecture = System.getProperty("os.arch");

	private DesiredCapabilities desiredCapabilitiesObj;

	WebDriver getDriver() {

		if (null == webDriver) {

			System.out.println("=================================================");

			System.out.println("Current Operating System: " + operatingSystem);

			System.out.println("Current Architecture: " + systemArchitecture);

			System.out.println("Current Browser Selection: Firefox");

			System.out.println("=================================================");

			String firefoxDriverPath = "src/test/resources/drivers/gecko-driver/geckodriver-v0.24.0-win64/geckodriver.exe";

			LogUtils.info("Path of Firefox Driver : " + firefoxDriverPath);

			System.setProperty("webdriver.gecko.driver", firefoxDriverPath);

			desiredCapabilitiesObj = DesiredCapabilities.firefox();

			desiredCapabilitiesObj.setCapability("marionette", true);
			
			desiredCapabilitiesObj.setPlatform(Platform.WINDOWS);

			webDriver = new FirefoxDriver(desiredCapabilitiesObj);
		}

		return webDriver;
	}

	void quitDriver() {
		if (null != webDriver) {
			webDriver.quit();
			webDriver = null;
		}
	}
}