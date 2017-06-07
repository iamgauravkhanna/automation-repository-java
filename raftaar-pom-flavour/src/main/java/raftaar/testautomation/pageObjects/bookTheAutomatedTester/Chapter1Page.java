package raftaar.testautomation.pageObjects.bookTheAutomatedTester;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import raftaar.testautomation.utils.BaseTest;
import raftaar.testautomation.utils.WebPage;

public class Chapter1Page extends BaseTest {

	private WebDriver webDriverObj;

	WebPage webPageObj = new WebPage();

	@FindBy(linkText = "Home Page")
	WebElement HomePageLink;

	/***
	 * Constructor
	 * 
	 * @param driver
	 *            an instance of WebDriver
	 */
	public Chapter1Page(WebDriver driver) {

		webDriverObj = driver;

		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(webDriverObj, 30);

		PageFactory.initElements(factory, this);

		System.out.println("Chapter 1 Page Elements Page Initialized");

	}

	//
	public void clickHomePageLink() {

		HomePageLink.click();

	}

}
