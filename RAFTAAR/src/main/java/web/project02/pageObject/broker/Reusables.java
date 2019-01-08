package web.project02.pageObject.broker;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.BasePage;
import utils.JavaUtil;
import utils.LogUtils;
import web.project02.pageObject.employer.SignUp;
import web.project02.pageObject.uiMap.Auth0LogIn;
import web.project02.pageObject.uiMap.Employer;

public class Reusables extends BasePage {

	AddEmployer AddEmployerObj;
	TopLinks topLinksObj;
	ManageEmployer manageEmployerPageObj;
	Auth0LogIn auth0LogInObj;
	SignUp signUpObj;
	BrokerHome brokerHomePageObj;

	public Reusables(WebDriver driverObj, HashMap<String, String> hashMapObj) {

		webDriverObj = driverObj;

		basePageHashMapObj = hashMapObj ;
		
		LogUtils.info("Calling Reusables Constructor");

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

		String Email = JavaUtil.generateEmail();

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

		setText(By.name("emailId"), JavaUtil.replaceVariable("${EmployerEmail}"));

	}

	public void fillEmployerDetails(String workBook, String sheetName, int iterationNumber) {

		AddEmployerObj = new AddEmployer(webDriverObj);
		
		waitForPageLoaded();
		
		basePageHashMapObj = JavaUtil.readTestDataFiles(workBook,sheetName,iterationNumber);

		// We need to modify condition when cell type is formuala, we need to get that
		// as String

		AddEmployerObj.waitForEmployerPageToAppear();
		AddEmployerObj.setCompanyName();
		AddEmployerObj.pause();
		AddEmployerObj.setSIC();
		AddEmployerObj.setEIN();
		AddEmployerObj.setFullTimeEEs();
		AddEmployerObj.setFirstName();
		AddEmployerObj.setLastName();
		AddEmployerObj.setAddressLine1();
		AddEmployerObj.enterZipCode();
		// AddEmployerObj.selectCounty();
		AddEmployerObj.setCity();
		AddEmployerObj.setEmailID();
		AddEmployerObj.clickAdd();
		AddEmployerObj.clickOk();

	}

	public void addEmployer() {

		topLinksObj = new TopLinks(webDriverObj);
		manageEmployerPageObj = new ManageEmployer(webDriverObj);
		
		topLinksObj.clickClientsTab();
		manageEmployerPageObj.clickAddEmployer();
		manageEmployerPageObj.clickEnterManually();
		fillEmployerDetails("test-data.xlsx", "signup", 2);

	}

	public void loginBroker() {

		brokerHomePageObj = new BrokerHome(webDriverObj);
		auth0LogInObj = new Auth0LogIn(webDriverObj);
		
		brokerHomePageObj.openHomePage();
		auth0LogInObj.brokerLogin();

	}

	public void createPackage() {

		manageEmployerPageObj.filterEmployerByEIN();
		manageEmployerPageObj.waitForEmployerName();
		manageEmployerPageObj.clickOnEmployerName();

	}

}