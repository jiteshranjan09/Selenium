package com.smart.qa.testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.smart.qa.base.TestBase;
import com.smart.qa.page.AdminPage;
import com.smart.qa.page.HomePage;
import com.smart.qa.page.LoginPage;
import com.smart.qa.page.User;

public class AdminPageTest extends TestBase {
	
	LoginPage Lpage;
	HomePage homepage;
	AdminPage AD;
	User user;
	
	public AdminPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup(){
		Lanuchchromedriver();
		Lpage = new LoginPage();
		homepage=Lpage.SignIn("Pumaenergy.admin@gep.com", "Password@123");
		try {
			AD=homepage.Admin("2.o");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void verifyusermanager_redirection(){
		user =AD.UserManger();
	}
	
	
	@AfterMethod
	public void Teardown(){
		//driver.quit();
	}

}

