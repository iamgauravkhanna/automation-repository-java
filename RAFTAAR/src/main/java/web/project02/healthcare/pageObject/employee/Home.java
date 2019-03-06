package web.project02.healthcare.pageObject.employee;

import utils.BasePage;
import org.openqa.selenium.WebDriver;

public class Home extends BasePage {

	public static final String EMPLOYER_URL = "xxx";

	public Home(WebDriver driverObj) {

		webDriverObj = driverObj;

	}

	public void openHomePage() {

		openBrowser(Home.EMPLOYER_URL);

	}

}