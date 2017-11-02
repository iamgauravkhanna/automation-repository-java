package org.gtg.raftaar_implementation.pageObjects.webApp.phix.broker;

import org.gtg.raftaar.utils.BasePage;
import org.gtg.raftaar.utils.JavaUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddEmployer extends BasePage {

	public static final By ADD_EMPLOYER_HEADING = By.xpath("//h2[text()='Add Employer']");

	public static final By COMPANY_NAME = By.name("employer.companyName");

	public static final By SIC = By.id("searchSIC");

	public AddEmployer(WebDriver driverObj) {

		webDriverObj = driverObj;

	}

	public void fillEmployerDetails() {

		waitFor(ADD_EMPLOYER_HEADING);
		setText(COMPANY_NAME, JavaUtils.generateRandomString());
		pause();
		setText(SIC, "cotto");
		// pause();
		// click(By.xpath("//*[text()='N (0131)']"));
		waitFor(By.xpath("//ul[contains(@id,'typeahead')]/li[1]"));
		clickUsingJavaScript(By.xpath("//ul[contains(@id,'typeahead')]/li[1]"));
		setText(By.id("employer.federalEmployerIdentificationNumber"), JavaUtils.generateRandomNumber(9));
		setText(By.name("employer.currentFullTimeEmployees"), JavaUtils.generateRandomNumber(2));
		setText(By.name("employer.firstName"), JavaUtils.generateRandomString());
		setText(By.name("employer.lastName"), JavaUtils.generateRandomString());
		setText(By.name("employer.address.streetAddressLine1"), JavaUtils.generateRandomString());
		setText(By.name("employer.address.zip"), "18017");

		try {

			pressKey(By.name("employer.address.zip"), "TAB");

		} catch (Exception e) {

			e.printStackTrace();
		}

		click(By.xpath("//label[text()='County']/..//span[text()='Select']"));
		pause();
		// click(By.xpath("//ul//li[text()='LEHIGH']"));
		// clickUsingJavaScript(By.xpath("//ul//li[text()='LEHIGH']"));
		clickLiElement(By.xpath("//ul//li"), "LEHIGH");
		pause();
		setText(By.id("address.city"), JavaUtils.generateRandomString());
		setText(By.name("employer.emailId"), JavaUtils.generateEmail());
		setText(By.name("employer.workPhoneNumber"), JavaUtils.generateRandomNumber(10));
		clickUsingJavaScript(By.xpath("//button[text()='Add to Client List and Notify']"));
		click(By.xpath("//button[text()='Ok']"));

	}
}
