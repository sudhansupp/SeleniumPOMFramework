package com.demo.library;

import static com.demo.util.PropertyFileReader.FileTransferDataProp;
import static com.demo.util.PropertyFileReader.ObjectRepoProp;
import static com.demo.util.PropertyFileReader.TextProp;
import static com.demo.util.PropertyFileReader.FileTransferDataProp;

import java.io.Writer;
import java.net.MalformedURLException;
import java.net.URL;
import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.Collator;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import javax.imageio.ImageIO;

import uiFunctions.GUIFunctions;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.asserts.SoftAssert;

import com.demo.config.BaseClass;

import com.demo.util.ExcelFunctions;
import com.demo.util.TestData;
import com.google.common.base.Function;
import com.jacob.com.LibraryLoader;
 

import autoitx4java.AutoItX;

import static com.demo.util.PropertyFileReader.ObjectRepoProp;
import uiFunctions.GUIFunctions;
import org.openqa.selenium.interactions.Actions;


public class CustomFunc {
	public static Logger log = Logger.getLogger(CustomFunc.class.getName());
	static Date now;
	static List<Long> homePageLoadingTime = new ArrayList<Long>();
	static List<Long> sitePageLoadingTime = new ArrayList<Long>();
	static List<Long> siteCreationPageLoadingTime = new ArrayList<Long>();
	static List<Long> applicationsPageLoadingTime = new ArrayList<Long>();
	static List<Long> applicationCreationPageLoadingTime = new ArrayList<Long>();
	static List<Long> connectToRemotePageLoadingTime = new ArrayList<Long>();
	static List<Long> deviceCreationPageLoadingTime = new ArrayList<Long>();
	static List<Long> fileTransferPageLoadingTime = new ArrayList<Long>();
	static List<Long> loginPageLoadingTime = new ArrayList<Long>();
	static List<Long> OperatorClientPageLoadingTime = new ArrayList<Long>();
	static List<Long> remoteUserPageLoadingTime = new ArrayList<Long>();
	static List<Long> siteDetailsPageLoadingTime = new ArrayList<Long>();
	static List<Long> userCreationPageLoadingTime = new ArrayList<Long>();
	static List<Long> activeConnectionTableLoadingTime = new ArrayList<Long>();
	static List<Long> systemLogTableLoadingTime = new ArrayList<Long>();
	static List<Long> userDetailsTableLoadingTime = new ArrayList<Long>();
	static List<Long> applicationTableLoadingTime = new ArrayList<Long>();
	static List<Long> switchRoleLoadingTime = new ArrayList<Long>();
	static List<Long> deviceCreationLoadingTime = new ArrayList<Long>();
	static List<Long> siteCreationLoadingTime = new ArrayList<Long>();
	static List<Long> searchedItemLoadingTime = new ArrayList<Long>();
	static List<Long> auditLogPageLoadingTime = new ArrayList<Long>();
	public static HashMap<String, String> hash_map;
	public static String cookie;
	public static Capabilities cap;

	static ExcelFunctions ef = new ExcelFunctions();

	public static Date getNow() {
		return now;
	}

	public static void setNow(Date now) {
		CustomFunc.now = now;
	}

	public static void addDeviceCreationLoadingTime(long time) {
		deviceCreationLoadingTime.add(time);
	}

	public static void searchedItemLoadingTime(long time) {
		searchedItemLoadingTime.add(time);
	}

	public static void addSiteCreationLoadingTime(long time) {
		siteCreationLoadingTime.add(time);
	}

	public static void addApplicationTableLoadingTime(long time) {
		applicationTableLoadingTime.add(time);
	}

	public static void addSwitchRoleLoadingTime(long time) {
		switchRoleLoadingTime.add(time);
	}

	public static void addUserDetailsTableLoadingTime(long time) {
		userDetailsTableLoadingTime.add(time);
	}

	public static void addActiveConnectionTableLoadingTime(long time) {
		activeConnectionTableLoadingTime.add(time);
	}

	public static void addSystemLogTableLoadingTime(long time) {
		systemLogTableLoadingTime.add(time);
	}

	public static void addHomePageLoadingTime(long time) {
		homePageLoadingTime.add(time);
	}

	public static void addSitePageLoadingTime(long time) {
		sitePageLoadingTime.add(time);
	}

	public static void addsiteCreationPageLoadingTime(long time) {
		siteCreationPageLoadingTime.add(time);
	}

	public static void addApplicationPageLoadingTime(long time) {
		applicationsPageLoadingTime.add(time);
	}

	public static void addApplicationCreationPageLoadingTime(long time) {
		applicationCreationPageLoadingTime.add(time);
	}

	public static void addConnectToRemotePageLoadingTime(long time) {
		connectToRemotePageLoadingTime.add(time);
	}

	public static void addDeviceCreationPageLoadingTime(long time) {
		deviceCreationPageLoadingTime.add(time);
	}

	public static void addFileTransferPageLoadingTime(long time) {
		fileTransferPageLoadingTime.add(time);
	}

	public static void addLoginPageLoadingTime(long time) {
		loginPageLoadingTime.add(time);
	}

	public static void addOperatorClientPageLoadingTime(long time) {
		OperatorClientPageLoadingTime.add(time);
	}

	public static void addRemoteUserPageLoadingTime(long time) {
		remoteUserPageLoadingTime.add(time);
	}

	public static void addSiteDetailsPageLoadingTime(long time) {
		siteDetailsPageLoadingTime.add(time);
	}

	public static void addUserCreationPageLoadingTime(long time) {
		userCreationPageLoadingTime.add(time);
	}

	public static void auditLogPageLoadingTime(long time) {
		auditLogPageLoadingTime.add(time);
	}

	public static void enterPageLoadingTimes() throws Exception {
		if (deviceCreationLoadingTime.size() > 0) {
			ef.insertPageLoadingTimeValuesInExcelSheet("LoadingTime", "DeviceCreationTime", deviceCreationLoadingTime);
		}
		if (searchedItemLoadingTime.size() > 0) {
			ef.insertPageLoadingTimeValuesInExcelSheet("LoadingTime", "SearchedItem", searchedItemLoadingTime);
		}

		if (siteCreationLoadingTime.size() > 0) {
			ef.insertPageLoadingTimeValuesInExcelSheet("LoadingTime", "SiteCreationTime", siteCreationLoadingTime);
		}
		if (homePageLoadingTime.size() > 0) {
			ef.insertPageLoadingTimeValuesInExcelSheet("LoadingTime", "HomePage", homePageLoadingTime);
		}
		if (sitePageLoadingTime.size() > 0) {
			ef.insertPageLoadingTimeValuesInExcelSheet("LoadingTime", "SitePage", sitePageLoadingTime);
		}

		if (siteCreationPageLoadingTime.size() > 0) {
			ef.insertPageLoadingTimeValuesInExcelSheet("LoadingTime", "SiteCreationPage", siteCreationPageLoadingTime);
		}

		if (applicationsPageLoadingTime.size() > 0) {
			ef.insertPageLoadingTimeValuesInExcelSheet("LoadingTime", "ApplicationPage", applicationsPageLoadingTime);
		}

		if (applicationCreationPageLoadingTime.size() > 0) {
			ef.insertPageLoadingTimeValuesInExcelSheet("LoadingTime", "ApplicationCreationPage",
					applicationCreationPageLoadingTime);
		}

		if (connectToRemotePageLoadingTime.size() > 0) {
			ef.insertPageLoadingTimeValuesInExcelSheet("LoadingTime", "ConnectToRemotePage",
					connectToRemotePageLoadingTime);
		}

		if (deviceCreationPageLoadingTime.size() > 0) {
			ef.insertPageLoadingTimeValuesInExcelSheet("LoadingTime", "DeviceCreationPage",
					deviceCreationPageLoadingTime);
		}

		if (fileTransferPageLoadingTime.size() > 0) {
			ef.insertPageLoadingTimeValuesInExcelSheet("LoadingTime", "FileTransferPage", fileTransferPageLoadingTime);
		}

		if (loginPageLoadingTime.size() > 0) {
			ef.insertPageLoadingTimeValuesInExcelSheet("LoadingTime", "LoginPage", loginPageLoadingTime);
		}

		if (OperatorClientPageLoadingTime.size() > 0) {
			ef.insertPageLoadingTimeValuesInExcelSheet("LoadingTime", "OperatorClientPage",
					OperatorClientPageLoadingTime);
		}
		if (switchRoleLoadingTime.size() > 0) {
			ef.insertPageLoadingTimeValuesInExcelSheet("LoadingTime", "SwitchRole", switchRoleLoadingTime);
		}

		if (remoteUserPageLoadingTime.size() > 0) {
			ef.insertPageLoadingTimeValuesInExcelSheet("LoadingTime", "RemoteUserPage", remoteUserPageLoadingTime);
		}

		if (siteDetailsPageLoadingTime.size() > 0) {
			ef.insertPageLoadingTimeValuesInExcelSheet("LoadingTime", "SiteDetailsPage", siteDetailsPageLoadingTime);
		}

		if (userCreationPageLoadingTime.size() > 0) {
			ef.insertPageLoadingTimeValuesInExcelSheet("LoadingTime", "UserCreationPage", userCreationPageLoadingTime);
		}

		if (activeConnectionTableLoadingTime.size() > 0) {
			ef.insertPageLoadingTimeValuesInExcelSheet("TableLoadingTimes", "ActiveConnectionsTable",
					activeConnectionTableLoadingTime);
		}

		if (systemLogTableLoadingTime.size() > 0) {
			ef.insertPageLoadingTimeValuesInExcelSheet("TableLoadingTimes", "SystemLogTable",
					systemLogTableLoadingTime);
		}
		if (userDetailsTableLoadingTime.size() > 0) {
			ef.insertPageLoadingTimeValuesInExcelSheet("TableLoadingTimes", "UserDetailsTable",
					userDetailsTableLoadingTime);
		}
		if (auditLogPageLoadingTime.size() > 0) {
			ef.insertPageLoadingTimeValuesInExcelSheet("TableLoadingTimes", "AuditLogTableLoadTime",
					auditLogPageLoadingTime);
		}

		if (applicationTableLoadingTime.size() > 0) {
			ef.insertPageLoadingTimeValuesInExcelSheet("TableLoadingTimes", "ApplicationsTable",
					applicationTableLoadingTime);
		}

	}

	/**
	 * Method Name: isElementPresent Description:Method to verify the Element
	 * 
	 * @param by     :Element locator
	 * @param driver :WebDriver
	 * @return true: if element is present, false: if element is not present
	 */
	public static boolean isElementPresent(By by, WebDriver driver) {
		try {
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			driver.findElement(by);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			return true;
		} catch (Exception e) {
			System.out.println("Exception while finding object ");
			GUIFunctions.updateReportWithMessage(driver, "FindIssue", "Either UIObject using property : " + by
					+ " is not able to identify or issue in existence or validating non exsistence of object as per scenario executing",
					"warning", true);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			return false;

		}
	}

	public static long getTimeDifference(Date oldTime, Date latestTime) {

		long diff = latestTime.getTime() - oldTime.getTime();
		System.out.println("TimeDifference in MilliSeconds = " + diff);
		System.out.println("TimeDifference in Seconds = " + diff / 1000);
		return diff;
	}

	/**
	 * Method Name: getRootDir Description: Method to get Root directory
	 * 
	 * @return :rootDir
	 */
	public static String getRootDir() {
		File path = new File("");
		String absPath = path.getAbsolutePath();
		File dir = new File(absPath);
		String rootDir = dir.getParent();
		return rootDir;

		// return absPath;
	}

	/**
	 * MethodName:generateTimeStamp Description: This method generates timestamp
	 * 
	 * @return newDate
	 */

	public static Date getCurrentTime() {

		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();

		return date;
	}

	public static String generateTimeStamp() {

		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();
		SimpleDateFormat stringDate = new SimpleDateFormat("ddMMyyhhmmss");

		String newDate = stringDate.format(date);

		return newDate;

	}

	/**
	 * This element verifies element is displayed or not
	 * 
	 * @param ele
	 * @param driver
	 * @return
	 * @throws Exception
	 */

	public static boolean isElementVisible(By ele, WebDriver driver) {
		try {
			driver.findElement(ele).isDisplayed();
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	/**
	 * This Function selects the radio button if it is .
	 * 
	 * @param driver : WebDriver instance.
	 */

	public static void selectRaidoButton(WebDriver driver, By by, String eleName) {
		// Initialize WebElement
		WebElement ele = driver.findElement(by);

		try {
			if (!ele.isSelected()) {
				ele.click();
			}
			System.out.println("Successfully selected the raido button '" + eleName + "'");
		}

		catch (NoSuchElementException e) {

			System.out.println("Exception element not present : " + eleName);
		}

	}



	/**
	 * Method Name: waitObjectToLoad Description: This function waits until the
	 * specific element to load
	 * 
	 * @param driver  : WebDriver instance
	 * @param by      :Element locator
	 * @param timeSec :time in seconds
	 */
	public static void waitObjectToLoad(WebDriver driver, By by, int timeSec) {

		WebDriverWait wait = new WebDriverWait(driver, timeSec);
		wait.until(ExpectedConditions.presenceOfElementLocated(by));

	}

	/**
	 * This methods wait till the Provided locator becomes Clickable
	 * 
	 * @param driver  : WebDriver instance
	 * @param by      :Element locator
	 * @param timeSec :time in seconds
	 */
	public static void waitObjectToBecomeClickable(WebDriver driver, By by, int timeSec) {

		WebDriverWait wait = new WebDriverWait(driver, timeSec);

		wait.until(ExpectedConditions.elementToBeClickable(by));

	}

	/**
	 * This methods wait till the Provided Locator Becomes invisible, for Example,
	 * can use for Loading icon to disappear.
	 * 
	 * @param driver  : WebDriver instance
	 * @param by      :Element locator
	 * @param timeSec :time in seconds
	 */
	public static void waitTillLoadingObjectDisappears(WebDriver driver, By by, int timeSec) {

		try {
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(driver, timeSec);
			wait.until(ExpectedConditions.invisibilityOf(driver.findElement(by)));
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		} catch (Exception e) {
			System.out.println("No loader appears");
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
	}

	public static void waitTillLoadingObjectDisappears(WebDriver driver, int timeSec) {
		By by = By.xpath(ObjectRepoProp.getProperty("Loader_Xpath"));
		try {
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(driver, timeSec);
			wait.until(ExpectedConditions.invisibilityOf(driver.findElement(by)));
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		} catch (Exception e) {
			System.out.println("No loader appears");
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
	}

	/**
	 * @method waitTillLoadingObjectToAppears(WebDriver driver, By by, int timeSec)
	 * @param driver
	 * @param by
	 * @param timeSec
	 * @return boolean
	 */
	public static boolean waitTillLoadingObjectToAppears(WebDriver driver, By by, int timeSec) {

		try {
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(driver, timeSec);
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(by)));
			driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
			Thread.sleep(2000);
			return true;
		} catch (Exception e) {
			GUIFunctions.updateReportWithMessage(driver, "issue",
					"Either issue in identifying visibility of desired object by using : " + by
							+ " or check for any other issue",
					"warning", true);
			driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
			return false;
		}
	}



	public static List<String> getFiles(String path) {

		List<String> results = new ArrayList<String>();

		File[] files = new File(path).listFiles();
		// If this pathname does not denote a directory, then listFiles() returns null.

		for (File file : files) {
			System.out.println(file.getName());
			if (file.getName().contains("zip")) {
				results.add(file.getName());
			}
		}
		return results;
	}

	public static List<String> getFiles(String path, String searchTerm) {

		List<String> results = new ArrayList<String>();

		File[] files = new File(path).listFiles();
		// If this pathname does not denote a directory, then listFiles() returns null.

		for (File file : files) {
			if (file.getName().contains(searchTerm)) {
				results.add(file.getName());
			}
		}
		return results;
	}

	public static void createConfigFile(String mailbox, String urn, String deviceType, String path) throws Exception {
		String newPath = path.replace("\\", "\\\\");
		List<String> lines = Arrays.asList(" mtsEndpointSettings {", "  mailbox = \"" + mailbox + "\"",
				"   urn = \"" + urn + "\"", "   clientType = \"" + deviceType + "\"",
				"   clientRootDirectory = \"" + newPath + "\"", "}");

		List<String> results = new ArrayList<String>();
		File[] files = new File(path).listFiles();
		// If this pathname does not denote a directory, then listFiles() returns null.
		for (File file : files) {

			results.add(file.getName());
		}

		Path file = Paths.get(path + "\\" + results.get(0) + "\\conf\\application.conf");
		Files.write(file, lines, Charset.forName("UTF-8"));
	}

	
	
	public static void createFile(String fileName) {
		try {
			PrintWriter writer = new PrintWriter(fileName, "UTF-8");
			writer.println("The first line");
			writer.println("The second line");
			writer.close();
		} catch (IOException e) {
			// do something
		}
	}

	public static void checkFilePresense(String path, String fileName) {

		Boolean flag = false;
		File[] files = new File(path).listFiles();
		// If this pathname does not denote a directory, then listFiles() returns null.

		for (File file : files) {
			if (file.isFile() && file.getName().equalsIgnoreCase(fileName)) {
				flag = true;
				break;
			}
		}
		Assert.assertTrue(flag, "File is not Transfered properly");
	}


	public static String getStringofGivenCharLength(int len) {
		// String output = "a";
		char[] chars = "abcdefghijklmnopqrstuvwxyz1234567890".toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < len; i++) {
			char c = chars[random.nextInt(chars.length)];
			sb.append(c);
		}
		String output = sb.toString();
		return output;
	}



	
	
	public static boolean checkTheGivenStringInFile(String path, String valueToBeFound) {
		File fileToRead = new File(path);
		boolean flag = false;
		try (FileReader fileStream = new FileReader(fileToRead);
				BufferedReader bufferedReader = new BufferedReader(fileStream)) {
			String fullread = "";
			String line = null;

			while ((line = bufferedReader.readLine()) != null) {
				// do something with line
				// System.out.println("@@@@@@@@@@@@@ inside While");
				fullread = fullread + line;
			}
			if (fullread.contains(valueToBeFound)) {
				flag = true;
			}
			System.out.println(fullread);

		} catch (FileNotFoundException ex) {
			// exception Handling
		} catch (IOException ex) {
			// exception Handling
		}

		return flag;
	}

	public static void invokeRemoteDesktop(String RdpFileName) throws Exception {

		System.out.println("exe");
		String cmd = "mstsc " + "\"" + RdpFileName + "\"";
		Runtime r = Runtime.getRuntime();
		Process pr = r.exec(cmd);
		System.out.println("exe done");

	}

	public static void deleteAllFilesInGivenDirectory(String folderPath) throws Exception {
		try {
			System.out.println();
			// FileUtils.cleanDirectory(folderName);
			File dir = new File(folderPath);
			for (File file : dir.listFiles()) {
				/*
				 * System.out.println(file.getName()); System.out.println(file.isFile());
				 * System.out.println(file.isDirectory()); //if (!file.isDirectory())
				 * file.delete();
				 */
				delete(file);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * @method deleteAllFilesAndFoldersIncludingGivenDirectory(String folderPath)
	 * @param folderPath
	 * @throws Exception
	 */
	public static void deleteAllFilesAndFoldersIncludingGivenDirectory(String folderPath) throws Exception {
		try {

			File dir = new File(folderPath);
			for (File file : dir.listFiles()) {
				delete(file);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * @method delete(File f)
	 * @param f
	 * @throws IOException
	 */
	public static void delete(File f) throws IOException {
		if (f.isDirectory()) {
			for (File c : f.listFiles())
				delete(c);
		}
		if (!f.delete())
			throw new FileNotFoundException("Failed to delete file: " + f);
	}

	/**
	 * @method getDateInddMMyyyyFormat()
	 * @return String - date in dd/MM/yyyy format
	 */
	public static String getTodayDateInddMMyyyyFormat() {

		String today;
		Date date = Calendar.getInstance().getTime();

		// Display a date in day, month, year format
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		today = formatter.format(date);
		System.out.println("Today : " + today);

		return today;
	}

	/**
	 * isValidDateFormat(String format, String value)
	 * 
	 * @param format
	 * @param dateValue
	 * @return boolean
	 */
	public static boolean isValidDateFormat(String format, String dateValue) {
		Date date = null;
		boolean flag = false;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			sdf.setLenient(false);
			date = sdf.parse(dateValue);
			if (dateValue.equals(sdf.format(date))) {
				flag = true;
			}
		} catch (ParseException ex) {
			System.out.print("Exception in isValidFormat() : ");
			ex.printStackTrace();
		}
		return flag;
	}

	/**
	 * @method getCurrentDateInRequiredTimeZoneWithRequiredFormat(String
	 *         timeZone,String format)
	 * @param timeZone
	 * @param format
	 * @return String
	 */
	public static String getCurrentDateInRequiredTimeZoneWithRequiredFormat(String timeZone, String format) {
		// **************Code to get current time in UTC TimeZone*****************
		String localDateandTimeInUTCTimeZone = "";
		Calendar cal = Calendar.getInstance();
		Date today = cal.getTime();
		SimpleDateFormat dateFormatGmt = new SimpleDateFormat(format);
		dateFormatGmt.setTimeZone(TimeZone.getTimeZone(timeZone));
		localDateandTimeInUTCTimeZone = dateFormatGmt.format(today);
		System.out.println("LocalDateandTime in UTC TimeZone: " + localDateandTimeInUTCTimeZone);
		return localDateandTimeInUTCTimeZone;
	}

	
	public static boolean validateTooltip(WebDriver driver, By infoicon, By tooltip, String expectedtooltiptext) {

		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(infoicon)).perform();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return GUIFunctions.getText(driver, tooltip, "tool tip").contains(expectedtooltiptext);
	}

	public static WebDriver instanciateSecondWebDriver(String driverName, String baseUrl, WebDriver driver)
			throws Exception {

		if (driverName.equalsIgnoreCase("CHROME")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
			String downloadFilepath = System.getProperty("user.dir") + "\\Downloads";

			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("download.default_directory", downloadFilepath);
			ChromeOptions options = new ChromeOptions();
			HashMap<String, Object> chromeOptionsMap = new HashMap<String, Object>();
			options.setExperimentalOption("prefs", chromePrefs);
			options.addArguments("--test-type");
			options.addArguments("--disable-extensions"); // to disable browser extension popup
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
			cap.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
			driver = new ChromeDriver(cap);
			driver.manage().deleteAllCookies();
		} else if (driverName.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\drivers\\IEDriverServer.exe");

			DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();

			ieCapabilities.setCapability("nativeEvents", false);
			ieCapabilities.setCapability("unexpectedAlertBehaviour", "accept");
			ieCapabilities.setCapability("ignoreProtectedModeSettings", true);
			ieCapabilities.setCapability("disable-popup-blocking", true);
			ieCapabilities.setCapability("enablePersistentHover", false);

			InternetExplorerOptions options = new InternetExplorerOptions();
			options.requireWindowFocus();
			driver = new InternetExplorerDriver(options);
			// driver = new InternetExplorerDriver(ieCapabilities);

			// driver = new InternetExplorerDriver();
			driver.manage().deleteAllCookies();
			// Invoke FF Driver
		} else {
			// Invoke FF Driver

			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\drivers\\geckodriver.exe");

			driver = new FirefoxDriver();

			// driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		}
		driver.get(baseUrl);
		Capabilities cap = ((org.openqa.selenium.remote.RemoteWebDriver) driver).getCapabilities();
		driver.manage().window().maximize();

		// CustomFunc.performPkiLogin();
		/*
		 * try { driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 * driver.findElement(By.xpath("//login")); } catch (Exception e) { //
		 * if(baseUrl.split("://")[0].equals("http")) System.out.println("Inside if");
		 * // CustomFunc.performPkiLogin(); CustomFunc.performEntitlementLogin(driver,
		 * "anil.kumarreddy@siemens.com", "Jakr@8690"); }
		 */ driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;

	}

	/**
	 * @method getPastDate(String monthOryear, int number)
	 * @param monthOryear
	 * @param number
	 * @return String
	 */
	public static String getPastDate(String monthOryear, int number) {
		String date = "";
		SimpleDateFormat formatter;

		try {
			Calendar cal = Calendar.getInstance();
			if (monthOryear.equalsIgnoreCase("year"))
				cal.add(Calendar.YEAR, -number);
			else if (monthOryear.equalsIgnoreCase("month"))
				cal.add(Calendar.MONTH, -number);
			Date nextYear = cal.getTime();
			formatter = new SimpleDateFormat("dd/MM/yyyy");
			date = formatter.format(nextYear);
			System.out.println("Past Date: " + date);
		} catch (Exception e) {
			System.out.println("Exception in getPastDate : " + e.getMessage());
		}
		return date;
	}

	/**
	 * @method getFutureDate(String monthOryear, int number)
	 * @param monthOryear
	 * @param number
	 * @return String
	 */
	public static String getFutureDate(String monthOryear, int number) {
		String date = "";
		SimpleDateFormat formatter;

		try {
			Calendar cal = Calendar.getInstance();
			if (monthOryear.equalsIgnoreCase("year"))
				cal.add(Calendar.YEAR, number);
			else if (monthOryear.equalsIgnoreCase("month"))
				cal.add(Calendar.MONTH, number);
			Date nextYear = cal.getTime();
			formatter = new SimpleDateFormat("dd/MM/yyyy");
			date = formatter.format(nextYear);
			System.out.println("Past Date: " + date);
		} catch (Exception e) {
			System.out.println("Exception in getPastDate : " + e.getMessage());
		}
		return date;
	}

	/**
	 * @method selectDateFromDTP(WebDriver driver,String startDateOrExpirationDate,
	 *         String year, String month, String day)
	 * @param startDateORExpiryDate
	 * @param year
	 * @param month
	 * @param day
	 * @return String
	 */
	public static String selectDateFromDTP(WebDriver driver, String startDateOrExpirationDate, String year,
			String month, String day) {

		String actMonth, actYear, actDay, tempToReplace = "", sDate = "";
		String strStartingYearInView = "", strEndingYearInView = "", monthInMonthView, yearInYearView, dayInDayView;
		int intStartingYearInView, intEndingYearInView, intYear;

		WebElement monthView, yearView, dayView;
		List<WebElement> monthRows, monthCols, yearRows, yearCols, dayRows, dayCols;
		boolean yearVisible = false, monthSelection = false, yearSelection = false, daySelection = false;
		By inputField = null;

		if (startDateOrExpirationDate.equalsIgnoreCase("StartDate")) {
			tempToReplace = "mydateStart";
			inputField = By.xpath(ObjectRepoProp.getProperty("StartDateTextBox_Xpath"));
			;
		} else if (startDateOrExpirationDate.equalsIgnoreCase("ExpirationDate")) {
			tempToReplace = "mydateExp";
			inputField = By.xpath(ObjectRepoProp.getProperty("ExpirationDateTextBox_Xpath"));
		} else {
			Assert.fail(
					"Please provide the valid test data as either StartDate or ExpirationDate as argument for startDateORExpiryDate");
		}

		By datePickerIcon = By.xpath("//my-date-picker[@formcontrolname='" + tempToReplace
				+ "']//span[@class='mydpicon icon-mydpcalendar']");
		By datePickerVisibility = By.xpath("//my-date-picker[@formcontrolname='" + tempToReplace
				+ "']//div[@class='selector selectorarrow selectorarrowleft']");
		By currentSelectedMonth = By.xpath("//my-date-picker[@formcontrolname='" + tempToReplace
				+ "']//button[@class='headerlabelbtn monthlabel']");
		By currentSelectedYear = By.xpath("//my-date-picker[@formcontrolname='" + tempToReplace
				+ "']//button[@class='headerlabelbtn yearlabel']");
		By currentSelectedDay = By
				.xpath("//my-date-picker[@formcontrolname='" + tempToReplace + "']//span[@class='markcurrday']");
		By upArrowOfYearView = By.xpath("//my-date-picker[@formcontrolname='" + tempToReplace
				+ "']//table[@class='yeartable']//button[contains(@class,'icon-mydpup')]");
		By downArrowOfYearView = By.xpath("//my-date-picker[@formcontrolname='" + tempToReplace
				+ "']//table[@class='yeartable']//button[contains(@class,'icon-mydpdown')]");
		By monthViewToSelect = By
				.xpath("//my-date-picker[@formcontrolname='" + tempToReplace + "']//table[@class='monthtable']");
		By yearViewToSelect = By
				.xpath("//my-date-picker[@formcontrolname='" + tempToReplace + "']//table[@class='yeartable']");
		By dayViewToSelect = By
				.xpath("//my-date-picker[@formcontrolname='" + tempToReplace + "']//table[@class='caltable']");

		try {

			// start date is resetting to today's date
			// clickOnNowAndValidateStartDate();

			GUIFunctions.clickElement(driver, datePickerIcon, startDateOrExpirationDate + " Date picker");

			if (driver.findElement(datePickerVisibility).isDisplayed()) {
				actMonth = driver.findElement(currentSelectedMonth).getText();
				System.out.println("Selected current actMonth : " + actMonth);

				actYear = driver.findElement(currentSelectedYear).getText();
				System.out.println("Selected current actYear : " + actYear);

				// actDay = driver.findElement(currentSelectedDay).getText();
				// System.out.println("Selected current actDay : "+actDay);

				// ************************Month selection************************
				if (!actMonth.equalsIgnoreCase(month)) {
					driver.findElement(currentSelectedMonth).click();
					if (driver.findElement(monthViewToSelect).isDisplayed()) {
						monthView = driver.findElement(monthViewToSelect);
						monthRows = monthView.findElements(By.tagName("tr"));
						System.out.println("Total rows in month view : " + monthRows.size());

						// looping through the visible months to select desired month
						for (int j = 0; j < monthRows.size(); j++) {
							monthCols = monthRows.get(j).findElements(By.tagName("td"));
							System.out.println("Total cols in month view of row : " + monthCols.size());
							for (int i = 0; i < monthCols.size(); i++) {
								monthInMonthView = monthCols.get(i).getText();
								System.out.println("monthInMontView : " + monthInMonthView);

								if (monthInMonthView.equalsIgnoreCase(month)) {
									monthCols.get(i).click();
									monthSelection = true;
									break;
								}
							} // Inner for loop
							if (monthSelection)
								break;// breaking outer for loop
						} // outer for loop

						if (!monthSelection) {
							GUIFunctions.updateReportWithMessage(driver, "monthSelection",
									"Either issue in finding month in month view or given input month name : " + month
											+ " is wrong",
									"fail", true);
							Assert.fail("Either issue in finding month in month view or given input month name : "
									+ month + " is wrong");
						}
					}
				} else {
					monthSelection = true;
				}
				// *********************************************************************

				// ******************************Year selection************************
				if (!actYear.equals(year)) {
					int clicks = 0;
					driver.findElement(currentSelectedYear).click();
					if (driver.findElement(yearViewToSelect).isDisplayed()) {
						do {
							clicks++;
							yearView = driver.findElement(yearViewToSelect);
							yearRows = yearView.findElements(By.tagName("tr"));
							System.out.println("Total rows in year view : " + yearRows.size());

							// Getting first and last year showing in the year view to check whether desired
							// year is in the view or not
							strStartingYearInView = yearRows.get(1).findElements(By.tagName("td")).get(0).getText();
							int colSize = yearRows.get(yearRows.size() - 2).findElements(By.tagName("td")).size();
							strEndingYearInView = yearRows.get(yearRows.size() - 2).findElements(By.tagName("td"))
									.get(colSize - 1).getText();

							// Converting years from string to int to compare
							intStartingYearInView = Integer.parseInt(strStartingYearInView);
							intEndingYearInView = Integer.parseInt(strEndingYearInView);
							intYear = Integer.parseInt(year);

							// Moving up or down to make visible of desired year i the year view
							if (intYear < intStartingYearInView) {
								GUIFunctions.clickElement(driver, upArrowOfYearView, "upArrowOfYearView");
							} else if (intYear > intEndingYearInView) {
								GUIFunctions.clickElement(driver, downArrowOfYearView, "downArrowOfYearView");
							} else {
								yearVisible = true;
							}

							// Breaking the loop after 5 clicks for safer side
							if (clicks == 5)
								break;

						} while (!yearVisible);

						if (yearVisible) {
							// looping through the visible years to select desired year
							for (int j = 1; j < yearRows.size() - 1; j++) {
								yearCols = yearRows.get(j).findElements(By.tagName("td"));
								System.out.println("Total cols in year view of row : " + j + " : " + yearCols.size());

								for (int i = 0; i < yearCols.size(); i++) {
									yearInYearView = yearCols.get(i).getText();
									System.out.println("yearInMontView : " + yearInYearView);

									if (yearInYearView.equals(year)) {
										yearCols.get(i).click();
										yearSelection = true;
										break;
									}
								} // Inner for loop
								if (yearSelection)
									break;
							} // outer for loop

							if (!yearSelection) {
								GUIFunctions.updateReportWithMessage(driver, "yearSelection",
										"Either issue in finding year in year view or given input year name : " + year
												+ " is wrong",
										"fail", true);
								Assert.fail("Either issue in finding year in year view or given input year : " + year
										+ " is wrong");
							}
						} else {
							GUIFunctions.updateReportWithMessage(driver, "yearSelectionIssue",
									"Either after several clicks also expected year is not visible or issue in finding the required object",
									"fail", true);
							Assert.fail(
									"Either after several clicks also expected year is not visible or issue in finding the required object");
						}
					}
				} else
					yearSelection = true;
				// *********************************************************************

				// ******************************Day selection************************
				if (driver.findElement(dayViewToSelect).isDisplayed()) {
					dayView = driver.findElement(dayViewToSelect);
					dayRows = dayView.findElements(By.tagName("tr"));
					System.out.println("Total rows in day view : " + dayRows.size());
					for (int j = 1; j < dayRows.size(); j++) {
						dayCols = dayRows.get(j).findElements(By.tagName("td"));
						System.out.println("Total cols in day view of row : " + j + " : " + dayCols.size());

						for (int i = 0; i < dayCols.size(); i++) {
							dayInDayView = dayCols.get(i).getText();
							String monthState = dayCols.get(i).findElement(By.tagName("div")).getAttribute("class");
							System.out.println("monthState " + monthState);
							System.out.println("dayIndayView : " + dayInDayView);

							if (monthState.contains("currmonth")) {
								if (dayInDayView.equals(day)) {
									dayCols.get(i).click();
									daySelection = true;
									break;
								}
							}
						} // Inner for loop

						if (daySelection)
							break;
					} // outer for loop

					if (!daySelection) {
						System.out.println("Either issue in finding day in calender day view or given input day : "
								+ day + " is wrong");
						GUIFunctions.updateReportWithMessage(driver, "daySelectionIssue",
								"Either issue in finding day in calender day view or given input day : " + day
										+ " is wrong",
								"fail", true);
						Assert.fail("Either issue in finding day in calender day view or given input day : " + day
								+ " is wrong");
					}
				}
				// *********************************************************************

				if (monthSelection && yearSelection && daySelection) {
					driver.findElement(datePickerIcon).click();

					actMonth = driver.findElement(currentSelectedMonth).getText();
					if (actMonth.equalsIgnoreCase(month)) {
						GUIFunctions.updateReportWithMessage(driver, "monthSelection",
								"Successfully selected month as : " + month, "pass", false);
					} else {
						GUIFunctions.updateReportWithMessage(driver, "monthSelectionIssue",
								"Expected month to select is : " + month + ", but actual selected month is : "
										+ actMonth,
								"fail", true);
						Assert.fail("Expected month to select is : " + month + ", but actual selected month is : "
								+ actMonth);
					}

					actYear = driver.findElement(currentSelectedYear).getText();
					if (actYear.equals(year)) {
						GUIFunctions.updateReportWithMessage(driver, "yearSelection",
								"Successfully selected year as : " + year, "pass", false);
					} else {
						GUIFunctions.updateReportWithMessage(driver, "yearSelectionIssue",
								"Expected year to select is : " + year + ", but actual selected year is : " + actYear,
								"fail", true);
						Assert.fail(
								"Expected year to select is : " + year + ", but actual selected year is : " + actYear);
					}

					driver.findElement(datePickerIcon).click();

					sDate = driver.findElement(inputField).getAttribute("value");
					System.out.println("Date : " + sDate);
					String arrDate[] = sDate.split("/");
					sDate = arrDate[0];
					if (sDate.equals(day)) {
						GUIFunctions.updateReportWithMessage(driver, "daySelection",
								"Successfully selected day as : " + day, "pass", false);
					} else {
						GUIFunctions.updateReportWithMessage(driver, "daySelectionIssue",
								"Expected day to select is : " + day + ", but actual selected day is : " + sDate,
								"fail", true);
						Assert.fail("Expected day to select is : " + day + ", but actual selected day is : " + sDate);
					}
				}
			} else {
				GUIFunctions.updateReportWithMessage(driver, "datePickerVisibilityIssue",
						startDateOrExpirationDate + " date picker calender is not showing on clicking calender icon",
						"fail", true);
				Assert.fail(
						startDateOrExpirationDate + " date picker calender is not showing on clicking calender icon");
			}
		} catch (Exception e) {
			System.out.println("Exception in selectDateFromDTP() : " + e.getLocalizedMessage());
		}

		return sDate;
	}

	public static void waitTillLoadingObjectDisapperarsNew(WebDriver driver, int timeSec) {
		By Loader = By.xpath(ObjectRepoProp.getProperty("Loader_Xpath"));
		try {
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(driver, timeSec);
			wait.until(ExpectedConditions.invisibilityOf(driver.findElement(Loader)));
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println("No loader appears : " + e.getMessage());
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
	}

	

	public static boolean createDirectory(String path) {
		boolean flag = false;

		try {
			Thread.sleep(2000);
			Files.createDirectories(Paths.get(path));
			flag = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	
	/**
	 * @method
	 * @return
	 */
	public static void modifyFile(String filepath, String oldString, String newString) {
		File fileToBeModified = new File(filepath);

		String oldContent = "";

		BufferedReader reader = null;

		FileWriter writer = null;

		try {
			reader = new BufferedReader(new FileReader(fileToBeModified));

			// Reading all the lines of input text file into oldContent

			String line = reader.readLine();

			while (line != null) {
				oldContent = oldContent + line + System.lineSeparator();

				line = reader.readLine();
			}

			// Replacing oldString with newString in the oldContent

			String newContent = oldContent.replaceAll(oldString, newString);

			// Rewriting the input text file with newContent

			writer = new FileWriter(fileToBeModified);

			writer.write(newContent);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// Closing the resources

				reader.close();

				writer.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static boolean validateTwoFilesAreEqual(File source, File target) {
		boolean isTwoEqual = false;
		try {
			isTwoEqual = FileUtils.contentEquals(source, target);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return isTwoEqual;

	}

	public static void deleteAFolder(String path) {
		try {
			FileUtils.deleteDirectory(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void deleteAFile(String path) {
		try {
			FileUtils.forceDelete(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void invokeCmd(String cmdToRun) throws Exception {

		System.out.println("exe");
		String cmd = cmdToRun;
		Runtime r = Runtime.getRuntime();
		Process pr = r.exec("cmd /c " + cmd);
		System.out.println("exe done");

	}

	public static void updateConfigFile(String Filepath, String Pathoftransfer) {
		String newPath = Pathoftransfer.replace("\\", "\\\\");
		File fileToBeModified = new File(Filepath + "\\application.conf");
		String oldContent = "";

		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(fileToBeModified));
			String line = reader.readLine();
			while (line != null) {
				oldContent = oldContent + line + System.lineSeparator();
				line = reader.readLine();
			}

			String newContent = oldContent.replace("D:\\\\", newPath);

			FileWriter writer;
			writer = new FileWriter(fileToBeModified);
			writer.write(newContent);
			reader.close();
			writer.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void validateHighlightedColumn(WebDriver driver, String Column) {

		By by = null;
		if (Column.equalsIgnoreCase("Time")) {
			by = By.xpath("(//div[contains(@class,'column-header-title') and contains(text(),'" + Column
					+ "')])[1]/parent::div");
		} else if (Column.equalsIgnoreCase("Local Time")) {
			by = By.xpath("(//div[contains(@class,'column-header-title') and contains(text(),'" + Column
					+ "')])[2]/parent::div");
		} else {
			by = By.xpath(
					"//div[contains(@class,'column-header-title') and contains(text(),'" + Column + "')]/parent::div");

		}
		if (isElementPresent(by, driver)) {
			if (GUIFunctions.getAttribute(driver, by, Column, "class").contains("highlight-header")) {
				GUIFunctions.updateReportWithMessage(driver, "Highlighted Column",
						Column + "is highlighted as expected as Default Column", "pass", true);
			} else {
				GUIFunctions.updateReportWithMessage(driver, "Highllighted Column",
						Column + "is not highlighted. Please check", "fail", true);
				Assert.fail("FAILURE!The highlighted column is not the Time Stamp. Please check the reports");
			}
		} else {
			GUIFunctions.updateReportWithMessage(driver, "Highlighted Column",
					Column + "is not available. Please check", "fail", true);
			Assert.fail("FAILURE!The highlighted column is not the Time Stamp. Please check the reports");
		}
	}

	public static void createFolderAndFiles(String Location, String FileName) throws InterruptedException {
		Location = Location + "\\" + FileName + "Folder\\";
		File f = new File(Location);

		if (f.exists()) {
			f.delete();
			System.out.println("Deleted previous folder");
			f.mkdir();
		} else {
			f.mkdir();
		}
		// FileName = FileName+CustomFunc.getRandomText(Type.NUMBER, 3);
		File newFile = new File(Location + "\\" + FileName + "_text1.txt");
		// Create text file

		Writer writer = null;
		try {
			newFile.createNewFile();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(newFile), "utf-8"));
			writer.write("Text File for transfer");
		} catch (IOException ex) {
			// Report
		} finally {
			try {
				writer.close();
			} catch (Exception ex) {
				/* ignore */}
		}

		/// create excel file file
		File myExcelFile = new File(Location + "\\" + FileName + "Excel.xls");

		try {
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(myExcelFile), "utf-8"));
			writer.write("Text File for transfer");
		} catch (IOException ex) {
			// Report
		} finally {
			try {
				writer.close();
			} catch (Exception ex) {
				/* ignore */}
		}

		// create doc file

		File myDocFile = new File(Location + "\\" + FileName + "_doc.doc");

		try {
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(myDocFile), "utf-8"));
			writer.write("Text File for transfer");
		} catch (IOException ex) {
			// Report
		} finally {
			try {
				writer.close();
			} catch (Exception ex) {
				/* ignore */}
		}

		// create exe file

		File myExeFile = new File(Location + "\\" + FileName + "_exe.exe");

		try {
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(myExeFile), "utf-8"));
			writer.write("Text File for transfer");
		} catch (IOException ex) {
			// Report
		} finally {
			try {
				writer.close();
			} catch (Exception ex) {
				/* ignore */}
		}

		// create

		File myJpgFile = new File(Location + "\\" + FileName + "_jpg.jpg");
		try {

			BufferedImage image = new BufferedImage(963, 963, BufferedImage.TYPE_INT_ARGB);
			ImageIO.write(image, "jpg", myJpgFile);
			System.out.println("Writing complete.");
		} catch (IOException ex) {
			System.out.println("Error: " + ex);
		}

		// create

	}

	/**
	 * 
	 * @method isFileDownloaded(String downloadPath, String fileName)
	 * 
	 * @param downloadPath
	 * 
	 * @param fileName
	 * 
	 * @return boolean

	 */
	public static boolean isFileDownloaded(String downloadPath, String fileName) {

		boolean flag = false;
		File dir = new File(downloadPath);
		File[] dir_contents = dir.listFiles();
		for (int i = 0; i < dir_contents.length; i++) {
			if (dir_contents[i].getName().contains(fileName))
				Reporter.log(
						"File name contains : " + fileName + " has been downloaded successfully to proceed further");
			return flag = true;
		}
		return flag;
	}

	public static void performPkiLogin(WebDriver driver, String PKIPin) throws Exception {
		Robot rb = new Robot();
		Thread.sleep(3000);
		if (BaseClass.driverName.equalsIgnoreCase("IE")) {
			for (int i = 0; i < 13; i++) {
				rb.keyPress(KeyEvent.VK_TAB);
				rb.keyRelease(KeyEvent.VK_TAB);
				Thread.sleep(500);
			}

			Thread.sleep(2000);
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);

		} else if (BaseClass.driverName.equalsIgnoreCase("CHROME")) {
			for (int i = 0; i < 8; i++) {
				rb.keyPress(KeyEvent.VK_TAB);
				rb.keyRelease(KeyEvent.VK_TAB);
				Thread.sleep(500);
			}

			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);

			Thread.sleep(5000);
			Reporter.log("<br/>Successfully Clicked on Authentication Page Login Button<br/>");
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
		}

		Thread.sleep(10000);
		// Enter user name by ctrl-v
		StringSelection username = new StringSelection(PKIPin);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(username, null);
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);

		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Reporter.log("<br/>\"Successfully Clicked on OK Button after entring PKI pin\"<br/>");
		// GUIFunctions.updateReportWithMessage(driver, "PKILogin1", "Successfully
		// Clicked on OK Button after entring PKI pin", "pass", true);
	}

	public static boolean validateDropDownValues(By by, WebDriver driver, String DropDownName,
			ArrayList<String> expectedValueList) {

		Select select = new Select(driver.findElement(by));
		List<WebElement> list = select.getOptions();

		List<String> actualValues = new ArrayList<String>();
		for (WebElement ele : list) {
			actualValues.add(ele.getText());
		}

		if (actualValues.equals(expectedValueList)) {

			GUIFunctions.updateReportWithMessage(driver, DropDownName + "_Values_Correct",
					"SUCCESS! " + DropDownName + " vlaues are correct", "pass", true);
			return true;
		}

		else {
			GUIFunctions.updateReportWithMessage(driver, DropDownName + "_Values_Incorrect",
					"SUCCESS! " + DropDownName + " vlaues are not correct", "fail", true);
			return false;
		}

	}

	/**
	 * @method this returns random number without zero
	 * @param
	 * @return
	

	 */
	public static String getRandomNumber(int len) {

		char[] chars = "123456789".toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < len; i++) {
			char c = chars[random.nextInt(chars.length)];
			sb.append(c);
		}
		String output = sb.toString();
		System.out.println(output);
		return output;
	}


	public static void copyAndPaste(WebDriver driver, By by, String txt) throws Exception {
		driver.findElement(by).sendKeys(Keys.ENTER);

		StringSelection selection = new StringSelection(txt);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(selection, selection);
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
	}

	public static void waitTillObjectIsDisplayed(WebDriver driver, By by, String elementName, int timeSec) {

		try {
			System.out.println("coming inside the method waitTillObjectIsDisplayed");
			WebDriverWait wait = new WebDriverWait(driver, timeSec);
			wait.until(ExpectedConditions.presenceOfElementLocated(by));
		} catch (org.openqa.selenium.TimeoutException e) {
			GUIFunctions.updateReportWithMessage(driver, "", "FAILURE!The element: " + elementName
					+ " is not displayed even after waiting for " + timeSec + " seconds", "fail", true);

		}
	}

	

	public static String getSystemLogTimeStampForCurrentTime() {
		String timeStamp = "";

		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		String strDate = date.toString().substring(0, 3);

		SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy HH:mm:ss");
		timeStamp = sdf.format(date);
		if (timeStamp.contains("0")) {
			timeStamp = timeStamp.substring(1, timeStamp.length());
		}
		timeStamp = strDate + ", " + timeStamp;
		System.out.println(timeStamp);

		return timeStamp;

	}

	

	/**
	 * @method captureScreenShotOfDesktop()
	 * @return String - path
	
	 */
	public static String captureScreenShotOfDesktop() {
		String path = "";
		try {
			Robot r = new Robot();
			String dirPath = System.getProperty("user.dir") + "//DesktopImgs";
			File files = new File(dirPath);
			if (!files.exists()) {
				if (files.mkdirs()) {
					System.out.println("Multiple directories are created!");
				} else {
					System.out.println("Failed to create multiple directories!");
				}
			}

			path = dirPath + "//RDP_" + CustomFunc.generateTimeStamp() + ".jpg";
			// Used to get ScreenSize and capture image
			Rectangle capture = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
			BufferedImage Image = r.createScreenCapture(capture);
			ImageIO.write(Image, "jpg", new File(path));
			System.out.println("Screenshot saved");
		} catch (Exception ex) {
			System.out.println("Exception in captureScreenShotOfDesktop : " + ex.getMessage());
		}
		return path;

	}

	
	public static WebDriver restartBrowser(String driverName, String URL, WebDriver driver) throws Exception {

		driver.close();

		driver = instanciateSecondWebDriver(driverName, URL, driver);

		return driver;

	}

	

	public static boolean deleteGmail(WebDriver driver) throws Exception {
		driver.findElement(By.xpath("//span[@role='checkbox']")).click();
		Thread.sleep(3000);
		try {
			driver.findElement(By.xpath("//div[@data-tooltip='Delete']")).click();
		} catch (Exception e) {
			System.out.println("No More Emails to Delete");
		}

		Thread.sleep(3000);

		boolean flag1 = CustomFunc.isElementPresent(By.xpath("//td[contains(.,'No new emails!')]"), driver);
		// Assert.assertTrue(flag1);
		if (!flag1) {
			System.out.println("All emails are not deleted...Tests may fail");
		}

		return flag1;
	}

	public static void loginToGmail(String emailID, String password, WebDriver driver) throws Exception {
		boolean flag = false;

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		GUIFunctions.typeTxtboxValue(driver, By.xpath("//input[@type='email']"), emailID);
		GUIFunctions.clickElement(driver, By.xpath("//span[.='Next']"), "Next button");
		Thread.sleep(4000);
		GUIFunctions.typeTxtboxValue(driver, By.xpath("//input[@type='password']"), password);
		Thread.sleep(5000);
		GUIFunctions.clickElement(driver, By.xpath("//span[.='Next']"), "Next button");
		Thread.sleep(10000);

	}

	public static boolean validateGmailList(String textToVerify, WebDriver driver) throws Exception {
		boolean flag = false;
		driver.navigate().refresh();
		Thread.sleep(15000);
		int newMailCount = driver.findElements(By.xpath("(//table[@class='F cf zt'])[1]//tr/td[6]")).size();
		// String to validate

		// String subjectToValidate = "Connection of type WEB_APPLICATION Started for
		// ATestDevice241018093749";
		if (newMailCount > 0) {
			for (int i = 1; i <= newMailCount; i++) {
				flag = driver.findElement(By.xpath("(//table[@class='F cf zt'])[1]//tr[" + i + "]/td[6]")).getText()
						.contains(textToVerify);
				System.out.println(
						driver.findElement(By.xpath("(//table[@class='F cf zt'])[1]//tr[" + i + "]/td[6]")).getText());
				System.out.println();
				if (flag) {
					System.out.println("inside break");
					break;
				}
			}

		} else {
			System.out.println("No mails present to Read");
		}
		return flag;

	}

	/**
	 * @method :
	 * @return

	 */
	public static boolean validateGmailContentForFileTransferStartEvent(String subject, WebDriver driver,
			String fileName, String fileSize, String source, String destination, String deviceName, String transferType,
			String reasonForFailure, String endTime) throws Exception {
		boolean flag = false;
		driver.navigate().refresh();
		Thread.sleep(15000);
		int newMailCount = driver.findElements(By.xpath("(//table[@class='F cf zt'])[1]//tr/td[6]")).size();
		// String to validate

		// String subjectToValidate = "Connection of type WEB_APPLICATION Started for
		// ATestDevice241018093749";
		if (newMailCount > 0) {
			for (int i = 1; i <= newMailCount; i++) {
				flag = driver.findElement(By.xpath("(//table[@class='F cf zt'])[1]//tr[" + i + "]/td[6]")).getText()
						.contains(subject);

				if (flag) {

					driver.findElement(By.xpath("(//table[@class='F cf zt'])[1]//tr[" + i + "]/td[6]")).click();

					boolean mismatch = false;

					if (!GUIFunctions
							.getText(driver, By.xpath("//label[contains(.,'Transferred File Name:')]"), "file name")
							.equals("Transferred File Name: " + fileName)) {
						mismatch = true;
						GUIFunctions.updateReportWithMessage(driver, "", "Transferred File Name mismatch", "fail",
								true);
					}

					if (!GUIFunctions.getText(driver, By.xpath("//label[contains(.,'File Size:')]"), "file size")
							.equals("File Size: " + fileSize)) {
						mismatch = true;
						GUIFunctions.updateReportWithMessage(driver, "", "Transferred fileSize mismatch", "fail", true);
					}

					if (!GUIFunctions.getText(driver, By.xpath("//label[contains(.,'Source:')]"), "source")
							.equals("Source: " + source)) {
						mismatch = true;
						GUIFunctions.updateReportWithMessage(driver, "", "source mismatch", "fail", true);
					}

					if (!GUIFunctions.getText(driver, By.xpath("//label[contains(.,'Destination:')]"), "Destination")
							.equals("Destination: " + destination)) {
						mismatch = true;
						GUIFunctions.updateReportWithMessage(driver, "", "Destination mismatch", "fail", true);
					}

					if (!GUIFunctions.getText(driver, By.xpath("//label[contains(.,'Device Name:')]"), "Device Name")
							.equals("Device Name: " + deviceName)) {
						mismatch = true;
						GUIFunctions.updateReportWithMessage(driver, "", "deviceName mismatch", "fail", true);
					}

					if (!GUIFunctions
							.getText(driver, By.xpath("//label[contains(.,'Transfer Type:')]"), "Transfer Type")
							.equals("Transfer Type: " + transferType)) {
						mismatch = true;
						GUIFunctions.updateReportWithMessage(driver, "", "Transfer Type mismatch", "fail", true);
					}

					if (!GUIFunctions.getText(driver, By.xpath("//label[contains(.,'Reason For Failure:')]"),
							"Reason For Failure").equals("Reason For Failure: " + reasonForFailure)) {
						mismatch = true;
						GUIFunctions.updateReportWithMessage(driver, "", "reasonForFailure mismatch", "fail", true);
					}

					if (!GUIFunctions.getText(driver, By.xpath("//label[contains(.,'End Time:')]"), "End Time:")
							.equals("End Time: " + endTime)) {
						mismatch = true;
						GUIFunctions.updateReportWithMessage(driver, "", "End Time mismatch", "fail", true);
					}

					if (mismatch == false) {
						GUIFunctions.updateReportWithMessage(driver, "",
								"All labels in Event Start notification mail is correct", "pass", false);
					}

					System.out.println("inside break");
					break;
				}
			}

		} else {
			System.out.println("No mails present to Read");
		}
		return flag;

	}

	
	/**
	 * @method
	 * @return

	 */
	public static String generatePortNumber() {

		// CustomFunc.getRandomText(Type.NUMBER, 2);

		String port = getRandomNumber(1) + getRandomNumber(1) + getRandomNumber(1) + getRandomNumber(1);

		return port;

	}

	/**
	 * @method
	 * @return
	 * @throws InterruptedException
	 */
	public static boolean waitUntilTheGivenTextAppearsInFile(WebDriver driver, String filepath, String text,
			int seconds) throws InterruptedException {

		boolean flag = true;

		int count = 0;

		while (!CustomFunc.checkTheGivenStringInFile(filepath, text)) {
			Thread.sleep(1000);
			count++;
			if (count > seconds) {
				flag = false;
				GUIFunctions.updateReportWithMessage(driver, "", "Text:[" + text + "] did not appear in the file:["
						+ filepath + "]. Waited for " + seconds + " seconds", "fail", false);
				break;
			}
		}

		return flag;

	}


	public static void runBatchFile(String path) throws Exception {

		System.out.println("exe");
		String cmd = "cmd /c start " + path;
		Runtime r = Runtime.getRuntime();
		Process pr = r.exec(cmd);
		Thread.sleep(10000);
		System.out.println("exe done");
		System.out.println("exit code is :" + pr.exitValue());
		Assert.assertEquals(pr.exitValue(), 0);

	}


	/**
	 * @method
	 * @param
	 * @param
	 * @return
	 */
	public static String getMonthInNumber(String monthname) {

		monthname = monthname.toUpperCase();

		String monthNumber = null;

		switch (monthname) {
		case "JAN":
			monthNumber = "01";
			break;
		case "FEB":
			monthNumber = "02";
			break;
		case "MAR":
			monthNumber = "03";
			break;
		case "APR":
			monthNumber = "04";
			break;
		case "MAY":
			monthNumber = "05";
			break;
		case "JUN":
			monthNumber = "06";
			break;
		case "JUL":
			monthNumber = "07";
			break;
		case "AUG":
			monthNumber = "08";
			break;
		case "SEP":
			monthNumber = "09";
			break;
		case "OCT":
			monthNumber = "10";
			break;
		case "NOV":
			monthNumber = "11";
			break;
		case "DEC":
			monthNumber = "12";
			break;

		default:
			Reporter.log(
					"<br/> <p><font color=\"red\">\"Provide correct month[Jan Feb Mar Apr May Jun Jul Aug Sep Oct Nov Dec]\"</font><br/>");
			break;
		}

		return monthNumber;
	}

	
	/**
	 * @method
	
	 */

	public static String getDataDependencyPath() throws Exception {
		String projectpath = System.getProperty("user.dir");
		String workspacepath = new File(projectpath).getParent();

		String dependencydatapath = workspacepath + "\\DEPENDENCYDATA";

		File directory = new File(dependencydatapath);
		if (!directory.exists()) {
			directory.mkdir();

		}

		return dependencydatapath;
	}

	public static void getCookieValues(WebDriver driver) {

		hash_map = new HashMap<String, String>();
		Set<Cookie> cookies = driver.manage().getCookies();
		for (Cookie a : cookies) {
			hash_map.put(a.getName(), a.getValue());
		}
		cookie = hash_map.toString().replace(",", ";").replaceAll("^.|.$", "");

	}

	/**
	 * @method

	 */

	public static void overcomeElementInvisibleExceptionAndClick(WebDriver driver, By by) throws Exception {

		List<WebElement> list = driver.findElements(by);
		boolean clicked = false;

		for (WebElement ele : list) {

			try {
				ele.click();
				clicked = true;
				break;
			} catch (org.openqa.selenium.ElementNotVisibleException e) {

			}
		}

		if (clicked == false) {
			GUIFunctions.updateReportWithMessage(driver, "",
					"unable to click after overcming element invisible exception", "fail", true);
		}

		Thread.sleep(2000);

	}

	public static String retriveCookieValuesUsingSplit(WebDriver driver) {
		String cookieInStringFromat = driver.manage().getCookies().toString();
		String[] arrOfStr = cookieInStringFromat.split(";", 10);
		String RegionSessionID = arrOfStr[0].substring(arrOfStr[0].indexOf("=") + 1, arrOfStr[0].length());
		String XSRFToken = arrOfStr[4].substring(arrOfStr[4].indexOf("=") + 1, arrOfStr[4].length());
		String SessionID = arrOfStr[8].substring(arrOfStr[8].indexOf("=") + 1, arrOfStr[8].length());
		String cookie = "REGION-SESSION=" + RegionSessionID + "; XSRF-TOKEN=" + XSRFToken + "; SESSION=" + SessionID;
		return cookie;
	}

	public static boolean verifyFileWithSpecifiedNameExists(String folderpath, String filename) {

		File folder = new File(folderpath);
		File[] listOfFiles = folder.listFiles();

		boolean isSuccessful = false;

		for (int i = 0; i < listOfFiles.length; i++) {

			if (listOfFiles[i].getName().contains(filename)) {
				isSuccessful = true;
				break;
			}
		}

		return isSuccessful;
	}

	public static void deleteFileWithSpecifiedName(String folderpath, String filename) {

		File folder = new File(folderpath);
		File[] listOfFiles = folder.listFiles();
		String completefilename = "";

		boolean isSuccessful = false;

		for (int i = 0; i < listOfFiles.length; i++) {

			if (listOfFiles[i].getName().contains(filename)) {

				completefilename = listOfFiles[i].getName();
				isSuccessful = true;
				break;
			}
		}

		if (isSuccessful) {
			deleteAFile(folderpath + "\\" + completefilename);
		}
	}

	public static int getMatchCountOfAParticularPatternInAString(String s) {
		String regx = ".*@.*";
		Pattern pattern = Pattern.compile(regx);
		Matcher matcher = pattern.matcher(s);

		int count = 0;
		while (matcher.find())
			count++;

		System.out.println(count);
		return count;
	}



}
