package com.flipkart.qa.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.flipkart.qa.pageobjects.Homepage;
import com.flipkart.qa.pageobjects.loginpage;
import com.flipkart.qa.utilities.loadpropfile;


public class login extends baseclass{
	Homepage hp;
	loginpage lp;
	
	loadpropfile prop = new loadpropfile();
	
	@Test(priority =1)
	public void loginmousehover() {
		hp=new Homepage(driver);
		hp.hoveronlogin();
		
		Assert.assertTrue(hp.newcust(), "new customer sign up option is not displayed");
		Assert.assertTrue(hp.orders(), "Orders is not displayed");
		Assert.assertTrue(hp.rewards());
		Assert.assertTrue(hp.whishlist());
		Assert.assertTrue(hp.flipkartpluszone(), "flipkart plus zone is not displayed");
		Assert.assertTrue(hp.giftcard());
	}
	
	@Test(priority = 2)
	public void checkelementsinloginpage()  {
		lp = hp.clickonlogin();
		Assert.assertEquals(lp.palceholder(), "Enter Email/Mobile number", "palceholder is not as expected");
		Assert.assertEquals(lp.logintxt(), "Login");
		Assert.assertEquals(lp.newacc(), "New to Flipkart? Create an account");
		lp.entermailid(prop.emailid());
		lp.requestotp();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='CONTINUE']")));
		Assert.assertTrue(lp.continuebtn(), "continue button is not displayed");
		
	 
	}
	@Test(priority =3)
	public void clickotpwithnoemailid()  {
		lp=new loginpage(driver);
		lp.clicklogin();
		lp.entermailid(" ");
		lp.requestotp();
		Assert.assertTrue(lp.emailwarning(), "warning msg not displayed");
	}
	
}
