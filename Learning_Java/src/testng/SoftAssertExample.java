package testng;

import org.testng.annotations.Test;
//import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

public class SoftAssertExample {
	//private Assertion hardAssert = new Assertion();
	private SoftAssert softAssert = new SoftAssert();

	@Test
	public void testForSoftAssertionFailure() {
		softAssert.assertTrue(false);
		softAssert.assertEquals(1, 1);
		//softAssert.assertAll();
	}
}

// Reference : http://sqa.stackexchange.com/questions/12967/is-there-any-way-to-continue-selenium-web-driver-script-after-assert-fails
//Reference : https://rameshbaskar.wordpress.com/2013/09/11/soft-assertions-using-testng/