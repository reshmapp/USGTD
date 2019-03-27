package com.qa.usgtd.test;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.usgtd.base.TestBase;
import com.qa.usgtd.pages.HomePage;
import com.qa.usgtd.pages.LoginPage;
import com.qa.usgtd.pages.OrderConfirmPage;
import com.qa.usgtd.pages.OrderEntryPage;
import com.qa.usgtd.pages.SearchStockPage;
import com.qa.usgtd.pages.SelectBuySell;
import com.qa.usgtd.util.TestUtil;

public class OrderEntryPageTest extends TestBase {

	
	LoginPage loginPage;
	HomePage homePage;
	SearchStockPage searchStkPage;
	SelectBuySell selectBuySell;
	OrderEntryPage orderEntry;
	OrderConfirmPage orderConfirm;
	
	String sheetName ="OrderData";
	
	public OrderEntryPageTest() {
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
		orderEntry = new OrderEntryPage();
		orderConfirm = new OrderConfirmPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		searchStkPage = homePage.clickOnSearchUSMkt();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}
	
	@DataProvider
	public Object[][] getGTDTestData() {
		Object GTDData[][]= TestUtil.getTestData(sheetName);
		return GTDData;
	}
	
	@Test(dataProvider = "getGTDTestData")
	public void verifyOrderEntry(String ticker,String Qty,String Price,String Stmntype,String acntype,String ordDate) throws Exception{
	
		selectBuySell = searchStkPage.clickSearchTicker(ticker);
		orderEntry = selectBuySell.clickBuy();
		orderConfirm = orderEntry.EnterOrderValue(Qty, Price, Stmntype, acntype,ordDate);
	
	}
		
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
