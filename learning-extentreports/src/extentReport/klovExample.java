package extentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.KlovReporter;

public class klovExample {
	
	public static void main (String [] args) {
		
		ExtentReports extentReportsObj = new ExtentReports();
		
		KlovReporter klovReporter = new KlovReporter();

		// specify mongoDb connection
		klovReporter.initMongoDbConnection("localhost", 27017);

		// specify project
		// ! you must specify a project, other a "Default project will be used"
		klovReporter.setProjectName("Java");

		// you must specify a reportName otherwise a default timestamp will be used
		klovReporter.setReportName("AppBuild");

		// URL of the KLOV server
		// you must specify the served URL to ensure all your runtime media is uploaded
		// to the server
		klovReporter.setKlovUrl("http://localhost");

		extentReportsObj.attachReporter(klovReporter);
		
		extentReportsObj.createTest("My First Test") ;
	
	}

}
