package com.flipkart.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.flipkart.qa.pageobjects.Homepage;

public class home extends baseclass {
	Homepage hp;

	@Test(priority = 7)
	public void Fashion() {
		hp = new Homepage(driver);
		hp.fashion();
		Assert.assertEquals(hp.pagetitle(),
				"Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
        Assert.assertFalse(hp.mainfashionlist.isEmpty(), "Fashion dropdown mainlist is empty");
        Assert.assertFalse(hp.subfashionlist.isEmpty(), "Fashion  dropdown sublist is empty");
	}

	 @Test(priority = 1)
	public void capturehrscrollimages() {
		hp = new Homepage(driver);
		hp.scrollanimation();
	}

	@Test(priority = 5)
	public void electronics() {
		hp = new Homepage(driver);
		hp.hoveronelectronics();
		Assert.assertFalse(hp.mainprolist.isEmpty(), "Main product list is empty");
		Assert.assertFalse(hp.subprolist.isEmpty(), "sub product list is empty");
	}

	@Test(priority = 6)
	public void Furnituresandhome() {
		hp = new Homepage(driver);
		hp.hoveronfurniture();
		Assert.assertFalse(hp.mainfurlist.isEmpty(), "Furniture product list is empty");
		Assert.assertFalse(hp.subfurlist.isEmpty(), "Sub furniture product list is empty");
	}

	@Test(priority = 3)
	public void Beautytoysandmore() {
		hp = new Homepage(driver);
		hp.toysandmore();
		Assert.assertFalse(hp.maintoylist.isEmpty(), "Beauty toys and more main dropdown list is empty");
		Assert.assertFalse(hp.subtoylist.isEmpty(), "Beauty toys and more sub dropdown list is empty");
	}

	@Test(priority = 2)
	public void twowheeler() {
		hp = new Homepage(driver);
		hp.twowheeler();
		Assert.assertFalse(hp.twowheelerlist.isEmpty(), "Two wheeler list is empty");
	}
	@Test(priority = 8)
	public void nodropdowntabs() {
		hp = new Homepage(driver);
		Assert.assertTrue(hp.grocery(),"Grocery tab is not displayed on homepage");
		Assert.assertTrue(hp.mobiles(), "Mobiles tab is not displayed on homepage");
		Assert.assertTrue(hp.Appliances(), "Appliances tab is not displayed on homepage");
		Assert.assertTrue(hp.Travel(), "Travel tab is not displayed on homepage");
	}


}
