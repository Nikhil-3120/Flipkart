package com.flipkart.qa.utilities;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {

	

	public static ExtentReports GenerateExtentReport() {

		ExtentReports extentreport = new ExtentReports();
		File reportfile = new File("./ExtentReports/ExtentReport.html");
		ExtentSparkReporter sparkreport = new ExtentSparkReporter(reportfile);

		sparkreport.config().setTheme(Theme.DARK);
		sparkreport.config().setReportName("Flipkart automation results");
		sparkreport.config().setDocumentTitle("Flipkart Automation Test Report");
		sparkreport.config().setTimeStampFormat("dd/mm//yyyy hh:mm:ss");
		extentreport.attachReporter(sparkreport);

		extentreport.setSystemInfo("Application URL", loadpropfile.geturl() );
		extentreport.setSystemInfo("Browser name", loadpropfile.browsername());
		extentreport.setSystemInfo("Operating System", System.getProperty("os.name"));
		extentreport.setSystemInfo("User Name", System.getProperty("user.name"));
		extentreport.setSystemInfo("java version", System.getProperty("java.version"));

		return extentreport;

	}
}
