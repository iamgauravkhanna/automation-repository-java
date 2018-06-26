package android.nativeApps;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TouchActionExample {
	AndroidDriver driver;
	Dimension size;
	WebDriverWait wait;

	@BeforeTest
	public void setUp() throws Exception {

		//
		DesiredCapabilities capabilities = new DesiredCapabilities();

		//
		capabilities.setCapability("deviceName", "Emulator");

		//
		capabilities.setCapability("platformVersion", "5.0.2");

		//
		capabilities.setCapability("platformName", "Android");

		//
		capabilities.setCapability("appPackage", "com.fortysevendeg.android.swipelistview");

		//
		capabilities.setCapability("appActivity",
				"com.fortysevendeg.android.swipelistview.sample.activities.SwipeListViewExampleActivity");

		//
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		//
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		//
		wait = new WebDriverWait(driver, 300);

		//
		wait.until(ExpectedConditions.elementToBeClickable(By.className("android.widget.RelativeLayout")));
	}

	@Test
	public void swipingHorizontal() throws InterruptedException {

		// Get the size of screen.
		size = driver.manage().window().getSize();

		//
		System.out.println(size);

		// Find swipe x points from screen's with and height.
		// Find x1 point which is at right side of screen.
		int x1 = (int) (size.width * 0.20);

		// Find x2 point which is at left side of screen.
		int x2 = (int) (size.width * 0.80);

		// Create object of TouchAction class.
		TouchAction action = new TouchAction((MobileDriver) driver);

		// Find element to swipe from right to left.
		WebElement ele1 = (WebElement) driver.findElementsById("com.fortysevendeg.android.swipelistview:id/front")
				.get(3);

		System.out.println(ele1.getText());

		// Create swipe action chain and perform horizontal(right to left)
		// swipe.
		// Here swipe to point x1 Is at left side of screen. So It will swipe
		// element from right to left.
		action.longPress(ele1).moveTo(x1, 580).release().perform();

		// Find element to swipe from left to right.
		WebElement ele2 = (WebElement) driver.findElementsById("com.fortysevendeg.android.swipelistview:id/back")
				.get(3);

		// Create swipe action chain and perform horizontal(left to right)
		// swipe.
		// Here swipe to point x2 Is at right side of screen. So It will swipe
		// element from left to right.
		action.longPress(ele2).moveTo(x2, 580).release().perform();
	}

	@AfterTest
	public void End() {
		driver.quit();
	}

}
