package com.qa.usgtd.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.usgtd.base.TestBase;
import com.qa.usgtd.pages.HomePage;
import com.qa.usgtd.pages.LoginPage;
import com.qa.usgtd.pages.SearchStockPage;
import com.qa.usgtd.pages.SelectBuySell;

public class SearchStockPageTest extends TestBase {

		LoginPage loginPage;
		HomePage homePage;
		SearchStockPage searchStkPage;
		SelectBuySell selectBuySell;
		
		public SearchStockPageTest() {
			super();
		}

		//test cases should be separated -- independent with each other
		//before each test case -- launch the browser and login
		//@test -- execute test case
		//after each test case -- close the browser
		
		@BeforeMethod
		public void setUp() throws Exception   {
			initialization();
			//driver.manage().deleteAllCookies();
			loginPage = new LoginPage();  	
			searchStkPage = new SearchStockPage();
			selectBuySell = new SelectBuySell();
			homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
			searchStkPage = homePage.clickOnSearchUSMkt();
			System.out.println("Hello");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		}
		
		@Test
		public void verifySelectTicker() throws Exception{
			selectBuySell = searchStkPage.clickSearchTicker("AAL");
		
			
			
		}
			
		
		@AfterMethod
		public void tearDown(){
			driver.quit();
		}
		
}
