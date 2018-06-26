package android.nativeApps;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

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
		capabilities.setCapability("deviceName", "ZX1B32FFXF");
		capabilities.setCapability("browserName", "Android");
		capabilities.setCapability("platformVersion", "4.4.2");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "io.appium.android.apis");
		capabilities.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Test
	public void ScrollToView() {

		// Click on Views.
		driver.findElement(By.name("Views")).click();

		// Scroll till element which contains "Seek Bar" text If It Is not
		// visible on screen.
		//driver.scrollTo("Seek Bar");
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(" + "new UiSelector().text(\"Seek Bar\"));").click();

		// Locate SeekBar element.
		WebElement seekBar = driver.findElementById("io.appium.android.apis:id/seek");
		// Get start point of seekbar.
		int startX = seekBar.getLocation().getX();
		System.out.println(startX);
		// Get end point of seekbar.
		int endX = seekBar.getSize().getWidth();
		System.out.println(endX);
		// Get vertical location of seekbar.
		int yAxis = seekBar.getLocation().getY();

		// Set sllebar move to position.
		// endX * 0.6 means at 60% of seek bar width.
		int moveToXDirectionAt = (int) (endX * 0.6);
		System.out.println("Moving seek bar at " + moveToXDirectionAt + " In X direction.");

		// Moving seekbar using TouchAction class.
		TouchAction act = new TouchAction(driver);
		act.press(startX, yAxis).moveTo(moveToXDirectionAt, yAxis).release().perform();
	}

	@AfterTest
	public void End() throws IOException {
		driver.quit();

	}
}