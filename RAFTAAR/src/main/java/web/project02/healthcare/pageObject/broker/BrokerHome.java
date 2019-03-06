package web.project02.healthcare.pageObject.broker;

import utils.BasePage;
import utils.TestDataWriter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BrokerHome extends BasePage {

	public static final By LOGIN_LINK = By.linkText("Log In");

	public static final By PRIVACY_POLICY_LINK = By.linkText("Privacy Policy");

	public static final By TERMS_OF_USE = By.linkText("Terms of Use");

	public BrokerHome(WebDriver driverObj) {

		webDriverObj = driverObj;

	}

	public void openHomePage() {

		openBrowser(TestDataWriter.getInstance().getKey("BROKER_URL"));

		maximizeBrowser();

	}

}