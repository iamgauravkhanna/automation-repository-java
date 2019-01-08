package web.project02.pageObject.uiMap;

import utils.BasePage;
import utils.BaseTest;
import utils.DataDictionary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Auth0LogIn extends BasePage {

	public static final By LOGIN_WELCOME_TEXT = By.xpath("//h3[text()='Sign in for Returning User']");

	public static final By USERNAME = By.name("username");

	public static final By PASSWORD = By.name("password");

	public static final By LOG_IN = By.xpath("//input[@value='Sign In']");

	public static final By SIGN_UP_LINK = By.linkText("Sign Up");

	public static final By PRIVACY_POLICY_LINK = By.linkText("Privacy Policy");

	public static final By TERMS_OF_USE = By.linkText("Terms of Use");

	public Auth0LogIn(WebDriver driverObj) {

		webDriverObj = driverObj;

	}

	public void login(String userName, String password) {

		waitFor(LOGIN_WELCOME_TEXT);

		setText(USERNAME, userName);

		setText(PASSWORD, password);

		click(LOG_IN);

	}

	public void employerLogin() {

		login(basePageHashMapObj.get("EmployerEmail"), basePageHashMapObj.get("EmployerPassword"));

	}

	public void brokerLogin() {

		login(basePageHashMapObj.get("BROKER_USERNAME"), basePageHashMapObj.get("BROKER_PASSWORD"));

	}

	public void clickSignUp() {

		waitFor(LOGIN_WELCOME_TEXT);

		click(SIGN_UP_LINK);

	}
}