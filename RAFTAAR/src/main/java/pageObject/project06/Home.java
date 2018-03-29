package pageObject.project06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.BasePage;

public class Home extends BasePage {

	public static final String HOME_URL = "http://book.theautomatedtester.co.uk/";

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