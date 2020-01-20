package com.ats_base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.ats_base.Base;
import com.ats_pages.CreateProjectPage;
import com.ats_utilities.ExcelUtility;
import com.ats_utilities.Utilities;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Base {

	// This class initialize the few common objects like driver, .properties file,
	// extent report, log4j and other classes will extent this class to utilize
	// these objects.

	public static WebDriver driver;
	public static Properties config = new Properties();
	public static FileInputStream fis;
	public static Logger log = Utilities.getlog4j(Base.class.getName());
	public static WebDriverWait wait;
	public static ExtentReports extReport = Utilities.getinstance();
	public static ExtentTest extTest;
	public static ExcelUtility excel = null;
	public static String browser;

	@BeforeTest
	public void testsetup() throws IOException {
		if (driver == null) {

			fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\Properties\\config.properties");
			config.load(fis);

			if (config.getProperty("browser").equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\src\\test\\resources\\Executables\\chromedriver.exe");
				driver = new ChromeDriver();
				log.info("chromedriver initilized");
			}
			if (config.getProperty("browser") == "firefox") {
				// Fire fox-driver

			}

			driver.get(config.getProperty("applicationurl"));
			log.info("application opened ");

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			log.info("browser maximized ");

			wait = new WebDriverWait(driver, 7);

			excel = new ExcelUtility(System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\TestData.xlsx");

		}

	}

	// This method accepts webElement and perform click operation.
	public void click(WebElement element) {

		extTest.log(LogStatus.PASS, "element clicked successfully : " + element.getText());
		log.info("element clicked " + element);
		element.click();

	}
	// This method accepts webElement, string value and enters that value in the
	// edit box.

	public void editBox(WebElement element, String value) {

		element.sendKeys(value);

		log.info("Values entered in the element " + element);
		extTest.log(LogStatus.PASS, "Detail entered in the field : " + value);

	}

	// This method accepts the webElement, string value and enters that value in the
	// drop down.

	public void dynamicDropdown(WebElement element, String value) throws InterruptedException {
		element.sendKeys(value);
		CreateProjectPage crtProj = new CreateProjectPage();
		try {
		 wait.until(ExpectedConditions.visibilityOf(crtProj.dropDown()));} catch(Exception e) { 
		 }

		element.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		Thread.sleep(500);
		log.info(element + " selected with value:- " + value);
		extTest.log(LogStatus.PASS, "Value entered in the dropdown : " + value);

	}

	// To quit WebDriver instance
	@AfterTest
	public void testclose() throws InterruptedException {
		Thread.sleep(5000);
		if (driver != null) {
			driver.quit();
		}
		log.info("Test execution completed");


	}

}
