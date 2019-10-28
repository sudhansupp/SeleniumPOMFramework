package com.demo.library;

import static com.demo.util.PropertyFileReader.ObjectRepoProp;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import static com.demo.util.PropertyFileReader.ObjectRepoProp;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.demo.config.BaseClass;
import com.jacob.com.LibraryLoader;
import com.relevantcodes.extentreports.LogStatus;
import uiFunctions.GUIFunctions;
import autoitx4java.AutoItX;
import utils.ExtentReports.ExtentTestManager;

public class AutoItFunctions {
	static AutoItX x;
	private final WebDriver driver;
	public AutoItFunctions(WebDriver driver) {

		this.driver = driver;


	}							
	/**
	 *
	 * Returns if the JVM is 32 or 64 bit version
	 */
	public static String jvmBitVersion(){
		return System.getProperty("sun.arch.data.model");
	}



	public static void EnterPKIPasswordAndClickOk(WebDriver driver, String Password) throws Exception {
		By loader = By.xpath(ObjectRepoProp.getProperty("MS_Loader_Xpath"));
		String jacobDllVersionToUse;

		if (jvmBitVersion().contains("32")) {
			jacobDllVersionToUse = "jacob-1.18-x86.dll";
		} else {
			jacobDllVersionToUse = "jacob-1.18-x64.dll";
		}
		File file = new File("lib", jacobDllVersionToUse);
		System.setProperty(LibraryLoader.JACOB_DLL_PATH, file.getAbsolutePath());

		Thread.sleep(5000);
		x = new AutoItX();
		x.setOption("WinTitleMatchMode", "2");
		x.winActivate("Siemens Corporate Entitlement Service");

		if (BaseClass.driverName.equalsIgnoreCase("CHROME")) 
		{
			
			
			for (int i = 0; i < 4; i++) { x.send("{TAB}", false); Thread.sleep(500); }
			 
			
			  Thread.sleep(2000); x.send("{ENTER}", false);
			 
			Thread.sleep(5000);
			x.send("{ENTER}", false);
			Thread.sleep(1000);
		}
		else 
		{
			for (int i = 0; i < 12; i++) {
				x.send("{TAB}", false);
				Thread.sleep(500);
			}
			x.send("{ENTER}", false);
			Thread.sleep(20000);
		}



		x.winActivate("Windows Security");
		x.winWaitActive("Windows Security");
		Thread.sleep(1000);
		
		for(int i=0;i<Password.length();i++) {
			String str="{NUMPAD"+Password.charAt(i)+"}";
			x.send(str, false);
		}
		
		
	
		
		
		x.send("{ENTER}", false);
		
		
		/*
		 * x.controlClick("Windows Security", "", "[CLASS:Edit;INSTANCE:1]");
		 * x.ControlSetText("Windows Security", "", "[CLASS:Edit;INSTANCE:1]",
		 * Password);
		 */
		Thread.sleep(1000);
		//x.controlClick("Windows Security", "", "[CLASS:Button;INSTANCE:2]");
		Thread.sleep(3000);
		CustomFunc.waitTillLoadingObjectDisappears(driver, loader, 20);

		
	}




}
