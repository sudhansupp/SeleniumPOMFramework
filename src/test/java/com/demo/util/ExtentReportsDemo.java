/*package com.crsp.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.seleniumhq.jetty9.server.Dispatcher;

import com.aventstack.extentreports.ExtentReports;

public class ExtentReportsDemo {
 
    static final ExtentReports extent = new  ExtentReports();
    static WebDriver driver = new FirefoxDriver();
 
    static String reportLocation = "C:\\Tools\\reports\\";
    static String imageLocation = "images/";
     
    public static void main (String args[]) {
 
        extent.init(reportLocation + "ScreenshotReport.html", true);
 
        extent.config().documentTitle("Sample ExtentReports report");
         
        extent.config().reportHeadline("Test report for ParaBank login tests generated using <b>ExtentReports</b>");
 
        extent.startTest("TC01.1","This test is a positive login test for ParaBank");
        runPositiveTest();
        extent.endTest();
 
        extent.startTest("TC01.2","This is a negative login test for ParaBank (contains a defect)");
        runNegativeTest();
        extent.endTest();
 
        driver.quit();
    }
 
    public static void runPositiveTest() {
 
        driver.get("http://parabank.parasoft.com");
 
        checkTitle(driver,"ParaBank | Welcome | Online Banking");
 
        driver.findElement(By.name("username")).sendKeys("john");
        driver.findElement(By.name("password")).sendKeys("demo");
        driver.findElement(By.xpath("//input[@value='Log In']")).click();
 
        checkTitle(driver,"ParaBank | Accounts Overview");
 
        driver.findElement(By.partialLinkText("Log Out")).click();
    }
 
    public static void runNegativeTest() {
 
        driver.get("http://parabank.parasoft.com");
 
        checkTitle(driver,"ParaBank | Welcome | Online Banking");
 
        driver.findElement(By.name("username")).sendKeys("john");
        driver.findElement(By.name("password")).sendKeys("incorrectpassword");
        driver.findElement(By.xpath("//input[@value='Log In']")).click();
 
        checkErrorMessage(driver,"Incorrect credentials");
    }
 
    public static void checkTitle(WebDriver driver, String expectedTitle) {
 
        if(driver.getTitle().equals(expectedTitle)) {
            extent.log(LogStatus.PASS, "Check page title", "Page title is " + expectedTitle);
        } else {
            extent.log(LogStatus.FAIL, "Check page title", "Incorrect login page title " + driver.getTitle());
        }
    }
 
    public static void checkErrorMessage(WebDriver driver, String expectedMessage) {
 
        String errorMessage = driver.findElement(By.className("error")).getText();
 
        if(errorMessage.equals(expectedMessage)) {
            extent.log(LogStatus.PASS, "Check error message", "Error message is " + expectedMessage);
        } else {
            extent.log(LogStatus.FAIL, "Check error message","View details below:",createScreenshot(driver));
        }
    }
}*/