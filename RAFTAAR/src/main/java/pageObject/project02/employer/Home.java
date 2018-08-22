package pageObject.project02.employer;

import utils.BasePage;
import org.openqa.selenium.WebDriver;

public class Home extends BasePage {

	public static final String EMPLOYER_URL = "XXXX";

	public Home(WebDriver driverObj) {

		webDriverObj = driverObj;

	}

	public void openHomePage() {

		openBrowser(Home.EMPLOYER_URL);

	}

}