package android.nativeApps.swipelistview;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SwipeHorizontalAndVertical {

	AndroidDriver<AndroidElement> driver;

	Dimension size;

	@BeforeTest
	public void setUp() throws Exception {

		//
		DesiredCapabilities capabilities = new DesiredCapabilities();

		//
		capabilities.setCapability("deviceName", "emulator-5554");

		//
		capabilities.setCapability("platformVersion", "7.1.1");

		//
		capabilities.setCapability("platformName", "Android");

		//
		capabilities.setCapability("appPackage", "com.fortysevendeg.android.swipelistview");

		//
		capabilities.setCapability("appActivity",
				"com.fortysevendeg.android.swipelistview.sample.activities.SwipeListViewExampleActivity");

		capabilities.setCapability("noReset", "true");

		//
		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		//
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		//
		// WebDriverWait wait = new WebDriverWait(driver, 300);

		//
		// wait.until(ExpectedConditions.elementToBeClickable(By.className("android.widget.RelativeLayout")));
	}

	@Test
	public void swipingHorizontal() throws InterruptedException {

		driver.findElementById("android:id/button1").click();

		Thread.sleep(5000);

		AndroidElement element = driver.findElementByXPath("//*[text()='Android Easter Egg']"); 
				
				
				//driver
				//.findElementById("com.fortysevendeg.android.swipelistview:id/example_row_tv_title");

		//
		System.out.println(element.getSize());

		//
		size = element.getSize();

		// Find swipe start and end point from screen's width and height.
		// Find startx point which is at right side of screen.
		int startx = (int) (size.width * 0.20);

		// Find endx point which is at left side of screen.
		int endx = (int) (size.width * 0.70);

		// Find vertical point where you wants to swipe. It is in middle of
		// screen height.
		int starty = size.height / 2;

		System.out.println("startx = " + startx + " ,endx = " + endx + " , starty = " + starty);

		TouchAction touchAction = new TouchAction(driver);

		touchAction.press(PointOption.point(endx, starty));

		Thread.sleep(5000);

		touchAction.moveTo(PointOption.point(startx, starty)).release().perform();
		
		Thread.sleep(5000);

	}

	@AfterTest
	public void End() {

		//
		driver.quit();
	}

}