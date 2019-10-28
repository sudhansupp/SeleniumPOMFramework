package com.demo.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.transform.TransformerException;

import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Recordset;

/**
 * @author : Jagadish Arahunasi
 * @Company : Siemens CT DD DS AA TEC
 * @Project : CRSP-NG Automation
 */

public class TestNGSuiteCreator {
	static XmlSuite	newSuite ;
	static XmlSuite mainSuite ;
	static XmlSuite usersuite;
	static XmlSuite systemManagementSuite;
	static XmlSuite loginSuite;
	static XmlSuite connectToRemoteSuite;
	static FileWriter writer = null;
	static FileWriter mainSuitewriter = null;
	static List<String> suite_a = new ArrayList<String>();
	static boolean isMain = false;
	static File file;

	/**
	 * This method Creates a TestSuite with Details provided in the TestData Sheet.
	 * @param recordset: Recordset Instance
	 * @param connection : Fillo Connection
	 * @param ef : ExcelFunctions Instance
	 * @param moduleName :Module Name String to be printed in the String
	 * @param TestsheetName : Sheet name of the Excel file, where the test cases are saved.
	 */
	public static void createTestSuite(Recordset recordset,Connection connection,ExcelFunctions ef,String moduleName,String TestsheetName ) {
		try{
			
			newSuite = new XmlSuite();
			newSuite.setName(moduleName);
			newSuite.addListener("org.uncommons.reportng.HTMLReporter");
			newSuite.addListener("org.uncommons.reportng.JUnitXMLReporter");
			newSuite.addListener("utils.Listeners.TestListener");
			newSuite.addListener("com.demo.util.Screenshot");

			recordset = connection.executeQuery("Select * from "+ TestsheetName+" where Exucute ='YES' ");
			while (recordset.next()) {
				XmlTest test = new XmlTest(newSuite);
				test.setName(recordset.getField("Test_Case_Name")+ " " +recordset.getField("Locale") + " " + recordset.getField("Browser"));

				// test.setPreserveOrder ("true");
				Map<String, String> testngParams = new HashMap<String, String>();

				// Assigning the RELATIVE_TC.
			
				testngParams.put("Browser", recordset.getField("Browser"));
				testngParams.put("Locale", recordset.getField("Locale"));
				// Add any parameters that you want to set to the Test.
				test.setParameters(testngParams);
				List<XmlClass> classes = new ArrayList<XmlClass>();
				if (!recordset.getField("PreCondition").equalsIgnoreCase("NA")) {
					String[] array = recordset.getField("PreCondition").split(",");
					for (int j = 0; j < array.length; j++) {

						String sheetName = null;
						if (array[j].endsWith("L")) {
							sheetName = "LoginModule";
						} 
						Connection connection1 = ef.getFilloConnection();
						Recordset recordset1 = connection1.executeQuery("Select * from " + sheetName + " where TC_ID ='" + array[j] + "' and Locale='English'");
						while (recordset1.next()) {
							XmlClass preConditionClass = new XmlClass();

							preConditionClass.setName("com.demo.test." + recordset1.getField("Module_Name") + "."
									+ recordset1.getField("Test_Case_Name"));
							classes.add(preConditionClass);

						}
					}
				}
				XmlClass testClass = new XmlClass();
				testClass.setName("com.demo.test." + recordset.getField("Module_Name") + "."
						+ recordset.getField("Test_Case_Name"));
				classes.add(testClass);
				test.setXmlClasses(classes);

			}	
			File file = new File(System.getProperty("user.dir") + "/TestSuites/"+TestsheetName + ".xml");
			writer = new FileWriter(file);
			writer.write(newSuite.toXml());
			writer.close();
			//recordset.close();
			//connection.close();
			System.out.println("suite File saved!");

		}
		catch (Exception pce) {
			System.out.println("No TestCases are added for execution suite : "+pce.getMessage());
		}


	}

	

	/**
	 * Execution Starts from here, it reads Globaldata.xslx and creates testNG
	 * suites for Execution for the given modules and executes them.
	 * @param argv
	 * @throws FilloException
	 * @throws IOException
	 * @throws TransformerException
	 */

	public static void main(String argv[]) throws FilloException, IOException, TransformerException {
System.out.println("Inside the main method");
		String moduleName;

		mainSuite = new XmlSuite();
		mainSuite.setName("ActualDriverSuite");
		//mainSuite.addListener("org.uncommons.reportng.HTMLReporter");
		//mainSuite.addListener("org.uncommons.reportng.JUnitXMLReporter");
		//mainSuite.addListener("utils.Listeners.TestListener");
		//mainSuite.addListener("com.demo.util.Screenshot");

		try {
			ExcelFunctions ef = new ExcelFunctions();
			Connection connection = ef.getFilloConnection();
			Recordset recordset = connection.executeQuery("Select * from DriverSheet where Exucute ='YES' ");

			while(recordset.next()) {
				moduleName = recordset.getField("Module");
				System.out.println("Module : "+moduleName);
				createTestSuite(recordset,connection,ef,moduleName,moduleName);
				suite_a.add(System.getProperty("user.dir") + "/TestSuites/"+moduleName+".xml");				
			}

			try {
				mainSuite.setSuiteFiles(suite_a);
				file = new File(System.getProperty("user.dir") + "/TestSuites/TestSuite_Main.xml");
				mainSuitewriter = new FileWriter(file);

				mainSuitewriter.write(mainSuite.toXml());
				mainSuitewriter.close();

				recordset.close();
				connection.close();
			} catch (Exception e) {
				System.out.println("While writing into main suite getting exception : "+e.getMessage());
			}

		} catch (Exception pce) {
			System.out.println("TestData Issue : Please provide atleast one YES to respective module to execute."+pce.getMessage());
		}
	}

}
