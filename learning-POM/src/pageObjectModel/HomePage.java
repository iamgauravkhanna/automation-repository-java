package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	WebDriver myDriver;

	By Chapter1 = By.linkText("Chapter1");
	By Chapter2 = By.linkText("Chapter2");
	By Chapter3 = By.linkText("Chapter3");
	By Chapter4 = By.linkText("Chapter4");
	By Chapter8 = By.linkText("Chapter8");
	By HomeTitle = By.xpath("//div[text()='Selenium: Beginners Guide']");

	public HomePage(WebDriver myDriver) {
		this.myDriver = myDriver;
	}

	public void clickOnLinkChapter1() {

		myDriver.findElement(Chapter1).click();
	}

	public void verifyHomePageText() {

		myDriver.findElement(HomeTitle).isDisplayed();
	}

}
