package javaExamples.regularexpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserNameValidator {

	static Pattern pattern;
	static Matcher matcher;

	final static String USERNAME_PATTERN = "^[a-z0-9_-]{3,15}$";

	/**
	 * Validate username with regular expression
	 * 
	 * @param username
	 *            username for validation
	 * @return true valid username, false invalid username
	 */
	public static boolean validate(String username) {

		pattern = Pattern.compile(USERNAME_PATTERN);
		System.out.println("Pattern Compilation successfull");
		System.out.println("Pattern : " + pattern);
		matcher = pattern.matcher(username);
		return matcher.matches();

	}

	public static void main(String[] args) {

		boolean x = validate("grv_khan12");

		if (x)
			System.out.println("Username is Valid");
		else
			System.out.println(
					"Sorry. Enter Valid Username. Username should be 3 to 15 characters with any lower case character, digit or special symbol \"_-\" only");
	}
}