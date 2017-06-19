package raftaar.testautomation.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

/**
 * This class represents methods to be executed on Mobile Page
 *
 * @author Gaurav Khanna
 *
 * @since 1st Jan 2017
 *
 * @version 1.0
 *
 * @param the
 *            parameters used by the method
 *
 * @return the value returned by the method
 *
 * @throws what
 *             kind of exception does this method throw
 */

public class MobilePage extends BaseTest {

	AndroidDriver<?> androidDriverObj;
	private WebElement element;
	private WebDriverWait wait;
	private int elementWaitTime = 10;

	public MobilePage(AndroidDriver<?> driver) {

		androidDriverObj = driver;

	}

	public void clickSimple(By locator) {

		WebElement e = findElement(locator);

		LogManager.info("Value of Webelement " + e);

		e.click();
	}

	public WebElement findElement(By locator) {

		wait = new WebDriverWait(androidDriverObj, elementWaitTime);

		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		element = androidDriverObj.findElement(locator);

		return element;
	}

	public String getText(By locator) {

		WebElement e = findElement(locator);

		LogManager.info("Value of Webelement " + e);

		return e.getText();

	}

}