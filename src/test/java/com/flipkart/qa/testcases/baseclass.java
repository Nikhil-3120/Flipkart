package com.flipkart.qa.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.flipkart.qa.pageobjects.Homepage;
import com.flipkart.qa.utilities.listeners;
import com.flipkart.qa.utilities.loadpropfile;

public class baseclass {

	public static WebDriver driver;
	loadpropfile lpf = new loadpropfile();

	public static File failedtestscreenshotpath;

	@Parameters("browser")
	@BeforeClass
	public void lauchbrowser(String browser) {
		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			System.out.println("bowser driver not available");
		}
		driver.manage().window().maximize();
		driver.get(loadpropfile.geturl());
	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}

	public static void capturescreenshot() {
		File src = Homepage.screenshotelement.getScreenshotAs(OutputType.FILE);
		File target = new File("./screenshots/" + Homepage.screenshotname + ".png");
		try {
			FileUtils.copyFile(src, target);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public static String capturefailscreenshot(String Testname) {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String screenshotpath = "../failedtestsscreenshots/" + Testname + ".jpg";
		File failedtestscreenshotpath = new File(screenshotpath);

		try {
			FileUtils.copyFile(src, failedtestscreenshotpath);
		} catch (IOException e) {

			e.printStackTrace();
		}
		return screenshotpath;
	}

	public boolean validatesuggestionlist(ArrayList<String> suggestionlist) {
		for (String eachsuggvalues : suggestionlist) {
			if (eachsuggvalues.toLowerCase().contains(lpf.getsearchinput())) {
				return true;
			}
		}
		return false;
	}
}
