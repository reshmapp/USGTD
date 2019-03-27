package com.qa.usgtd.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.usgtd.base.TestBase;
import com.qa.usgtd.pages.HomePage;
import com.qa.usgtd.pages.LoginPage;
import com.qa.usgtd.pages.SearchStockPage;

public class HomePageTest extends TestBase {
		LoginPage loginPage;
		HomePage homePage;
		SearchStockPage searchStkPage;
		
		public HomePageTest() {
			super();
		}

		//test cases should be separated -- independent with each other
		//before each test case -- launch the browser and login
		//@test -- execute test case
		//after each test case -- close the browser
		
		@BeforeMethod
		public void setUp() throws Exception {
			initialization();
			loginPage = new LoginPage();
			searchStkPage = new SearchStockPage();
			homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
			searchStkPage = homePage.clickOnSearchUSMkt();
		}
		
		@Test
		public void verifySearchMkt() throws Exception{
			
			searchStkPage = homePage.clickOnSearchUSMkt();
			
		}
			
		
		@AfterMethod
		public void tearDown(){
			driver.quit();
		}
		
		

}
