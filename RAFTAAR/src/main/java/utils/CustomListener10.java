package utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class CustomListener10 implements ITestListener {

	private static ExtentReports extent = ExtentManager.createInstance("extent000001.html");
	private static ExtentTest test;

	public synchronized void onStart(ITestContext context) {

		extent.createTest(context.getName());
	
	}

	public synchronized void onFinish(ITestContext context) {
		
		extent.flush();
	
	}

	public synchronized void onTestStart(ITestResult result) {

		test = extent.createTest(result.getMethod().getMethodName());
	}

	public synchronized void onTestSuccess(ITestResult result) {

		test.pass("Test Case : " + result.getTestName() + " passed");

	}

	public synchronized void onTestFailure(ITestResult result) {

		test.fail(result.getThrowable());

	}

	public synchronized void onTestSkipped(ITestResult result) {

		test.skip(result.getThrowable());

	}

	public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}
}