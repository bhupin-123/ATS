package com.ats_utilities;

import java.io.File;

import java.io.IOException;
import java.lang.reflect.Method;

import java.util.Date;
import java.util.Hashtable;

import org.apache.commons.io.FileUtils;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.ats_base.Base;
import com.relevantcodes.extentreports.ExtentReports;

public class Utilities extends Base {
	
	//This class contains the various common methods and utilities are required to automate tests effectively.
	
	//This method takes the screen shot and has been utilized in the listener so take the screenshot for every failure. 

	public static String screenshotname;

	public static void screenshot() {
		Date d = new Date();
		screenshotname = d.toString().replaceAll(" ", "_").replaceAll(":", "_") + ".jpg";

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {

			FileUtils.copyFile(src, new File(System.getProperty("user.dir") + "\\target\\" + screenshotname));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	//This method returns the log4j object needed for logs maintenance.

	public static Logger getlog4j(String name) {
		Logger log = Logger.getLogger(name);
		Date d = new Date();
		System.setProperty("current.date", d.toString().replace(":", "_").replace(" ", "_"));
		PropertyConfigurator.configure("./src/test/resources/Properties/log4j.properties");
		return log;

	}

	// Method to read excel file and add the details in the Hash-table.

	public static Hashtable<String, String> getExcelData(String sheet1) throws IOException {

		int totalrows = excel.getRowCount(sheet1);
		int totalcols = excel.getColumnCount(sheet1);
		Hashtable<String, String> hs = null;

		for (int rows = 1; rows < totalrows; rows++) {
			hs = new Hashtable<String, String>();
			for (int cols = 0; cols < totalcols; cols++) {

				hs.put(excel.getCellData(sheet1, 0, cols), excel.getCellData(sheet1, rows, cols));
			}

		}
		return hs;

	}
	
	//This method returns the extent report object 

	public static ExtentReports extReport;

	public static ExtentReports getinstance() {

		extReport = new ExtentReports(System.getProperty("user.dir") + "\\target\\extent.html");
		extReport.loadConfig(
				new File(System.getProperty("user.dir") + "\\src\\test\\resources\\Extentconfig\\ReportsConfig.xml"));
		return extReport;
	}

}
