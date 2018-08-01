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

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class DriverUtil {

	//
	WebDriver webDriverObj;

	//
	AndroidDriver<MobileElement> androidDriverObj;

	//
	IOSDriver<?> iOSDriverObj;

	//
	DesiredCapabilities capabilities;

	//
	WebDriverWait wait;

	//
	String highLightPropertyName = "outline";

	//
	String highlightColor = "#00ff00 solid 3px";

	//
	String originalColor = "none";

	//
	public static Map<String, String> configPropertiesMap = new HashMap<String, String>();

	public DriverUtil() {

		LogUtils.info("Calling Constructor : DriverUtil()");

		try {

			// Get Properties File
			getProperties();

		} catch (Exception e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * Initialize Browser & WebDriver
	 * 
	 * @throws MalformedURLException
	 * 
	 */
	public WebDriver intializeDriver() {

		LogUtils.info("Entering Method : intializeDriver()");

		if ((configPropertiesMap.get("IsRemote").equalsIgnoreCase("Yes"))) {

			if (configPropertiesMap.get("Browser").equalsIgnoreCase("Firefox")) {

				LogUtils.info("Using Browser Firefox");

				//
				// System.setProperty("webdriver.gecko.driver",
				// System.getProperty("user.dir") + "/resources/drivers/geckodriver.exe");

				System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");

				//
				capabilities = DesiredCapabilities.firefox();

				//
				capabilities.setBrowserName("firefox");

				//
				capabilities.setCapability("marionette", true);
			}

			if (configPropertiesMap.get("Browser").equalsIgnoreCase("Chrome")) {

				//
				DesiredCapabilities dc = new DesiredCapabilities();

				//
				dc = DesiredCapabilities.chrome();

				//
				dc.setBrowserName("chrome");

				//
				dc.setPlatform(Platform.WINDOWS);

				String chromeDriverPath = "src/test/resources/drivers/chromedriver.exe";

				LogUtils.info("Path of Chrome Driver : " + chromeDriverPath);

				//
				System.setProperty("webdriver.chrome.driver", chromeDriverPath);

				webDriverObj = new ChromeDriver(dc);

				// Maximize browser window
				webDriverObj.manage().window().maximize();
			}

			if (configPropertiesMap.get("Platform").equalsIgnoreCase("Windows")) {

				capabilities.setPlatform(Platform.WINDOWS);
			}

			LogUtils.info("Entering Block to run test on Remote Environment");

			try {

				webDriverObj = new RemoteWebDriver(new URL(configPropertiesMap.get("RemoteURL")), capabilities);

			} catch (MalformedURLException e) {

				LogUtils.info("Oops Error Occured");

				e.printStackTrace();

			}

		} else {

			if (configPropertiesMap.get("Browser").equalsIgnoreCase("Chrome")) {
				//
				DesiredCapabilities dc = new DesiredCapabilities();

				//
				dc = DesiredCapabilities.chrome();

				//
				dc.setBrowserName("chrome");

				//
				dc.setPlatform(Platform.WINDOWS);

				String chromeDriverPath = "src/test/resources/drivers/chromedriver.exe";

				LogUtils.info("Path of Chrome Driver : " + chromeDriverPath);

				//
				System.setProperty("webdriver.chrome.driver", chromeDriverPath);

				webDriverObj = new ChromeDriver(dc);

				// Maximize browser window
				webDriverObj.manage().window().maximize();
			}

			if (configPropertiesMap.get("Browser").equalsIgnoreCase("Firefox")) {

				System.setProperty("webdriver.gecko.driver",
						"src/test/resources/drivers/geckodriver.exe");

				DesiredCapabilities capabilities = DesiredCapabilities.firefox();

				capabilities.setCapability("marionette", true);

				webDriverObj = new FirefoxDriver(capabilities);
			}

			if (configPropertiesMap.get("Browser").equalsIgnoreCase("IE")) {

				System.setProperty("webdriver.ie.driver",
						System.getProperty("user.dir") + "/resources/drivers/IEDriverServer.exe");

				DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();

				capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
						true);

				webDriverObj = new InternetExplorerDriver(capabilities);

				webDriverObj.manage().window().maximize();

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

		//
		FileInputStream resourceStream = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\"
				+ System.getProperty("EnvironmentFilePath"));

		//
		FileInputStream resourceStream2 = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\resources\\common.properties");

		try {

			//
			properties.load(resourceStream);

			//
			LogUtils.info("Environment Level Properties Loaded Successfully");

			//
			properties.load(resourceStream2);

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
			// System.out.println(key + " => " + value);

			//
			configPropertiesMap.put(key, value);

		}

		LogUtils.info(configPropertiesMap.get("Platform"));
		LogUtils.info(configPropertiesMap.get("Browser"));
		LogUtils.info(configPropertiesMap.get("IsRemote"));
		LogUtils.info(configPropertiesMap.get("RemoteURL"));

	}

	public AndroidDriver<MobileElement> initializeAndroidDriverObj(String appPackageObj, String appActivityObj) {
		// Created object of DesiredCapabilities class
		DesiredCapabilities capabilities = new DesiredCapabilities();

		/*
		 * // Set BROWSER_NAME desired capability
		 * capabilities.setCapability("BROWSER_NAME", "Android");
		 * 
		 * // Set android VERSION desired capability
		 * capabilities.setCapability("VERSION", "5.0.1");
		 * 
		 * // Set android deviceName desired capability
		 * capabilities.setCapability("deviceName", "emulator-5554");
		 * 
		 * // Set platformName desired capability.
		 * capabilities.setCapability("platformName", "Android");
		 * 
		 * // This package name of your app (you can get it from apk info app) //
		 * capabilities.setCapability("appPackage", "com.android.calculator2");
		 * 
		 * // This is Launcher activity of your app (you can get it from apk info //
		 * app) // capabilities.setCapability("appActivity", //
		 * "com.android.calculator2.Calculator");
		 * 
		 * capabilities.setCapability("applicationName", "API Demos");
		 * 
		 * capabilities.setCapability("noReset", true);
		 * 
		 * capabilities.setCapability("appPackage", "io.appium.android.apis");
		 * 
		 * capabilities.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
		 */

		// Set android VERSION desired capability
		capabilities.setCapability("platformVersion", "7.1.1");

		// Set android deviceName desired capability
		capabilities.setCapability("deviceName", "Real Device");

		// Set platformName desired capability.
		capabilities.setCapability("platformName", "Android");

		// This package name of your app (you can get it from apk info app)
		capabilities.setCapability("appPackage", appPackageObj);

		// This is Launcher activity of your app (you can get it from apk info
		// app)
		capabilities.setCapability("appActivity", appActivityObj);

		// Create RemoteWebDriver instance and connect to the Appium server
		// It will launch the Calculator App in Android Device using the
		// configurations specified in Desired Capabilities
		try {

			androidDriverObj = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

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