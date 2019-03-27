package com.qa.usgtd.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:/Users/Murli/eclipse-workspace/USGTD/src/main/java/"
					+ "com/qa/usgtd/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization(){
		String browserName = prop.getProperty("browser");
		
		
	if(browserName.equals("mozilla")){
			System.setProperty("webdriver.gecko.driver", "D:\\Software Exes\\Selenium\\Mozilla\\geckodriver.exe");	
			driver = new FirefoxDriver(); 
		}
	else if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "D:\\Software Exes\\Selenium\\chromedriver_win32\\chromedriver.exe");	
			driver = new ChromeDriver(); 
		}
		else {
			System.out.println("Driver Not found");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
}