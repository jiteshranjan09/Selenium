package com.smart.qa.testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.smart.qa.base.TestBase;
import com.smart.qa.page.AdminPage;
import com.smart.qa.page.CreateUserPage;
import com.smart.qa.page.HomePage;
import com.smart.qa.page.LoginPage;
import com.smart.qa.page.User;

public class CreateUserPage_Test extends TestBase{

	
	LoginPage Lpage;
	HomePage homepage;
	AdminPage AD;
	User user;
	CreateUserPage UserCreation;
//	String sheetName = "PUMA";
	
	public CreateUserPage_Test(){
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
		user =AD.UserManger();
		UserCreation=user.Adduser();
	}
	
	/*@DataProvider
	public String[][] getUserCreationData(){
		String data[][] = com.smart.qa.util.TestUtil.getTestData(sheetName);
		return data;
	}
	*/
	
	@Test //(priority=1, dataProvider="getUserCreationData")
	public void verifynewuserbutton() {
		UserCreation.Basicdetails("Smart","User","DEV","123@gep.com","aaa","12344","United States","India Standard Time");
		UserCreation.Persona("Admin");
	/*	UserCreation.AdditonalActivity_ADD(AdditionActivity);
		UserCreation.AdditonalActivity_Remove(RMAdditionActivity);
		UserCreation.Mapping(BDivision,BEntity,BDefault,SDivision,SEntity,SDefault,CatName,ShipName);
		UserCreation.Accountingdetials(CurrencyData);
		UserCreation.SaveBtn(First_Name);
		user.SearchUser(First_Name);*/
	}
	
	
	@AfterMethod
	public void Teardown(){
		driver.quit();
	}

}
