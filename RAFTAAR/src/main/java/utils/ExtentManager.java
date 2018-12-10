package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.KlovReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

	private static ExtentReports extent;

	private static KlovReporter klov = new KlovReporter();;

	public static ExtentReports getInstance() {

		if (extent == null)

		{
			System.out.println(DataDictionary.getInstance().getDataDictionary().get("logsDirectory"));
			
			String reportLink = DataDictionary.getInstance().getDataDictionary().get("logsDirectory") + "\\" + JavaUtil.generateRandomNumber(10) + ".html" ;

			DataDictionary.getInstance().getDataDictionary().put("reportPath", reportLink);
			
			createInstance(reportLink);
			
			System.out.println("Extent Report Instance......");

		}

		return extent;
	}

	public static ExtentReports createInstance(String fileName) {

		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);

		htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);

		htmlReporter.config().setChartVisibilityOnOpen(true);

		htmlReporter.config().setTheme(Theme.STANDARD);
		
		String ReportTitle = "Report #" + JavaUtil.getCurrentTimeStamp() ;

		htmlReporter.config().setDocumentTitle(ReportTitle);

		htmlReporter.config().setEncoding("utf-8");

		htmlReporter.config().setReportName(ReportTitle);

		extent = new ExtentReports();

		// specify mongoDb connection
		klov.initMongoDbConnection("localhost", 27017);

		// specify project
		// ! you must specify a project, other a "Default project will be used"
		klov.setProjectName("RAFTAAR v3.0");

		// you must specify a reportName otherwise a default timestamp will be used
		klov.setReportName(JavaUtil.getCurrentTimeStamp());

		// URL of the KLOV server
		// you must specify the served URL to ensure all your runtime media is uploaded
		// to the server
		klov.setKlovUrl("http://localhost:8005/");

		extent.attachReporter(htmlReporter, klov);

		return extent;
	}
}