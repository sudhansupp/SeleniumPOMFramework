package com.demo.config;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.demo.library.CustomFunc;
import com.demo.util.EnvProperty;
import com.demo.util.JSONRead;
import com.demo.util.PropertyFileReader;


import uiFunctions.GUIFunctions;
import utils.ExtentReports.ExtentTestManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class BaseClass {
	public static WebDriver driver = null, driver2 = null, driver3 = null;
	public static Logger log;
	public String language;
	public static String driverName;
	public String siteDataValue;
	public String deviceDataValue;
	public String userDataValue;
	public String userCreationDataValue;
	public static String baseUrl;
	public Capabilities cap;
	// public CRSPNGFunctions obj_CRSPNGFunctions;

	public static ITestResult result;

	public static JSONRead jsonRead;
	public static EnvProperty envProperty;
	
	

	/**
	 * This method is responsible for invoking web driver, Navigating to the
	 * application URL, Setting up Implicit waits and maximizing the browser.
	 * 
	 * @throws Exception
	 */
	@Parameters({ "Browser", "Locale" })
	@BeforeTest()
	public void setUp(ITestContext testContext, String browser, String locale) throws Exception {
System.out.println("inside base class");
		// Initiate Logger
		log = Logger.getLogger(this.getClass().getName());
		PropertyConfigurator.configure("log4j.properties");

		// Assigning default value to ITestResult variable
		result = null;

		// Assigning locale value
		language = locale;
		Reporter.log("Locale->" + locale);
		log.info("Assigning locale value");

		// Assigning driver value
		driverName = browser;
		Reporter.log("Driver->" + browser);

	
		setEnJSONFile();

		// Assigning baseUrl value
		baseUrl = envProperty.getUrl();
		// baseUrl = url;
		Reporter.log("BaseURL->" + baseUrl);

		if (driverName.equalsIgnoreCase("CHROME")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
			String downloadFilepath = System.getProperty("user.dir") + "\\Downloads";

			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("download.default_directory", downloadFilepath);
			chromePrefs.put("safebrowsing.enabled", "true");

			ChromeOptions options = new ChromeOptions();
			HashMap<String, Object> chromeOptionsMap = new HashMap<String, Object>();
			options.setExperimentalOption("prefs", chromePrefs);
			options.addArguments("--test-type");
			options.addArguments("--disable-extensions"); // to disable browser extension popup
			// addded to disable warning (discard/keep)while downloading
			options.addArguments("--safebrowsing-disable-extension-blacklist");
			options.addArguments("--safebrowsing-disable-download-protection");
			options.setExperimentalOption("useAutomationExtension", false);// Added this line, because of getting error
																			// popup stating
																			// loading-of-unpacked-extensions-is-disabled-by-the-administrator

			DesiredCapabilities cap = DesiredCapabilities.chrome();
			cap.setCapability(ChromeOptions.CAPABILITY, chromeOptionsMap);
			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			cap.setCapability(ChromeOptions.CAPABILITY, options);
			cap.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
			cap.setCapability("chrome.switches", Arrays.asList("--incognito"));
			LoggingPreferences logPrefs = new LoggingPreferences();
			logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
			logPrefs.enable(LogType.BROWSER, Level.ALL);
			cap.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
			driver = new ChromeDriver(cap);
			driver.manage().deleteAllCookies();
			
		
		} else if (driverName.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\drivers\\IEDriverServer.exe");

			// DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
			//
			// ieCapabilities.setCapability("nativeEvents", false);
			// ieCapabilities.setCapability("unexpectedAlertBehaviour", "accept");
			// ieCapabilities.setCapability("ignoreProtectedModeSettings", true);
			// ieCapabilities.setCapability("disable-popup-blocking", true);
			// ieCapabilities.setCapability("enablePersistentHover", false);

			InternetExplorerOptions options = new InternetExplorerOptions();
			options.requireWindowFocus();
			driver = new InternetExplorerDriver(options);
			// driver = new InternetExplorerDriver(ieCapabilities);

			// driver = new InternetExplorerDriver();
			driver.manage().deleteAllCookies();
			System.out.println();
		}
		

		driver.get(baseUrl);
		cap = ((org.openqa.selenium.remote.RemoteWebDriver) driver).getCapabilities();
		driver.manage().window().maximize();
		
		
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  driver.manage().timeouts().pageLoadTimeout(240, TimeUnit.SECONDS);
		  driver.manage().timeouts().setScriptTimeout(120, TimeUnit.SECONDS);
		 
	}

	@AfterTest
	public void tearDown() throws Exception {

		/*
		 * extent.endTest(test); extent.flush();
		 */

		// driver.get(baseUrl);
		// obj_CRSPNGFunctions.fn_MS_Logout(driver);

		if (driver != null) {
			// Closing the driver once the suite execution is finished.
			driver.close();
			// Quitting the driver once the suite execution is finished.
			driver.quit();
		}

		// Kill the chromedriver.exe server process -if exists.
		if (driverName.equalsIgnoreCase("CHROME")) {
			Runtime.getRuntime().exec("taskkill /im chromedriver.exe /f");

		}
		CustomFunc.enterPageLoadingTimes();
	}

	@BeforeMethod
	public void methodLevelSetup(Method method) throws Exception {
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		/*
		 * Checks for exceptions like IllegalStateException or SkipException or
		 * SessionNotFoundException or UnreachableBrowserException, If found skips the
		 * test method
		 */
		if (result != null) {
			if ((result.getThrowable().toString().contains("IllegalStateException")
					|| result.getThrowable().toString().contains("SkipException")
					|| result.getThrowable().toString().contains("SessionNotFoundException")
					|| result.getThrowable().toString().contains("UnreachableBrowserException"))) {

				throw new SkipException("Skip Methods");
			}
		}

	}

	@AfterMethod
	public void methodLevelTearDown() throws Exception {
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		/*
		 * Checks for exceptions like IllegalStateException or SkipException or
		 * SessionNotFoundException or UnreachableBrowserException, If found skips the
		 * test method
		 */
		if (result != null) {
			if ((result.getThrowable().toString().contains("IllegalStateException")
					|| result.getThrowable().toString().contains("SkipException")
					|| result.getThrowable().toString().contains("SessionNotFoundException")
					|| result.getThrowable().toString().contains("UnreachableBrowserException"))) {

				throw new SkipException("Skip Methods");
			}
		}
	}

	@AfterClass
	public void classLevelTearDown() throws Exception {
		/*
		 * Checks for exceptions like IllegalStateException or SkipException or
		 * UnreachableBrowserException, If found skips the test cases
		 */
		if (result != null) {
			if ((result.getThrowable().toString().contains("IllegalStateException")
					|| result.getThrowable().toString().contains("SkipException")
					|| result.getThrowable().toString().contains("UnreachableBrowserException"))) {

				throw new SkipException("Skip Testcases");
			}
		}

	}
	
	public static void setEnJSONFile() throws Exception {
		jsonRead = new JSONRead();
		envProperty = jsonRead.getJSONData();
	}
	

}