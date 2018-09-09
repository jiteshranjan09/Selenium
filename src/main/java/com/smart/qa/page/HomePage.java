package com.smart.qa.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.smart.qa.base.TestBase;


public class HomePage extends TestBase {
	static WebElement Dropdown,Abtn;
	static public By Procurement = By.xpath(".//a[@original-title='Procurement']");
	public static String ManuName;
	public static By Setting = By.id("Settings");	
	public static By settingDropdown = By.id("dvSetting");
	public static By Admin2= By.xpath(".//a[@message='Navigation']/i");
	public static By Admin2_btn= By.xpath(".//a[contains(@href,'Administration')]/span");
	//Action
	public String Pagetitle(){
		String Tittle=driver.getTitle();
		return Tittle;
	}

	public void HometoSubMenu(String Sub_Menu){
		Actions act = new Actions(driver);
		WebElement MainMenu = driver.findElement(Procurement);
		act.moveToElement(MainMenu);
		WebElement submenu = driver.findElement(By.xpath(".//a[text()='"+Sub_Menu+"']"));
		act.moveToElement(submenu);
		act.click().build().perform();
	}
	public CatalogHomePage ReturnCatalogPage(String Sub_Menu){
		HometoSubMenu(Sub_Menu);
		String URL = driver.getCurrentUrl();
		if (URL.contains("Catalog")){
			System.out.println("Redirect to Catalog page successfully");
		}
		return new CatalogHomePage();	
	}
	public RequisitionLandingPage ReturnRequisitionLandingPage(String Sub_Menu){
		HometoSubMenu(Sub_Menu);
		String URL = driver.getCurrentUrl();
		if (URL.contains("Requisition")){
			System.out.println("Redirect to Requisition page successfully");
		}
		return new RequisitionLandingPage();	
	}
	public OrderLandingPage ReturnOrderLandingPage(String Sub_Menu){
		HometoSubMenu(Sub_Menu);
		String URL = driver.getCurrentUrl();
		if (URL.contains("Order")){
			System.out.println("Redirect to Order page successfully");
		}
		return new OrderLandingPage();	
	}
	public InvoiceLandingPage ReturnInvoiceLandingPage(String Sub_Menu){
		HometoSubMenu(Sub_Menu);
		String URL = driver.getCurrentUrl();
		if (URL.contains("Invoice")){
			System.out.println("Redirect to Invoice page successfully");
		}
		return new InvoiceLandingPage();	
	}

	public  AdminPage Admin(String Platform) throws Exception{
		if (Platform.equalsIgnoreCase("1.o")){
			driver.findElement(Setting).click();
			Dropdown=driver.findElement(settingDropdown);
			if (Dropdown.isEnabled()==true){
				Thread.sleep(2000);
				driver.findElement(By.linkText("Admin")).click();
			}
			String Tittle=driver.getTitle();
			org.testng.Assert.assertTrue(Tittle.equalsIgnoreCase(":: Administration ::"));
			System.out.println("Moved to Administration Page Successfully");
			
		}
		else {
			driver.findElement(Admin2).click();
			Abtn=elementToBeClickable(driver, Admin2_btn);
			Abtn.click();
			String Tittle=driver.getTitle();
			org.testng.Assert.assertTrue(Tittle.equalsIgnoreCase(":: Administration ::"));
			System.out.println("Moved to Administration Page Successfully");
		}
		
		
		return new AdminPage();
	}


}

