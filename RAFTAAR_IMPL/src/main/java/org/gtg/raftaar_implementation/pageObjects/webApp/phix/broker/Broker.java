package org.gtg.raftaar_implementation.pageObjects.webApp.phix.broker;

import org.openqa.selenium.By;

public class Broker {

	/**
	 * Home Page
	 */
	public static final String HOME__BROKER_URL = "abcd";

	public static final By HOME__LOGIN_LINK = By.linkText("Log In");

	public static final By HOME__PRIVACY_POLICY_LINK = By.linkText("Privacy Policy");

	public static final By HOME__TERMS_OF_USE = By.linkText("Terms of Use");

	/**
	 * Login Page
	 */

	public static final By LOGIN__USERNAME = By.name("emailId");

	public static final By LOGIN__PASSWORD = By.name("password");

	public static final By LOGIN__LOG_IN = By.xpath("//input[@value='Log In']");

	/**
	 * Top Links
	 */
	public final static By TOP_LINKS__CLIENTS_TAB = By.xpath("//a[text()='Clients']");

	/**
	 * Manage Employer Page
	 */
	public final static By MANAGE_EMPLOYERS__SEARCH_BY = By.id("filterType");

	public final static By MANAGE_EMPLOYERS__SEARCH_BY_EIN = By.xpath("//label[@for='status_ein']");

	public final static By MANAGE_EMPLOYERS__SEARCH_BY_TEXTBOX = By.id("searchEmployers");

	public final static By MANAGE_EMPLOYERS__SEARCH_ICON = By.xpath("//span[@class='input-group-btn']");

	public final static By MANAGE_EMPLOYERS__ADD_EMPLOYER_BUTTON = By.xpath("//button[contains(.,'Add Employer')]");

	public final static By MANAGE_EMPLOYERS_ENTER_MANUALLY_BUTTON = By.xpath("//button[contains(.,'Enter Manually')]");

}
