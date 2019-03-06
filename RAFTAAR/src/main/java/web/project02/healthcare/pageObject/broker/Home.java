package web.project02.healthcare.pageObject.broker;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.BasePage;

public class Home extends BasePage {

	public static final String HOME_URL = "http://automationpractice.com";

	public Home(WebDriver driverObj) {

		webDriverObj = driverObj;

	}

	public void openHomePage() {

		openBrowser(Home.HOME_URL);

	}

	public void clickContactUs() {

		click(By.xpath("//a[text()='Contact us']"));

	}

}