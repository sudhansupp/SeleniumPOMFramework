package com.demo.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

import com.demo.config.BaseClass;

public class Screenshot extends TestListenerAdapter {
	public static Logger log = Logger.getLogger(Screenshot.class.getName());
	// Get the root directory of the project
	// public static String rootDir = CustomFunc.getRootDir();
	public static String rootDir = System.getProperty("user.dir");
	public static File scrFile;
	static Date today = Calendar.getInstance().getTime();
	private static final String ESCAPE_PROPERTY = "org.uncommons.reportng.escape-output";
	// For logging
	// public Logger log = Logger.getLogger(this.getClass().getName());

	// create our "formatter" (our custom format)
	String pattern = "MM/dd/yyyy";

	static SimpleDateFormat formatter = new SimpleDateFormat("dd_MMM_yyyy_hh_mm_ss");
	Date date = new Date();
	long a = date.getTime();
	String screenshots = null;
	
	

	@Override
	public void onTestFailure(ITestResult result) {
		// Reporter.log("HELLO " + result.getMethod().toString());
		//String base64Screenshot = "data:image/png;base64,"+((TakesScreenshot)BaseClass.driver).getScreenshotAs(OutputType.BASE64);
		// Handling Android/IOS Appium server skipping at runtime.
			if (result.getThrowable().toString().contains("IllegalStateException")) {
			System.setProperty(ESCAPE_PROPERTY, "false");
			
		//	Reporter.log("<br/><a href="+base64Screenshot+" class=\"highslide\" rel=\"highslide\"> <img src="+base64Screenshot+"  alt=\"Highslide JS\" title=\"Click to enlarge\" hight=\'100\' width=\'100\'/></a><br/>");
			/*Reporter.log("<br />" + "<a href=\"" + rootDir + "/screenshots/" + result.getName()
					+ result.getStartMillis() + ".png\" class=\"highslide\" rel=\"highslide\">" + " <img src=\""
					+ rootDir + "/screenshots/" + result.getName() + result.getStartMillis()
					+ ".png\"  alt=\"Highslide JS\" title=\"Click to enlarge\" hight=\'100\' width=\'100\'/> </a>"
					+ "<br/>");
			Reporter.log(
					"<a href=\"" + rootDir + "/screenshots/" + result.getName() + result.getStartMillis() + ".png\">"
					// + result.getName() + result.getStartMillis() + " </a>"
							+ "<br/>");*/

			// For RemoteWebDriver - Argument the RemoteWebDriver to WebDriver
			// to achieve the screenshot capturing.
			if (BaseClass.driver.getClass().getName().equalsIgnoreCase("org.openqa.selenium.remote.RemoteWebDriver")) {
				System.setProperty(ESCAPE_PROPERTY, "false");
				WebDriver augmentedDriver = new Augmenter().augment(BaseClass.driver);
				scrFile = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
			} else {
				System.setProperty(ESCAPE_PROPERTY, "false");
				scrFile = ((TakesScreenshot) BaseClass.driver).getScreenshotAs(OutputType.FILE);
			}
			try {
				System.setProperty(ESCAPE_PROPERTY, "false");
				FileUtils.copyFile(scrFile,
						new File(rootDir + "/screenshots/" + result.getName() + result.getStartMillis() + ".png"));
			} catch (IOException e) {
			
				e.printStackTrace();
			}

			Reporter.log("THROWABLE: " + result.getThrowable().toString());
			Reporter.log("THROWABLE: " + result.getThrowable().toString());

			BaseClass.result = result;

			//BaseClass.driver.quit();

		} else {
			System.setProperty(ESCAPE_PROPERTY, "false");
			if (!(result.getThrowable().toString().contains("UnreachableBrowserException: "))
					&& !(result.getThrowable().toString().contains("SessionNotFoundException"))) {
				System.setProperty(ESCAPE_PROPERTY, "false");
				/*Reporter.log("<br />" + "<a href=\"" + rootDir + "/screenshots/" + result.getName()
						+ result.getStartMillis() + ".png\" class=\"highslide\" rel=\"highslide\">" + " <img src=\""
						+ rootDir + "/screenshots/" + result.getName() + result.getStartMillis()
						+ ".png\"  alt=\"Highslide JS\" title=\"Click to enlarge\" hight=\'100\' width=\'100\'/> </a>"
						+ "<br/>");
				Reporter.log("<a href=\"" + rootDir + "/screenshots/" + result.getName() + result.getStartMillis()
						+ ".png\">" + result.getName() + result.getStartMillis() + " </a>" + "<br/>");*/
				// For RemoteWebDriver - Argument the RemoteWebDriver to
				// WebDriver
				// to achieve the screenshot capturing.
				if (BaseClass.driver.getClass().getName()
						.equalsIgnoreCase("org.openqa.selenium.remote.RemoteWebDriver")) {
					System.setProperty(ESCAPE_PROPERTY, "false");
					WebDriver augmentedDriver = new Augmenter().augment(BaseClass.driver);
					scrFile = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
				} else {
					scrFile = ((TakesScreenshot) BaseClass.driver).getScreenshotAs(OutputType.FILE);
				}
				try {
					FileUtils.copyFile(scrFile,
							new File(rootDir + "/screenshots/" + result.getName() + result.getStartMillis() + ".png"));
					System.setProperty(ESCAPE_PROPERTY, "false");
				} catch (IOException e) {
					System.setProperty(ESCAPE_PROPERTY, "false");
				
					e.printStackTrace();
				}
			}
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.setProperty(ESCAPE_PROPERTY, "false");
		//String base64Screenshot = "data:image/png;base64,"+((TakesScreenshot)BaseClass.driver).getScreenshotAs(OutputType.BASE64);
		Reporter.log("Test has been Skipped, because of : "+result.getThrowable().toString());
		try {
			System.setProperty(ESCAPE_PROPERTY, "false");
			//System.out.println("Am at SKIPPED");
			// Close all browsers
			//BaseClass.driver.quit();

		} catch (NullPointerException e) {
			System.setProperty(ESCAPE_PROPERTY, "false");
			result.setThrowable(e);
			e.printStackTrace();

		}

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// Reporter.log("HELLO " + result.getMethod().toString());
		System.setProperty(ESCAPE_PROPERTY, "false");
		//String base64Screenshot = "data:image/png;base64,"+((TakesScreenshot)BaseClass.driver).getScreenshotAs(OutputType.BASE64);
		try {
			System.setProperty(ESCAPE_PROPERTY, "false");
			/*Reporter.log("<br />" + "<a href=\"" + rootDir + "/screenshots/" + result.getName()
					+ result.getStartMillis() + ".png\" class=\"highslide\" rel=\"highslide\">" + " <img src=\""
					+ rootDir + "/screenshots/" + result.getName() + result.getStartMillis()
					+ ".png\"  alt=\"Highslide JS\" title=\"Click to enlarge\" hight=\'100\' width=\'100\'/> </a>"
					+ "<br/>");
			Reporter.log(
					"<a href=\"" + rootDir + "/screenshots/" + result.getName() + result.getStartMillis() + ".png\">"
					// + result.getName() + result.getStartMillis() + " </a>"
							+ "<br/>");*/
			
			//Reporter.log("<br/><a href="+base64Screenshot+" class=\"highslide\" rel=\"highslide\"> <img src="+base64Screenshot+"  alt=\"Highslide JS\" title=\"Click to enlarge\" hight=\'100\' width=\'100\'/></a><br/>");

			// For RemoteWebDriver - Argument the RemoteWebDriver to WebDriver
			// to achieve the screenshot capturing.
			if (BaseClass.driver.getClass().getName().equalsIgnoreCase("org.openqa.selenium.remote.RemoteWebDriver")) {
				System.setProperty(ESCAPE_PROPERTY, "false");
				WebDriver augmentedDriver = new Augmenter().augment(BaseClass.driver);
				scrFile = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);

			} else {
				System.setProperty(ESCAPE_PROPERTY, "false");
				scrFile = ((TakesScreenshot) BaseClass.driver).getScreenshotAs(OutputType.FILE);
			}
			FileUtils.copyFile(scrFile,
					new File(rootDir + "/screenshots/" + result.getName() + result.getStartMillis() + ".png"));

			//FileUtils.copyFile(scrFile,
					//new File(rootDir + "/screenshots/" + result.getName() + result.getStartMillis() + ".png"));

		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}