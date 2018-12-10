package utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ListenerUtil implements ITestListener {

	private static ExtentReports extentReportsObj ;
	
/*	= ExtentManager
			.createInstance("ExtentReport_" + JavaUtils.getCurrentTimeStamp() + ".html");*/

	private static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();

	public synchronized void onStart(ITestContext context) {
		
		extentReportsObj = ExtentManager.getInstance() ;

		System.out.println("Extent Reports Version 3 Test Suite started!");

		//test.get().info("Extent Reports Version 3 Test Suite started!");
	}

	public synchronized void onFinish(ITestContext context) {

		System.out.println(("Extent Reports Version 3  Test Suite is ending!"));

		test.get().info("Extent Reports Version 3  Test Suite is ending!");

		extentReportsObj.flush();
		
		System.out.println("Report Path => " + DataDictionary.getInstance().getDataDictionary().get("reportPath"));
	}

	public synchronized void onTestStart(ITestResult result) {

		System.out.println((result.getMethod().getMethodName() + " started!"));

		ExtentTest extentTestObj = extentReportsObj.createTest(result.getMethod().getMethodName(),
				result.getMethod().getDescription());

		test.set(extentTestObj);

		test.get().info((result.getMethod().getMethodName() + " started!"));

	}

	public synchronized void onTestSuccess(ITestResult result) {
		System.out.println((result.getMethod().getMethodName() + " passed!"));
		test.get().pass("Test passed");
	}

	public synchronized void onTestFailure(ITestResult result) {
		System.out.println((result.getMethod().getMethodName() + " failed!"));
		test.get().fail(result.getThrowable());
	}

	public synchronized void onTestSkipped(ITestResult result) {
		System.out.println((result.getMethod().getMethodName() + " skipped!"));
		test.get().skip(result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println(("onTestFailedButWithinSuccessPercentage for " + result.getMethod().getMethodName()));

		test.get().info(("onTestFailedButWithinSuccessPercentage for " + result.getMethod().getMethodName()));

	}
	
	public static ExtentTest getInstance() {

		return test.get();
	}

}