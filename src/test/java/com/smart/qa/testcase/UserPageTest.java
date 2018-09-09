package com.smart.qa.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.smart.qa.base.TestBase;
import com.smart.qa.page.AdminPage;
import com.smart.qa.page.CreateUserPage;
import com.smart.qa.page.HomePage;
import com.smart.qa.page.LoginPage;
import com.smart.qa.page.User;

public class UserPageTest extends TestBase {
	
	LoginPage Lpage;
	HomePage homepage;
	AdminPage AD;
	User user;
	CreateUserPage UserCreation;
	
	public UserPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup(){
		Lanuchchromedriver();
		Lpage = new LoginPage();
		homepage=Lpage.SignIn(prob.getProperty("UserName"), prob.getProperty("Password"));
		try {
			AD=homepage.Admin("2.o");
		} catch (Exception e) {
			e.printStackTrace();
		}
		user =AD.UserManger();
	}
	
	@Test(priority=2)
	public void verifyPageTittle(){
		String Pagetittle = user.PageTitle();
		Assert.assertEquals(Pagetittle, ":: Users ::");
	}
	@Test(priority=1)
	public void verifynewuserbutton(){
		UserCreation=user.Adduser();
	}
	
	
	@AfterMethod
	public void Teardown(){
		//driver.quit();
	}

}
