package raftaar.testautomation.utils;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * This class represents handling all possible methods on web page in a browser
 * 
 * @author Gaurav Khanna
 * 
 */

public class WebPage extends BaseTest {

	WebDriver myDriver;
	private WebElement element;
	private WebDriverWait wait;
	private String highLightPropertyName = "outline";
	private String highlightColor = "#00ff00 solid 3px";
	private String originalColor = "none";
	private int elementWaitTime = 10;

	public WebPage() {

	}

	public void clickSimple(WebElement chapter1) {

		LogManager.info("Value of Webelement " + chapter1);

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

		driverObj.manage().window().maximize();
	}

	public WebDriver initializeDriverObj() throws MalformedURLException {

		// myDriver = new FirefoxDriver();

		// System.out.println("Entering Remote URL section");

		DesiredCapabilities capability = DesiredCapabilities.firefox();

		capability.setBrowserName("firefox");

		capability.setPlatform(Platform.WINDOWS);

		myDriver = new RemoteWebDriver(new URL("http://192.168.49.72:4444/wd/hub"), capability);

		LogManager.info("Browser Initialized");

		return myDriver;

	}

	public WebElement findElement(WebDriver webDriverObj, By locator) {

		wait = new WebDriverWait(webDriverObj, elementWaitTime);

		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		element = webDriverObj.findElement(locator);

		try {
			fnHighlightMe(driver, element);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return element;
	}

	private void fnHighlightMe(WebDriver driver, WebElement element) throws InterruptedException {

		// Creating JavaScriptExecuter Interface
		JavascriptExecutor js = (JavascriptExecutor) driver;

		for (int iCnt = 0; iCnt < 3; iCnt++) {
			/*
			 * // Execute javascript js.executeScript(
			 * "arguments[0].style.border='4px groove green'", element);
			 * Thread.sleep(1000); js.executeScript(
			 * "arguments[0].style.border='outline|#00ff00 solid 3px'",
			 * element);
			 */

			js.executeScript("arguments[0].style." + highLightPropertyName + " = '" + highlightColor + "'", element);
			Thread.sleep(50);

			js.executeScript("arguments[0].style." + highLightPropertyName + " = '" + originalColor + "'", element);
			Thread.sleep(50);

			js.executeScript("arguments[0].style." + highLightPropertyName + " = '" + highlightColor + "'", element);
			Thread.sleep(50);

			js.executeScript("arguments[0].style." + highLightPropertyName + " = '" + originalColor + "'", element);

		}

	}

}