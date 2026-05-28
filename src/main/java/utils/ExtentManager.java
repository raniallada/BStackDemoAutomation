package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getReportObject() {

        if (extent == null) {

            String reportPath = System.getProperty("user.dir")
                    + "\\Reports\\ExtentReport.html";

            ExtentSparkReporter reporter =
                    new ExtentSparkReporter(reportPath);

            reporter.config().setReportName(
                    "BStack Demo Automation Report");

            reporter.config().setDocumentTitle(
                    "Automation Test Results");

            extent = new ExtentReports();

            extent.attachReporter(reporter);

            extent.setSystemInfo("Tester", "Rani Esther");
        }

        return extent;
    }
}