package com.crm.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.Base.TestBase;

public class LoginPage extends TestBase{

	
	//OR of the Login Page 
	
	@FindBy(name="email")
	
	WebElement username; 
	
	@FindBy(name="password")
	
	WebElement password;
	
	@FindBy(xpath =".//div[contains(text(), 'Login')][0]")
			WebElement loginBtn;
	
	@FindBy(xpath="//a[@href='https://register.freecrm.com/register/'][0]")
	
	WebElement signUp;
	
	@FindBy(xpath="(//a[@href='https://freecrm.com/freecrm'])[0]")

	WebElement freeCamLogo;
	
	//initalize the elements of the page factory.... 
	
	public LoginPage(){
		
		PageFactory.initElements(driver,this); //this - pointing to the current class object.
	}
	
	//Features... 
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean validateCRMImage(){
		
		return freeCamLogo.isDisplayed();
		
		
	}
	
	public HomePage Login(String un, String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
		
		
	}
	
	
	
	
			
	
		
	
}
