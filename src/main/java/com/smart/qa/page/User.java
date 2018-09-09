package com.smart.qa.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.smart.qa.base.TestBase;

public class User extends TestBase {
	
	String Page_tittle;
	public By AddNewUser = By.xpath(".//a[@id='addNewUser'][contains(@href,'CreateUser')]");
	public By UserSearch = By.id("txtSearchUser");
	
	public String PageTitle(){
		Page_tittle=driver.getTitle();
		return Page_tittle;
	}
	
	public CreateUserPage Adduser(){
		driver.findElement(AddNewUser).click();	
		return new CreateUserPage();
	}
	
	public void SearchUser(String FirstName){
		elementToBeClickable(driver, UserSearch);
		driver.findElement(UserSearch).sendKeys(FirstName);
		driver.findElement(UserSearch).sendKeys(Keys.ENTER);
		snap(driver, FirstName);
		
	}
}
