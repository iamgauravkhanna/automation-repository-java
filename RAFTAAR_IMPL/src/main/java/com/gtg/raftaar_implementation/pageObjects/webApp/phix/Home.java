package com.gtg.raftaar_implementation.pageObjects.webApp.phix;

import org.gtg.raftaar.utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home extends BasePage {

	public static final String BROKER_URL = "xxxx";

	public static final By LOGIN_LINK = By.linkText("Log In");

	public static final By PRIVACY_POLICY_LINK = By.linkText("Privacy Policy");

	public static final By TERMS_OF_USE = By.linkText("Terms of Use");

	public Home(WebDriver driverObj) {

		webDriverObj = driverObj;

	}

	public void openHomePage() {

		openBrowser(Home.BROKER_URL);

	}

}