package com.smart.qa.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.smart.qa.base.TestBase;

public class AdminPage extends TestBase {
	
	public static By Admin_allElement = By.xpath(".//li[@class='width180 iconBox']");
	int Size,i;
	String SectionName;
	List<WebElement> List_Element;
	public User UserManger(){
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		List_Element=driver.findElements(Admin_allElement);
		Size = List_Element.size();
		for(i=1; i<=Size;i++){
			SectionName=driver.findElement(By.xpath(".//div[@class='iconListCont fulLeft']/ul/li["+i+"]/a/span[2]")).getText();
			if (SectionName.equalsIgnoreCase("User Manager")){
				driver.findElement(By.xpath(".//div[@class='iconListCont fulLeft']/ul/li["+i+"]")).click();
				break;
			}
		
		}
		return new User();
		
	}

}
