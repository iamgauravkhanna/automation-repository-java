package webdriverScripts.utils;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.MarionetteDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Utils {

	/**
	 * This method is used to initialize WebDriver object
	 * 
	 * @param browserName
	 *            This is name of browser to be used
	 * @param hubURL
	 *            This is URL of Selenium grid hub
	 * @param myDriver
	 *            This is object name of WebDriver
	 * @return WebDriver object
	 * @exception MalformedURLException
	 */
	public static WebDriver initializeDriver(String browserName, String hubURL, WebDriver myDriver)
			throws MalformedURLException {

		if (!(hubURL.equalsIgnoreCase("local"))) {

			System.out.println("Using Selenium Grid to run tests");
			DesiredCapabilities capability = DesiredCapabilities.firefox();
			capability.setBrowserName("firefox");
			capability.setPlatform(Platform.WINDOWS);
			myDriver = new RemoteWebDriver(new URL(hubURL), capability);
		} else {
			String marionetteDriverLocation = "c://selenium//wires.exe";
			System.setProperty("webdriver.gecko.driver", marionetteDriverLocation);
			myDriver = new MarionetteDriver();
		}
		return myDriver;
	}
}
