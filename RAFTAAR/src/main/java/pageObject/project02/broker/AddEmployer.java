package pageObject.project02.broker;

import utils.BasePage;
import utils.JavaUtil;
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

		setText(COMPANY_NAME, JavaUtil.generateRandomString());

	}

	public void setSIC() {

		setText(SIC, "cotto");
		// pause();
		// click(By.xpath("//*[text()='N (0131)']"));
		waitFor(By.xpath("//ul[contains(@id,'typeahead')]/li[1]"));
		clickUsingJavaScript(By.xpath("//ul[contains(@id,'typeahead')]/li[1]"));

	}

	public void setEIN() {

		setText(By.id("employer.federalEmployerIdentificationNumber"), JavaUtil.generateRandomNumber(9));

	}

	public void setFullTimeEEs() {

		setText(By.name("employer.currentFullTimeEmployees"), JavaUtil.generateRandomNumber(2));

	}

	public void enterZipCode() {

		setText(By.name("employer.address.zip"), "80001");

		try {

			pressKey(By.name("employer.address.zip"), "TAB");

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void setFirstName() {

		setText(By.name("employer.firstName"), JavaUtil.generateRandomString());

	}

	public void setLastName() {

		setText(By.name("employer.lastName"), JavaUtil.generateRandomString());

	}

	public void setAddressLine1() {

		setText(By.name("employer.address.streetAddressLine1"), JavaUtil.generateRandomString());

	}

	public void selectCounty() {

		click(By.xpath("//label[text()='County']/..//span[text()='Select']"));
		
		pause();		
		
		click(By.xpath("//ul//li[text()='LEHIGH']"));
		
		clickUsingJavaScript(By.xpath("//ul//li[text()='LEHIGH']"));
		
		// clickLiElement(By.xpath("//ul//li"), "LEHIGH");
		
		pause();

	}

	public void setCity() {

		setText(By.id("address.city"), JavaUtil.generateRandomString());

	}

	public void setEmailID() {

		setText(By.name("employer.emailId"), JavaUtil.generateEmail());

	}

	public void clickAdd() {

		click(By.xpath("//button[text()='Add to Client List']"));

	}

	public void clickOk() {

		click(By.xpath("//button[text()='Ok']"));

	}
}