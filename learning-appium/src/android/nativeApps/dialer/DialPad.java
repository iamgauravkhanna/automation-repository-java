package android.nativeApps.dialer;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Point;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DialPad {

	AndroidDriver<AndroidElement> androidDriver;

	@BeforeTest
	public void setUp() throws Exception {

		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("deviceName", "emulator-5554");

		capabilities.setCapability("platformVersion", "7.1.1");

		capabilities.setCapability("platformName", "Android");

		capabilities.setCapability("noReset", "true");

		capabilities.setCapability("appPackage", "com.android.dialer");

		capabilities.setCapability("appActivity", "com.android.dialer.DialtactsActivity");

		androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		androidDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Test
	public void dial() {

		// Click on dial pad button to open dialer pad.
		// driver.findElementById("com.android.dialer:id/dialpad_button").click();
		androidDriver.findElementById("com.android.dialer:id/floating_action_button").click();

		// Create object of TouchAction class.
		TouchAction touchActionObj = new TouchAction(androidDriver);

		// Get Location of 0 dial pad Element
		Point pointObj = androidDriver.findElementById("0").getLocation();

		// Perform long press action on button 0 of dialer pad.
		touchActionObj.longPress(PointOption.point(pointObj.getX(), pointObj.getY()));

		// Get the result from dial text box.
		String result = androidDriver.findElementById("com.android.dialer:id/digits").getText();

		// Compare actual and expected result using testng assertion.
		Assert.assertEquals(result, "+", "Actual value is : " + result + " did not match with expected value: +");
	}

	@AfterClass
	public void tearDown() {
		androidDriver.quit();
	}
}