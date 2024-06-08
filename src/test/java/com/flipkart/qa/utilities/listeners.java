package com.flipkart.qa.utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.flipkart.qa.pageobjects.Homepage;
import com.flipkart.qa.testcases.baseclass;

public class listeners implements ITestListener {

	ExtentReports extentreport;
	ExtentTest extenttest;

	public void onStart(ITestContext context) {
		extentreport = ExtentReport.GenerateExtentReport();

	}

	public void onTestStart(ITestResult result) {
		extenttest = extentreport.createTest(result.getName());
		extenttest.log(Status.INFO, result.getName() + "Test method started executing");
	}

	public void onTestSuccess(ITestResult result) {
		extenttest.log(Status.PASS, result.getName() + "Test method succesfully executed");
		String testname = result.getName();
		File screenshotfolder = new File("./screenshots/");
		if(testname.equalsIgnoreCase("capturehrscrollimages")) {
			
			  File[] screenshotFiles = screenshotfolder.listFiles();
			    if (screenshotFiles != null) {
			        for (File screenshotFile : screenshotFiles) {
			            extenttest.addScreenCaptureFromPath(screenshotFile.getAbsolutePath());
			        }   
			    }
			}
	}

	public void onTestFailure(ITestResult result) {
		String screenshotpath = baseclass.capturefailscreenshot(result.getName());
		 File screenshotFile = new File(screenshotpath);
		    if (screenshotFile.exists()) {
		        extenttest.addScreenCaptureFromPath(screenshotpath);
				// Alternatively, you can use the commented out line below
				// extenttest.fail(MediaEntityBuilder.createScreenCaptureFromPath(screenshotpath).build());
				 
		    } else {
		        extenttest.fail("Screenshot not found at path: " + screenshotpath);
		    }
		//extenttest.fail(MediaEntityBuilder.createScreenCaptureFromPath(screenshotpath).build());
		extenttest.log(Status.INFO, result.getThrowable());
		extenttest.log(Status.FAIL, result.getName() + "<b>Test method  got failed</b>");
	}

	public void onTestSkipped(ITestResult result) {
		extenttest.log(Status.INFO, result.getThrowable());
		extenttest.log(Status.SKIP, result.getName() + "Got skipped");
	}

	public void onFinish(ITestContext context) {
		extentreport.flush();
		try {
			Desktop.getDesktop().browse(new File("ExtentReports/ExtentReport.html").toURI());
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
