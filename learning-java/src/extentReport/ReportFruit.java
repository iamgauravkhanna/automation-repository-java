package extentReport;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ReportFruit {
    private ExtentReports extent1;
    private ExtentReports extent2;
    
    @BeforeClass
    public void beforeClass() {
        extent1 = new ExtentReports("C:\\Code\\Orange.html", true);
        extent2 = new ExtentReports("C:\\Code\\Apple.html", true);
    }
    
    @Test
    public void testOne() {
        ExtentTest test = extent1.startTest("My First Test", "Sample description");
        test.log(LogStatus.PASS, "details");
        extent1.endTest(test);
    }
    
    @Test
    public void testTwo() {
        ExtentTest test = extent2.startTest("My Second Test", "Sample description");
        test.log(LogStatus.INFO, "details");
        extent2.endTest(test);
    }
    
    @AfterSuite
    public void afterSuite() {
        // write all resources to report file
        extent1.flush();
        extent2.flush();
    }
}