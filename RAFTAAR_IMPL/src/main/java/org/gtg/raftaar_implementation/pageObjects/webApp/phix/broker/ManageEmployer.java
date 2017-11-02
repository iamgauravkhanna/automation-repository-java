package org.gtg.raftaar_implementation.pageObjects.webApp.phix.broker;

import org.gtg.raftaar.utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ManageEmployer extends BasePage {

	public final static By SEARCH_BY = By.id("filterType");

	public final static By SEARCH_BY_EIN = By.xpath("//label[@for='status_ein']");

	public final static By SEARCH_BY_TEXTBOX = By.id("searchEmployers");

	public final static By SEARCH_ICON = By.xpath("//span[@class='input-group-btn']");

	public final static By ADD_EMPLOYER = By.xpath("//button[text()='Add Employer']");

	public final static By ENTER_MANUALLY = By.xpath("//button[text()='Enter Manually']");

	public ManageEmployer(WebDriver driverObj) {

		webDriverObj = driverObj;

	}

	public void clickAddEmployer() {

		click(ADD_EMPLOYER);

	}

	public void clickEnterManually() {

		click(ENTER_MANUALLY);

	}

}
