package nativeApps;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ScrollToTextExample {

	AndroidDriver driver;

	@BeforeTest
	public void setUp() throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Emulator");
		capabilities.setCapability("platformVersion", "5.0.2");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "io.appium.android.apis");
		capabilities.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Test
	public void ScrollToText() throws InterruptedException {
		// Scroll till element which contains "Views" text If It Is not visible
		// on screen.
		// driver.scrollTo("Views");
		// Click on Views/.
		driver.findElement(By.name("Views")).click();
		System.out.println("Scrolling has been started to find text -> Tabs.");
		// Scroll till element which contains Tabs text.
		// driver.scrollTo("Tabs");

		driver.findElement(By.name("Views")).click();

		while (driver.findElements(By.name("WebView")).size() == 0) {
			/*
			 * Dimension dimensions = driver.manage().window().getSize(); Double
			 * screenHeightStart = dimensions.getHeight() * 0.5; int scrollStart
			 * = screenHeightStart.intValue(); Double screenHeightEnd =
			 * dimensions.getHeight() * 0.2; int scrollEnd =
			 * screenHeightEnd.intValue(); // driver.swipe(0, scrollStart, 0,
			 * scrollEnd, 2000); new TouchAction(driver).press(0,
			 * scrollStart).waitAction(2000).moveTo(0,
			 * scrollEnd).release().perform();
			 */

			Dimension dimensions = driver.manage().window().getSize();
			int Startpoint = (int) (dimensions.getHeight() * 0.5);
			int scrollEnd = (int) (dimensions.getHeight() * 0.5);
			driver.swipe(200, Startpoint, 200, scrollEnd, 2000);
		}

		if (driver.findElements(By.name("WebView")).size() > 0) {
			driver.findElement(By.name("WebView")).click();
			System.out.println("Tabs text has been found and now clicking on It.");
		}

		// Click on Tabs.
		// driver.findElement(By.name("Tabs")).click();
	}

	@AfterTest
	public void End() {
		driver.quit();
	}

}
