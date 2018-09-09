package com.smart.qa.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderLandingPage {
	
	//Page Factor
	@FindBy(xpath=".//*[@id='reset01'][@class='resetFilter displayBlock filterStatusDisable']")
	WebElement removefilter;

	@FindBy(id="aCreateNew")
	WebElement CreateBtn;

	@FindBy (id="liABlank")
	WebElement BlankOption;

	//Action:

	public void RemoveFilter(){
		if (removefilter.isEnabled()==true){
			removefilter.click();
		}
	}

	public BlankOrderPage CreateBlankDocument(){
		if (CreateBtn.isEnabled()){
			CreateBtn.click();
			if (BlankOption.isEnabled()){
				BlankOption.click();
			}
		}
		System.out.println("Redirect to BlankRequisition page successfully");
		return new BlankOrderPage();
	}

}
