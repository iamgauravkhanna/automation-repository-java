package raftaar.testautomation.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

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

	public WebDriver initializeDriverObj(WebDriver webDriverObj) {

		webDriverObj = new FirefoxDriver();

		return webDriverObj;

	}
}