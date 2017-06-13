package raftaar.testautomation.utils;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverUtil {

	WebDriver myDriver;
	
	public WebDriver initializeDriverObj() {

		// myDriver = new FirefoxDriver();

		// System.out.println("Entering Remote URL section");

		DesiredCapabilities capability = DesiredCapabilities.firefox();

		capability.setBrowserName("firefox");

		capability.setPlatform(Platform.WINDOWS);

		try {
			myDriver = new RemoteWebDriver(new URL("http://192.168.49.72:4444/wd/hub"), capability);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		LogManager.info("Browser Initialized");

		return myDriver;

	}

}
