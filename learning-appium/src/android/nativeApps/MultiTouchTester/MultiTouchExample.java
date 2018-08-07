package android.nativeApps.MultiTouchTester;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MultiTouchExample {

	AndroidDriver<AndroidElement> androidDriverObj;
	Dimension size;

	@BeforeTest
	public void setUp() throws Exception {

		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("deviceName", "emulator-5554");

		capabilities.setCapability("platformVersion", "7.1.1");

		capabilities.setCapability("platformName", "Android");

		capabilities.setCapability("noReset", "true");

		capabilities.setCapability("appPackage", "com.the511plus.MultiTouchTester");

		capabilities.setCapability("appActivity", "com.the511plus.MultiTouchTester.MultiTouchTester");

		androidDriverObj = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		androidDriverObj.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Test
	public void mTouchAction() throws InterruptedException {

		// Get Size of Window
		size = androidDriverObj.manage().window().getSize();

		// Get X Y Coordinates for touch action 1(Top left side).
		int x1 = (int) (size.width * 0.20);
		int y1 = (int) (size.height * 0.20);

		// Get X Y Coordinates for touch action 2(Top right side).
		int x2 = (int) (size.width * 0.80);
		int y2 = (int) (size.height * 0.20);

		// Get X Y Coordinates for touch action 3(Bottom left side).
		int x3 = (int) (size.width * 0.20);
		int y3 = (int) (size.height * 0.80);

		// Get X Y Coordinates for touch action 4(Bottom right side).
		int x4 = (int) (size.width * 0.80);
		int y4 = (int) (size.height * 0.80);

		// Get X Y Coordinates for touch action 5(middle of the screen).
		int x5 = size.width / 2;
		int y5 = size.height / 2;

		// Create object of MultiTouchAction class.
		MultiTouchAction maction = new MultiTouchAction(androidDriverObj);

		// Set touch action1 on given X Y Coordinates of screen.
		// TouchAction action1 = new TouchAction((MobileDriver) driver).longPress(x1,
		// y1);
		TouchAction action1 = new TouchAction(androidDriverObj).longPress(PointOption.point(x1, y1));

		// Set touch action2 on given X Y Coordinates of screen.
		// TouchAction action2 = new TouchAction((MobileDriver) driver).longPress(x2,
		// y2).waitAction(1500);
		TouchAction action2 = new TouchAction(androidDriverObj).longPress(PointOption.point(x2, y2));

		// Set touch action3 on given X Y Coordinates of screen.
		// TouchAction action3 = new TouchAction((MobileDriver) driver).longPress(x3,
		// y3).waitAction(1500);
		TouchAction action3 = new TouchAction(androidDriverObj).longPress(PointOption.point(x3, y3));

		// Set touch action4 on given X Y Coordinates of screen.
		// TouchAction action4 = new TouchAction((MobileDriver) driver).longPress(x4,
		// y4).waitAction(1500);
		TouchAction action4 = new TouchAction(androidDriverObj).longPress(PointOption.point(x4, y4));

		// Set touch action5 on given X Y Coordinates of screen.
		// TouchAction action5 = new TouchAction((MobileDriver) driver).longPress(x5,
		// y5).waitAction(1500);
		TouchAction action5 = new TouchAction(androidDriverObj).longPress(PointOption.point(x5, y5));

		// Generate multi touch action chain using different actions and perform
		// It.
		maction.add(action1).add(action2).add(action3).add(action4).add(action5).perform();

		Thread.sleep(5000);
	}

	@AfterTest
	public void End() {

		androidDriverObj.quit();
	}
}