package pageObject.project02.broker;

import utils.BasePage;
import utils.BaseTest;
import utils.JavaUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BrokerHome extends BasePage {

	//public static final String BROKER_URL = "https://qa08.product-phix-all-qa2.demo.hcinternal.net/broker/";

	public static final By LOGIN_LINK = By.linkText("Log In");

	public static final By PRIVACY_POLICY_LINK = By.linkText("Privacy Policy");

	public static final By TERMS_OF_USE = By.linkText("Terms of Use");

	public BrokerHome(WebDriver driverObj) {

		webDriverObj = driverObj;

	}

	public void openHomePage() {

		openBrowser(BaseTest.baseTesthashMapObj.get("BROKER_URL"));
		
		maximizeBrowser();
		
	}

}