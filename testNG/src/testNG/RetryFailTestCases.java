/*
 * @Author : Gaurav Khanna 
 */

package testNG;

import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class RetryFailTestCases implements IRetryAnalyzer {

	int retryCount = 0;
	int maxRetryCount = 2;

	public boolean retry(ITestResult result) {

		if (retryCount < maxRetryCount) {

			retryCount++;

			return true;
		}

		return false;
	}

	@Test(retryAnalyzer = RetryFailTestCases.class)
	public void testGenX() {

		// ListenerTest fails for gaurav. This will run till retryCount <
		// maxRetryCount
		Assert.assertEquals("gaurav", "GauravFail");
	}

}