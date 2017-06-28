package raftaar.testautomation.utils;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class DriverUtil {

	WebDriver webDriverObj;
	AndroidDriver<?> androidDriverObj;
	IOSDriver<?> iOSDriverObj;
	DesiredCapabilities capability;
	WebDriverWait wait;

	public WebDriver initializeDriverObj() throws Exception {

		if ((LoadProperties.getProperties().get("IsRemote").equalsIgnoreCase("Yes"))) {

			if (System.getProperty("Browser").equalsIgnoreCase("Firefox")) {
				capability = DesiredCapabilities.firefox();
				capability.setBrowserName("firefox");
			}

			if (System.getProperty("Platform").equalsIgnoreCase("Windows")) {

				capability.setPlatform(Platform.WINDOWS);
			}

			webDriverObj = new RemoteWebDriver(new URL(System.getProperty("RemoteURL")), capability);
		}

		else {

			String browserName = System.getProperty("Browser");

			try {
				DesiredCapabilities dc = new DesiredCapabilities();
				dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);

				if (browserName.equalsIgnoreCase("firefox")) {
					webDriverObj = new FirefoxDriver();
				} else if (browserName.equalsIgnoreCase("chrome")) {
					String chromepath = System.getProperty("user.dir") + "\\lib\\drivers\\chromedriver.exe";
					System.setProperty("webdriver.chrome.driver", chromepath);
					webDriverObj = new ChromeDriver();
				} else if (browserName.equalsIgnoreCase("ie")) {
					// String iepath = System.getProperty("user.dir") +
					// "\\drivers\\IEDriverServer.exe";
					String iepath = System.getProperty("user.dir") + "\\lib\\drivers\\IEDriverServer.exe";
					System.setProperty("webdriver.ie.driver", iepath);
					// driver = new InternetExplorerDriver();
					DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
					caps.setCapability("ignoreZoomSetting", true);
					webDriverObj = new InternetExplorerDriver(caps);
				}
				wait = new WebDriverWait(webDriverObj, 30);
			} catch (WebDriverException e) {
				System.out.println(e.getMessage());
			}
		}

		return webDriverObj;

	}

	public AndroidDriver<?> initializeAndroidDriverObj() {
		// Created object of DesiredCapabilities class
		DesiredCapabilities capabilities = new DesiredCapabilities();

		// Set BROWSER_NAME desired capability
		capabilities.setCapability("BROWSER_NAME", "Android");

		// Set android VERSION desired capability
		capabilities.setCapability("VERSION", "5.0.1");

		// Set android deviceName desired capability
		capabilities.setCapability("deviceName", "emulator-5554");

		// Set platformName desired capability.
		capabilities.setCapability("platformName", "Android");

		// This package name of your app (you can get it from apk info app)
		// capabilities.setCapability("appPackage", "com.android.calculator2");

		// This is Launcher activity of your app (you can get it from apk info
		// app)
		// capabilities.setCapability("appActivity",
		// "com.android.calculator2.Calculator");

		capabilities.setCapability("applicationName", "API Demos");

		capabilities.setCapability("noReset", true);

		capabilities.setCapability("appPackage", "io.appium.android.apis");

		capabilities.setCapability("appActivity", "io.appium.android.apis.ApiDemos");

		// Create RemoteWebDriver instance and connect to the Appium server
		// It will launch the Calculator App in Android Device using the
		// configurations specified in Desired Capabilities
		try {
			androidDriverObj = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4444/wd/hub"), capabilities);
		} catch (MalformedURLException e) {

			e.printStackTrace();
		}
		return androidDriverObj;
	}

}
