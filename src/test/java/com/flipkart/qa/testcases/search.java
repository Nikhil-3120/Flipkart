package com.flipkart.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.flipkart.qa.pageobjects.Homepage;
import com.flipkart.qa.pageobjects.searchpage;

public class search extends baseclass {
	Homepage hp;
	searchpage sp;
	
	@Test(priority = 1)
	public void searchbarautosuggestion() {
		hp = new Homepage(driver);
		Assert.assertEquals(hp.searchbarplaceholder(), "Search for Products, Brands and More", "placeholder is wrong");
		hp.search(lpf.getsearchinput());
		hp.clicksearchbtn();
		Assert.assertTrue(validatesuggestionlist(hp.autosugglist),
				"auto suggestion list is not suggesting as expected");
	}

	@Test(priority = 2)
	public void filterslist() {
		sp = new searchpage(driver);
		sp.getfiltersectionlist();
		boolean filterlist = sp.getfiltersectionlist().isEmpty();
		Assert.assertFalse(filterlist, "Filter section on the searchpage is empty");

	}

	 @Test(priority = 3)
	public void checkcoloroftextofatabs() {
		sp.tabtextcolorchanging();
		boolean colorcompare = sp.colorbeforehover.equals(sp.colorafterhover);
		Assert.assertFalse(colorcompare, "Fonts color is not changing after mouse hovering");
	}

	 @Test(priority = 4)
	public void searchproducts() {
		boolean prolist = sp.products().isEmpty();
		Assert.assertFalse(prolist, "product list is empty on the searchpage");
	}

	@Test(priority = 5)
	public void backtotopbtn() {
		Assert.assertTrue(sp.scrollingpage(), "back to top button is not functioning as expected while scrolling");
	}
}
