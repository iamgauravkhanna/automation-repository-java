package web.project03.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.LogUtils;
import utils.BasePage;

public class AdminPage extends BasePage {

	By email = By.name("email");
	By password = By.name("password");
	By loginButton = By.xpath("//button/span[text()='Login']");

	public AdminPage(WebDriver driverObj) {

		webDriverObj = driverObj;

	}

	public void login() {

		LogUtils.info("Running login() method");

		setText(email, "admin@phptravels.com");
		setText(password, "demoadmin");
		click(loginButton);

	}

}