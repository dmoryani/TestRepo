package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.Base.TestBase;
import com.crm.qa.pages.RegisterPage;
import com.crm.qa.pages.SignUpPage;

public class RegisterPageTest extends TestBase {

	RegisterPage registerPage;
	SignUpPage signUpPage;

	public RegisterPageTest() {
		super();

	}

	@BeforeMethod

	public void launchBrowser() {

		initialization();
		registerPage = new RegisterPage();

	}

	@Test(priority=1)

	public void Register() {
		
		

		signUpPage =registerPage.fillUpRegisterationForm(prop.getProperty("username"), prop.getProperty("PhoneNumber"));
		boolean flag1= registerPage.validateErrorMessage();
		Assert.assertTrue(flag1);
	}
	
	
	
	/*@Test(priority=2, dependsOnMethods="Register")
	public void validateErrorMessageOnSignUp(){
		
		
	}*/
	/*@AfterMethod
	
	public void tearDown(){
		
		driver.quit();
	}*/

}
