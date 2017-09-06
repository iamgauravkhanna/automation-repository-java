package org.gtg.raftaar_implementation.pageObjects.webApp.phix.broker;

import org.openqa.selenium.By;

public class ManageEmployer {

	public final static By SEARCH_BY = By.id("filterType");

	public final static By SEARCH_BY_EIN = By.xpath("//label[@for='status_ein']");

	public final static By SEARCH_BY_TEXTBOX = By.id("searchEmployers");

	public final static By SEARCH_ICON = By.xpath("//span[@class='input-group-btn']");

}
