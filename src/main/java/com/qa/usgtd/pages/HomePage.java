package com.qa.usgtd.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.usgtd.base.TestBase;

public class HomePage extends TestBase {

	
	@FindBy(xpath = "//select[@name ='stoc-type-01']")
	WebElement selectMarket;
	
	@FindBy(xpath="//button[@id='searchStockFormSearchBtn']")
	WebElement searchMktBtn;
	
	public HomePage() {
		PageFactory.initElements(driver,this);
	}
	
	
	public SearchStockPage clickOnSearchUSMkt() throws Exception  {
		Select select = new Select(driver.findElement(By.name("stoc-type-01")));
		select.selectByValue("1");
		select.getFirstSelectedOption();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		searchMktBtn.click();
	
		System.out.println("Clicked Search");
		return new SearchStockPage();
	}
}
