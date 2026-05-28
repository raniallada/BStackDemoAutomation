package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ConfigReader;
import utils.ExtentManager;
import utils.ScreenshotUtil;
import utils.BrowserFactory;

public class BaseTest {

    public WebDriver driver;
    
    public ExtentReports extent;

    public ExtentTest test;
    
    ConfigReader config;
    
    
    @BeforeTest
    public void startReport() {

        extent = ExtentManager.getReportObject();
    }

    @BeforeMethod
    public void setup() {
    	
    	  config = new ConfigReader();

    	driver = BrowserFactory.launchBrowser(
    	        config.getBrowser());

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get(config.getUrl());
    }

    
    @AfterMethod
    public void tearDown(ITestResult result) {

        if (test != null) {

            if (result.getStatus() == ITestResult.FAILURE) {

            	String path = ScreenshotUtil.captureScreenshot(
            	        driver,
            	        result.getName());

            	test.fail(result.getThrowable());

            	test.addScreenCaptureFromPath(path);
            }

            else if (result.getStatus() == ITestResult.SUCCESS) {

                test.pass("Test Passed");
            }
        }

        driver.quit();
    }
    
    @AfterTest
    public void endReport() {

        extent.flush();
    }
}