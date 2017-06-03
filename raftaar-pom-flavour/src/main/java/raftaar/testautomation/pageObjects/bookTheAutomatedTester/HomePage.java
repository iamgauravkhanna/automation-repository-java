package raftaar.testautomation.pageObjects.bookTheAutomatedTester;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import raftaar.testautomation.utils.WebPage;

public class HomePage {

	private WebDriver webDriverObj;

	WebPage webPageObj = new WebPage();

	@FindBy(linkText = "Chapter1")
	WebElement Chapter1;

	@FindBy(linkText = "Chapter2")
	WebElement Chapter2;

	@FindBy(linkText = "Chapter3")
	WebElement Chapter3;

	@FindBy(linkText = "Chapter4")
	WebElement Chapter4;

	@FindBy(linkText = "Chapter8")
	WebElement Chapter8;

	@FindBy(xpath = "//div[text()='Selenium: Beginners Guide']")
	WebElement HomeTitle;

	/***
	 * Constructor
	 * 
	 * @param driver
	 *            an instance of WebDriver
	 */
	public HomePage() {

		webDriverObj = webPageObj.initializeDriverObj(webDriverObj);

		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(webDriverObj, 30);

		PageFactory.initElements(factory, this);

		System.out.println("Home Page Elements Page Initialized");
	}

	//
	public void clickOnLinkChapter1() {

		webPageObj.clickSimple(Chapter1);
	}

	//
	public void verifyHomePageText() {

		HomeTitle.isDisplayed();

	}

	public void clickOnLinkChapter2() {

		Chapter2.click();

	}

	public void openHomePage() {

		webPageObj.get(webDriverObj, "http://book.theautomatedtester.co.uk/");

	}

}
