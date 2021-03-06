package com.smart.qa.testcase;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import com.smart.qa.base.TestBase;
import com.smart.qa.page.AdminPage;
import com.smart.qa.page.CreateUserPage;
import com.smart.qa.page.HomePage;
import com.smart.qa.page.LoginPage;
import com.smart.qa.page.User;

public class CreateUserPageTest_Ascena extends TestBase {
	
	LoginPage Lpage;
	HomePage homepage;
	AdminPage AD;
	User user;
	CreateUserPage UserCreation;
	String sheetName = "Ascena";
	
	public CreateUserPageTest_Ascena(){
		
		super();
		System.out.println("inside Test Ascena COnstructor");
	}
	
	@BeforeMethod
	public void setup(){
		System.out.println("inside Test Ascena Set up");
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
	
	@DataProvider
	public String[][] getUserCreationData(){
		System.out.println("inside Test Ascena Data Provider");
		String data[][] = com.smart.qa.util.TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=1, dataProvider="getUserCreationData")
	public void verifynewuserbutton(String First_Name, String Last_Name,String Designation,String User_Email,String UserName,String Phone,String Country,String TimeZone,String Persona,String AdditionActivity,String RMAdditionActivity,String BDivision,String BEntity, String BDefault,String SDivision,String SEntity, String SDefault,String CatName, String ShipName, String CurrencyData) {
		UserCreation.Basicdetails(First_Name,Last_Name,Designation,User_Email,UserName,Phone,Country,TimeZone);
		UserCreation.Persona(Persona);
		UserCreation.AdditonalActivity_ADD(AdditionActivity);
		UserCreation.AdditonalActivity_Remove(RMAdditionActivity);
		UserCreation.Mapping(BDivision,BEntity,BDefault,SDivision,SEntity,SDefault,CatName,ShipName);
		UserCreation.Accountingdetials(CurrencyData);
		UserCreation.SaveBtn(First_Name);
		user.SearchUser(First_Name);
	}
	
	
	@AfterMethod
	public void Teardown(){
		driver.quit();
	}

}
