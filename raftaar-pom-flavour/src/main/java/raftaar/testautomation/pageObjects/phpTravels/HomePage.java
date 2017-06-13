package raftaar.testautomation.pageObjects.phpTravels;

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

		super.assertPresent(homeFrontEndText);

	}

	public void openBrowser() {

		super.get("http://phptravels.com/demo/");

	}

	public void clickAdminLink() {

		super.clickSimple(AdminLink);

	}

	public void switchToAdminPage() {

		super.switchToWindow("Administator Login");

	}

}
