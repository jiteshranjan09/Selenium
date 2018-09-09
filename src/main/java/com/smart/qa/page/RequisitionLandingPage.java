package com.smart.qa.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.smart.qa.base.TestBase;


public class RequisitionLandingPage extends TestBase{

	//Page Factor
	@FindBy(xpath=".//*[@id='reset01'][@class='resetFilter displayBlock filterStatusDisable']")
	WebElement removefilter;
	static public By CreateREQ= By.id("aCreateNew");
	static public By Blank= By.id("liABlank");
	static WebElement CreateBtn,BlankOption;
	 WebDriverWait Wait = new WebDriverWait(driver, 10);
	//Action:

	public void RemoveFilter(){
		if (removefilter.isEnabled()==true){
			removefilter.click();
		}
	}

	public RequisitionPage CreateBlankDocument() throws Exception{

		CreateBtn = driver.findElement(CreateREQ);
		if (CreateBtn.isEnabled()){
			CreateBtn.click(); 
			wait(10);
			BlankOption=driver.findElement(Blank);
			if (BlankOption.isEnabled()){
				BlankOption.click();
			}
		}
		System.out.println("Redirect to BlankRequisition page successfully");
		return new RequisitionPage();
	}
}

