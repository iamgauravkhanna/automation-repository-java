package testMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import utils.ExcelUsingApachePOI;



public class KeywordMethods {

	public WebDriver webDriver;

	//
	public String testCaseName;

	//
	public String method;

	//
	public String locator;

	//
	public String value;

	//
	public String data;

	//
	public By loc;

	public By locatorMethod(String locator, String value) {

		By byElement = null;

		if (locator.equalsIgnoreCase("id")) {

			byElement = By.id(value);

		} else if (locator.equalsIgnoreCase("xpath")) {

			byElement = By.xpath(value);

		} else if (locator.equalsIgnoreCase("linkText")) {

			byElement = By.linkText(value);

		} else if (locator.equalsIgnoreCase("class")) {

			byElement = By.className(value);

		}

		return byElement;

	}

	//
	public void testRun(ExcelUsingApachePOI excelObject, String testExecution,
			String testSheetName) {

		//
		if ("Y".equalsIgnoreCase(testExecution)) {

			//
			System.out.println("Test Case to be executed : " + testSheetName);

			//
			for (int j = 2; j <= excelObject.getRowCount(testSheetName); j++) {

				// Print all methods
				method = excelObject.getCellData(testSheetName, "Keyword", j);

				locator = excelObject.getCellData(testSheetName, "Locator", j);

				value = excelObject.getCellData(testSheetName, "Value", j);

				data = excelObject.getCellData(testSheetName, "Data", j);

				loc = locatorMethod(locator, value);

				if (method.equalsIgnoreCase("openBrowser")) {

					//
					openBrowser(loc);

				} else if (method.equalsIgnoreCase("getUrl")) {

					//
					getUrl(value);
				} else if (method.equalsIgnoreCase("closeBrowser")) {

					//
					closeBrowser();
				} else if (method.equalsIgnoreCase("click")) {

					//
					click(loc);
				} else if (method.equalsIgnoreCase("clickLink")) {

					//
					clickLink(loc);

				} else if (method.equalsIgnoreCase("assertText")) {

					//
					assertText(loc, data);
				}

			}

		}

	}

	public void openBrowser(By loc) {

		//
		webDriver = new FirefoxDriver();
	}

	public void getUrl(String value) {

		webDriver.get(value);
	}

	public void closeBrowser() {

		webDriver.quit();

	}

	public void click(By loc) {

		webDriver.findElement(loc).click();

	}

	public void clickLink(By loc) {

		webDriver.findElement(loc).click();

	}

	public void assertText(By loc, String Data) {

		System.out.println("Entering assertText");

		Assert.assertEquals(data, webDriver.findElement(loc).getText());

	}
}
