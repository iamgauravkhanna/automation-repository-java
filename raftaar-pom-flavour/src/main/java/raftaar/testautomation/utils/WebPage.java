package raftaar.testautomation.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * This class represents methods to be executed on web page in browser
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

	public WebPage(WebDriver driver) {

		myDriver = driver;

	}

	/**
	 * This method clicks on element using webdriver's click command
	 *
	 * @author Gaurav Khanna
	 *
	 * @since 1st Jan 2017
	 *
	 * @version 1.0
	 *
	 * @param By element
	 *
	 * @return Nothing
	 *
	 * @throws Nothing
	 *             
	 */
	public void clickSimple(By locator) {

		WebElement e = findElement(locator);

		LogManager.info("Value of Webelement " + e);

		e.click();
	}

	public WebDriver openBrowser(WebDriver webDriverObj, String browserName) {

		this.myDriver = webDriverObj;

		if (browserName.contains("Firefox")) {

			myDriver = new FirefoxDriver();
		}

		return myDriver;
	}

	public void get(String url) {

		myDriver.get(url);

		myDriver.manage().window().maximize();
	}

	public WebElement findElement(By locator) {

		wait = new WebDriverWait(myDriver, elementWaitTime);

		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		element = myDriver.findElement(locator);

		try {

			fnHighlightMe(myDriver, element);

			LogManager.info("Element Highlighted");

		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		return element;
	}

	private void fnHighlightMe(WebDriver driver, WebElement element) throws InterruptedException {

		// Creating JavaScriptExecuter Interface
		JavascriptExecutor js = (JavascriptExecutor) driver;

		for (int iCnt = 0; iCnt < 3; iCnt++) {

			js.executeScript("arguments[0].style." + highLightPropertyName + " = '" + highlightColor + "'", element);
			Thread.sleep(50);

			js.executeScript("arguments[0].style." + highLightPropertyName + " = '" + originalColor + "'", element);
			Thread.sleep(50);

			js.executeScript("arguments[0].style." + highLightPropertyName + " = '" + highlightColor + "'", element);
			Thread.sleep(50);

			js.executeScript("arguments[0].style." + highLightPropertyName + " = '" + originalColor + "'", element);

		}

	}

	public void assertPresent(By homeFrontEndText) {

		findElement(homeFrontEndText);
		LogManager.info("Element is Visible on UI");

	}

	public void setText(By email, String emailID) {

		findElement(email).sendKeys(emailID);

	}

	public void switchToWindow(String your_title) {

		String currentWindow = myDriver.getWindowHandle(); // will keep current
															// window to switch
															// back
		for (String winHandle : myDriver.getWindowHandles()) {
			if (myDriver.switchTo().window(winHandle).getTitle().equals(your_title)) {
				// This is the one you're looking for
				break;
			} else {
				myDriver.switchTo().window(currentWindow);
			}
		}

	}

}