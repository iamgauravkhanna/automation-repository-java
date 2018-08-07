package android.nativeApps.apiDemo;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Point;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.CommonUtils;

public class TapOnSwitch {

	AndroidDriver<AndroidElement> androidDriverObj;

	@BeforeTest
	public void setUp() throws Exception {

		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("platformVersion", "7.1.1");

		capabilities.setCapability("deviceName", "emulator-5554");

		capabilities.setCapability("platformName", "Android");

		capabilities.setCapability("appPackage", "io.appium.android.apis");

		capabilities.setCapability("appActivity", "io.appium.android.apis.ApiDemos");

		androidDriverObj = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		androidDriverObj.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Test
	public void tapSwitchOnOff() throws InterruptedException {

		// Click on Views.
		androidDriverObj.findElementById("Views").click();

		// Scroll till element which contains "Switches" text If It Is not
		// visible on screen.
		CommonUtils.scrollToElementAndClick(androidDriverObj, "Switches");

		// Get status of switch using it's text.
		String switchStatus1 = androidDriverObj.findElementById("io.appium.android.apis:id/monitored_switch").getText();

		System.out.println(switchStatus1);

		// If switchStatus1 = Monitored switch OFF, Execute inner code.
		if ((switchStatus1.trim()).equals("Monitored switch OFF")) {

			System.out.println("Setting Monitored switch to ON");

			// Locate switch button element by name = Monitored switch OFF.
			AndroidElement switch1 = androidDriverObj.findElementById("io.appium.android.apis:id/monitored_switch");

			Point pointObj = switch1.getLocation();
			
			Point pointObj2 = switch1.getCenter();

			TouchAction touchActionObj = new TouchAction(androidDriverObj);

			System.out.println("Value of X and Y => " + pointObj.getX() + " & " + pointObj.getY() + " & " + pointObj2.x + " & " + pointObj2.y);			
			
			// Tap on switch button "Monitored switch OFF" to make it ON.
			// swt.tap(1, 1);
			touchActionObj.tap(PointOption.point(pointObj2.x, pointObj2.y));
				
			//Point pointObj2 = switch1.getCenter();
			
			//touchActionObj.tap(PointOption.point(pointObj2, pointObj2));
			
			Thread.sleep(5000);

			//System.out.println("Monitored switch is ON now.");
			
			String switchStatus2 = androidDriverObj.findElementById("io.appium.android.apis:id/monitored_switch").getText();
			
			System.out.println("Value after step 1" + switchStatus2);
			
			switch1.click();
			
			String switchStatus3 = androidDriverObj.findElementById("io.appium.android.apis:id/monitored_switch").getText();
			
			Thread.sleep(5000);

			System.out.println("Value after step 2" + switchStatus3);
		}

		// Pause test for 5 seconds to put switch ON for 5 seconds.
		Thread.sleep(5000);

		// Get status of switch using it's text.
		String switchStatus2 = androidDriverObj.findElementById("io.appium.android.apis:id/monitored_switch").getText();

		System.out.println(switchStatus2);

		// If switchStatus1 = Monitored switch ON, Execute inner code.
		if ((switchStatus2.trim()).equals("Monitored switch ON")) {

			System.out.println("Setting Monitored switch to OFF");

			// Locate switch button element by name = Monitored switch ON.
			AndroidElement switch2 = androidDriverObj.findElementById("io.appium.android.apis:id/monitored_switch");

			// Tap on switch button "Monitored switch OFF" to make it OFF.
			// swt.tap(1, 1);

			System.out.println("Monitored switch is OFF now.");
		}
	}

	@AfterTest
	public void End() {
		androidDriverObj.quit();
	}
}