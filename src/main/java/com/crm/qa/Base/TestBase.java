package com.crm.qa.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.Utils.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop; 
	
	
	
	public TestBase() {

		try {
		prop = new Properties(); 
		
			FileInputStream fi = new FileInputStream("C:\\Users\\Divya\\workspace\\NaveenLabs_FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			prop.load(fi);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	public static void initialization(){ 
		String browserName = prop.getProperty("browser");
		System.out.println(prop.getProperty("browser"));// read the prop of the browser. Browser is Chrome.. 
		
		if(browserName.equals("chrome")){
			
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Divya\\chromedriver.exe");
			 driver = new ChromeDriver();
			
		}
		else if(browserName.equals("FF")){
			System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\Divya");
			 driver = new FirefoxDriver();
			
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		/*driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);*/
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		
		
		driver.get(prop.getProperty("url"));
	}
	

}
