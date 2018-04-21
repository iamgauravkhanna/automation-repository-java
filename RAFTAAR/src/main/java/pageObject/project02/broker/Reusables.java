package pageObject.project02.broker;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pageObject.project02.uiMap.Employer;
import utils.BasePage;
import utils.JavaUtils;

public class Reusables extends BasePage {
	
	AddEmployer AddEmployerObj ;

	public Reusables(WebDriver driverObj) {

		webDriverObj = driverObj;

	}
	
	public void EmployerSignUp() {

		waitFor(By.xpath(
				"//*[text()='Enter the email address you use as your username, your password, and click Log In.']"));

		click(Employer.LOGIN__SIGNUP_LINK);

		/*
		 * waitFor(By
		 * .xpath("//*[text()='Great! You have chosen hCentive Employee Benefits. To find plans and review proposals, enter the requested information below to complete your registration.']"
		 * ), 60);
		 */

		String Email = JavaUtils.generateEmail();

		setVariable("EmployerEmail", Email);

		/*
		 * String a = BasePage.propertiesMap.get("EmployerEmail");
		 * 
		 * System.out.println(BasePage.propertiesMap.get("EmployerEmail"));
		 */
		setText(Employer.SIGN_UP__EMAIL_ID, BasePage.testCaseMap.get("EmployerEmail"));

		setText(Employer.SIGN_UP__PASSWORD, "Qwerty@12");

		setText(Employer.SIGN_UP__CONFIRM_PASSWORD, "Qwerty@12");

		click(Employer.SIGN_UP__SECURITY_QUESTION_1_DROPDOWN);

		clickLiElement(By.xpath("//ul[@id='securityQuestion0-menu']/li"),
				"What is the make and model of your first car?");

		setText(Employer.SIGN_UP__SECURITY_QUESTION_1_ANSWER, "Black");

		click(Employer.SIGN_UP__SECURITY_QUESTION_2_DROPDOWN);

		clickLiElement(By.xpath("//ul[@id='securityQuestion1-menu']/li"), "Where were you born");

		setText(Employer.SIGN_UP__SECURITY_QUESTION_2_ANSWER, "Green");

		click(Employer.SIGN_UP__ATTESTATION_CHECKBOX);

		click(Employer.SIGN_UP__REGISTER_BUTTON);

	}

	public void EmployerLogIn() {

		setText(By.name("emailId"), JavaUtils.replaceVariable("${EmployerEmail}"));

	}

	public void fillEmployerDetails() {

		AddEmployerObj = new AddEmployer(webDriverObj);		
		waitForPageLoaded();
		AddEmployerObj.waitForEmployerPageToAppear();
		AddEmployerObj.setCompanyName();
		AddEmployerObj.pause();
		AddEmployerObj.setSIC();
		AddEmployerObj.setEIN();
		AddEmployerObj.setFullTimeEEs();
		
		/*setText(By.name("employer.firstName"), JavaUtils.generateRandomString());
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
		click(By.xpath("//button[text()='Ok']"));*/

	}

}
