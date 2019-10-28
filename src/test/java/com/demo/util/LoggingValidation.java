package com.demo.util;

import org.apache.log4j.Logger;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;



public class LoggingValidation {
	public static Logger log = Logger.getLogger(LoggingValidation.class.getName());
	// static String desktopPath = System.getProperty("user.home") + "\\Desktop";

	static String desktopPath = System.getProperty("user.dir")+"\\Test_Results";
	static String relativePath = desktopPath + "\\TestResultExtentReport"+".html";

	public static ExtentReports report = new ExtentReports();
	
	public static ExtentTest logger;
	
	public static void test() {
//		report.
	}
}
