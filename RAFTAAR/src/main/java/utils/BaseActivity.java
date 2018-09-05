package utils;

import java.text.SimpleDateFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class BaseActivity {

	// AndroidDriver<Mo> androidDriverObj;
	protected AndroidDriver<AndroidElement> androidDriverObj;
	private WebElement element;
	private MobileElement mobileElement;
	private WebDriverWait wait;
	private int elementWaitTime = 10;
	private String destDir;
	private SimpleDateFormat dateFormat;

	/**
	 * Constructor of this class
	 */
	public BaseActivity() {

		try {

			LogUtils.info("Calling MobilePage Constructor");

		} catch (Exception e) {

			e.printStackTrace();			

		}

	}

	public void clickSimple(By locator) {

		MobileElement e = findMobileElement(locator);

		LogUtils.info("Value of MobileElement " + e);

		e.click();
	}

	public WebElement findElement(By locator) {

		wait = new WebDriverWait(androidDriverObj, elementWaitTime);

		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		element = androidDriverObj.findElement(locator);

		return element;
	}

	public MobileElement findMobileElement(By locator) {

		wait = new WebDriverWait(androidDriverObj, elementWaitTime);

		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		mobileElement = androidDriverObj.findElement(locator);

		return mobileElement;
	}

	public String getText(By locator) {

		WebElement e = findElement(locator);

		LogUtils.info("Value of Webelement " + e);

		return e.getText();

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

		LogUtils.info("Value of percantageObj : " + percantageObj);

		// endX * 0.6 means at 60% of seek bar width.
		int moveToXDirectionAt = (int) (endX * percantageObj);

		System.out.println("Moving seek bar at " + moveToXDirectionAt + " In X direction.");

		// Moving seekbar using TouchAction class.
		TouchAction act = new TouchAction(androidDriverObj);

		// act.press(startX, yAxis).moveTo(moveToXDirectionAt,
		// yAxis).release().perform();
	}

	public void tap() {

	}

	public void swipe() {

	}

	public void press() {

	}

	public void longPress() {

	}

	public void drag() {

	}
	
	public void openActivity(String appPackage, String appActivity ) {
		
		Activity activityObj = new Activity(appPackage, appActivity) ;

		androidDriverObj.startActivity(activityObj);
	
	}

}