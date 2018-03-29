package pageObject.project02.employer;

import org.gtg.raftaar.utils.BasePage;
import org.gtg.raftaar.utils.JavaUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUp extends BasePage {

	public static final By EMAIL_ID = By.xpath("//input[@name='emailId']");

	public static final By PASSWORD = By.xpath("//input[@name='password']");

	public static final By CONFIRM_PASSWORD = By.xpath("//input[@name='confirmPassword']");

	public static final By SECURITY_QUESTION_1_DROPDOWN = By.xpath("//span[@id='securityQuestion0-button']");

	public static final By SECURITY_QUESTION_1_QUESTION = By
			.xpath("//ul[@id='securityQuestion0-menu']/li[text()='What is the make and model of your first car?']");

	public static final By SECURITY_QUESTION_1_ANSWER = By.xpath("//*[@id='securityQuestionAnswers0.securityAnswer']");

	public static final By SECURITY_QUESTION_2_DROPDOWN = By.xpath("//*[@id='securityQuestion1-button']");

	public static final By SECURITY_QUESTION_2_QUESTION = By
			.xpath("//ul[@id='securityQuestion1-menu']/li[text()='Where were you born?']");

	public static final By SECURITY_QUESTION_2_ANSWER = By.xpath("//*[@id='securityQuestionAnswers1.securityAnswer']");

	public static final By ATTESTATION_CHECKBOX = By.xpath("//input[@id='conditions']/..");

	public static final By REGISTER_BUTTON = By.xpath("//input[@type='submit']");

	public SignUp(WebDriver driverObj) {

		webDriverObj = driverObj;

	}

	public void startSignUp() {

		String Email = JavaUtils.generateEmail();

		setVariable("EmployerEmail", Email);

		setText(EMAIL_ID, BasePage.testCaseMap.get("EmployerEmail"));
		
		setVariable("EmployerPassword","Qwerty@12");

		setText(PASSWORD, "Qwerty@12");

		setText(CONFIRM_PASSWORD, "Qwerty@12");

		click(SECURITY_QUESTION_1_DROPDOWN);

		clickLiElement(By.xpath("//ul[@id='securityQuestion0-menu']/li"),
				"What is the make and model of your first car?");

		setText(SECURITY_QUESTION_1_ANSWER, "Black");

		click(SECURITY_QUESTION_2_DROPDOWN);

		clickLiElement(By.xpath("//ul[@id='securityQuestion1-menu']/li"), "Where were you born");

		setText(SECURITY_QUESTION_2_ANSWER, "Green");

		click(ATTESTATION_CHECKBOX);

		click(REGISTER_BUTTON);

	}

}