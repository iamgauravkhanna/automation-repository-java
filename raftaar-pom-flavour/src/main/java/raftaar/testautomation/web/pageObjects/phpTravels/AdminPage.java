package raftaar.testautomation.web.pageObjects.phpTravels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import raftaar.testautomation.utils.LogManager;
import raftaar.testautomation.utils.WebPage;

public class AdminPage extends WebPage {

	By email = By.name("email");
	By password = By.name("password");
	By loginButton = By.xpath("//button/span[text()='Login']");

	public AdminPage(WebDriver driver) {
		super(driver);
		LogManager.setClassName(this.getClass().getName());
	}

	public void login() {

		LogManager.info("Running login() method");

		super.setText(email, "admin@phptravels.com");
		super.setText(password, "demoadmin");
		super.clickSimple(loginButton);

	}

}
