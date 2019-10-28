package com.demo.util;

import static com.demo.util.PropertyFileReader.FileTransferDataProp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.testng.Reporter;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

/**
 * @author : Jagadish Arahunasi
 * @Company : Siemens CT DD DS AA TEC
 * @Project : CRSP-NG Automation
 *
 */

public class ExcelFunctions {
	public static Logger log = Logger.getLogger(ExcelFunctions.class.getName());
	Fillo fillo;
	Connection connection;
	String path = System.getProperty("user.dir")+"\\TestData\\GlobalData.xlsx";

	public Connection getFilloConnection() throws FilloException {

	
			path = System.getProperty("user.dir")+"\\TestData\\GlobalData.xlsx";
		fillo = new Fillo();
		connection = fillo.getConnection(path);
		return connection;

	}

	/**
	 * getExcelDatafield Returns the Excel Cell value in string format for the
	 * given Query
	 * 
	 * @param field
	 *            : Column name of the data required
	 * @param sheetName
	 *            : Excel file Sheet name
	 * @param dataVersion
	 *            : Data Version is the data version of the details required.
	 * @return : String Value
	 */

	public String getExcelDatafield(String field, String sheetName, String dataVersion) {

		String dsValue = null;
		try {
			fillo = new Fillo();
			String strQuery = "Select " + field + " from " + sheetName + " where DataVersion='" + dataVersion + "'";
			connection = fillo.getConnection(path);
			Recordset recordset = connection.executeQuery(strQuery);

			while (recordset.next()) {
				dsValue = (recordset.getField(field));
			}
			recordset.close();
			connection.close();
		} catch (Exception e) {

			Reporter.log("Given Data Version " + dataVersion + " is not present in the Sheet " + sheetName);

			dsValue = "";
		}

		return dsValue;

	}
	
	

	public String getExcelDatafield(String path, String field,String columnName, String sheetName, String dataVersion) {

		String dsValue = null;
		try {
			fillo = new Fillo();
			String strQuery = "Select " + field + " from " + sheetName + " where "+columnName + " ='" + dataVersion + "'";
			System.out.println(strQuery);
			connection = fillo.getConnection(path);
			
			Recordset recordset = connection.executeQuery(strQuery);

			while (recordset.next()) {
				dsValue = (recordset.getField(field));
			}
			recordset.close();
			connection.close();
		} catch (Exception e) {

			Reporter.log("Given Data Version " + dataVersion + " is not present in the Sheet " + sheetName,true);
e.printStackTrace();
			dsValue = "";
		}

		return dsValue;

	}
	
	
public void insertPageLoadingTimeValuesInExcelSheet(String sheetName,String columnName, List<Long> timeValues) throws Exception{
Fillo fillo=new Fillo();
Connection connection=fillo.getConnection(System.getProperty("user.dir")+"\\TestData\\DynamicData\\PageLoadingTime.xlsx");
for(long s:timeValues){
String strQuery="INSERT INTO "+ sheetName +"("+columnName+") VALUES('"+s+"')";

connection.executeUpdate(strQuery);

} 
connection.close();
	}

}
