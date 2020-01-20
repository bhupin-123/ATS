package com.ats_listeners;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.ats_base.Base;
import com.ats_utilities.Utilities;
import com.relevantcodes.extentreports.LogStatus;

public class TestListeners extends Base implements ITestListener {

	public void onTestStart(ITestResult result) {
		// Initialize extent report and log object for every method

		extTest = extReport.startTest(result.getName());
		log = Logger.getLogger(result.getTestClass().getName());
	}

	public void onTestSuccess(ITestResult result) {

	}

	public void onTestFailure(ITestResult result) {
		// On test case failure capture the screenshot and log that screenshot and error message in the extent report and log file.
		Utilities.screenshot();
		extTest.log(LogStatus.FAIL, "Verification failed with exception: "+result.getThrowable());
		// To create a extent reports screenshots with from local repository
			extTest.log(LogStatus.FAIL, extTest.addScreenCapture(System.getProperty("user.dir")+"\\target\\"+Utilities.screenshotname));
			log.error("verification failed with Exception : "+result.getThrowable());

	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		// close the extent report object.
		extReport.endTest(extTest);
		extReport.flush();

	}

}
