package com.qa.usgtd.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.usgtd.base.TestBase;

public class SelectBuySell extends TestBase {

	@FindBy(xpath = "//img[@src='/member/images/btn-buy-01.gif']")
	WebElement buyBtn;
	
	@FindBy(xpath = "//img[@src='/member/images/btn-sell-01.gif']")
	WebElement sellBtn;
	
	public SelectBuySell() {
		PageFactory.initElements(driver,this);
		}
	
	public OrderEntryPage clickBuy() {
		
		buyBtn.click();
		
		return new OrderEntryPage();
		
		
	}
}
