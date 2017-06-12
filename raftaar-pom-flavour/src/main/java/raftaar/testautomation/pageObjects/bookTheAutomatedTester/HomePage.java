package raftaar.testautomation.pageObjects.bookTheAutomatedTester;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import raftaar.testautomation.utils.BaseTest;
import raftaar.testautomation.utils.LogManager;
import raftaar.testautomation.utils.WebPage;

public class HomePage extends BaseTest {

	private WebDriver webDriverObj;

	WebPage webPageObj = new WebPage();

	By Chapter1 = By.linkText("Chapter1");

	By Chapter2 = By.linkText("Chapter2");

	By HomeTitle = By.xpath("//div[text()='Selenium: Beginners Guide']");

	/***
	 * Constructor
	 * 
	 * @param driver
	 *            an instance of WebDriver
	 */
	public HomePage(WebDriver driver) {

		webDriverObj = driver;

		LogManager.info("Home Page Elements Page Initialized");
	}

	//
	public void clickOnLinkChapter1() {

		webPageObj.clickSimple(webPageObj.findElement(webDriverObj, Chapter1));
	}

	//
	public void verifyHomePageText() {

		webPageObj.findElement(webDriverObj, Chapter1).isDisplayed();

	}

	public void clickOnLinkChapter2() {

		webPageObj.findElement(webDriverObj, Chapter2).click();

	}

	public void openHomePage() {

		webPageObj.get(webDriverObj, "http://book.theautomatedtester.co.uk/");

	}

}
