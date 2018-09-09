package com.smart.qa.testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.smart.qa.base.TestBase;
import com.smart.qa.page.HomePage;
import com.smart.qa.page.LoginPage;
import com.smart.qa.page.RequisitionLandingPage;
import com.smart.qa.page.RequisitionPage;

public class RequisitionLandingPageTest extends TestBase {
	
	LoginPage Lpage;
	HomePage homepage;
	RequisitionLandingPage ReqLandingPage;
	RequisitionPage ReqPage;
	
	public RequisitionLandingPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup(){
		Lanuchchromedriver();
		Lpage = new LoginPage();
		homepage=Lpage.SignIn(prob.getProperty("UserName"), prob.getProperty("Password"));
		ReqLandingPage = homepage.ReturnRequisitionLandingPage("Requisitions");
	}
	
	@Test
	public void VerifyCreateBlankReq() throws Throwable{
		ReqPage=ReqLandingPage.CreateBlankDocument();
	}
	
	
	@AfterMethod
	public void Teardown(){
	//	driver.quit();
	}

}
