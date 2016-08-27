package webdriverScripts.utils;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Utils {

	public static WebDriver initializeDriver(String browserName, String hubURL,
			WebDriver myDriver) throws MalformedURLException {

		if (!(hubURL.equalsIgnoreCase("local"))) {

			System.out.println("Using Selenium Grid to run tests");
			DesiredCapabilities capability = DesiredCapabilities.firefox();
			capability.setBrowserName("firefox");
			capability.setPlatform(Platform.WINDOWS);
			myDriver = new RemoteWebDriver(new URL(hubURL), capability);
		}
		return myDriver;
	}
}
