package com.qa.usgtd.pages;

	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

import com.qa.usgtd.base.TestBase;


	public class LoginPage extends TestBase{
		
		//Page Factory - OR:
		@FindBy(xpath="//input[@name='loginid']")
		WebElement username;
		
		@FindBy(xpath="//input[@name='passwd']")
		WebElement password;
		
		@FindBy(xpath="//button[@type='submit' and @class='s1-btn-login-small s1-form-login__btn s1-btn--narrow']")
		WebElement loginBtn;
		
		//Initializing the Page Objects:
		public LoginPage(){
			PageFactory.initElements(driver, this);
		}
		
		//Actions:
				
		public HomePage login(String un, String pwd){
			username.sendKeys(un);
			password.sendKeys(pwd);
			//loginBtn.click();
			    	JavascriptExecutor js = (JavascriptExecutor)driver;
			    	js.executeScript("arguments[0].click();", loginBtn);
			    	
			return new HomePage();
		}
		
	}



