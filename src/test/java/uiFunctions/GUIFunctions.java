package uiFunctions;


import static com.demo.util.PropertyFileReader.ObjectRepoProp;
import static com.demo.util.PropertyFileReader.StyleSheetProp;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.demo.config.BaseClass;
import com.demo.library.CustomFunc;


import com.relevantcodes.extentreports.model.*;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.view.ScreenshotHtml;
import utils.ExtentReports.ExtentTestManager;

public class GUIFunctions {
	
	public static Logger log = Logger.getLogger(GUIFunctions.class.getName());
	
	/**
	 * Method Name: isElementPresent Description:Method to verify the Element
	 * 
	 * @param by
	 *            :Element locator
	 * @param driver
	 *            :WebDriver
	 * @return true: if element is present, false: if element is not present
	 * @throws Exception 
	 */
	public static boolean isElementPresent(By by, WebDriver driver) {
		try {
			// Verify element is present
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.findElement(by);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			return true;
		} catch (NoSuchElementException e) {
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			updateReportWithMessage(driver, "NoSuchElementPresent","either desired object doesn't exists or issue in finding using proeprty : "+by, "fail",true);			
			return false;
		}
	}

	/**
	 * Method Name: navigateBack Description: Method to used to go back to home
	 * page by clicking on browser back button
	 * 
	 * @param driver
	 *            :WebDriver
	 * @return driver
	 * @throws Exception 
	 */
	public static WebDriver navigateBack(WebDriver driver) throws Exception {
		try {

			// Navigate back to Previous page
			driver.navigate().back();

		} catch (Exception e) {
			updateReportWithMessage(driver, "Navigation","Navigation to previous page failed: "+e.getLocalizedMessage(), "fail",true);
			//Reporter.log("Navigation to previous page failed--> \n" + e);
			//Reporter.log("<br/><p>Navigation to previous page failed");
		}

		return (driver);
	}

	/**
	 * Method Name: clickElement Description: This method clicks on WebElement
	 * specified
	 * 
	 * @param driver
	 *            : WebDriver
	 * @param ele
	 *            : WebElement locator
	 * @param eleName
	 *            : Name of the element to be clicked
	 * @ 
	 */

	public static boolean clickElement(WebDriver driver, By by, String eleName)  {
		boolean flag = false;
		try {
			if(BaseClass.driverName.equalsIgnoreCase("IE")) {
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(by));
			}
			else {
				driver.findElement(by).click();
			}

			updateReportWithMessage(driver, "Click","Successfully clicked on UIObject: " + eleName, "pass",false);
			flag = true;

		} catch (NoSuchElementException e) {
			//Reporter.log("Element to click is not present " + e);
			//Reporter.log("<br/><p>Element to click is not present");
			updateReportWithMessage(driver, "ClickIssue","Either UIObject : "+ eleName+" to click is not present or check for any other issue"+e.getLocalizedMessage() , "fail",true);
		}

		return flag;
	}

	/**
	 * Method Name: mouseOverElement Description: This method used to scroll to
	 * an element which not visible in the screen
	 * 
	 * @param driver
	 *            : WebDriver
	 * @param ele
	 *            : WebElement locator
	 * @throws InterruptedException 
	 */
	public static void mouseOverElement(WebDriver driver, WebElement ele)  {
		try {

			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Actions builder = new Actions(driver);
			builder.moveToElement(ele).build().perform();
			updateReportWithMessage(driver, "mouseOver","Successfully mouse over on desired UIObject","pass",false);
		} catch (NoSuchElementException e) {
			//Reporter.log("Element to mouse over is not present " + e);
			//Reporter.log("<br/><p>Element to mouse over is not present");
			updateReportWithMessage(driver, "mouseOverIssue","Either UIObject is not present to do mouseOver or issue in moving the cursor by action class : "+e.getLocalizedMessage(), "fail",true);
		}

	}

	/**
	 * Method Name: mouseOverElementAndClick Description: This method used to
	 * scroll to an element which not visible in the screen/ or Not Clickable by
	 * GUIFunctions.clickOnElement method and clicks on it
	 * 
	 * @param driver
	 * @param ele
	 * @param eleName
	 * @
	 */
	public static void mouseOverElementAndClick(WebDriver driver, WebElement ele, String eleName)  {
		try {

			// Mouse hover/roll over on element
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Actions builder = new Actions(driver);
			builder.moveToElement(ele).build().perform();
			builder.click().perform();
			updateReportWithMessage(driver, "mouseOver","Successfully mouse over and clicked on: " + eleName, "pass",false);
			//Reporter.log("Successfully mouse over and clicked on: " + eleName);
			//Reporter.log("<br/><p>Successfully mouse over and clicked on: " + eleName);

		} catch (NoSuchElementException e) {
			//Reporter.log("Element to mouse over and click is not present " + e);
			//Reporter.log("<br/><p>Element to mouse over and click is not present");
			updateReportWithMessage(driver, "mouseOverIssue","Either UIObject is not present to do mouseOver and click or issue in moving/clicking on object: "+e.getLocalizedMessage(), "fail",true);
		}

	}
	
	/**
	 * Method Name: clickElement Description: This method clicks on WebElement
	 * specified
	 * 
	 * @param driver
	 *            : WebDriver
	 * @param ele
	 *            : WebElement locator
	 * @param eleName
	 *            : Name of the element to be clicked
	 * @ 
	 */
	public static void typeTxtboxValue(WebDriver driver, By by, String value)  {
		try {			
			// Click on element
			driver.findElement(by).clear();
			driver.findElement(by).sendKeys(value);	
			//System.out.println("Entered value : "+value+" in respective textbox");
			//Reporter.log("<br/><p>Entered value : "+value+" in respective textbox");
			updateReportWithMessage(driver, "typeTxtboxValue","Entered value : "+value+" in respective textbox", "pass",false);
		} catch (NoSuchElementException e) {
			//Reporter.log("Element to type data is not present " + e);
			//Reporter.log("<br/><p>Element to type data is not present");
			updateReportWithMessage(driver, "typeTxtboxValueIssue","Either UIObject not present to proceed or something went wrong while entering text : "+e.getLocalizedMessage(), "fail",true);
			//System.out.println(e);
		}
	}
	
	public static boolean typeTxtboxValue(WebDriver driver, By by, String value,String objName)  {
		boolean flag = false;
		try {	
			driver.findElement(by).clear();
			driver.findElement(by).sendKeys(value);	
			flag = true;
			updateReportWithMessage(driver, "typeTxtboxValue","Entered value : "+value+" in "+objName, "pass",false);
		} catch (NoSuchElementException e) {			
			updateReportWithMessage(driver, "typeTxtboxValueIssue","Either UIObject not present to proceed or something went wrong while entering text : "+e.getLocalizedMessage(), "fail",true);
		}
		
		return flag;
	}

	/**
	 * selectDropDownValue(WebElement ele, String dropDownValue, String optType)
	 * @param ele
	 * @param dropDownValue - to select
	 * @param optType - Either text or value
	 * @
	 */
	public static void selectDropDownValue(WebElement ele, String dropDownValue, String optType)  {
		try {
			// Dropdown in which value to be selected
			Select dropDown = new Select(ele);

			// Selecting dropdown value
			if (optType.equalsIgnoreCase("text")) {
				dropDown.selectByVisibleText(dropDownValue);
				Reporter.log("<br/><p>Selected value from drop down is : "+dropDownValue+"<br/>");
			} else if (optType.equalsIgnoreCase("value")) {
				dropDown.selectByValue(dropDownValue);
				Reporter.log("<br/><p>Selected value from drop down is : "+dropDownValue+"<br/>");
			}

		} catch (NoSuchElementException e) {
			Reporter.log("Element to select drop down is not present " + e);
			Assert.fail();
			//Reporter.log("<br/><p>Element to drop down is not present");

		}

	}

	/**
	 * Method Name: checkOrUncheckCheckBox Description: This method
	 * checks/Unchecks the checkbox
	 * 
	 * @param driver
	 *            : WebDriver
	 * @param By
	 *            : WebElement locator
	 * @param eleName
	 *            : Name of the element to be checked
	 * @param toCheck
	 *            : True: To check the checkbox false: To uncheck the checkbox
	 * 
	 */
	public static void checkOrUncheckCheckBox(WebDriver driver, By by, String eleName, Boolean toCheck)
	{
		try {
			if(BaseClass.driverName.equalsIgnoreCase("IE")){
				if (toCheck) {
					// check checkbox if not checked
					if (!driver.findElement(by).isSelected()) {
						((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(by));


						//Reporter.log("Successfully checked the checkbox/radio: " + eleName);
						//Reporter.log("<br/><p>Successfully checked the checkbox/radio button: " + eleName);
						updateReportWithMessage(driver, "checkOrUncheckCheckBox","Successfully selected the checkbox/radio button: " + eleName, "pass",false);
					}
				} else if (!toCheck) {
					// Uncheck checkbox if it is checked
					if (driver.findElement(by).isSelected()) {
						((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(by));


						//Reporter.log("Successfully unchecked the checkbox: " + eleName);
						//Reporter.log("<br/><p>Successfully unchecked the checkbox/radio button: " + eleName);
						updateReportWithMessage(driver, "checkOrUncheckCheckBox","Successfully de-selected the checkbox/radio button: " + eleName, "pass",false);
					}
				}
			}else {
				if (toCheck) {
					// check checkbox if not checked
					if (!driver.findElement(by).isSelected()) {
						driver.findElement(by).click();

						//Reporter.log("Successfully checked the checkbox/radio: " + eleName);
						//Reporter.log("<br/><p>Successfully checked the checkbox/radio button: " + eleName);
						updateReportWithMessage(driver, "checkOrUncheckCheckBox","Successfully selected the checkbox/radio button: " + eleName, "pass",false);
					}
				} else if (!toCheck) {
					// Uncheck checkbox if it is checked
					if (driver.findElement(by).isSelected()) {
						driver.findElement(by).click();

						//Reporter.log("Successfully unchecked the checkbox: " + eleName);
						//Reporter.log("<br/><p>Successfully unchecked the checkbox/radio button: " + eleName);
						updateReportWithMessage(driver, "checkOrUncheckCheckBox","Successfully de-selected the checkbox/radio button: " + eleName, "pass",false);
					}
				}
			}

		} catch (NoSuchElementException e) {
			//Reporter.log("Checkbox element is not present " + e.getMessage());
			//Reporter.log("<br/><p>Checkbox/radio button element is not present "+ e.getMessage());
			updateReportWithMessage(driver, "checkOrUncheckCheckBoxIssue","Checkbox/radio button element is not present to select/de-select"+ e.getLocalizedMessage(), "fail",true);

		}

	}

	/**
	 * getText(WebDriver driver, By by, String eleName)
	 * @param driver
	 * @param by
	 * @param eleName
	 * @return String
	 * @ 
	 * @Author Anil
	 */
	public static String getText(WebDriver driver, By by, String eleName) {
		String text = "";
		try {
			text = driver.findElement(by).getText();
			updateReportWithMessage(driver, "getText","Reading text from : "+eleName+" - is : "+text, "pass",false);
			return text;
		}
		catch(Exception e) {
			updateReportWithMessage(driver, "getTextIssue","Either UI element is not present or issue while getting text from : "+eleName+" : " + e.getMessage(), "fail",true);
			return text;
		}
	}
	
	/**
	 * getAttribute(WebDriver driver, By by, String eleName, String attributeStringToPass)
	 * @param driver
	 * @param by
	 * @param eleName
	 * @return String
	 * @ 
	 * @Author Anil
	 */
	public static String getAttribute(WebDriver driver, By by, String eleName, String attributeStringToPass) {
		String text = "";

		try {
			text = driver.findElement(by).getAttribute(attributeStringToPass);
			//Reporter.log("<br/><p>Reading "+attributeStringToPass+" attribute from : "+eleName+" - is : "+text);
			///System.out.println("Reading "+attributeStringToPass+" attribute from : "+eleName+" - is : "+text);
			updateReportWithMessage(driver, "getAttribute","Reading "+attributeStringToPass+" attribute from : "+eleName+" - is : "+text, "pass",false);
			return text;
		}
		catch(Exception e) {
			//Reporter.log("<br/><p>Either UI element is not present or issue while getting attribute : " +attributeStringToPass+" : "+ e);
			//System.out.println("Either UI element is not present or issue while getting attribute : " +attributeStringToPass+" : "+ e.getMessage());
			updateReportWithMessage(driver, "getAttribute","Either UI element : "+eleName +" is not present or issue while getting attribute : " +attributeStringToPass, "fail",true);
			updateReportWithMessage(driver, "getAttribute",e.getLocalizedMessage(), "fail",true);

			
			return text;
		}
	}

	/**
	 * takeScreenShot(WebDriver webdriver,String fileName)
	 * @Description This function will take screenshot
	 * @param webdriver
	 * @param fileName
	 * @return String - path of saved snap shot
	 * @author Anil
	 */
	public static String takeScreenShot(WebDriver webdriver,String fileName){

		fileName = fileName.replace(" ", "");

		String fileNameWithPathtimeStamp = System.getProperty("user.dir")+"/screenshots/"+fileName+"_"+CustomFunc.generateTimeStamp()+".png";
		//Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);
		//Call getScreenshotAs method to create image file
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		//Move image file to new destination
		File DestFile=new File(fileNameWithPathtimeStamp);
		//Copy file at destination
		try {
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (IOException e) {
			System.out.println("Exception in takeScreenShot() method, in GUIFunctions.java : "+e.getLocalizedMessage());
		}

		return fileNameWithPathtimeStamp;
	}


	/**
	 * @Function updateReport(WebDriver driver,String fileNameToUpdate, String status) 
	 * @Description - Wil update the report at desired step with snap shot
	 * @param driver
	 * @param fileNameToUpdate
	 * @param status
	 * @
	 * @author Anil 
	 */
	/*public static void updateReport(WebDriver driver,String fileNameToUpdate, String status)  {

		String name = takeScreenShot(driver, fileNameToUpdate);

		System.out.println(fileNameToUpdate);

		if(status.equalsIgnoreCase("pass"))
			Reporter.log("<br /> <a href="+name+" class=\"highslide\" rel=\"highslide\">" + "<b>"+fileNameToUpdate+"</b><br />"+" <img src="+name+"  alt=\"Highslide JS\" title=\"Click to enlarge\" hight=\'100\' width=\'100\'/></a><br/>");
		//Reporter.log("<br/><a href=" + name+ "><b>"+fileNameToUpdate+"</b></a>");
		else if(status.equalsIgnoreCase("fail")) {
			//Reporter.log("<br/><a href=" + name+ "><b><font color=\"red\">"+fileNameToUpdate+"</font></b></a>");			
			Reporter.log("<br/><a href="+name+" class=\"highslide\" rel=\"highslide\">" + "<b><font color=\"red\">"+fileNameToUpdate+"</font></b><br/>" +"<img src="+name+"  alt=\"Highslide JS\" title=\"Click to enlarge\" hight=\'100\' width=\'100\'/> </a><br/>");
			//Assert.assertTrue(false);
		}		
	}*/

	/**
	 * @Function addBase64ScreenShot(String base64)
	 * @param String base64
	 * @return String
	 * @author Anil 
	 */
	public static String addBase64ScreenShot(String base64) {
		String screenCaptureHtml = ScreenshotHtml.getBase64Source(base64);
		ScreenCapture img = new ScreenCapture();
		img.setSource(screenCaptureHtml);
		return screenCaptureHtml;
	}

	/**
	 * @Function updateReportWithMessage(WebDriver driver,String fileNameToUpdate,String messageToPrint, String status, boolean screenShotRequiredOrNot) 
	 * @Description - Wil update the report at desired step with snap shot
	 * @param WebDriver driver
	 * @param String fileNameToUpdate
	 * @param String messageToPrint
	 * @param String status - pass/fail/warning
	 * @param boolean screenShotRequiredOrNot
	 * @
	 * @author Anil 
	 */
	public static void updateReportWithMessage(WebDriver driver,String fileNameToUpdate,String messageToPrint, String status, boolean screenShotRequiredOrNot){
		
		String name = "";

		/*String base64Screenshot = "data:image/png;base64,"+((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);		
		System.out.println(messageToPrint);
		if(status.equalsIgnoreCase("pass")) {
			if(screenShotRequiredOrNot) {
				//Reporter.log("<br/> <p><font color=\"black\">"+messageToPrint+"</font><br/>"+"<img src="+addBase64ScreenShot(base64Screenshot)+"  alt=\"Highslide JS\" title=\"Click to enlarge\" hight=\'100\' width=\'100'/><br/>");

				Reporter.log("<br/> <p><font color=\"black\">"+messageToPrint+"</font><br/><a href="+base64Screenshot+" class=\"highslide\" rel=\"highslide\"> <img src="+base64Screenshot+"  alt=\"Highslide JS\" title=\"Click to enlarge\" hight=\'100\' width=\'100\'/></a><br/>");	
				//ExtentTestManager.getTest().log(LogStatus.PASS,messageToPrint,ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot));
			}
			else {
				Reporter.log("<br/> <p><font color=\"black\">"+messageToPrint+"<br/>");
				//ExtentTestManager.getTest().log(LogStatus.PASS,messageToPrint,"");
			}

		}
		else if(status.equalsIgnoreCase("fail")) {				
			if(screenShotRequiredOrNot) {
				Reporter.log("<br/> <p><font color=\"red\">"+messageToPrint+"</font><br/><a href="+base64Screenshot+" class=\"highslide\" rel=\"highslide\"> <img src="+base64Screenshot+"  alt=\"Highslide JS\" title=\"Click to enlarge\" hight=\'100\' width=\'100\'/></a><br/>");
				//ExtentTestManager.getTest().log(LogStatus.FAIL,messageToPrint,ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot));
			}
			else {
				Reporter.log("<br/> <p><font color=\"red\">"+messageToPrint+"<br/>");
				//ExtentTestManager.getTest().log(LogStatus.FAIL,messageToPrint,"");
			}
		}	
		else if(status.equalsIgnoreCase("warning")) {				
			if(screenShotRequiredOrNot) {
				Reporter.log("<br/> <p><font color=\"orange\">"+messageToPrint+"</font><br/><a href="+base64Screenshot+" class=\"highslide\" rel=\"highslide\"> <img src="+base64Screenshot+"  alt=\"Highslide JS\" title=\"Click to enlarge\" hight=\'100\' width=\'100\'/></a><br/>");
				//ExtentTestManager.getTest().log(LogStatus.WARNING,messageToPrint,ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot));
			}
			else {
				Reporter.log("<br/> <p><font color=\"orange\">"+messageToPrint+"<br/>");
				//ExtentTestManager.getTest().log(LogStatus.WARNING,messageToPrint,"");
			}
		}*/

		
		if(status.equalsIgnoreCase("pass")) {
			if(screenShotRequiredOrNot) {
				System.out.println(messageToPrint);
				name = takeScreenShot(driver, fileNameToUpdate);
				Reporter.log("<br/> <p><font color=\"black\">"+messageToPrint+"</font><br/><a href="+name+" class=\"highslide\" rel=\"highslide\"> <img src="+name+"  alt=\"Highslide JS\" title=\"Click to enlarge\" hight=\'100\' width=\'100\'/></a><br/>");
				ExtentTestManager.getTest().log(LogStatus.PASS,messageToPrint,ExtentTestManager.getTest().addScreenCapture(name));
			}
			else {
				System.out.println(messageToPrint);
				Reporter.log("<br/> <p><font color=\"black\">"+messageToPrint+"<br/>");
				ExtentTestManager.getTest().log(LogStatus.PASS,messageToPrint,"");
			}

		}
		else if(status.equalsIgnoreCase("fail")) {	
			if(screenShotRequiredOrNot) {
				System.out.println(messageToPrint);
				name = takeScreenShot(driver, fileNameToUpdate);
				Reporter.log("<br/> <p><font color=\"red\">"+messageToPrint+"</font><br/><a href="+name+" class=\"highslide\" rel=\"highslide\"><img src="+name+"  alt=\"Highslide JS\" title=\"Click to enlarge\" hight=\'100\' width=\'100\'/> </a><br/>");
				ExtentTestManager.getTest().log(LogStatus.FAIL,messageToPrint,ExtentTestManager.getTest().addScreenCapture(name));
			}
			else {
				System.out.println(messageToPrint);
				Reporter.log("<br/> <p><font color=\"red\">"+messageToPrint+"<br/>");
				ExtentTestManager.getTest().log(LogStatus.FAIL,messageToPrint,"");
			}
		}	
		else if(status.equalsIgnoreCase("warning")) {	
			if(screenShotRequiredOrNot) {
				System.out.println(messageToPrint);
				name = takeScreenShot(driver, fileNameToUpdate);
				Reporter.log("<br/> <p><font color=\"orange\">"+messageToPrint+"</font><br/><a href="+name+" class=\"highslide\" rel=\"highslide\"><img src="+name+"  alt=\"Highslide JS\" title=\"Click to enlarge\" hight=\'100\' width=\'100\'/> </a><br/>");
				ExtentTestManager.getTest().log(LogStatus.WARNING,messageToPrint,ExtentTestManager.getTest().addScreenCapture(name));
			}
			else {
				System.out.println(messageToPrint);
				Reporter.log("<br/> <p><font color=\"orange\">"+messageToPrint+"<br/>");
				ExtentTestManager.getTest().log(LogStatus.WARNING,messageToPrint,"");
			}
		}	
	}

	/**
	 * @method scrollIntoView(WebDriver driver,By by)
	 * @param driver
	 * @param by
	 * @author Anil
	 */
	public static void scrollIntoView(WebDriver driver,By by) {
		WebElement element = driver.findElement(by);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @method isElementDisplayed(WebDriver driver,By by)
	 * @param driver
	 * @param by
	 * @return boolean
	 * @author Anil
	 */
	public static boolean isElementDisplayed(WebDriver driver,By by, String eleName)  {


		if(isElementPresent(by, driver, eleName)) {

			try {
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				driver.findElement(by).isDisplayed();
				updateReportWithMessage(driver, "ElementDisplayed",eleName+" : is showing", "pass",true);
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				return true;
			} catch (Exception e) {
				updateReportWithMessage(driver, "NoElementDisplayed",eleName+" : might be present in DOM it seems but not displaying on UI", "fail",true);
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				return false;
			}			
		}
		return false;

	}
	

	/**
	 * @method getSelectedDropDownValue(WebDriver driver,By by,String eleName)
	 * @param driver
	 * @param by
	 * @param eleName
	 * @return String
	 * @author Anil
	 */
	public static String getSelectedDropDownValue(WebDriver driver,By by,String eleName)  {

		String option="";
		try {
			// Dropdown in which value to be selected
			Select dropDown = new Select(driver.findElement(by));
			try {
				WebElement selected = dropDown.getFirstSelectedOption();
				option = selected.getText();
				updateReportWithMessage(driver, "SelectedOption","Selected option from - "+eleName+" - is : "+option, "pass",false);
			} catch (Exception e) {
				System.out.println("Exception while getting selected option from drop down, might be nothing has selected : "+e.getMessage());
			}
		} catch (NoSuchElementException e) {
			updateReportWithMessage(driver, "SelectedOptionIssue","Something went worng while getting selected option from drop down : "+eleName, "fail",false);
		}

		return option;
	}



	public static boolean isElementEnabled(WebDriver driver,By by, String objName) {
		if(isElementPresent(by, driver)) {
			try {
				driver.findElement(by).isDisplayed();
				updateReportWithMessage(driver, "ElementDisplayed",objName+" : is showing and enbaled on UI", "pass",true);
				return true;
			} catch (Exception e) {
				updateReportWithMessage(driver, "NoElementDisplayed",objName+" : might be present in DOM it seems but not e on UI", "fail",true);
				return false;
			}			
		}else
			return false;
	}

	public static boolean validateTooltip(WebDriver driver,By infoicon,By tooltip,String expectedtooltiptext) throws InterruptedException {

		Actions actions=new Actions(driver);
		actions.moveToElement(driver.findElement(infoicon)).perform();
		Thread.sleep(2000);
		return GUIFunctions.getText(driver, tooltip, "tool tip").contains(expectedtooltiptext);
	}

	public static boolean waitToDisplay(WebDriver driver,By by,String eleName,int timeSec)  {

		WebDriverWait wait = new WebDriverWait(driver, timeSec);

		try {
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(by)));
			return true;
		} catch (TimeoutException t) {
			System.out.println("Not able to find"+eleName);
			return false;
		}
	}

	/**
	 * @method isClickable(WebDriver driver,By by,String objName, int timeToWait)
	 * @param driver
	 * @param by
	 * @param objName
	 * @param timeToWait
	 * @return boolean
	 * @author Anil
	 */
	public static boolean isClickable(WebDriver driver,By by,String objName, int timeToWait) 
	{
		try{
			WebDriverWait wait = new WebDriverWait(driver, timeToWait);
			wait.until(ExpectedConditions.elementToBeClickable(by));
			return true;

		}
		catch (Exception e){
			updateReportWithMessage(driver, "NotClickable","UI object : "+objName+" is not in clickable status, either loader masking the object or check for any other issue", "fail",true);
			return false;
		}			
	}
	/**
	 * @method 
	 * @param 
	 * @param 
	 * @param 
	 * @return boolean
	 * @author Guru
	 */
	public static boolean isElementVisible(WebDriver driver,By by,int timeout) {

		WebDriverWait wait = new WebDriverWait(driver, timeout);

		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			return true;

		}
		catch(org.openqa.selenium.TimeoutException e) {
			return false;
		}
	}

	public static boolean isElementEditable(WebDriver driver,By by) {

		if(driver.findElement(by).isEnabled()){
			return true;
		}
		else
			return false;
	}

	/**
	 * @method 
	 * @param 
	 * @param 
	 * @param 
	 * @return boolean
	 * @author Guru
	 */
	public static boolean isElementClickable(WebDriver driver,By by,int timeout,String elementName) throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, timeout);

		try{
			wait.until(ExpectedConditions.elementToBeClickable(by));
			return true;

		}
		catch(org.openqa.selenium.TimeoutException e) {
			GUIFunctions.updateReportWithMessage(driver, "", elementName+ " is still not clickable.Waited for "+timeout+" seconds", "fail", true);
			return false;
		}
	}
	/* @method waitToDisAppear(WebDriver driver,By by)
	 * @param driver
	 * @param by
	 * @author Anil
	 */
	public static void waitToDisAppear(WebDriver driver) {
		CustomFunc.waitTillLoadingObjectDisappears(driver, 60);
	} 
	/**
	 * Method Name: clickElement Description: This method clears the textbox
	 * 
	 * @param driver
	 *            : WebDriver
	 * @param by
	 *            : WebElement locator
	 * @param key
	 *            : Name of the key to be clicked
	 */
	public static void clearTextBox(WebDriver driver, By by, String value) {
		try {			
			// Click on element	

			for(int i=0;i<value.length();i++) {
				driver.findElement(by).sendKeys(Keys.BACK_SPACE);
			}
			System.out.println("Cleared respective textbox");
			Reporter.log("<br/><p>Cleared respective textbox");
		} catch (NoSuchElementException e) {
			Reporter.log("Element  not present " + e);
			Reporter.log("<br/><p>Element  not present");
			System.out.println(e);
		}
	}

	/**
	 * @method doubleClick(WebDriver driver, By by, String objName)
	 * @param driver
	 * @param by
	 * @return Anil
	 */
	public static boolean doubleClick(WebDriver driver, By by, String objName) {
		try {
			Actions action = new Actions(driver);
			WebElement btnElement=driver.findElement(by);
			action.doubleClick(btnElement).build().perform();
			updateReportWithMessage(driver, "doubleclick","Double clicked on UI object : "+objName, "pass",true);
			return true;
		} catch (Exception e) {
			updateReportWithMessage(driver, "doubleclick","Exception while Double clicking on UI object : "+objName+" : "+e.getLocalizedMessage(), "fail",true);
			return false;
		}
	}

	public static void refreshAndWait(WebDriver driver) {

		driver.navigate().refresh();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		waitToDisAppear(driver);
	}



	/**
	 * @method dragAndDrop(WebDriver driver, By SourceElement,By TargetElement)
	 * @param driver, SourceElement, TargetElement
	 * @param by
	 * @return Meenakshi
	 */
	public static boolean dragAndDrop(WebDriver driver, By SourceElement,By TargetElement) {
		try {
			Actions action = new Actions(driver);
			WebElement source=driver.findElement(SourceElement);
			WebElement target=driver.findElement(TargetElement);

			/*Action dragAndDrop = action.clickAndHold(source)
			        .dragAndDrop(source,target).release(source).build();*/

			Action dragAndDrop =  action.clickAndHold(source)
					.moveByOffset(1, 0)
					.moveToElement(target)
					.release(target)
					.build();

			dragAndDrop.perform();

			updateReportWithMessage(driver, "dragAndDrop","Dragged the UI Object To Source", "pass",true);
			return true;
		} catch (Exception e) {
			updateReportWithMessage(driver, "doubleclick","Failure while dragging the element Please check"+e.getLocalizedMessage(), "fail",true);
			return false;
		}
	}

	public static boolean  ClickFirstPageButton(WebDriver driver) throws Exception {
		boolean isSuccess=false;
		By FirstButton = By.xpath(ObjectRepoProp.getProperty("FirstButton_Xpath"));
		By LastButton = By.xpath(ObjectRepoProp.getProperty("LastButton_Xpath"));
		
		
           if(getTotalNumberOfPages(driver)==1) {
			
			if(GUIFunctions.getAttribute(driver, FirstButton, "FirstButton", "class").contains("disabled")&&GUIFunctions.getAttribute(driver, LastButton, "LastButton", "class").contains("disabled"))
			
			GUIFunctions.updateReportWithMessage(driver, "",
					"First button and Last button are disabled as table has single page", "pass", true);
		}
           else {
        	   if(getCurrentPageNumber (driver)!=1) {
				try {
					GUIFunctions.clickElement(driver, FirstButton, "First Button");
					isSuccess=true;
					CustomFunc.waitTillLoadingObjectDisappears(driver, 60);
					
					
					/*
					 * Assert.assertTrue(GUIFunctions.getAttribute(driver, FirstButton,
					 * "First Button", "class") .contentEquals("disabled"),
					 * "Failure:First button is not disabled");
					 * Assert.assertTrue(GUIFunctions.isElementEnabled(driver, LastButton),
					 * "Failure: Last Button is Not enabled");
					 */
					
					if(!GUIFunctions.getAttribute(driver, FirstButton, "First Button", "class")
							.contentEquals("disabled")) {
						GUIFunctions.updateReportWithMessage(driver, "",
								"First button is NOT disabled", "fail",
								true);
					}
					
					if(GUIFunctions.getAttribute(driver, LastButton, "LastButton", "class")
							.contentEquals("disabled")) {
						GUIFunctions.updateReportWithMessage(driver, "",
								"LastButton is disabled", "fail",
								true);
					}
				
				
				} catch (org.openqa.selenium.WebDriverException e) {
					GUIFunctions.updateReportWithMessage(driver, "",
							"CANNOT CLICK First button.It seems to be disabled.You must be on First page", "fail",
							true);
				}
        	   }
           }
		
         return isSuccess;
	}

	public static boolean ClickPreviousPageButton(WebDriver driver) throws Exception {
		boolean isSuccess=false;
		By PreviousButton = By.xpath(ObjectRepoProp.getProperty("PreviousButton_Xpath"));
		
		
		 if(getTotalNumberOfPages(driver)==1) {
				
				if(GUIFunctions.getAttribute(driver, PreviousButton, "PreviousButton", "class").contains("disabled"))
				
				GUIFunctions.updateReportWithMessage(driver, "",
						"PreviousButton is disabled as table has single page", "pass", true);
			}
		
		 else {
			 if(getCurrentPageNumber (driver)!=1) {
				try {
					GUIFunctions.clickElement(driver, PreviousButton, "Previous Button");
					isSuccess=true;
					CustomFunc.waitTillLoadingObjectDisappears(driver, 60);
				} catch (org.openqa.selenium.WebDriverException e) {
					GUIFunctions.updateReportWithMessage(driver, "",
							"CANNOT CLICK Previous button .It seems to be disabled.You must be on first page", "fail",
							true);
				}
			 }
		
		 }
		 return isSuccess;

	}

	public static boolean  ClickNextPageButton(WebDriver driver) throws Exception {
		boolean isSuccess=false;
		By NextButton = By.xpath(ObjectRepoProp.getProperty("NextButton_Xpath"));
		
        if(getTotalNumberOfPages(driver)==1) {
			
			if(GUIFunctions.getAttribute(driver, NextButton, "NextButton", "class").contains("disabled"))
			
			GUIFunctions.updateReportWithMessage(driver, "",
					"NextButton is disabled as table has single page", "pass", true);
		}
        else {
		
        	if(getCurrentPageNumber (driver)!=GUIFunctions.getTotalNumberOfPages(driver)) {
				try {
					GUIFunctions.clickElement(driver, NextButton, "Next Button");
					isSuccess=true;
					CustomFunc.waitTillLoadingObjectDisappears(driver, 60);
				} catch (org.openqa.selenium.WebDriverException e) {
					GUIFunctions.updateReportWithMessage(driver, "",
							"CANNOT CLICK Next button. It seems to be disabled.You must be on last page", "fail", true);
				}
        	}
		
        }
        
        return isSuccess;

	}

	public static boolean  verifyLastPageButton(WebDriver driver) throws Exception {
		
		boolean isSuccess=false;
		
		By FirstButton = By.xpath(ObjectRepoProp.getProperty("FirstButton_Xpath"));
		By LastButton = By.xpath(ObjectRepoProp.getProperty("LastButton_Xpath"));

		if(getTotalNumberOfPages(driver)==1) {
			
			if(GUIFunctions.getAttribute(driver, FirstButton, "FirstButton", "class").contains("disabled")&&GUIFunctions.getAttribute(driver, LastButton, "LastButton", "class").contains("disabled"))
			
			GUIFunctions.updateReportWithMessage(driver, "",
					"First button and Last button are disabled as table has single page", "pass", true);
		}
		
		else {
			if(getCurrentPageNumber (driver)!=GUIFunctions.getTotalNumberOfPages(driver)) {
		
				try {

					GUIFunctions.clickElement(driver, LastButton, "Last Button");
					isSuccess=true;
					CustomFunc.waitTillLoadingObjectDisappears(driver, 60);
					
					/*
					 * Assert.assertTrue(GUIFunctions.getAttribute(driver, LastButton,
					 * "Last Button", "class") .contentEquals("disabled"),
					 * "Failure:Last button is not disabled");
					 * Assert.assertTrue(GUIFunctions.isElementEnabled(driver, FirstButton),
					 * "Failure: First Button is Not enabled");
					 */
					
					if(!GUIFunctions.getAttribute(driver, LastButton, "LastButton", "class")
							.contentEquals("disabled")) {
						GUIFunctions.updateReportWithMessage(driver, "",
								"LastButton is NOT disabled", "fail",
								true);
					}
					
					if(GUIFunctions.getAttribute(driver, FirstButton, "FirstButton", "class")
							.contentEquals("disabled")) {
						GUIFunctions.updateReportWithMessage(driver, "",
								"FirstButton is  disabled", "fail",
								true);
					}
					
					
					

				} catch (org.openqa.selenium.WebDriverException e) {
					GUIFunctions.updateReportWithMessage(driver, "",
							"CANNOT CLICK Last button. It seems to be disabled.You must be on Last page", "fail", true);
				}
			}
		}
		
		
		return isSuccess;

	}

	/**
	 * @method This method doesn't attach the exception in the report when the element is not expected to display
	 * @param 
	 * @param 
	 * @author Gururaj
	 */
	public static boolean isElementPresent(By by, WebDriver driver, boolean isExpected) {
		try {
			// Verify element is present			
			driver.findElement(by);
			if(isExpected) {
				return true;
			}
			else {
				return false;
			}
		} catch (NoSuchElementException e) {
			if(isExpected) {
				updateReportWithMessage(driver, "NoSuchElementPresent","No such element present : "+e.getLocalizedMessage(), "fail",true);
				return false;
			}
			else {
				return true;
			}


		}
	}
	/**
	 * @method selectDropDownByValue(WebDriver driver, By by, String dropDownValueToSelect, String optionType, String objName)
	 * @param driver
	 * @param by
	 * @param dropDownValueToSelect
	 * @param objName
	 * @return boolean
	 * @author Anil
	 */
	public static boolean selectDropDownByValue(WebDriver driver, By by, String dropDownValueToSelect, String objName)  {

		WebElement dpdwn = null;
		String selectedValue = "";
		boolean flag = false;
		try {
			try {
				dpdwn = driver.findElement(by);

			} catch (Exception e) {
				updateReportWithMessage(driver, "objIssue","Either UI field : "+objName+" doesn't exists in current page or issue in finding", "fail",true);
				Assert.fail("Either UI field : "+objName+" doesn't exists in current page or issue in finding");
			}

			Select dropDown = new Select(dpdwn);
			dropDown.selectByValue(dropDownValueToSelect);
			selectedValue = dropDown.getFirstSelectedOption().getText();
			if(selectedValue.equals(dropDownValueToSelect)) {
				updateReportWithMessage(driver, "selected",dropDownValueToSelect+" value selected from - "+objName+" drop down", "pass",true);
				flag = true;
			}
			else {
				updateReportWithMessage(driver, "Notselected","Actual selected value :"+selectedValue+" is different from expected value : "+dropDownValueToSelect+"to select from "+objName+" drop down", "pass",true);
				Assert.fail("Actual selected value :"+selectedValue+" is different from expected value : "+dropDownValueToSelect+"to select from "+objName+" drop down");
			}
		} catch (NoSuchElementException e) {
			updateReportWithMessage(driver, "Notselected","Something went wrong while selecting value : "+dropDownValueToSelect+" from "+objName+"drop down", "fail",true);
			Assert.fail("Something went wrong while selecting value : "+dropDownValueToSelect+" from "+objName+"drop down");
		}

		return flag;

	}

	/**
	 * @method selectDropDownByText(WebDriver driver, By by, String dropDownValueToSelect, String objName)
	 * @param driver
	 * @param by
	 * @param dropDownValueToSelect
	 * @param objName
	 * @return boolean
	 * @author Anil
	 */
	public static boolean selectDropDownByText(WebDriver driver, By by, String dropDownValueToSelect, String objName)  {

		WebElement dpdwn = null;
		String selectedValue = "";
		boolean flag = false;
		try {
			try {
				dpdwn = driver.findElement(by);

			} catch (Exception e) {
				updateReportWithMessage(driver, "objIssue","Either UI field : "+objName+" doesn't exists in current page or issue in finding", "fail",true);
				Assert.fail("Either UI field : "+objName+" doesn't exists in current page or issue in finding");
			}

			Select dropDown = new Select(dpdwn);
			dropDown.selectByVisibleText(dropDownValueToSelect);
			selectedValue = dropDown.getFirstSelectedOption().getText();
			if(selectedValue.equals(dropDownValueToSelect)) {
				updateReportWithMessage(driver, "selected","Value selected from - "+objName+" drop down is:["+dropDownValueToSelect+"]", "pass",true);
				flag = true;
			}
			else {
				updateReportWithMessage(driver, "Notselected","Actual selected value :"+selectedValue+" is different from expected value : "+dropDownValueToSelect+"to select from "+objName+" drop down", "pass",true);
				Assert.fail("Actual selected value :"+selectedValue+" is different from expected value : "+dropDownValueToSelect+"to select from "+objName+" drop down");
			}
		} catch (Exception e) {
			updateReportWithMessage(driver, "Notselected","Something went wrong while selecting value : "+dropDownValueToSelect+" from "+objName+"drop down : "+e.getMessage(), "fail",true);
			Assert.fail("Something went wrong while selecting value : "+dropDownValueToSelect+" from "+objName+"drop down");
		}

		return flag;

	}
 public static boolean isElementEnabled(WebDriver driver,By by) {

		if(driver.findElement(by).isEnabled())
			return true;
		else
			return false;		
	}
	
	public static boolean isElementPresent(By by, WebDriver driver, String objName) {
		try {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.findElement(by);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			return true;
		} catch (NoSuchElementException e) {
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			updateReportWithMessage(driver, "NoSuchElementPresent","Either : "+objName+" doesn't exists or issue in finding using property : "+by, "fail",true);			
			return false;
		}
	}
	
		
	/**
	 * validateCSSValue(WebDriver driver, By by, String eleName,String cssValueName, String expectedValue)
	 * @param driver
	 * @param by
	 * @param eleName
	 * @param CSS value Name
	 * @param Expected value of CSS attribute
	 * @return boolean
	 * @ 
	 * @Author Meenakshi
	 */
	public static boolean validateCSSValue(WebDriver driver, By by, String eleName,String cssValueName, String expectedValue) {
		boolean flag = false;
		String text = "";

		try {
			text = driver.findElement(by).getCssValue(cssValueName);
			if(text.contains(expectedValue)) {
				flag =   true;
			}else {
			updateReportWithMessage(driver, "FontOfCRSPNGLOGO", "Failure!!CSS Value"+cssValueName+" of element"+eleName+" is incorrect as Expected value is"+expectedValue+"but actual value is"+text+" Please check", "fail", true);
			}
			return flag;
		}
		catch(Exception e) {
			
			System.out.println("Either UI element is not present or issue while getting attribute : " +cssValueName+" : "+ e.getMessage());
			updateReportWithMessage(driver, "getAttribute","Either UI element "+eleName+":is not present or issue while getting attribute : " +cssValueName, "fail",true);
			return flag;
		}
		
		
	}
	
	
	/**
	 * validateCSSValue(WebDriver driver, By by, String eleName,String cssValueName, String expectedValue)
	 * @param driver
	 * @param by
	 * @param eleName
	 * @param Expected Font-text value
	 * @param Expected Font-size value
	 * @param Expected color value
	 * @return boolean
	 * @ 
	 * @Author Meenakshi
	 */
	public static boolean validateFontColorANDSizeAndText(WebDriver driver,By by,String eleName ,String FontText,String FontSize, String FontColor) {
		boolean flag = false;
		if(GUIFunctions.validateCSSValue(driver, by, eleName, "font-family", FontText)) {
			flag = false;
		}
		if(GUIFunctions.validateCSSValue(driver, by, eleName, "font-size", FontText)) {
			flag = false;
		}
		if(GUIFunctions.validateCSSValue(driver, by, eleName, "color", FontText)) {
			flag = false;
		}
		
		return flag;
	}
	
		/**
     * @method This method doesn't attach the exception in the report when the element is not expected to display
     * @param 
      * @param 
      * @author Gururaj
     */
     public static boolean validateElementIsNotPresent(By by, WebDriver driver,String elementName) {
           
           driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
           try {
                                      
                      driver.findElement(by);
                         driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                         GUIFunctions.updateReportWithMessage(driver, "elementAbsent", "FAILURE!"+elementName+" is present(not working as expected)", "fail", true);
                         return false;
                  
           } catch (NoSuchElementException e) {
                         driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                         GUIFunctions.updateReportWithMessage(driver, "elementAbsent", "SUCCESS!"+elementName+" is not present(working as expected)", "pass", false);
              return true;
           }
           

     }
     
     /**
 	 * takeScreenShot(WebDriver webdriver,String fileName)
 	 * @Description This function will take screenshot
 	 * @param webdriver
 	 * @param fileName
 	 * @return String - path of saved snap shot
 	 * @author Anil
 	 */
 	public static String takeRemoteWebDriverScreenShot(WebDriver webdriver,String fileName){

 		fileName = fileName.replace(" ", "");

 		String fileNameWithPathtimeStamp = System.getProperty("user.dir")+"/screenshots/"+fileName+"_"+CustomFunc.generateTimeStamp()+".png";
 		
 		WebDriver augmentedDriver = new Augmenter().augment(webdriver);
 		//Convert web driver object to TakeScreenshot
 		TakesScreenshot scrShot =((TakesScreenshot)augmentedDriver);
 		//Call getScreenshotAs method to create image file
 		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
 		//Move image file to new destination
 		File DestFile=new File(fileNameWithPathtimeStamp);
 		//Copy file at destination
 		try {
 			FileUtils.copyFile(SrcFile, DestFile);
 		} catch (IOException e) {
 			System.out.println("Exception in takeScreenShot() method, in GUIFunctions.java : "+e.getLocalizedMessage());
 		}

 		return fileNameWithPathtimeStamp;
 	}
 	
 	/**
	 * @method 
	 * @param 
	 * @param 
	 * @return 
	 * @author Gururaj
	 * @throws Exception 
	 */
	
	public static int getTotalNumberOfPages(WebDriver driver) throws Exception {
		

		By verfiyPageNum = By.xpath(ObjectRepoProp.getProperty("VerfiyPageNum_Xpath"));
		String MaximumPagesString = GUIFunctions.getAttribute(driver, verfiyPageNum, "Page number", "max");
		int MaximumNoOfPagesInt = Integer.parseInt(MaximumPagesString);
		
		return MaximumNoOfPagesInt;
		
		
	}
	/**
	 * @method 
	 * @param 
	 * @param 
	 * @return 
	 * @author Gururaj
	 * @throws Exception 
	 */
	public static int getCurrentPageNumber (WebDriver driver) throws Exception {
		By displayCurrentpageLabel = By.xpath(ObjectRepoProp.getProperty("DisplayCurrentpageLabel_Xpath"));

		String ActualPage = GUIFunctions.getText(driver, displayCurrentpageLabel, "Current Page");
		String [] pagestatus=ActualPage.split(" ");
		int ActualPageNum = Integer.parseInt(pagestatus[1].trim());
		return ActualPageNum;
	}
	
	
	
	
	/**
	 * @method 
	 * @param 
	 * @param 
	 * @return 
	 * @author Gururaj
	 * @throws Exception 
	 */
	public static boolean switchToNewTab (WebDriver driver, int newTabNumber) throws Exception {
		
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		
		
		//wait for the tab to open (time out 30 seconds)
		
		boolean isSuccess=true; 
		
		int count=0;		
		while(tabs.size()<(newTabNumber+1)&&count<60) {
			count++;
			Thread.sleep(2000);
			tabs=new ArrayList<String> (driver.getWindowHandles());			
			Reporter.log("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@tab size"+tabs.size());
			
			if(!(tabs.size()<(newTabNumber+1))&&count>=15){
				isSuccess=false;
				GUIFunctions.updateReportWithMessage(driver, "", "Problem in switching to new tab:"+newTabNumber+".Tab might not be present.", "fail", true);
				
			}
			
		}		
		if(isSuccess) {
		driver.switchTo().window(tabs.get(newTabNumber));		

		Thread.sleep(3000);
		}
		
		return isSuccess;
	}
	
	/**
	 * @method 
	 * @param 
	 * @param 
	 * @return 
	 * @author Gururaj
	 * @throws Exception 
	 */
	public static void closeCurrentTab (WebDriver driver) throws Exception {
		
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());		
				
		if(tabs.size()>1) {
			driver.close();
			GUIFunctions.updateReportWithMessage(driver, "", "After closing current tab", "pass", true);
		}
		else {
			GUIFunctions.updateReportWithMessage(driver, "", "No tab present to close", "fail", true);

		}		
		
	}
	
	
	/**
	 * @method 
	 * @param 
	 * @param 
	 * @return 
	 * @author Gururaj
	 * @throws Exception 
	 */
	public static void takeScreenshotOfWindowsApplications (String description,String path) throws Exception {
		Rectangle screenRect=new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		
		BufferedImage image = new Robot().createScreenCapture(screenRect);
		 ImageIO.write(image, "png", new File(path));	
		 
		Reporter.log("<br/> <p><font color=\"blue\">"+description+"</font><br/><a href="+path+" class=\"highslide\" rel=\"highslide\"> <img src="+path+"  alt=\"Highslide JS\" title=\"Click to enlarge\" hight=\'100\' width=\'100\'/></a><br/>");

		
	}

	
	
	
	
	
	
	
}