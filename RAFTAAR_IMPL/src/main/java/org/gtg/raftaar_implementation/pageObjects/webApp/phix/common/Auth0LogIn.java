package org.gtg.raftaar_implementation.pageObjects.webApp.phix.common;

import org.gtg.raftaar.utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Auth0LogIn extends BasePage {

	public static final By LOGIN_WELCOME_TEXT = By.xpath("//h1[text()='Welcome to Fidelity Health Marketplace!']");

	public static final By USERNAME = By.name("emailId");

	public static final By PASSWORD = By.name("password");

	public static final By LOG_IN = By.xpath("//input[@value='Log In']");

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

		login(BasePage.testCaseMap.get("EmployerEmail"), BasePage.testCaseMap.get("EmployerPassword"));

	}

	public void brokerLogin() {

		login("fhm.agencyadmin01@dev18.cc", "Qwerty@12");

	}

	public void clickSignUp() {

		waitFor(LOGIN_WELCOME_TEXT);

		click(SIGN_UP_LINK);

	}
}