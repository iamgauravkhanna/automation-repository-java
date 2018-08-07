package android.nativeApps.apiDemo;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ControlSeekBar {

	AndroidDriver driver;

	@BeforeTest
	public void setUp() throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "emulator-5554");
		capabilities.setCapability("platformVersion", "7.1.1");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "io.appium.android.apis");
		capabilities.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Test
	public void ScrollToView() throws InterruptedException {

		// Click on Views.
		driver.findElement(By.id("Views")).click();

		// Scroll till element which contains "Seek Bar" text If It Is not
		// visible on screen.
		// driver.scrollTo("Seek Bar");
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(" + "new UiSelector().text(\"Seek Bar\"));").click();

		// Locate SeekBar element.
		WebElement seekBar = driver.findElementById("io.appium.android.apis:id/seek");
		// Get start point of seekbar.
		int startX = seekBar.getLocation().getX();
		System.out.println("startx Location : " + startX);
		// Get end point of seekbar.
		int endX = seekBar.getSize().getWidth();
		System.out.println("endx Location :" + endX);
		// Get vertical location of seekbar.
		int yAxis = seekBar.getLocation().getY();

		// Set sllebar move to position.
		// endX * 0.6 means at 60% of seek bar width.
		int moveToXDirectionAt = (int) (endX * 0.9);
		System.out.println("Moving seek bar at " + moveToXDirectionAt + " In X direction.");

		Thread.sleep(5000);

		// Moving seekbar using TouchAction class.
		TouchAction act = new TouchAction(driver);
		// act.press(startX, yAxis).moveTo(moveToXDirectionAt,
		// yAxis).release().perform();

		act.press(PointOption.point(startX, yAxis)).moveTo(PointOption.point(moveToXDirectionAt, yAxis)).release()
				.perform();

		Thread.sleep(5000);
	}

	@AfterTest
	public void End() throws IOException {
		driver.quit();

	}
}