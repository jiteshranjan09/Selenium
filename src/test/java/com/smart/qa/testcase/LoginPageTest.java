package com.smart.qa.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.smart.qa.base.TestBase;
import com.smart.qa.page.HomePage;
import com.smart.qa.page.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage LPage;
	HomePage homepage;
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void Setup(){
		Lanuchchromedriver();
		LPage = new LoginPage();
	}
	
	@Test (priority=1)
	public void LoginPageTittleTest(){
		String Tittle=LPage.Pagetitle();
		Assert.assertEquals(Tittle, ":: Login ::");
	}
	
	@Test(priority=2)
	public void SignbuttonTest(){
		homepage=LPage.SignIn(prob.getProperty("UserName"), prob.getProperty("Password"));
	}
	
	@AfterMethod
	public void Teardown(){
		driver.quit();
	}

}
