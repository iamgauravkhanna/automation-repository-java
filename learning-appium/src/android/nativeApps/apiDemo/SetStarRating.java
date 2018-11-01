package android.nativeApps.apiDemo;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import utils.CommonUtils;
import utils.ScreenshotUtility;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * 
 * @author Gaurav Khanna
 *
 * Using TouchAction - Press
 *
 */
public class SetStarRating {

	AndroidDriver<AndroidElement> androidDriverObj;

	@BeforeTest
	public void setUp() throws Exception {

		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("deviceName", "emulator-5554");

		capabilities.setCapability("platformVersion", "7.1.1");

		capabilities.setCapability("platformName", "Android");

		capabilities.setCapability("appPackage", "io.appium.android.apis");

		capabilities.setCapability("appActivity", "io.appium.android.apis.ApiDemos");

		capabilities.setCapability("noReset", "true");

		androidDriverObj = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		androidDriverObj.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		// Click on Views.
		androidDriverObj.findElement(By.id("Views")).click();

		CommonUtils.scrollToElementAndClick(androidDriverObj, "Rating Bar");

	}

	// Set 3 StarRatingbar = 1 star.
	@Test
	public void set3StarRatingbar() {

		// Locate threeStarRatingbar.
		WebElement threeStarRatingbar = androidDriverObj.findElement(By.id("io.appium.android.apis:id/ratingbar1"));

		// Get start point of threeStarRatingbar.
		int startX = threeStarRatingbar.getLocation().getX();

		System.out.println(startX);

		// Get end point of threeStarRatingbar.
		int endX = threeStarRatingbar.getSize().getWidth();

		System.out.println(endX);

		// Get vertical location of threeStarRatingbar.
		int yAxis = threeStarRatingbar.getLocation().getY();

		// Set threeStarRatingbar tap position to set Rating = 1 star.
		// You can use endX * 0.3 for 1 star, endX * 0.6 for 2 star, endX * 1
		// for 3 star.
		int tapAt = (int) (endX * 0.3);

		TouchAction act = new TouchAction(androidDriverObj);
		
		CommonUtils.takeScreenshot(androidDriverObj);

		// Set threeStarRatingbar to Rating = 1.0 using TouchAction class.
		act.press(PointOption.point(tapAt, yAxis)).release().perform();
		
		CommonUtils.takeScreenshot(androidDriverObj);

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	// Set 5 StarRatingbar = 4 star.
	@Test(dependsOnMethods = "set3StarRatingbar")
	public void set5StarRatingbar() {

		// Locate fiveStarRatingbar.
		WebElement fiveStarRatingbar = androidDriverObj.findElement(By.id("io.appium.android.apis:id/ratingbar2"));

		// Get start point of fiveStarRatingbar.
		int startX = fiveStarRatingbar.getLocation().getX();

		System.out.println(startX);

		// Get end point of fiveStarRatingbar.
		int endX = fiveStarRatingbar.getSize().getWidth();

		System.out.println(endX);

		// Get vertical location of fiveStarRatingbar.
		int yAxis = fiveStarRatingbar.getLocation().getY();

		// Set fiveStarRatingbar tap position to set Rating = 4 star.
		// You can use endX * 0.2 for 1 star, endX * 0.4 for 2 star, endX * 0.6
		// for 3 star, endX * 0.8 for 4 star, endX * 1 for 5 star.
		int tapAt = (int) (endX * 0.8);

		TouchAction act = new TouchAction(androidDriverObj);
		
		CommonUtils.takeScreenshot(androidDriverObj);

		// Set fiveStarRatingbar to Rating = 4 star using TouchAction class.
		act.press(PointOption.point(tapAt, yAxis)).release().perform();
		
		CommonUtils.takeScreenshot(androidDriverObj);

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@AfterTest
	public void End() {
		androidDriverObj.quit();
	}
}