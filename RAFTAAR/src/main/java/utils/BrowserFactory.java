package utils;

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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;

public class BrowserFactory {

	AndroidDriver<AndroidElement> androidDriverObj;

	IOSDriver<?> iOSDriverObj;

	WebDriverWait webDriverWaitObj;

	String highLightPropertyName = "outline";

	String highlightColor = "#00ff00 solid 3px";

	String originalColor = "none";

	DesiredCapabilities desiredCapabilitiesObj;

	public Map<String, String> driverUtilHashMap = new HashMap<String, String>();

	private WebDriver webDriverObj;

	/**
	 * 
	 * Declaring DriverUtil Constructor
	 * 
	 * @param hashMapObj
	 */
	public BrowserFactory() {

		LogUtils.info("Calling Constructor : DriverUtil()");

		String operatingSystem = System.getProperty("os.name").toUpperCase();

		String systemArchitecture = System.getProperty("os.arch");

		LogUtils.info("Current Operating System: " + operatingSystem);

		LogUtils.info("Current Architecture: " + systemArchitecture);

		// driverUtilHashMap = hashMapObj;

		try {

			getProperties();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	/**
	 * 
	 * Initialize Browser & WebDriver
	 * 
	 * @throws MalformedURLException
	 * 
	 * 
	 */
	public WebDriver getBrowser() {

		LogUtils.info("Entering Method : intializeDriver()");

		if (DataDictionary.getInstance().getKey("Browser").equalsIgnoreCase("Chrome")) {

			String chromeDriverPath = "src/test/resources/drivers/chrome-driver/2.46/chromedriver.exe";

			LogUtils.info("Path of Chrome Driver : " + chromeDriverPath);

			System.setProperty("webdriver.chrome.driver", chromeDriverPath);

			desiredCapabilitiesObj = new DesiredCapabilities();

			desiredCapabilitiesObj = DesiredCapabilities.chrome();

			desiredCapabilitiesObj.setBrowserName("chrome");

		} else if (DataDictionary.getInstance().getKey("Browser").equalsIgnoreCase("Firefox")) {

			String firefoxDriverPath = "src/test/resources/drivers/gecko-driver/geckodriver-v0.24.0-win64/geckodriver.exe";

			LogUtils.info("Path of Firefox Driver : " + firefoxDriverPath);

			System.setProperty("webdriver.gecko.driver", firefoxDriverPath);

			desiredCapabilitiesObj = DesiredCapabilities.firefox();

			desiredCapabilitiesObj.setCapability("marionette", true);

		} else if (DataDictionary.getInstance().getKey("Browser").equalsIgnoreCase("IE"))

		{

			String internetExplorerDriverPath = System.getProperty("user.dir")
					+ "/resources/drivers/IEDriverServer.exe";

			LogUtils.info("Path of Internet Driver : " + internetExplorerDriverPath);

			System.setProperty("webdriver.ie.driver", internetExplorerDriverPath);

			desiredCapabilitiesObj = DesiredCapabilities.internetExplorer();

			desiredCapabilitiesObj
					.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);

		}

		if (DataDictionary.getInstance().getKey("Platform").equalsIgnoreCase("Windows")) {

			desiredCapabilitiesObj.setPlatform(Platform.WINDOWS);

		} else if (DataDictionary.getInstance().getKey("Platform").equalsIgnoreCase("Linux")) {

			desiredCapabilitiesObj.setPlatform(Platform.LINUX);

		}

		if ((DataDictionary.getInstance().getKey("IsRemote").equalsIgnoreCase("Yes"))) {

			LogUtils.info("Entering Block to run test on Remote Environment");

			try {

				webDriverObj = new RemoteWebDriver(new URL(driverUtilHashMap.get("RemoteURL")), desiredCapabilitiesObj);

			} catch (MalformedURLException e) {

				LogUtils.info("Oops Error Occured");

				e.printStackTrace();

			}

		} else {

			if (DataDictionary.getInstance().getKey("Browser").equalsIgnoreCase("IE")) {
				webDriverObj = new InternetExplorerDriver(desiredCapabilitiesObj);
			}

			if (DataDictionary.getInstance().getKey("Browser").equalsIgnoreCase("Firefox")) {
				webDriverObj = new FirefoxDriver(desiredCapabilitiesObj);
			}

			if (DataDictionary.getInstance().getKey("Browser").equalsIgnoreCase("Chrome")) {
				webDriverObj = new ChromeDriver(desiredCapabilitiesObj);
			}

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

		System.out.println("Environment File Path => " + System.getProperty("EnvironmentFilePath"));

		//
		FileInputStream resourceStream = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\"
				+ System.getProperty("EnvironmentFilePath"));

		//
		FileInputStream resourceStream2 = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\resources\\common.properties");

		try {

			//
			properties.load(resourceStream);

			for (String name : properties.stringPropertyNames()) {

				driverUtilHashMap.put(name, properties.getProperty(name));

				System.out.println("Env Var : " + properties.getProperty(name));
			}

			//
			LogUtils.info("Environment Level Properties Loaded Successfully");

			//
			properties.load(resourceStream2);

			for (String name : properties.stringPropertyNames()) {

				driverUtilHashMap.put(name, properties.getProperty(name));

				System.out.println(name + " : " + properties.getProperty(name));
			}

			//
			LogUtils.info("Common Properties Loaded Successfully");

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
			System.out.println(key + " => " + value);

			//
			driverUtilHashMap.put(key, value);

			DataDictionary.getInstance().putKey(key, value);

		}

	}

	public AndroidDriver<AndroidElement> initializeAndroidDriverObj() {

		// Created object of DesiredCapabilities class
		DesiredCapabilities capabilities = new DesiredCapabilities();

		// Set android VERSION desired capability
		capabilities.setCapability("platformVersion", "7.1.1");

		// Set android deviceName desired capability
		capabilities.setCapability("deviceName", "emulator-5554");

		// Set platformName desired capability.
		capabilities.setCapability("platformName", "Android");

		// This package name of your app (you can get it from apk info app)
		capabilities.setCapability("appPackage", "com.android.calculator2");

		// This is Launcher activity of your app (you can get it from apk info
		// app)
		capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

		// Create RemoteWebDriver instance and connect to the Appium server
		// It will launch the Calculator App in Android Device using the
		// configurations specified in Desired Capabilities
		try {

			androidDriverObj = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

			System.out.println("Android Driver Intialized Successfully");

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