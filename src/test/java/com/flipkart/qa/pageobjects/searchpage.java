package com.flipkart.qa.pageobjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class searchpage {

	WebDriver driver;

	public searchpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[normalize-space()='Filters']/ancestor::div[3]")
	WebElement Filters;

	@FindBy(xpath = "//span[normalize-space()='Filters']/ancestor::div[3]//section")
	List<WebElement> Filtersections;

	List<String> filterlist = new ArrayList<String>();

	public List<String> getfiltersectionlist() {
		for (WebElement filters : Filtersections) {
			filterlist.add(filters.getText());
		}
		return filterlist;
	}

	@FindBy(xpath = "//div[@class='bpjkJb']//span")
	List<WebElement> toptabs;

	@FindBy(xpath = "//a[@class='TSD49J']")
	List<WebElement> tablinks;

	public List<String> colorbeforehover = new ArrayList<String>();

	public List<String> colorafterhover = new ArrayList<String>();

	public void tabtextcolorchanging() {

		for (WebElement ele : toptabs) {
			ele.getCssValue("color");
			colorbeforehover.add(ele.getCssValue("color"));
		}

		Actions act = new Actions(driver);
		for (WebElement ele : toptabs) {
			act.moveToElement(ele).perform();
			ele.getCssValue("color");
			colorafterhover.add(ele.getCssValue("color"));
		}

		for (WebElement ele : tablinks) {
			colorbeforehover.add(ele.getCssValue("color"));
		}

		for (WebElement ele1 : tablinks) {
			act.moveToElement(ele1).perform();
			colorafterhover.add(ele1.getCssValue("color"));
		}

	}

	@FindBy(xpath = "//span[normalize-space()='Filters']/ancestor::div[3]/../../../../div//div[@class='_75nlfW']")
	List<WebElement> productsonsearchpage;

	@FindBy(xpath = "//span[normalize-space()='Filters']/ancestor::div[3]/../../../../div//div[@class='_75nlfW']//a//img")
	List<WebElement> productslink;

	List<String> productslist = new ArrayList<String>();

	public List<String> products() {

		for (WebElement pro1 : productslink) {
			productslist.add(pro1.getAttribute("alt"));
		}
		return productslist;
	}

	@FindBy(xpath = "//span[normalize-space()='Back to top']")
	WebElement backtotopbtn;

	public boolean scrolltotop() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollTop)");
		return backtotopbtn.isDisplayed();
	}

	public boolean scrolltobottom() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		return backtotopbtn.isDisplayed();

	}

	public boolean scrollingpage() {
		searchpage search = new searchpage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		for (int i = 0; i < 10; i++) {
			search.scrolltobottom();
			wait.until(ExpectedConditions.visibilityOf(backtotopbtn));
			search.scrolltotop();
			wait.until(ExpectedConditions.invisibilityOf(backtotopbtn));
		}
		return true;
	}
}
