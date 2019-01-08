package web.project02.pageObject.uiMap;

import org.openqa.selenium.By;

public class Employer {

	/**
	 * Home
	 */
	public static final String HOME__EMPLOYER_URL = "https://qa07form1.product-phix-all-qa2.demo.hcinternal.net/employer";

	/**
	 * Login
	 */
	public static final By LOGIN__SIGNUP_LINK = By.xpath("//a[text()='Sign Up']");

	/**
	 * Sign Up
	 */

	public static final By SIGN_UP__EMAIL_ID = By.xpath("//input[@name='emailId']");

	public static final By SIGN_UP__PASSWORD = By.xpath("//input[@name='password']");

	public static final By SIGN_UP__CONFIRM_PASSWORD = By.xpath("//input[@name='confirmPassword']");

	public static final By SIGN_UP__SECURITY_QUESTION_1_DROPDOWN = By.xpath("//span[@id='securityQuestion0-button']");

	public static final By SIGN_UP__SECURITY_QUESTION_1_QUESTION = By.xpath(
			"//ul[@id='securityQuestion0-menu']/li[text()='What is the make and model of your first car?']");

	public static final By SIGN_UP__SECURITY_QUESTION_1_ANSWER = By
			.xpath("//*[@id='securityQuestionAnswers0.securityAnswer']");

	public static final By SIGN_UP__SECURITY_QUESTION_2_DROPDOWN = By.xpath("//*[@id='securityQuestion1-button']");

	public static final By SIGN_UP__SECURITY_QUESTION_2_QUESTION = By
			.xpath("//ul[@id='securityQuestion1-menu']/li[text()='Where were you born?']");

	public static final By SIGN_UP__SECURITY_QUESTION_2_ANSWER = By
			.xpath("//*[@id='securityQuestionAnswers1.securityAnswer']");

	public static final By SIGN_UP__ATTESTATION_CHECKBOX = By.xpath("//input[@id='conditions']/..");

	public static final By SIGN_UP__REGISTER_BUTTON = By.xpath("//input[@type='submit']");
}
