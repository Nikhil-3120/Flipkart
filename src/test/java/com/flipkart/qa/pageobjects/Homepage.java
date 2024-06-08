package com.flipkart.qa.pageobjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.flipkart.qa.testcases.baseclass;

public class Homepage {
	WebDriver driver;

	public Homepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String pagetitle() {
		String actualtitle = driver.getTitle();
		return actualtitle;
	}

	@FindBy(xpath = "//span[contains(text(),'Grocery')]")
	WebElement grocery;

	@FindBy(xpath = "//span[contains(text(),'Mobiles')]")
	WebElement mobiles;

	@FindBy(xpath = "(//span[contains(text(),'Appliances')])[1]")
	WebElement Appliances;

	@FindBy(xpath = "//span[contains(text(),'Travel')]")
	WebElement Travel;

	public boolean grocery() {
		Actions act = new Actions(driver);
		act.moveToElement(grocery).perform();
		return grocery.isDisplayed();
	}

	public boolean mobiles() {
		Actions act = new Actions(driver);
		act.moveToElement(mobiles).perform();
		return mobiles.isDisplayed();
	}

	public boolean Appliances() {
		Actions act = new Actions(driver);
		act.moveToElement(Appliances).perform();
		return mobiles.isDisplayed();
	}

	public boolean Travel() {
		Actions act = new Actions(driver);
		act.moveToElement(Travel).perform();
		return mobiles.isDisplayed();
	}

	@FindBy(xpath = "//span[contains(text(),'Fashion')]")
	WebElement Fashion;

	@FindBy(xpath = "//body/div/div[1]/object[1]/a")
	List<WebElement> fashiondropdown;

	@FindBy(xpath = "//body[1]/div[4]/div[2]/object[1]")
	List<WebElement> subfashiondropdown;

	public List<String> mainfashionlist = new ArrayList<String>();
	public List<String> subfashionlist = new ArrayList<String>();

	public void fashion() {
		Actions act1 = new Actions(driver);
		act1.moveToElement(Fashion).perform();

		for (WebElement fas : fashiondropdown) {
			act1.moveToElement(fas).perform();
			mainfashionlist.add(fas.getText());

			for (WebElement subfas : subfashiondropdown) {
				subfashionlist.add(subfas.getText());
			}
		}
	}

	@FindBy(xpath = "//span[normalize-space()='Login']")
	WebElement loginbtn;

	public loginpage clickonlogin() {
		loginbtn.click();
		return new loginpage(driver);
	}

	public void hoveronlogin() {
		Actions act = new Actions(driver);
		act.moveToElement(loginbtn).perform();
	}

	@FindBy(xpath = "//span[normalize-space()='New customer?']")
	WebElement newcustomer;

	@FindBy(xpath = "//a[@title='My Profile']")
	WebElement myprofile;

	@FindBy(xpath = "//a[@title='Flipkart Plus Zone']")
	WebElement pluszone;

	@FindBy(xpath = "//a[@title='Orders']")
	WebElement Orders;

	@FindBy(xpath = "//a[@title='Wishlist']")
	WebElement Whishlist;

	@FindBy(xpath = "//a[@title='Rewards']")
	WebElement Rewards;

	@FindBy(xpath = "//a[@title='Gift Cards']")
	WebElement Giftcards;

	public boolean newcust() {
		return newcustomer.isDisplayed();
	}

	public boolean flipkartpluszone() {
		return pluszone.isDisplayed();
	}

	public boolean orders() {
		return Orders.isDisplayed();
	}

	public boolean whishlist() {
		return Whishlist.isDisplayed();
	}

	public boolean rewards() {
		return Rewards.isDisplayed();
	}

	public boolean giftcard() {
		return Giftcards.isDisplayed();
	}

	@FindBy(xpath = "//div[@class='_3bzdSa']//div[@data-clone='false']//a")
	List<WebElement> HRscrollinganime;

	@FindBy(xpath = "//div[@class='css-175oi2r r-u8s1d']//div[@class='css-175oi2r']")
	WebElement scrolldots;

	public static String screenshotname;
	public static WebElement screenshotelement;

	public void scrollanimation() {
		for (WebElement image : HRscrollinganime) {

			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
					.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);

			wait.until(ExpectedConditions.visibilityOf(image));

			String imagenames = image.getAttribute("href");
			screenshotname = imagenames.substring(imagenames.length() - 20, imagenames.length());
			screenshotelement = image;
			baseclass.capturescreenshot();

		}
	}

	@FindBy(xpath = "//span[contains(text(),'Electronics')]")
	WebElement Electronics;

	@FindBy(xpath = "//div[@class='_16rZTH']//object/a")
	List<WebElement> Electronicsdropdown;

	@FindBy(xpath = "//div[@class='_31z7R_']//object/a")
	List<WebElement> Subelectronicslist;

	public List<String> mainprolist = new ArrayList<String>();
	public List<String> subprolist = new ArrayList<String>();

	public void hoveronelectronics() {
		Actions act = new Actions(driver);
		act.moveToElement(Electronics).perform();

		for (WebElement fas : Electronicsdropdown) {
			act.moveToElement(fas).perform();
			mainprolist.add(fas.getText());

			for (WebElement subfas : Subelectronicslist) {
				subprolist.add(subfas.getText());
			}

		}

	}

	@FindBy(xpath = "//span[contains(text(),'Home & Furniture')]")
	WebElement Homenfurniture;

	@FindBy(xpath = "//div[@class='_16rZTH']//object/a")
	List<WebElement> furniturelist;

	@FindBy(xpath = "//div[@class='_31z7R_']//object/a")
	List<WebElement> Subfurniturelist;

	public List<String> mainfurlist = new ArrayList<String>();
	public List<String> subfurlist = new ArrayList<String>();

	public void hoveronfurniture() {
		Actions act = new Actions(driver);
		act.moveToElement(Homenfurniture).perform();

		for (WebElement fas : furniturelist) {
			act.moveToElement(fas).perform();
			mainfurlist.add(fas.getText());

			for (WebElement subfas : Subfurniturelist) {
				subfurlist.add(subfas.getText());
			}

		}
	}

	@FindBy(xpath = "//input[@title='Search for Products, Brands and More']")
	WebElement Searchtextfield;

	@FindBy(xpath = "//button[@title='Search for Products, Brands and More']")
	WebElement searchbutton;

	@FindBy(xpath = "//input[@placeholder='Search for Products, Brands and More']/../../following-sibling::ul/li/div")
	List<WebElement> Searchautosuggestionlist;

	public ArrayList<String> autosugglist = new ArrayList<String>();

	public void search(String product) {
		Searchtextfield.sendKeys(product);
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(5))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);

		wait.until(ExpectedConditions.visibilityOfAllElements(Searchautosuggestionlist));

		for (WebElement sugglist : Searchautosuggestionlist) {

			String suggproduct = sugglist.getText();
			autosugglist.add(suggproduct);
		}

	}

	public String searchbarplaceholder() {
		return Searchtextfield.getAttribute("placeholder");
	}

	public searchpage clicksearchbtn() {
		searchbutton.click();
		return new searchpage(driver);
	}

	@FindBy(xpath = "(//div[.='Refresh Page'])[1]")
	WebElement Refreshbutton;

	public void refreshbtn() {
		Refreshbutton.click();
	}

	@FindBy(xpath = "//span[contains(text(),'Beauty, Toys & More')]")
	WebElement toys;

	@FindBy(xpath = "//div[@class='_16rZTH']//object/a")
	List<WebElement> maintoyslist;

	@FindBy(xpath = "//div[@class='_31z7R_']//object/a")
	List<WebElement> subtoyslist;

	public List<String> maintoylist = new ArrayList<String>();
	public List<String> subtoylist = new ArrayList<String>();

	public void toysandmore() {
		Actions act = new Actions(driver);
		act.moveToElement(toys).perform();

		for (WebElement maintoy : maintoyslist) {
			act.moveToElement(maintoy).perform();
			maintoylist.add(maintoy.getText());

			for (WebElement subtoy : subtoyslist) {
				subtoylist.add(subtoy.getText());
			}
		}
	}

	@FindBy(xpath = "//span[contains(text(),'Two Wheelers')]")
	WebElement twowheelers;

	@FindBy(xpath = "//div[@class='_16rZTH']//object/a")
	List<WebElement> twowheelerdropdown;

	public List<String> twowheelerlist = new ArrayList<String>();

	public void twowheeler() {
		Actions act = new Actions(driver);
		act.moveToElement(twowheelers).perform();

		for (WebElement twowheellist : twowheelerdropdown) {
			twowheelerlist.add(twowheellist.getText());
		}
	}
}
