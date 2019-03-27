package com.qa.usgtd.pages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.usgtd.base.TestBase;

public class OrderEntryPage extends TestBase {

	@FindBy(xpath = "//input[@name ='orderValue']")
	WebElement ordQty;
	
	@FindBy(xpath = "//input[@name ='orderPriceInt']")
	WebElement ordPrice;
	
	@FindBy(xpath = "//input[@id='settlementCurrencyUSD']")
	WebElement sCurrUSD;
	
	@FindBy(xpath = "//input[@id='settlementCurrencyUSD']")
	WebElement sCurrJPY;
	
	@FindBy(xpath = "//input[@id='accountSpecial']")
	WebElement accntSpcl;
	
	@FindBy(xpath = "//input[@id='accountGenerial']")
	WebElement accntGen;
	
	@FindBy(xpath ="//input[@type ='submit']")
	WebElement submit;
	
	//@FindBy(xpath ="//img[@class='ui-datepicker-trigger']")
	//WebElement ordDate;
	
	@FindBy(xpath = "//input[@name ='datepicker']")
	WebElement ordDate;
	
	//@FindBy(xpath = "//select[@id='ordValDate']//option")
	//static
	//List<WebElement> dateElement;
	
	public OrderEntryPage() {
		PageFactory.initElements(driver,this);
		}
	
	public OrderConfirmPage EnterOrderValue(String Qty,String Price,String Stmntype,String acntype,String ordDate) {
		
		ordQty.sendKeys(Qty);
		ordPrice.sendKeys(Price);
		
		
		if (Stmntype == "USD")
			sCurrUSD.click();
		else
			sCurrJPY.click();
		
		if(acntype == "General")
			accntGen.click();
		else
			accntSpcl.click();
		
			
		SelectDate(ordDate);
			
		
		submit.click();
			
		
		return new OrderConfirmPage();
	}
	
	public static void SelectDate(String ordDate) {
		//String string = "January 2, 2010";
		//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy", Locale.ENGLISH);
		//LocalDate date = LocalDate.parse(ordDate, formatter);
		//System.out.println(date);
		//JavascriptExecutor js = ((JavascriptExecutor) driver);
		
		//js.executeScript("arguments[0].setAttribute('value','"+ordDate+"');",dateElement);
		//Select selectdt = new Select(dateElement);
		//selectdt.selectByVisibleText(ordDate);
		List<WebElement> dateElement = driver.findElements(By.xpath("//select[@id='ordValDate']//option"));
		System.out.println(dateElement.size());
		for (int i=0;i<dateElement.size();i++)
		{
			if(dateElement.get(i).getText().equals(ordDate))
			{
				dateElement.get(i).click();
				break;
			}
			
		}
		
	}
}
