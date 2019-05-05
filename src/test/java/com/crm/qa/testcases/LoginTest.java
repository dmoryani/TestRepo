package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.Base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginTest() {
		
		super(); /*super keyword is used to call the constructor of the parent class. 
		So under TestBase class(our parent class)- we need to call the 
		properties also. so we use this here before Initialization.*/
		
	}
	
	@BeforeMethod
	
	public void setUp(){
		
		initialization();
		loginPage = new LoginPage();
		
	}
	
	/*@Test(priority=1)
	
	public void loginPageTitileTest(){
		String title= loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "#1 Free CRM software in the Cloud FreeCRM");
	}*/
	
	@Test
	
	public void crmLogoImageTest(){
		boolean flag =loginPage.validateCRMImage();
		Assert.assertTrue(flag);
		
	}
	
	@Test 
	
	public void loginTest(){
		
		homePage=loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	
	public void tearDown(){
		
		driver.quit();
	}
	
	
	

}
