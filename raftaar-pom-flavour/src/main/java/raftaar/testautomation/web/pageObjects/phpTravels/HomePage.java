package raftaar.testautomation.web.pageObjects.phpTravels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import raftaar.testautomation.utils.WebPage;

public class HomePage extends WebPage {

	WebDriver webDriverObj;

	By homeFrontEndText = By.xpath("//*[contains(text(),'Front-End')]");
	By AdminLink = By.xpath("//*[contains(text(),'http://www.phptravels.net/admin')]");

	public HomePage(WebDriver driver) {

		super(driver);
	}

	public void verifyHomeFrontEndPresent() {

		assertPresent(homeFrontEndText);

	}

	public void openBrowser() {

		get("http://phptravels.com/demo/");

	}

	public void clickAdminLink() {

		clickSimple(AdminLink);

	}

	public void switchToAdminPage() {

		switchToWindow("Administator Login");

	}

}
