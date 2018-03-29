package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.TouchAction;
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
	private String destDir;
	private SimpleDateFormat dateFormat;

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

	public void takeScreenShot() {

		// Set folder name to store screenshots.
		destDir = "screenshots";

		// Capture screenshot.
		File scrFile = ((TakesScreenshot) androidDriverObj).getScreenshotAs(OutputType.FILE);

		// Set date format to set It as screenshot file name.
		dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");

		// Create folder under project with name "screenshots" provided to
		// destDir.
		new File(destDir).mkdirs();

		// Set file name using current date time.
		String destFile = dateFormat.format(new Date()) + ".png";

		try {
			// Copy paste file at destination folder location
			FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public WebElement getElementUsingUIAutomator(String optionValue) {

		String selectOption = String.format(
				"new UiScrollable(new UiSelector()).scrollIntoView(" + "new UiSelector().text(\"%s\"));", optionValue);

		WebElement webElementObj = androidDriverObj.findElementByAndroidUIAutomator(selectOption);

		return webElementObj;

	}

	public void clickUsingUIAutomator(String optionValue) {

		getElementUsingUIAutomator(optionValue).click();

	}

	public void moveSeekBar(By seekBar2, int percantage) {

		// Locate SeekBar element.
		WebElement seekBar = findElement(seekBar2);

		// Get start point of seekbar.
		int startX = seekBar.getLocation().getX();

		System.out.println(startX);

		// Get end point of seekbar.
		int endX = seekBar.getSize().getWidth();

		System.out.println(endX);

		// Get vertical location of seekbar.
		int yAxis = seekBar.getLocation().getY();

		// Set sllebar move to position.

		double percantageObj = percantage / 100;

		LogManager.info("Value of percantageObj : " + percantageObj);

		// endX * 0.6 means at 60% of seek bar width.
		int moveToXDirectionAt = (int) (endX * percantageObj);

		System.out.println("Moving seek bar at " + moveToXDirectionAt + " In X direction.");

		// Moving seekbar using TouchAction class.
		TouchAction act = new TouchAction(androidDriverObj);

		act.press(startX, yAxis).moveTo(moveToXDirectionAt, yAxis).release().perform();
	}

}