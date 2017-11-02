package org.gtg.raftaar.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class DriverUtil {

	WebDriver webDriverObj;
	AndroidDriver<?> androidDriverObj;
	IOSDriver<?> iOSDriverObj;
	DesiredCapabilities capability;
	WebDriverWait wait;

	//
	String highLightPropertyName = "outline";

	//
	String highlightColor = "#00ff00 solid 3px";

	//
	String originalColor = "none";


	//
	public static Map<String, String> configPropertiesMap = new HashMap<String, String>();
	
	public DriverUtil(){
		
		try {
			getProperties();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public WebDriver oldinitializeWebDriver() {

		if ((BasePage.propertiesMap.get("IsRemote").equalsIgnoreCase("Yes"))) {

			if (System.getProperty("Browser").equalsIgnoreCase("Firefox")) {
				capability = DesiredCapabilities.firefox();
				capability.setBrowserName("firefox");
			}

			if (System.getProperty("Platform").equalsIgnoreCase("Windows")) {

				capability.setPlatform(Platform.WINDOWS);
			}

			try {
				webDriverObj = new RemoteWebDriver(new URL(System.getProperty("RemoteURL")), capability);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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

	/**
	 * Initialize Browser & WebDriver
	 */
	public WebDriver intializeDriver() {

		if ((configPropertiesMap.get("IsRemote").equalsIgnoreCase("Yes"))) {

			//
			String browserName = configPropertiesMap.get("Browser");

			//			
			LogUtils.info("Running Tests on Remote Browsers");

			//
			LogUtils.info("Browser Name => " + browserName);

			//
			if (browserName.equalsIgnoreCase("chrome")) {//

				//
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "/resources/drivers/chromedriver.exe");

				//
				webDriverObj = new ChromeDriver();

			} else if (browserName.equalsIgnoreCase("firefox")) {

				//
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "/resources/drivers/geckodriver.exe");

				//
				DesiredCapabilities capabilities = DesiredCapabilities.firefox();

				//
				capabilities.setCapability("marionette", true);

				//
				webDriverObj = new FirefoxDriver(capabilities);

			} else if (browserName.equalsIgnoreCase("IE")) {

				//
				System.setProperty("webdriver.ie.driver",
						System.getProperty("user.dir") + "/resources/drivers/IEDriverServer.exe");

				//
				DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();

				//
				capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
						true);

				//
				webDriverObj = new InternetExplorerDriver(capabilities);

				//
				webDriverObj.manage().window().maximize();

			}

		} else {

			//
			DesiredCapabilities dc = new DesiredCapabilities();

			//
			dc = DesiredCapabilities.chrome();

			//
			dc.setBrowserName("chrome");

			//
			dc.setPlatform(Platform.WINDOWS);

			//
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "/resources/drivers/chromedriver.exe");

			webDriverObj = new ChromeDriver(dc);

			// Maximize browser window
			webDriverObj.manage().window().maximize();

		}
		return webDriverObj;
	}

	/**
	 * Method to find web element
	 * 
	 * @param locator
	 * @return
	 */
	public WebElement findElement(By locator) {

		WebDriverWait wait = new WebDriverWait(webDriverObj, 30);

		WebElement element = null;

		element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		if (element != null) {

			//
			LogUtils.info("Element Found");

		} else {

			//
			LogUtils.info("Element not found");

		}

		try {

			//
			highlightElement(element);

		} catch (InterruptedException e) {

			//
			e.printStackTrace();

		}

		// Return web element
		return element;

	}

	/**
	 * Method to enter text in web element
	 * 
	 * @param locator
	 * @param value
	 */
	public void setText(By locator, String value) {

		//
		findElement(locator).sendKeys(value);

	}

	/**
	 * Loads all the properties from property file and store them in Map
	 * 
	 * @return
	 * 
	 * @return map that contains the properties as key/value pairs
	 * 
	 * @throws Exception
	 */
	public void getProperties() throws Exception {

		//
		Properties properties = new Properties();

		//
		FileInputStream resourceStream = new FileInputStream(
				System.getProperty("user.dir") + "/resources/config/config.properties");

		try {

			//
			properties.load(resourceStream);

		} catch (IOException e) {

			//
			e.printStackTrace();

		} finally {

			//
			resourceStream.close();

		}

		//
		LogUtils.info("Reading Contents of Property File");

		//
		for (String key : properties.stringPropertyNames()) {

			//
			String value = properties.getProperty(key);

			//
			//System.out.println(key + " => " + value);

			//
			configPropertiesMap.put(key, value);

		}

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
	
	/**
	 * Highlight Web Element in Browser
	 * 
	 * @param element
	 * @throws InterruptedException
	 */
	public void highlightElement(WebElement element) throws InterruptedException {

		// Creating JavaScriptExecuter Interface
		JavascriptExecutor js = (JavascriptExecutor) webDriverObj;

		//
		for (int iCnt = 0; iCnt < 3; iCnt++) {

			//
			js.executeScript("arguments[0].style." + highLightPropertyName + " = '" + highlightColor + "'", element);

			//
			Thread.sleep(50);

			//
			js.executeScript("arguments[0].style." + highLightPropertyName + " = '" + originalColor + "'", element);

			//
			Thread.sleep(50);

			//
			js.executeScript("arguments[0].style." + highLightPropertyName + " = '" + highlightColor + "'", element);

			//
			Thread.sleep(50);

			//
			js.executeScript("arguments[0].style." + highLightPropertyName + " = '" + originalColor + "'", element);

		}

	}
}