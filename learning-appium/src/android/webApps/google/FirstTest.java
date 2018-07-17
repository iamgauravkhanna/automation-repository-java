package android.webApps.google;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class FirstTest {

	RemoteWebDriver remoteWebDriverObj;

	@BeforeTest
	public void setUp() throws MalformedURLException {

		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("deviceName", "emulator-5554");

		capabilities.setCapability("browserName", "Chrome");

		capabilities.setCapability("platformVersion", "7.1.1");

		capabilities.setCapability("platformName", "Android");

		capabilities.setCapability("noReset", "true");

		remoteWebDriverObj = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
	}

	@Test
	public void test001() {

		remoteWebDriverObj.get("https://www.google.com");
		
		System.out.println("Page Title : " + remoteWebDriverObj.getTitle());

	}

	@AfterTest
	public void End() throws IOException {

		remoteWebDriverObj.quit();
	}

}
