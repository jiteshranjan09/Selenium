package com.smart.qa.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.smart.qa.base.TestBase;
import com.smart.qa.page.AdminPage;
import com.smart.qa.page.HomePage;
import com.smart.qa.page.LoginPage;
import com.smart.qa.page.RequisitionLandingPage;

public class HomePageTest extends TestBase {
	
	LoginPage Lpage;
	HomePage homepage;
	RequisitionLandingPage ReqLandingPage;
	AdminPage AD;
	
	
	 public HomePageTest() {
		 super();
	}
	
	
	@BeforeMethod
	public void Setup(){
		Lanuchchromedriver();
		Lpage = new LoginPage();
		homepage=Lpage.SignIn(prob.getProperty("UserName"), prob.getProperty("Password"));
	}
	
	@Test(priority=2)
	public void VerifyPageTittle(){
		String Pagetittle = homepage.Pagetitle();
		Assert.assertEquals(Pagetittle, ":: Home ::");
	}
	
	@Test (priority=1)
	public void VerifySubMenuSection(){
		ReqLandingPage=homepage.ReturnRequisitionLandingPage("Requisitions");
	}
	
	@Test (priority=3)
	public void JumptoAdmin(){
		try {
			AD=homepage.Admin("2.o");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterMethod
	public void Teardown(){
		driver.quit();
	}

}
