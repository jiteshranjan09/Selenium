package com.smart.qa.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.smart.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory
	
	@FindBy(id="UserName")
	WebElement Login_username;
	
	@FindBy(id="Password")
	WebElement Login_pwd;
	
	@FindBy(id="login")
	WebElement Login_SignIn;
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Action
	 
	public String Pagetitle(){
		String Tittle=driver.getTitle();
		return Tittle;
	}
	
	public HomePage SignIn(String UserName, String Password){
		Login_username.sendKeys(UserName);
		Login_pwd.sendKeys(Password);
		Login_SignIn.click();
		return new HomePage();
		
	}
	
	

}
