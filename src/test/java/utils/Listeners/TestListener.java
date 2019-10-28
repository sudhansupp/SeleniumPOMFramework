package utils.Listeners;

import com.demo.config.BaseClass;
import com.relevantcodes.extentreports.LogStatus;

import uiFunctions.GUIFunctions;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.internal.TestResult;

import utils.ExtentReports.ExtentManager;
import utils.ExtentReports.ExtentTestManager;



public class TestListener extends BaseClass implements ITestListener {

	private static final String ESCAPE_PROPERTY = "org.uncommons.reportng.escape-output";
	public static File scrFile;
	public static String rootDir = System.getProperty("user.dir");
	
	public String name = "";

	private static String getTestMethodName(ITestResult iTestResult) {
		return iTestResult.getMethod().getConstructorOrMethod().getName();
	}

	@Override
	public void onStart(ITestContext iTestContext) {
		System.setProperty(ESCAPE_PROPERTY, "false");
		System.out.println("I am in onStart method " + iTestContext.getName());
		iTestContext.setAttribute("WebDriver", this.driver);
	}

	@Override
	public void onFinish(ITestContext iTestContext) {
		System.setProperty(ESCAPE_PROPERTY, "false");
		System.out.println("I am in onFinish method " + iTestContext.getName());
		//Do tier down operations for extentreports reporting!
		try{ExtentTestManager.endTest();}
		catch(Exception e) {
			e.printStackTrace();
		}
		ExtentManager.getReporter().flush();
		//ExtentManager.getReporter().close();
	}

	@Override
	public void onTestStart(ITestResult iTestResult) {
		System.setProperty(ESCAPE_PROPERTY, "false");
		System.out.println("I am in onTestStart method " +  getTestMethodName(iTestResult) + " start");
		//Start operation for extentreports.
		ExtentTestManager.startTest(iTestResult.getTestContext().getName()+"_"+iTestResult.getMethod().getMethodName(),"");
	}

	@Override
	public void onTestSuccess(ITestResult iTestResult) {
		System.setProperty(ESCAPE_PROPERTY, "false");
		System.out.println("I am in onTestSuccess method " +  getTestMethodName(iTestResult) + " succeed");

		//Take base64Screenshot screenshot.
		//String base64Screenshot = "data:image/png;base64,"+((TakesScreenshot)webDriver).getScreenshotAs(OutputType.BASE64);
		//Reporter.log("<br/><a href="+base64Screenshot+" class=\"highslide\" rel=\"highslide\"> <img src="+base64Screenshot+"  alt=\"Highslide JS\" title=\"Click to enlarge\" hight=\'100\' width=\'100\'/></a><br/>");
		//ExtentTestManager.getTest().log(LogStatus.PASS,"Test passed",ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot));
			
		if (BaseClass.driver.getClass().getName().equalsIgnoreCase("org.openqa.selenium.remote.RemoteWebDriver")) {
			name = GUIFunctions.takeRemoteWebDriverScreenShot(driver, getTestMethodName(iTestResult));
			Reporter.log("<br/><a href="+name+" class=\"highslide\" rel=\"highslide\"><img src="+name+"  alt=\"Highslide JS\" title=\"Click to enlarge\" hight=\'100\' width=\'100\'/> </a><br/>");
			ExtentTestManager.getTest().log(LogStatus.PASS,ExtentTestManager.getTest().addScreenCapture(name));

		} else {
			name = GUIFunctions.takeScreenShot(driver, getTestMethodName(iTestResult));
			Reporter.log("<br/><a href="+name+" class=\"highslide\" rel=\"highslide\"><img src="+name+"  alt=\"Highslide JS\" title=\"Click to enlarge\" hight=\'100\' width=\'100\'/> </a><br/>");
			ExtentTestManager.getTest().log(LogStatus.PASS,ExtentTestManager.getTest().addScreenCapture(name));
		}
		
		//BaseClass.result = iTestResult;

	}

	@Override
	public void onTestFailure(ITestResult iTestResult) {
		System.setProperty(ESCAPE_PROPERTY, "false");
		System.out.println("I am in onTestFailure method " +  getTestMethodName(iTestResult) + " failed");
	
		//if (result.getThrowable().toString().contains("IllegalStateException")) {
		if (BaseClass.driver.getClass().getName().equalsIgnoreCase("org.openqa.selenium.remote.RemoteWebDriver")) {
			System.setProperty(ESCAPE_PROPERTY, "false");				
			name = GUIFunctions.takeRemoteWebDriverScreenShot(driver, getTestMethodName(iTestResult));
			Reporter.log("<br/><a href="+name+" class=\"highslide\" rel=\"highslide\"><img src="+name+"  alt=\"Highslide JS\" title=\"Click to enlarge\" hight=\'100\' width=\'100\'/> </a><br/><br><p><font color=\"red\">Test has been Failed, because of below reason</font></p>");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Test has been Failed, because of  : " + iTestResult.getThrowable().toString(),ExtentTestManager.getTest().addScreenCapture(name));

		} else {
			System.setProperty(ESCAPE_PROPERTY, "false");
			name = GUIFunctions.takeScreenShot(driver, getTestMethodName(iTestResult));
			Reporter.log("<br/> <a href="+name+" class=\"highslide\" rel=\"highslide\"><img src="+name+"  alt=\"Highslide JS\" title=\"Click to enlarge\" hight=\'100\' width=\'100\'/> </a><br/><br><p><font color=\"red\">Test has been Failed, because of below reason</font></p>");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Test has been Failed, because of  : " + iTestResult.getThrowable().toString(),ExtentTestManager.getTest().addScreenCapture(name));
		}		
		
		Reporter.log("<p><font color=\"red\">THROWABLE : " + iTestResult.getThrowable().toString()+"</p><br/>");
		BaseClass.result = iTestResult;
		
		/*if (result.getThrowable().toString().contains("IllegalStateException")) {
			iTestResult.setStatus(TestResult.SKIP);
			throw new SkipException("Skipping this due to  - " + iTestResult.getThrowable().toString());
		}*/
	}

	@Override
	public void onTestSkipped(ITestResult iTestResult) {
		System.setProperty(ESCAPE_PROPERTY, "false");
		System.out.println("I am in onTestSkipped method "+  getTestMethodName(iTestResult) + " skipped");
	
		ExtentTestManager.getTest().log(LogStatus.SKIP, "Test has been Skipped, because of : "+iTestResult.getThrowable().toString());

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
		System.setProperty(ESCAPE_PROPERTY, "false");
		System.out.println("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
	}

}
