package raftaar.testautomation.utils;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * 
 * This class represents handling all possible methods on web page in a browser
 * 
 * @author Gaurav Khanna
 * 
 */

public class WebPage {

	WebDriver myDriver;

	public WebPage() {
	}

	public void clickSimple(WebElement chapter1) {

		chapter1.click();
	}

	public WebDriver openBrowser(WebDriver webDriverObj, String browserName) {

		this.myDriver = webDriverObj;

		if (browserName.contains("Firefox")) {
			myDriver = new FirefoxDriver();
		}

		return myDriver;
	}

	public void get(WebDriver driverObj, String url) {

		driverObj.get(url);
	}

	public WebDriver initializeDriverObj() throws MalformedURLException {

		// myDriver = new FirefoxDriver();

		// System.out.println("Entering Remote URL section");

		DesiredCapabilities capability = DesiredCapabilities.firefox();

		capability.setBrowserName("firefox");

		capability.setPlatform(Platform.WINDOWS);

		myDriver = new RemoteWebDriver(new URL("http://192.168.49.72:4444/wd/hub"), capability);

		return myDriver;

	}
}