package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * This is base class for web tests containing all the methods possible on UI.
 * 
 * @author Gaurav.Khanna
 *
 */

public class BasePage {

	// Declaring variable 'webDriverObj' of WebDriver Type
	public WebDriver webDriverObj;

	//
	public static HashMap<String, String> propertiesMap;

	//
	String highLightPropertyName = "outline";

	//
	String highlightColor = "#00ff00 solid 3px";

	//
	String originalColor = "none";

	//
	public static HashMap<String, String> testCaseMap;

	// File, Sheet, S.No., Key, Value
	public HashMap<String, HashMap<String, HashMap<String, HashMap<String, String>>>> testDataMap;

	//
	public int defaultTimeOut = 60;

	/**
	 * Constructor of this class
	 */
	public BasePage() {

		try {

			LogUtils.info("Calling BasePage Constructor");

			// testCaseMap = getProperties();

			createTestDataMap();

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	private void createTestDataMap() {

		File folder = new File(System.getProperty("user.dir") + "/assets");

		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {

			if (listOfFiles[i].isFile()) {

				LogUtils.info("File " + listOfFiles[i].getName());

			} else if (listOfFiles[i].isDirectory()) {

				LogUtils.info("Directory " + listOfFiles[i].getName());

			}

		}

	}

	/**
	 * Method to click element using click() command
	 * 
	 * @param by
	 */
	public void click(By by) {

		//
		LogUtils.info("Using click()");

		//
		findElement(by).click();

	}

	public void clickLiElement(By by, String text) {

		LogUtils.info("Starting Quick Fix.....");

		List<WebElement> options = webDriverObj.findElements(by);

		// Loop through the options and select the one that matches

		for (WebElement opt : options) {

			if (opt.getText().contains(text)) {

				LogUtils.info("Quick Fix Found");

				opt.click();

			}
		}

	}

	public void isClickable(By by) {

		WebDriverWait wait = new WebDriverWait(webDriverObj, 30);

		boolean what = wait.until(ExpectedConditions.elementToBeClickable(findElement(by))) != null;

		if (what)
			LogUtils.info("Element is clickable");
		else
			LogUtils.info("Element not clickable");
	}

	/**
	 * Method to click element using JavaScript
	 * 
	 * @param element
	 */
	public void clickUsingJavaScript(By by) {

		//
		LogUtils.info("Using clickUsingJavaScript()");

		WebElement e = findElement(by);

		JavascriptExecutor jse = (JavascriptExecutor) webDriverObj;

		// jse.executeScript("arguments[0].scrollIntoView()", e);

		jse.executeScript("arguments[0].click()", e);

	}

	public void doubleClick(By by) {

	}

	/**
	 * Method to get tag name of web element
	 * 
	 * @param locator
	 */
	public void getTagName(By locator) {

		//
		LogUtils.info("Using getTagName()");

		//
		LogUtils.info("Tag Value is : " + findElement(locator).getTagName());

	}

	/**
	 * Method to open link in browser
	 * 
	 * @param link
	 */
	public void openBrowser(String link) {

		//
		LogUtils.info("Using getUrl()");

		//
		webDriverObj.get(link);
	}

	/**
	 * Initialize Browser & WebDriver
	 */
	public void intializeDriver() {

		if ((propertiesMap.get("IsRemote").equalsIgnoreCase("Yes"))) {

			//
			String browserName = propertiesMap.get("Browser");

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

		int attempts = 0;

		while (attempts < 2) {

			try {

				element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

				break;

			} catch (StaleElementReferenceException e) {

			}

			attempts++;
		}

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
	 * Method to find web element
	 * 
	 * @param locator
	 * 
	 * @return List of Web Elements
	 * 
	 */
	public List<WebElement> findElements(By locator) {

		List<WebElement> elements = null;

		elements = webDriverObj.findElements(locator);

		// Return web element
		return elements;

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

	public void type(String str, By locator) {

		LogUtils.info("Using type() method");

		char[] charArray = str.toCharArray();

		for (Character c : charArray) {

			findElement(locator).sendKeys(c.toString());

		}

	}

	/**
	 * Sends a special keystroke to element
	 * 
	 * @return
	 */
	public Keys pressKey(By locator, String key) throws Exception {

		Keys KEY = null;

		try {
			KEY = Keys.valueOf(key.toUpperCase());

			findElement(locator).sendKeys(KEY);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return KEY;
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
	public static HashMap<String, String> getProperties() throws Exception {

		//
		Properties properties = new Properties();

		propertiesMap = new HashMap<String, String>();

		//
		FileInputStream resourceStream = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\resources\\common.properties");

		try {

			//
			properties.load(resourceStream);

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
			LogUtils.info(key + " => " + value);

			//
			propertiesMap.put(key, value);

		}

		return propertiesMap;

	}

	public void waitFor(By locator, int time) {

		WebDriverWait wait = new WebDriverWait(webDriverObj, time);

		if (wait.until(ExpectedConditions.visibilityOfElementLocated(locator)) != null) {

			LogUtils.info("Element Visible on UI");

		}

	}

	public void waitFor(By locator) {

		waitFor(locator, defaultTimeOut);

	}

	/**
	 * 
	 * @param element
	 * @throws InterruptedException
	 */
	public void highlightElement(WebElement element) throws InterruptedException {

		// Creating JavaScriptExecuter Interface
		JavascriptExecutor js = (JavascriptExecutor) webDriverObj;

		for (int iCnt = 0; iCnt < 3; iCnt++) {

			js.executeScript("arguments[0].style." + highLightPropertyName + " = '" + highlightColor + "'", element);
			Thread.sleep(50);

			js.executeScript("arguments[0].style." + highLightPropertyName + " = '" + originalColor + "'", element);
			Thread.sleep(50);

			js.executeScript("arguments[0].style." + highLightPropertyName + " = '" + highlightColor + "'", element);
			Thread.sleep(50);

			js.executeScript("arguments[0].style." + highLightPropertyName + " = '" + originalColor + "'", element);

		}
	}

	/**
	 * 
	 * @param loc
	 * @param text
	 */
	public void selectByValue(By loc, String text) {

		Select selectObj = new Select(findElement(loc));

		selectObj.selectByVisibleText(text);

	}

	/**
	 * Prints all options available in drop down
	 * 
	 * @param locator
	 */
	public void getAllOptions(By locator) {

		Select selectObj = new Select(findElement(locator));

		List<WebElement> l = selectObj.getOptions();

		int i = 0;

		for (WebElement we : l) {

			System.out.println("Option #" + i + " " + we.getText());

			i++;

		}

	}

	/**
	 * Set variable in testCase Map
	 * 
	 * @param key
	 * @param value
	 */
	public void setVariable(String key, String value) {

		testCaseMap.put(key, value);

	}

	/**
	 * Run select query on DB
	 * 
	 * @return void
	 */
	public void runSelectQuery(String query) {

	}

	/**
	 * Look for requested window across all opened browsers
	 */
	public void switchBrowser(String webPageName) {
	}

	/**
	 *  
	 */
	public void getPageUrl(String url) {

		webDriverObj.get(url);
	}

	/**
	 * 
	 */
	public void runJavaScript() {

	}

	/**
	 * 
	 */
	public void pause() {

		try {
			Thread.sleep(10000);
			LogUtils.info("Pausing for 10 Secs");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void assertPresent(By loc) {

		if (findElement(loc).isDisplayed()) {

			System.out.println("Element is Visible");

		} else {

			throw new ElementNotVisibleException("Element not visible");
		}

		/*
		 * if(driver.findElements(By.xpath("value")).size() != 0){
		 * System.out.println("Element is Present"); }else{
		 * System.out.println("Element is Absent"); }
		 * 
		 * Or
		 * 
		 * if(driver.findElement(By.xpath("value"))!= null){
		 * System.out.println("Element is Present"); }else{
		 * System.out.println("Element is Absent"); }
		 */

	}

	public void maximizeBrowser() {

		//
		webDriverObj.manage().window().maximize();

	}

	public String getPageTitle() {

		return webDriverObj.getTitle();

	}

	public void quitBrowser() {

		webDriverObj.quit();

	}

	public void closeBrowser() {

		webDriverObj.close();

	}

	public void waitForPageLoaded() {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
						.equals("complete");
			}
		};
		try {
			Thread.sleep(1000);
			WebDriverWait wait = new WebDriverWait(webDriverObj, 90);
			wait.until(expectation);
			LogUtils.info("In Try Block of waitForPageLoaded() Method");
		} catch (Throwable error) {
			Assert.fail("Timeout waiting for Page Load Request to complete.");
		}
	}

}