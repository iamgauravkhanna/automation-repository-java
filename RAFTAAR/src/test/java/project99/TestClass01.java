package project99;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BasePage;
import utils.DriverUtil;

public class TestClass01 extends BasePage {

	DriverUtil driverUtilObj;

	List<WebElement> links;

	@Test(timeOut = 120000)
	public void TestMethod001() {

		driverUtilObj = new DriverUtil();

		super.webDriverObj = driverUtilObj.intializeDriver();

		maximizeBrowser();

		openBrowser("http://toolsqa.com/");

		links = findElements(By.tagName("a"));

		System.out.println("Size Of Links : " + links.size());

		for (int i = 1; i <= links.size(); i++)

		{

			System.out.println("Link #" + i + " : " + links.get(i).getText());

		}

		quitBrowser();

	}

	@Test
	public void TestMethod002() {

	}

}