package com.crm.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.Base.TestBase;

public class RegisterPage extends TestBase {
	
	
	
	//Create an OR for the Register Page ... 
	
	@FindBy(name="email")
	WebElement emailaddress;
	
	@FindBy(name="phone")
	WebElement phonenumber;
	
	@FindBy(name="terms")
	WebElement termsAndCondition;
	
	@FindBy(name="action")
	WebElement signUp;
	
	@FindBy(xpath="//div[@class='header']")
	WebElement errormessage;
			
			
	
	//Actions: 
	
	public RegisterPage(){
		
		PageFactory.initElements(driver, this); 
		
	}
	
	// Features...
	
	public SignUpPage fillUpRegisterationForm(String uname,String pwd){
		emailaddress.sendKeys(uname);
		phonenumber.sendKeys(pwd);
		termsAndCondition.click();
		signUp.click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		return new SignUpPage();
		
		
	}
	
	public boolean validateErrorMessage(){
		
		return errormessage.isDisplayed();
		
		
	}
}
