package pageFactoryDesignPattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HomePage {

	WebDriver myDriver;

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

	// Constructor to initialize elements
	public HomePage(WebDriver myDriver) {

		this.myDriver = myDriver;

		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(myDriver, 30);

		PageFactory.initElements(factory, this);
	}

	//
	public void clickOnLinkChapter1() {

		Chapter1.click();
	}

	//
	public void verifyHomePageText() {

		HomeTitle.isDisplayed();
	}

	public void clickOnLinkChapter2() {

		//
		Chapter2.click();

	}

}
