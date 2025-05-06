package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtil {

    private static ExtentReports extent;
    private static ExtentTest test;

    public static ExtentReports setupExtentReports() {
        if (extent == null) {
            ExtentSparkReporter spark = new ExtentSparkReporter("test-output/ExtentReport.html");
            extent = new ExtentReports();
            extent.attachReporter(spark);
        }
        return extent;
    }

    public static void startTest(String testName, String description) {
        test = extent.createTest(testName, description);
    }

    public static void endTest() {
        extent.flush();
    }

    public static void logInfo(String message) {
        test.info(message);
    }

    public static void logPass(String message) {
        test.pass(message);
    }

    public static void logFail(String message) {
        test.fail(message);
    }

    public static void logWarning(String message) {
        test.warning(message);
    }
}
