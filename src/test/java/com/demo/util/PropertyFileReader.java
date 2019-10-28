package com.demo.util;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
/**
 * @author : Jagadish Arahunasi
 * @Company : Siemens CT DD DS AA TEC
 * @Project : CRSP-NG Automation
 */
public class PropertyFileReader {
	public static Logger log = Logger.getLogger(PropertyFileReader.class.getName());
	public static Properties ObjectRepoProp;
	public static Properties TextProp;
	public static Properties DynamicDataProp;
	public static Properties StyleSheetProp;
	public static Properties FileTransferDataProp;
	public static Properties ConnectivityPreConditionProp;
	/**
	 * This method Initiates the Object Repository and loads the text property file and Dynamic Object Repo files
	 * file based on the locale passed
	 * 
	 * @param locale
	 */
	public static void loadPropertyFile(String locale) {

		ObjectRepoProp = new Properties();
		TextProp = new Properties();
		DynamicDataProp = new Properties();
		StyleSheetProp = new Properties();
		FileTransferDataProp=new Properties();
		ConnectivityPreConditionProp=new Properties();
		try {

			ObjectRepoProp.load(
					new FileInputStream(System.getProperty("user.dir")+"\\ObjectRepository\\ObjectRepository.properties"));
			
			
			switch (locale) {
			case "English":
				TextProp.load(
						new FileInputStream(System.getProperty("user.dir")+"\\TestData\\TextData\\Text_Eng.properties"));
				break;

			case "German":
				TextProp.load(new FileInputStream(
						System.getProperty("user.dir")+"\\TestData\\TextData\\Text_German.properties"));
				break;

			case "French":
				TextProp.load(new FileInputStream(
						System.getProperty("user.dir")+"\\TestData\\TextData\\Text_French.properties"));
				break;

			case "Chinese":
				TextProp.load(
						new FileInputStream(System.getProperty("user.dir")+"\\TestData\\TextData\\Text_CN.properties"));
				break;
			}

		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
