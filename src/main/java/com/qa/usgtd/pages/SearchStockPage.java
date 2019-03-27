package com.qa.usgtd.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.usgtd.base.TestBase;

public class SearchStockPage extends TestBase{

	@FindBy(xpath="//input[@id='dscrCdNm']")
	WebElement dscrName;
	
	@FindBy(xpath="//input[@class='roll img-ipad']")
	WebElement searchDscrBtn;
	
	public SearchStockPage() {
		PageFactory.initElements(driver,this);
		}
	
	public SelectBuySell clickSearchTicker(String tickern ) {
		
		dscrName.sendKeys(tickern);
		searchDscrBtn.click();
		return new SelectBuySell();
	}
	
}
