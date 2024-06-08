package com.flipkart.qa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpage {
   WebDriver driver;
	public loginpage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//input[@type='text'])[2]")
	WebElement emailtextfield;
	
	@FindBy(xpath = "//span[normalize-space()='Enter Email/Mobile number']")
	WebElement emailplaceholder;
	
	@FindBy(xpath = "//button[normalize-space()='Request OTP']")
	WebElement OTPbtn;
	
	@FindBy(xpath = "//span[contains(text(),'Login')]")
	WebElement logintext;
	
	@FindBy(linkText = "New to Flipkart? Create an account")
	WebElement createacc;
	
	public void entermailid(String email) {
		emailtextfield.sendKeys(email);
	}
	
	public String palceholder() {
		 String epl = emailplaceholder.getText();
		 return epl;
	}
	
	public void requestotp() {
		OTPbtn.click();
	}
	
	public String logintxt() {
		String logintxt = logintext.getText();
		return logintxt;
	}
	
	public String newacc() {
		String linktxt = createacc.getText();
		return linktxt;
	}
	
	@FindBy(xpath = "//span[contains(text(),'Please enter valid Email ID/Mobile number')]")
	WebElement emailwarning;
	
	public boolean emailwarning() {
		return emailwarning.isDisplayed();
	}
	
	@FindBy(xpath = "//a[normalize-space()='Login']")
	WebElement loginlink;
	
	public void clicklogin() {
		loginlink.click();
	}
	@FindBy(xpath = "//span[normalize-space()='CONTINUE']")
	WebElement continuebtn;
	
	public boolean continuebtn() {
		return continuebtn.isDisplayed();
		
	}

	
}
