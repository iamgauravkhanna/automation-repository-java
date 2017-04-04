package nativeApps;

import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SwipeHorizontalAndVertical {

	AndroidDriver driver;

	Dimension size;

	@BeforeTest
	public void setUp() throws Exception {

		// Set Drag-Sort Demos app folder path. This statement will refer
		// project's folder path.
		File classpathRoot = new File(System.getProperty("user.dir"));

		// Set folder name "Apps" where .apk file is stored.
		File appDir = new File(classpathRoot, "/apps");

		// Set Drag-Sort Demos .apk file name.
		File app = new File(appDir, "swipeListView.apk");

		//
		DesiredCapabilities capabilities = new DesiredCapabilities();

		//
		capabilities.setCapability("deviceName", "Emulator");

		//
		capabilities.setCapability("browserName", "Android");

		//
		capabilities.setCapability("platformVersion", "5.0.1");

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
		WebDriverWait wait = new WebDriverWait(driver, 300);

		//
		wait.until(ExpectedConditions.elementToBeClickable(By.className("android.widget.RelativeLayout")));
	}

	@Test
	public void swipingHorizontal() throws InterruptedException {

		// Get the size of screen.
		size = driver.manage().window().getSize();

		//
		System.out.println(size);

		// Find swipe start and end point from screen's with and height.
		// Find startx point which is at right side of screen.
		int startx = (int) (size.width * 0.70);

		// Find endx point which is at left side of screen.
		int endx = (int) (size.width * 0.30);

		// Find vertical point where you wants to swipe. It is in middle of
		// screen height.
		int starty = size.height / 2;

		System.out.println("startx = " + startx + " ,endx = " + endx + " , starty = " + starty);

		// Swipe from Right to Left.
		driver.swipe(startx, starty, endx, starty, 3000);

		Thread.sleep(2000);

		// Swipe from Left to Right.
		driver.swipe(endx, starty, startx, starty, 3000);

		Thread.sleep(2000);
	}

	@Test
	public void swipingVertical() throws InterruptedException {

		// Get the size of screen.
		size = driver.manage().window().getSize();

		//
		System.out.println(size);

		// Find swipe start and end point from screen's with and height.
		// Find starty point which is at bottom side of screen.
		int starty = (int) (size.height * 0.80);

		// Find endy point which is at top side of screen.
		int endy = (int) (size.height * 0.20);

		// Find horizontal point where you wants to swipe. It is in middle of
		// screen width.
		int startx = size.width / 2;

		//
		System.out.println("starty = " + starty + " ,endy = " + endy + " , startx = " + startx);

		// Swipe from Bottom to Top.
		driver.swipe(startx, starty, startx, endy, 3000);

		//
		Thread.sleep(2000);

		// Swipe from Top to Bottom.
		driver.swipe(startx, endy, startx, starty, 3000);

		//
		Thread.sleep(2000);
	}

	@AfterTest
	public void End() {

		//
		driver.quit();
	}

}