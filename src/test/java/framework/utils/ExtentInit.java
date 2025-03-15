package framework.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;

public class ExtentInit {

    static ExtentReports extent;
    static ExtentSparkReporter htmlReporter;
    public static ExtentTest logger;

    public static ExtentReports initializeReports(String testName) {

        String reportDirectory = System.getProperty("user.dir") + "/Reports_" + testName;

        File directory = new File(reportDirectory);
        if(!directory.exists()){
            directory.mkdirs();
        }

        try {
            String reportPath = reportDirectory + "/" + testName + ".html";
            htmlReporter = new ExtentSparkReporter(reportPath);
            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);

            htmlReporter.config().setDocumentTitle("Annamalai Report");
            htmlReporter.config().setReportName("Amazon Automation Report");
            htmlReporter.config().setTheme(Theme.DARK);

            return extent;
        } catch (Exception e) {
            System.out.println("Error initializing ExtentReports: " + e.getMessage());
            throw e;
        }
    }


    public static ExtentTest testCaseLog(String testName) {
        return extent.createTest(testName);
    }

    public static void quitReport() {
        if (extent != null) {
            extent.flush();
        }
    }




}
