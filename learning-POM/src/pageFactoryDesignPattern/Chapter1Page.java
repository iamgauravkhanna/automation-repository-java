package pageFactoryDesignPattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class Chapter1Page {

	WebDriver myDriver;

	@FindBy(linkText = "Home Page")
	WebElement HomePageLink;

	// 
	public Chapter1Page(WebDriver myDriver) {

		this.myDriver = myDriver;

		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(myDriver, 30);

		PageFactory.initElements(factory, this);

	}

	//
	public void clickHomePageLink() {

		HomePageLink.click();

	}

}
