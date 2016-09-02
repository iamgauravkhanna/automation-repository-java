package raftaar.testautomation.reporting;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Reporter;

public class CustomReportNG {

	// This property allows use to use html tags in output
	private final String ESCAPE_PROPERTY = "org.uncommons.reportng.escape-output";

	public static double imageQuality = 1.0;

	public static String dateTime = new SimpleDateFormat("yyyyMMddhhmm").format(new Date());

	public static String testNGResultFolder = System.getProperty("user.dir") + "\\" + "custom-testng-folder-"
			+ dateTime;

	public static String reportNGResultFolder = System.getProperty("user.dir") + "\\" + "custom-reportng-folder-"
			+ dateTime;

	public boolean embeddFiles = true;

	public int currentStepNumber = 0;

	public String screenshotDir = "screenshots";

	public String testNGMethodId = "";

	public CustomReportNG() {
		this("screenshots");
	}

	public CustomReportNG(String sceenshotDirectory) {

		this.screenshotDir = sceenshotDirectory;

		System.setProperty(ESCAPE_PROPERTY, "false");

		testNGResultFolder = new File(Reporter.getCurrentTestResult().getTestContext().getOutputDirectory())
				.getParent();

		testNGResultFolder = testNGResultFolder + File.separator;

		reportNGResultFolder = testNGResultFolder + "html" + File.separator;

		testNGMethodId = getTestngMethodID();

	}

	// Method to retrieve TestNG Method Id. Added for dependent testcases
	public static String getTestngMethodID() {

		return Reporter.getCurrentTestResult().getMethod().getMethodName() + "_"
				+ Reporter.getCurrentTestResult().getMethod().hashCode();
	}

}
