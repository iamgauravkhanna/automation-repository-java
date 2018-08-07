package project99;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BasePage;
import utils.DriverUtil;

public class KeywordExamples extends BasePage {

	DriverUtil driverUtilObj;

	List<WebElement> links;

	// Clicking Element
	@Test
	public void KeywordExample001() {

		driverUtilObj = new DriverUtil();

		super.webDriverObj = driverUtilObj.intializeDriver();

		maximizeBrowser();

		openBrowser("https://not-just-a-tester.blogspot.com/");

		links = findElements(By.tagName("a"));

		System.out.println("Size Of Links : " + links.size());

		for (int i = 1; i <= links.size(); i++) {
			System.out.println("Link #" + i + " : " + links.get(i).getText());
		}

	}

}