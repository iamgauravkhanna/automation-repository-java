package webdriverScripts.utils;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Utils {

	/**
	 * This method is used to initialize WebDriver object
	 * 
	 * @param browserName
	 *            This is name of browser to be used
	 * 
	 * @param hubURL
	 *            This is URL of Selenium grid hub
	 * 
	 * @param myDriver
	 *            This is object name of WebDriver
	 * 
	 * @return WebDriver object
	 * 
	 * @exception MalformedURLException
	 * 
	 */
	public static WebDriver initializeDriver(String browserName, String hubURL, WebDriver myDriver)
			throws MalformedURLException {

		DesiredCapabilities capability = null;

		if (!(hubURL.equalsIgnoreCase("local"))) {

			System.out.println("Using Selenium Grid to run tests");

			if (browserName.equalsIgnoreCase("firefox")) {
				capability = DesiredCapabilities.firefox();
				capability.setBrowserName("firefox");
			} else if (browserName.equalsIgnoreCase("chrome")) {
				capability = DesiredCapabilities.chrome();
				capability.setBrowserName("chrome");
			} else if (browserName.equalsIgnoreCase("ie")) {
				capability = DesiredCapabilities.internetExplorer();
				capability.setBrowserName("IE");
			}

			capability.setPlatform(Platform.WINDOWS);

			myDriver = new RemoteWebDriver(new URL(hubURL), capability);

		} else {

			if (browserName.equalsIgnoreCase("firefox")) {
				myDriver = new FirefoxDriver();
			} else if (browserName.equalsIgnoreCase("chrome")) {
				myDriver = new ChromeDriver();

			} else if (browserName.equalsIgnoreCase("ie")) {
				myDriver = new InternetExplorerDriver();

			}

		}
		return myDriver;
	}
}