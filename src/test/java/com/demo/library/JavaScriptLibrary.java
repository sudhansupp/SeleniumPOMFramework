package com.demo.library;

import java.util.concurrent.TimeUnit;
import static com.demo.util.PropertyFileReader.ObjectRepoProp;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import uiFunctions.GUIFunctions;


public class JavaScriptLibrary {
	
	public static By disabledSaveButton= By.xpath(ObjectRepoProp.getProperty("disabledSaveButton_Xpath"));
	/**
	 * @method scrollIntoView(WebDriver driver,By by)
	 * @param driver
	 * @param by
	 * @author Anil
	 */
	public static void scrollIntoView(WebDriver driver,By by) {
		WebElement element = null;
		try {
			CustomFunc.waitTillLoadingObjectDisappears(driver, 60);
			waitUntilPageReady(driver,60);
			element = driver.findElement(by);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			GUIFunctions.updateReportWithMessage(driver, "scrollIntoView", "Scrolling to desired object view", "pass", false);
		} catch (Exception e) {
			GUIFunctions.updateReportWithMessage(driver, "scrollIntoView", "Either isue in finding the object using by : "+by+" or check for any other issue", "fail", true);
			//Assert.fail("Either issue in finding the object using by : "+by+" or check for any other issue");
		}
	}
	
	/**
	 * @method scrollIntoView(WebDriver driver,WebElement obj, String objName)
	 * @param driver
	 * @param WebElement obj
	 * @param  String objName
	 * @author Anil
	 */
	public static void scrollIntoView(WebDriver driver,WebElement obj, String objName) {
		WebElement element = null;
		try {
			CustomFunc.waitTillLoadingObjectDisappears(driver, 60);
			waitUntilPageReady(driver,60);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", obj);
			GUIFunctions.updateReportWithMessage(driver, "scrollIntoView", "Scrolling to desired object view", "pass", false);
		} catch (Exception e) {
			GUIFunctions.updateReportWithMessage(driver, "scrollIntoView", "Either isue in finding the object "+objName+" by using :"+obj+" or check for any other issue", "fail", true);
			//Assert.fail("Either issue in finding the object using by : "+by+" or check for any other issue");
		}
	}
	
	
	/**
	 * @method  javaScriptClick(WebDriver driver,By by)
	 * @param driver
	 * @param By by
	 * @throws Exception
	 * @return boolean
	 * @author Anil
	 */
	public static boolean javaScriptClick(WebDriver driver,By by) throws Exception {
		boolean flag = false;
		try {
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			WebElement element = driver.findElement(by);
			if (element.isEnabled() && element.isDisplayed()) {
				System.out.println("Clicking on element with using java script click");
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
				flag = true;
			} else {
				GUIFunctions.updateReportWithMessage(driver, "NotFound", "Issuein finding the object enablility and visibility : "+by, "fail", true);
				Assert.fail("Issuein finding the object enablility and visibility : "+by);
			}		
		} catch (Exception e) {
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			GUIFunctions.updateReportWithMessage(driver, "NotFound", "Unable to find the object using the property : "+by, "fail", true);
			Assert.fail("Unable to find the object using the property : "+by);
		}
		
		return flag;
	}
	
	
	/**
	 * @method  javaScriptClick(WebDriver driver,WebElement element, String objName)
	 * @param driver
	 * @param WebElement element
	 * @param String objName
	 * @throws Exception
	 * @return boolean
	 * @author Anil
	 */
	public static boolean javaScriptClick(WebDriver driver,WebElement element, String objName) throws Exception {
		boolean flag = false;
		try {
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			if (element.isEnabled() && element.isDisplayed()) {
				System.out.println("Clicking on element with using java script click");
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
				Thread.sleep(1000);
				GUIFunctions.updateReportWithMessage(driver, "clicked", "Clicked on : "+objName+ " object on UI", "pass", true);
				flag = true;
			} else {
				GUIFunctions.updateReportWithMessage(driver, "NotFound", "Issue in finding the object enablility and visibility using: "+element, "fail", true);
				Assert.fail("Issuein finding the object enablility and visibility using : "+element);
			}		
		} catch (Exception e) {
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			GUIFunctions.updateReportWithMessage(driver, "NotFound", "Unable to find the object : "+objName+" using the property : "+element, "fail", true);
			Assert.fail("Unable to find the object : "+objName+"  using the property : "+element);
		}
		
		return flag;
	}
	
	/**
	 * @method waitUntilPageReady(WebDriver driver, long pageLoadTimeout)
	 * @param driver
	 * @param int pageLoadTimeout
	 * @author Anil
	 */
	public static void waitUntilPageReady(WebDriver driver, long pageLoadTimeout) {
		new WebDriverWait(driver, pageLoadTimeout).until(
		          webDriver ->((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
	}
	public static boolean javaScriptClickForDisabledButton(WebDriver driver,WebElement element, String objName) throws Exception {
		boolean flag = false;
		try {
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			if (element!=null) {
				System.out.println("Clicking on element with using java script click");
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
				Thread.sleep(1000);
				GUIFunctions.updateReportWithMessage(driver, "clicked", "Clicked on : "+objName+ " object on UI", "pass", true);
				flag = true;
			} else {
				GUIFunctions.updateReportWithMessage(driver, "NotFound", "Issue in finding the object visibility using: "+element, "fail", true);
				Assert.fail("Issuein finding the object enablility and visibility using : "+element);
			}		
		} catch (Exception e) {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			GUIFunctions.updateReportWithMessage(driver, "NotFound", "Unable to find the object : "+objName+" using the property : "+element, "fail", true);
			Assert.fail("Unable to find the object : "+objName+"  using the property : "+element);
		}
		
		return flag;
	}
}
