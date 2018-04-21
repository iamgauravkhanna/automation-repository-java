package pageObject.project02.broker;

import utils.BasePage;
import utils.JavaUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddEmployer extends BasePage {

	public static final By ADD_EMPLOYER_HEADING = By.xpath("//h2[text()='Add Employer']");

	public static final By COMPANY_NAME = By.name("employer.companyName");

	public static final By SIC = By.id("searchSIC");

	public AddEmployer(WebDriver driverObj) {

		webDriverObj = driverObj;

	}

	public void waitForEmployerPageToAppear() {

		waitFor(ADD_EMPLOYER_HEADING);

	}

	public void setCompanyName() {

		setText(COMPANY_NAME, JavaUtils.generateRandomString());

	}

	public void setSIC() {

		setText(SIC, "cotto");
		// pause();
		// click(By.xpath("//*[text()='N (0131)']"));
		waitFor(By.xpath("//ul[contains(@id,'typeahead')]/li[1]"));
		clickUsingJavaScript(By.xpath("//ul[contains(@id,'typeahead')]/li[1]"));

	}

	public void setEIN() {

		setText(By.id("employer.federalEmployerIdentificationNumber"), JavaUtils.generateRandomNumber(9));

	}

	public void setFullTimeEEs() {

		setText(By.name("employer.currentFullTimeEmployees"), JavaUtils.generateRandomNumber(2));

	}
}