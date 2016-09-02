package raftaar.testautomation.utlities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

/**
 * 
 * This class represents handling all possible methods on web page in a browser
 * 
 * @author Gaurav Khanna 
 * 
 */

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.apache.commons.io.FileUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.Logger;
import org.apache.velocity.runtime.directive.Parse;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
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
import org.openqa.selenium.remote.Response;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import raftaar.testautomation.utlities.JavaUtils;
import raftaar.testautomation.manager.TestManager;
import raftaar.testautomation.testcases.UITests;

public class WebPage {

	public WebDriver driver;
	public String StepOutcome;
	public WebElement element;
	public WebElement e;
	public String value;
	public String locatorType;
	public static String highLightPropertyName = "outline";
	public static String highlightColor = "#00ff00 solid 3px";
	public static String originalColor = "none";
	public static int screenShotCounter = 1;
	public By loc;
	public boolean elementNotFound;
	public int elementWaitTime = 10; // timeout value in second while waiting
										// for an element to appear DISPLAYED
	public WebDriverWait wait;
	public String alertText;
	public static Alert alert;
	public static String StepName ;

	public static Logger log = Logger.getLogger(WebPage.class);

	public String ExecuteKeyword(String action, String parent, String object, String data, String description,String testcaseid) throws Exception {

		StepOutcome = "NULL";
		StepName = testcaseid;

		value = null;

		// UITests.log.info("Object : " + object);
		// UITests.log.info("Data : " + data);

		if (object.contains("=") && !(object.isEmpty())) {
			locatorType = object.split("=")[0].toLowerCase().trim();

			if (locatorType.contains("xpath")) {
				value = object.substring(6);

			} else {
				value = object.split("=")[1].trim();

			}

			loc = locatorValue(locatorType, value);
		}

		if (loc == null) {
			// System.out.println("Oops Locator Is Null");
		} else if (!(action.equalsIgnoreCase("assertNotPresent"))) {
			e = what(driver, loc);
			// System.out.println("Got the Element : " + e);
		} else {
			try {
				element = driver.findElement(loc);
			} catch (Exception e) {
				elementNotFound = true;
			}
		}

		// System.out.println("Action is : " + action);

		switch (action) {

		case "openBrowser":

			openBrowser(TestManager.MyDataDicitonary.get("browser"));
			driver.get(data);
			driver.manage().window().maximize();
			StepOutcome = "Opening Browser";
			//UITests.extentReportTestObject.log(LogStatus.PASS, description);
			break;

		case "assert=":

			JavaUtils.assertEqual(Float.parseFloat(JavaUtils.getNumbersFromString(object)),
					Float.parseFloat(JavaUtils.getNumbersFromString(data)));

			StepOutcome = "Assertion Successfull";
			//UITests.extentReportTestObject.log(LogStatus.PASS, description);
			break;

		case "uploadFile":

			e.sendKeys(data);

			break;

		case "getUrl":

			// System.out.println("getUrl");
			// System.out.println("Data is " + data);
			driver.get(data);
			StepOutcome = data;
			break;

		case "maximizeWindow":
			// System.out.println("Maximize Window");
			driver.manage().window().maximize();
			StepOutcome = "Maximize Window";
			break;

		case "click":
			long startTime1 = System.currentTimeMillis();
			// WebElement e = driver.findElement(locator);
			// System.out.println("Value of e :" + e);
			e.click();
			// System.out.println("Element Clicked");
			// long startTime = System.currentTimeMillis();
			// System.out.println(" Load Time :" + (int)
			// (System.currentTimeMillis() - startTime));
			// long clickTime = System.currentTimeMillis() - startTime ;
			// long elapsed = ((System.currentTimeMillis() - startTime1) /
			// 1000);

			// String display = String.format("%02d:%02d:%02d", elapsed / 3600,
			// (elapsed % 3600) / 60, (elapsed % 60));

			// StepOutcome = display;
			break;

		case "selectByVisibleText":
			// System.out.println("Select By Visible Text");
			Select dropdown = new Select(driver.findElement(loc));
			dropdown.selectByVisibleText(data);
			break;

		case "selectByIndex": {
			// System.out.println("Select By Index");
			Select dropdown1 = new Select(driver.findElement(loc));
			// System.out.println("Data before conversion is " + data);
			Double db = Double.parseDouble(data);
			int uk = db.intValue();
			dropdown1.selectByIndex(uk);
		}
			break;

		case "selectByValue":
			// System.out.println("Select By Value");
			Select dropdown2 = new Select(driver.findElement(loc));
			dropdown2.selectByValue(data);
			break;

		case "getText":
			String var = driver.findElement(loc).getText();
			TestManager.MyDataDicitonary.put(data, var);
			break;

		case "assertText":
			// String var1 = TestManager.MyDataDicitonary.get(value);
			// Assert.assertEquals(var1, data);
			JavaUtils.assertEqual(object, data, "dummy");
			break;

		case "getAttribute":
			String var3 = e.getAttribute(data);
			TestManager.MyDataDicitonary.put(parent, var3);
			break;

		case "closeBrowser":
			driver.quit();
			// driver.close();
			break;

		case "clear":
			// System.out.println("Clear");
			e.clear();
			break;

		case "setText":
			// System.out.println("setText");
			e.sendKeys(data);
			break;

		case "pause":
			// System.out.println("Pause");
			int num = (int) Double.parseDouble(data);
			// int num = Integer.parseInt(data);
			driver.manage().timeouts().implicitlyWait(num, TimeUnit.SECONDS);
			break;

		case "getPageUrl":
			// System.out.println("Get Current Page URL");
			String url = driver.getCurrentUrl();
			TestManager.MyDataDicitonary.put(data, url);
			break;

		case "getPageTitle":
			// System.out.println("Get Current Page Title");
			driver.getTitle();
			break;

		case "refresh":
			// System.out.println("Get Current Page Title");
			driver.navigate().refresh();
			break;

		case "goTo":
			// System.out.println("Get Current Page Title");
			driver.navigate().to(data);
			break;

		case "goBack":
			// System.out.println("Get Current Page Title");
			driver.navigate().back();
			break;

		case "goForward":
			// System.out.println("Get Current Page Title");
			driver.navigate().forward();
			break;

		case "getPageSource":
			// System.out.println("Get Current Page Source");
			driver.getPageSource();
			break;

		case "assertPresent":
			// System.out.println("Get Current Page Source");
			e.isDisplayed();
			break;

		case "assertContains":
			// System.out.println("Get Current Page Source");
			String text = e.getText().trim();
			// System.out.println(text);
			JavaUtils.assertContains(text, data);
			break;

		case "assertContainsNot":
			// System.out.println("Get Current Page Source");
			e.getText().trim();
			JavaUtils.assertContainsNot(object, data);
			break;

		case "assertNotPresent":
			try {
				if (!(elementNotFound))
					throw new Exception("Element  is visible on page.");
			} catch (Exception e) {
				log.info(e + "\n");
				throw e;
			}
			break;

		case "assertEqual":
			// System.out.println("Get Current Page Source");
			JavaUtils.assertEqual(object, data, parent);
			break;

		case "assertLinkStatus":
			// System.out.println("Get Current Page Source");
			String href;
			href = driver.getCurrentUrl();
			HttpClient client = HttpClientBuilder.create().build();
			HttpGet request = new HttpGet(href);
			try {
				HttpResponse response = client.execute(request);
				int invalidLinksCount = 0;
				// verifying response code and The HttpStatus should be 200 if
				// not,
				// increment invalid link count
				//// We can also check for 404 status code like
				// response.getStatusLine().getStatusCode() == 404
				if (response.getStatusLine().getStatusCode() != 200)
					invalidLinksCount++;
			} catch (Exception e) {
				e.printStackTrace();
			}

			break;

		case "runJavaScript":
			System.out.println("Run JavaScript");

			ScriptEngineManager factory = new ScriptEngineManager();
			ScriptEngine engine = factory.getEngineByName("JavaScript");
			try {
				StepOutcome = (String) engine.eval(data);
				TestManager.MyDataDicitonary.put(data, StepOutcome);
			} catch (ScriptException e) {
				e.printStackTrace();
			}

			// JavascriptExecutor js;
			// js = (JavascriptExecutor) driver;
			// js.executeScript(data);
			// System.out.println("Step Outcome : "+ StepOutcome);
			// System.out.println("Java Script Executed");
			break;

		case "check":
			// System.out.println("Check");
			try {
				if (!e.isSelected()) {
				}
				e.click();
			} catch (Exception e) {
				log.info(e);
				throw new Exception("Checkbox is already selected");
			}
			break;

		case "waitFor":
			// System.out.println("Wait For Element");

			int data3 = (int) Double.parseDouble(data);
			WebDriverWait wait = new WebDriverWait(driver, data3);
			wait.until(ExpectedConditions.visibilityOfElementLocated(loc));

			break;

		case "waitForNot":
			Long startTime = System.currentTimeMillis();
			// int originalWaitTime = Integer.parseInt(data);
			int originalWaitTime = elementWaitTime;
			elementWaitTime = originalWaitTime / 10;
			boolean isDisplayed = true;
			do {
				try {
					isDisplayed = e.isDisplayed();
				} catch (Exception e) {
					isDisplayed = false;
					break;
				}

			} while (isDisplayed && (System.currentTimeMillis() - startTime) < originalWaitTime * 1000);

			elementWaitTime = originalWaitTime;
			// d.manage().timeouts().implicitlyWait(elementWaitTime,
			// TimeUnit.SECONDS);

			if (!isDisplayed)
				System.out.println("Time Is : " + (int) ((System.currentTimeMillis() - startTime) / 1000));
			else
				throw new TimeoutException("Object didn't disappear even after timeout of " + data + " seconds.");

			StepOutcome = "Wait For Not Element";
			break;

		case "scrollDown":
			// System.out.println("Scroll Down");
			JavascriptExecutor js1;
			js1 = (JavascriptExecutor) driver;
			js1.executeScript("window.scrollTo(0,0);");
			break;

		case "setVariable":
			// System.out.println("Set Variable");
			TestManager.MyDataDicitonary.put(object, data);
			// System.out.println("Value : " +
			// TestRunner.MyDataDicitonary.get(parent) + " & Key : "
			// + TestRunner.MyDataDicitonary.containsKey(parent));
			break;

		case "type":
			// System.out.println("Type Keys");
			for (Character c : data.toCharArray()) {
				driver.findElement(loc).sendKeys(c.toString());
				// System.out.println("Character " + c);
			}
			break;

		case "switchBrowser":
			// System.out.println("Type Keys");
			// for (Character c : data.toCharArray()) {
			// driver.findElement(loc).sendKeys(c.toString());
			// System.out.println("Character " + c);
			// }
			/*
			 * String handle= driver.getWindowHandle(); System.out.println(
			 * "Printing Window Handle : " + handle + "Current Url : " +
			 * driver.getCurrentUrl()); // Store and Print the name of all the
			 * windows open Set handles = driver.getWindowHandles();
			 * System.out.println("Printing Window Handles : " + handles +
			 * "Current Url : " + driver.getCurrentUrl());
			 * 
			 * // Pass a window handle to the other window
			 * 
			 * for (String handle1 : driver.getWindowHandles()) {
			 * 
			 * System.out.println("Printing Window Handle in Loop : " +
			 * handle1);
			 * 
			 * driver.switchTo().window(handle1);
			 */

			// parentWindowHandle =
			// WebDriverInitialize.getDriver().getWindowHandle(); // save the
			// current window handle.
			WebDriver popup = null;
			Set<String> windowIterator = driver.getWindowHandles();
			System.err.println("No of windows :  " + windowIterator.size());
			for (String s : windowIterator) {
				String windowHandle = s;
				popup = driver.switchTo().window(windowHandle);
				System.out.println("Window Title : " + popup.getTitle());
				System.out.println("Window Url : " + popup.getCurrentUrl());
				if (popup.getTitle().equalsIgnoreCase(data)) {
					System.out.println("Selected Window Title : " + popup.getTitle());

				}

			}
			System.out.println("Window Title :" + popup.getTitle());
			System.out.println();
			// return popup;

			/*
			 * for(String winHandle : driver.getWindowHandles()){
			 * driver.switchTo().window(winHandle); } System.out.println(
			 * "Title of the page after - switchingTo: " + driver.getTitle());
			 */

			break;

		case "getUniqueText":
			int intvar = (int) Double.parseDouble(data);
			String UniqueString = JavaUtils.getRandomString(intvar);
			TestManager.MyDataDicitonary.put(object, UniqueString);
			System.out.println("getUniqueText is " + object + " : " + UniqueString);
			StepOutcome = UniqueString;
			break;

		case "acceptAlert":
			acceptAlert();
			break;

		case "runSelectQuery":
			// System.out.println("DB Method");
			// UITests.log.info("Running DB Query Method");
			int count = DBUtils.runSelectQuery(data);
			StepOutcome = count + " Coloumns Fetched ";
			break;
		}

		return StepOutcome;
	}

	public By locatorValue(String locatorType, String value) {
		By by;

		switch (locatorType) {
		case "id":
			by = By.id(value);
			break;
		case "name":
			by = By.name(value);
			break;
		case "xpath":
			by = By.xpath(value);
			break;
		case "css":
			by = By.cssSelector(value);
			break;
		case "linktext":
			by = By.linkText(value);
			break;
		case "partialLinkText":
			by = By.partialLinkText(value);
			break;
		default:
			by = null;
			// System.out.println("Blank Locator");
			break;
		}

		return by;
	}

	public void openBrowser(String browserName) throws MalformedURLException {

		if (!(TestManager.MyDataDicitonary.get("RemoteURL").equalsIgnoreCase("local"))) {
			System.out.println("Entering Remote URL section");

			DesiredCapabilities capability = DesiredCapabilities.firefox();
			capability.setBrowserName("firefox");
			capability.setPlatform(Platform.WINDOWS);
			driver = new RemoteWebDriver(new URL(TestManager.MyDataDicitonary.get("RemoteURL")), capability);
		}

		else {
			try {
				DesiredCapabilities dc = new DesiredCapabilities();
				dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);

				if (browserName.equalsIgnoreCase("firefox")) {
					driver = new FirefoxDriver();
				} else if (browserName.equalsIgnoreCase("chrome")) {
					String chromepath = System.getProperty("user.dir") + "\\lib\\drivers\\chromedriver.exe";
					System.setProperty("webdriver.chrome.driver", chromepath);
					driver = new ChromeDriver();
				} else if (browserName.equalsIgnoreCase("ie")) {
					// String iepath = System.getProperty("user.dir") +
					// "\\drivers\\IEDriverServer.exe";
					String iepath = System.getProperty("user.dir") + "\\lib\\drivers\\IEDriverServer.exe";
					System.setProperty("webdriver.ie.driver", iepath);
					// driver = new InternetExplorerDriver();
					DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
					caps.setCapability("ignoreZoomSetting", true);
					driver = new InternetExplorerDriver(caps);
				}
				wait = new WebDriverWait(driver, 30);
			} catch (WebDriverException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public String acceptAlert() throws InterruptedException {
		boolean presentFlag = false;
		alertText = "";
		System.out.println("Entering Accept Alert Method");
		try {

			Thread.sleep(20000);
			// Check the presence of alert
			alert = driver.switchTo().alert();
			// Get Alert Text
			alertText = alert.getText();
			// Alert present; set the flag
			presentFlag = true;
			// if present consume the alert
			alert.accept();

		} catch (NoAlertPresentException ex) {
			// Alert not present
			// System.out.println("Exception Occured");
			ex.printStackTrace();
		}
		return alertText;
	}

	public static void fnHighlightMe(WebDriver driver, WebElement element) throws InterruptedException {
		// Creating JavaScriptExecuter Interface
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for (int iCnt = 0; iCnt < 3; iCnt++) {
			/*
			 * // Execute javascript js.executeScript(
			 * "arguments[0].style.border='4px groove green'", element);
			 * Thread.sleep(1000); js.executeScript(
			 * "arguments[0].style.border='outline|#00ff00 solid 3px'",
			 * element);
			 */

			js.executeScript("arguments[0].style." + highLightPropertyName + " = '" + highlightColor + "'", element);
			Thread.sleep(50);

			js.executeScript("arguments[0].style." + highLightPropertyName + " = '" + originalColor + "'", element);
			Thread.sleep(50);

			js.executeScript("arguments[0].style." + highLightPropertyName + " = '" + highlightColor + "'", element);
			Thread.sleep(50);

			js.executeScript("arguments[0].style." + highLightPropertyName + " = '" + originalColor + "'", element);

		}
	}

	public WebElement what(WebDriver driver, By locator) throws Exception {

		// System.out.println("WTF");

		// System.out.println("locator is : " + locator);

		// WebElement data = By.linkText("Chapter1");
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		element = driver.findElement(locator);

		// System.out.println("Element is : " + element);

		fnHighlightMe(driver, element);

		getscreenshot(driver);

		return element;

	}

	public static void getscreenshot(WebDriver d) throws Exception {
		File scrFile = ((TakesScreenshot) d).getScreenshotAs(OutputType.FILE);
		// The below method will save the screen shot in d drive with name
		// "screenshot.png"

		String out = new SimpleDateFormat(screenShotCounter + "-yyyy-MM-dd hh-mm-ss'.png'").format(new Date());

		File image = new File(System.getProperty("user.dir") + "\\screenshots\\" + out);

		FileUtils.copyFile(scrFile, image);

		// UITests.extentReportTestObject.addScreenCapture(image.getAbsolutePath());
		// UITests.extentReportTestObject.log(LogStatus.INFO, "Image", "Image
		// example:", image.getAbsolutePath());
		// UITests.extentReportTestObject.log(LogStatus.INFO,"Image",image.getAbsolutePath());
		String ImgSource = image.getAbsolutePath() ;
		/*UITests.extentReportTestObject.log(LogStatus.INFO, StepName,
				UITests.extentReportTestObject.addScreenCapture(image.getAbsolutePath()));*/
		//String HTMLCode = "<b><a href='" + ImgSource + "'><img src='./reports/logo/image.png' height='25' width='25' />Screenshot Link</a></b> | " + "<a href='" + ImgSource + "'>Defect Link</a>  | " + "<a href='" + ImgSource + "'>HTML Link</a>";
		String HTMLCode = "<b><a href='" + ImgSource + "'>Screenshot</a></b> | " + "<a href='" + ImgSource + "'>Defect</a>  | " + "<a href='" + ImgSource + "'>HTML</a>";
		UITests.extentReportTestObject.log(LogStatus.INFO, StepName,HTMLCode);
		screenShotCounter++;
	}

}
