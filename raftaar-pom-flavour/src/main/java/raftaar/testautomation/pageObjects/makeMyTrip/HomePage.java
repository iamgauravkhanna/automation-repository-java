package raftaar.testautomation.pageObjects.makeMyTrip;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import raftaar.testautomation.utils.BaseTest;
import raftaar.testautomation.utils.WebPage;

public class HomePage extends BaseTest {

	private WebDriver webDriverObj;

	WebPage webPageObj = new WebPage();

	By FromField = By.id("hp-widget__sfrom");
	By FromState = By.xpath("//span(text()='New Delhi, India')");

	public HomePage(WebDriver driver) {

		webDriverObj = driver;

	}

	public void clickFromField() {
		
		webPageObj.clickSimple(webPageObj.findElement(webDriverObj,FromField));
		webPageObj.clickSimple(webDriverObj.findElement(FromState));

	}

	public void openHomePage() {

		webPageObj.get(webDriverObj, "https://www.makemytrip.com/");

	}

}
