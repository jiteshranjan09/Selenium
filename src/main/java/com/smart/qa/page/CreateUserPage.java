package com.smart.qa.page;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import com.smart.qa.base.TestBase;

public class CreateUserPage extends TestBase {

	String Page_tittle,input;

	static String FName,Lname,designation,UserEmail,UserID,cuntry,timezone;
	WebElement Country,PersonaElement,DivisionElement,Moreactivitybtn,MTab,CPopup,Select,Categorybtn,dCategorybtn,
	Shipf,Autosug,ManagerF,Regionbtn,Bdefault,ATab,currency1,Checkbox,DRadioBtn,CPopUP,PTAB;
	Select Sc;
	public By First_name = By.xpath(".//input[@type='text'][@id='txtFirstName']");
	public By Last_name = By.xpath(".//input[@type='text'][@id='txtLastName']");
	public By Designation = By.xpath(".//input[@type='text'][@id='txtDesignation']");
	public By EmailID = By.xpath(".//input[@type='text'][@id='txtEmail']");
	public By userName = By.xpath(".//input[@type='text'][@id='txtUserName']");
	public By Phn_Number = By.xpath(".//input[@type='text'][@id='txtPhone1']");
	public By country = By.id("ddlCountries");
	public By PersonaTab = By.xpath(".//ul[@id='ulProcessBreadcrumb']/li[@id='lipr']");
	public By Mapping_tab = By.xpath(".//ul[@id='ulProcessBreadcrumb']/li[@id='limi']");
	public By Accounting = By.xpath(".//ul[@id='ulProcessBreadcrumb']/li[@id='liad']");
	public By PersonaDropdown = By.id("ddlPersona");
	public By MoreActitity = By.id("addMoreActivities");
	public By AllCheckbox = By.xpath(".//input[@type='checkbox'][@id='chkTask']");
	public By Searchbox = By.xpath(".//input[@type='text'][@id='txtActivitySearch']");
	public By Addbtn = By.xpath(".//input[@type='button'][@id='btnAddMoreActivities']");
	public By B_DivisionDropdown = By.id("ddlBelongLOB");
	public By S_DivisionDropdown = By.id("ddlServeLOB2");
	public By B_Entity = By.xpath(".//a[@href='javascript:;'][@class='_lnkSelectEntities1 primaryLink fancybox-manual-d selEntities']");
	public By S_Entity = By.xpath(".//a[@href='javascript:;'][@class='_lnkSelectEntities2 primaryLink fancybox-manual-d selEntities']");
	public By Entity_Select = By.xpath(".//span[@class='smart-chk-helper']");
	public By Donebtn = By.xpath(".//button[text()='Done']");
	public By B_defaultEntity = By.xpath(".//a[@href='javascript:;'][@class='_lnkDefaultEntity1 primaryLink fancybox-manual-i selDefault enabled']");
	public By S_defaultEntity = By.xpath(".//a[@href='javascript:;'][@class='_lnkDefaultEntity2 primaryLink fancybox-manual-i selDefault enabled']");
	public By B_Searchbox = By.xpath(".//input[@type='text'][@placeholder='Search']");
	public By default_radionbtn = By.xpath(".//input[@type='radio'][@class='marginLeft5 ng-scope']");
	public By Common_popup = By.xpath(".//div[@class='fancybox-outer']");
	public By Search = By.xpath(".//input[@type='text'][@placeholder='Search']");
	public By Category = By.xpath(".//a[@href='javascript:void(0)'][@class='popupLink _lnkOpenCategoryTree'][@original-title='Add Category']");
	public By defaultcategory = By.xpath(".//a[@href='javascript:void(0)'][@class='popupLink _lnkOpenDefaultCategoryTree'][@original-title='Add Default Category']");
	public By Shipttolocation = By.id("txtShipToLocation");
	public By Manager = By.id("txtManager");
	public By Region = By.xpath(".//a[@href='javascript:void(0)'][@class='popupLink _lnkOpenRegionTree'][@original-title='Add Region']");
	public By Currency = By.id("ddlCurrency");
	public By Primaryammount = By.id("txtP2PAmt");
	public By Save = By.id("btnSaveUser");
	public By TimeZone = By.id("ddlTimeZone");
	public By ConfirPopUp = By.xpath(".//div[@class='errorMesg new']/div[@class='notifyContainer fixedPos']/div[@class='message']");
	public By ConfirMessage = By.xpath(".//ul[@id='ulErrors']/li");

	public String PageTitle(){
		Page_tittle=driver.getTitle();
		return Page_tittle;
	}

	public void Basicdetails(String FName, String Lname,String designation,String UserEmail,String UserID,String Phn,String cuntry,String timezone){
		driver.findElement(First_name).sendKeys(FName);
		driver.findElement(Last_name).sendKeys(Lname);
		driver.findElement(Designation).sendKeys(designation);
		driver.findElement(EmailID).sendKeys(UserEmail);
		driver.findElement(userName).sendKeys(UserID);
		driver.findElement(Phn_Number).sendKeys(Phn);
		Country=driver.findElement(country);
		Sc = new Select(Country);
		Sc.selectByVisibleText(cuntry);
		Sc = new Select(driver.findElement(TimeZone));
		Sc.selectByValue(timezone);
		PTAB=driver.findElement(PersonaTab);
		pagescrollup(PTAB);
		PTAB.click();

	}
	public void Persona(String Persona){
		PersonaElement=driver.findElement(PersonaDropdown);
		Select Sc = new Select(PersonaElement);
		Sc.selectByVisibleText(Persona);
	}
	public void AdditonalActivity_ADD(String AdditionActivity){
		if (AdditionActivity.equalsIgnoreCase("NA")){

		}
		else if (AdditionActivity.equalsIgnoreCase("ALL")){
			driver.findElement(MoreActitity).click();
			driver.findElement(AllCheckbox).click();
			driver.findElement(Addbtn).click();
		}
		else{
			String[] test =AdditionActivity.split(","); 
			int Activitycount = test.length;
			for (int i=0; i<Activitycount;i++){
				driver.findElement(MoreActitity).click();
				Moreactivitybtn=waittest(MoreActitity);
				Moreactivitybtn.click();
				driver.findElement(Searchbox).sendKeys(test[i]);
				driver.findElement(Search).sendKeys(Keys.ENTER);
				driver.findElement(AllCheckbox).click();
				driver.findElement(Addbtn).click();

			}
		}

	}
	public void AdditonalActivity_Remove(String RMAdditionActivity){
		if (RMAdditionActivity.equalsIgnoreCase("NA")){

		}else{
			Moreactivitybtn=elementToBeClickable(driver,MoreActitity);
			Moreactivitybtn.click();
			String[] test =RMAdditionActivity.split(","); 
			int Activitycount = test.length;
			for (int i=0; i<Activitycount;i++){
				driver.findElement(Searchbox).sendKeys(test[i]);
				driver.findElement(Searchbox).sendKeys(Keys.ENTER);
				if (test[i].equalsIgnoreCase("dashboard")){
					driver.findElement(AllCheckbox).click();
					driver.findElement(AllCheckbox).click();
				}
				else
					driver.findElement(AllCheckbox).click();
				driver.findElement(Searchbox).clear();
			}
			driver.findElement(Addbtn).click();
		}
		MTab=driver.findElement(Mapping_tab);
		pagescrollup(MTab);
		MTab=elementToBeClickable(driver,Mapping_tab);
		if (MTab.isEnabled()){
			MTab.click();
		}
	}
	public void Mapping(String BDivision,String BEntity, String BDefault,String SDivision,String SEntity, String SDefault,String CatName, String ShipName) {
		//Belonging BU:
		DivisionElement=driver.findElement(B_DivisionDropdown);
		Sc = new Select(DivisionElement);
		Sc.selectByVisibleText(BDivision);
		driver.findElement(B_Entity).click();
		CPopup=waittest(Common_popup); 
		if (CPopup.isDisplayed()==true){
			if (BEntity.equalsIgnoreCase("ALL")){
				Select=waittest(By.xpath(".//input[@type='checkbox'][@text='show']"));
				Checkbox = elementToBeClickable(driver, Entity_Select);
				Checkbox.click();
				driver.findElement(Donebtn).click();
			}else{
				String[] Entname=BEntity.split(",");
				int EntityCount = Entname.length;
				for (int i=0; i<EntityCount;i++){
					Select=waittest(By.xpath(".//input[@type='checkbox'][@text='show']"));
					driver.findElement(B_Searchbox).sendKeys(Entname[i]);
					driver.findElement(B_Searchbox).sendKeys(Keys.ENTER);
					Checkbox = elementToBeClickable(driver, Entity_Select);
					if(Checkbox.isEnabled()==true){
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						Checkbox.click();
					}
					driver.findElement(B_Searchbox).clear();
				}
				driver.findElement(Donebtn).click();

			}
		}
		//Default Belonging BU:

		Bdefault=elementToBeClickable(driver,B_defaultEntity);
		Bdefault.click();
		//driver.findElement(B_defaultEntity).click();
		CPopup=waittest(Common_popup); 
		if (CPopup.isDisplayed()==true){
			elementToBeClickable(driver, default_radionbtn);
			driver.findElement(B_Searchbox).sendKeys(BDefault);
			driver.findElement(B_Searchbox).sendKeys(Keys.ENTER);
			DRadioBtn=elementToBeClickable(driver, default_radionbtn);
			DRadioBtn.click();
			driver.findElement(Donebtn).click();



		}

		//Serving BU:
		DivisionElement=driver.findElement(S_DivisionDropdown);
		Sc = new Select(DivisionElement);
		Sc.selectByVisibleText(SDivision);
		driver.findElement(S_Entity).click();
		CPopup=waittest(Common_popup); 
		if (CPopup.isDisplayed()==true){
			if (SEntity.equalsIgnoreCase("ALL")){
				Select=waittest(By.xpath(".//input[@type='checkbox'][@text='show']"));
				Checkbox = elementToBeClickable(driver, Entity_Select);
				Checkbox.click();
				driver.findElement(Donebtn).click();
			}else{
				String[] SEntname=SEntity.split(",");
				int EntityCount = SEntname.length;
				for (int i=0; i<EntityCount;i++){
					Select=waittest(By.xpath(".//input[@type='checkbox'][@text='show']"));
					driver.findElement(B_Searchbox).sendKeys(SEntname[i]);
					driver.findElement(B_Searchbox).sendKeys(Keys.ENTER);
					Checkbox = elementToBeClickable(driver, Entity_Select);
					if(Checkbox.isEnabled()==true){
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						Checkbox.click();
					}
					driver.findElement(B_Searchbox).clear();
				}
				driver.findElement(Donebtn).click();

			}
		}
		//Default Serving entity:
		WebElement a=elementToBeClickable(driver,S_defaultEntity);
		a.click();
		CPopup=waittest(Common_popup); 
		if (CPopup.isDisplayed()==true){
			elementToBeClickable(driver, default_radionbtn);
			driver.findElement(B_Searchbox).sendKeys(SDefault);
			driver.findElement(B_Searchbox).sendKeys(Keys.ENTER);
			DRadioBtn=elementToBeClickable(driver, default_radionbtn);
			DRadioBtn.click();
			driver.findElement(Donebtn).click();

		}
		//Category & default category
		Categorybtn=driver.findElement(Category);
		pagescrolldown(Categorybtn);
		Categorybtn=elementToBeClickable(driver,Category);
		Categorybtn.click();
		CPopup=waittest(Common_popup); 
		if (CPopup.isDisplayed()==true){
			Select=waittest(By.xpath(".//input[@type='checkbox'][@text='show']"));
			if (CatName.equalsIgnoreCase("ALL")){
				Checkbox = elementToBeClickable(driver, Entity_Select);
				Checkbox.click();
				driver.findElement(Donebtn).click();
			}else{
				driver.findElement(Search).sendKeys(CatName);
				driver.findElement(Search).sendKeys(Keys.ENTER);
				Checkbox = elementToBeClickable(driver, Entity_Select);
				Checkbox.click();
				driver.findElement(Donebtn).click();
			}		
		}

		dCategorybtn=elementToBeClickable(driver,defaultcategory);
		dCategorybtn.click();
		CPopup=waittest(Common_popup); 
		if (CPopup.isDisplayed()==true){
			elementToBeClickable(driver, default_radionbtn);
			driver.findElement(B_Searchbox).sendKeys(CatName);
			driver.findElement(B_Searchbox).sendKeys(Keys.ENTER);
			driver.findElement(default_radionbtn).click();
			driver.findElement(Donebtn).click();
		}
		//Ship to location
		Shipf = waittest(Shipttolocation);
		Shipf.sendKeys(ShipName);
		Shipf.sendKeys(Keys.TAB);

		//Region:
		Regionbtn=waittest(Region);
		Regionbtn.click();
		CPopup=waittest(Common_popup); 
		if (CPopup.isDisplayed()==true){
			Select=waittest(By.xpath(".//input[@type='checkbox'][@text='show']"));
			Checkbox = elementToBeClickable(driver, Entity_Select);
			Checkbox.click();
			driver.findElement(Donebtn).click();
		}

		//Manager:
		/*ManagerF = waittest(Manager);
		ManagerF.sendKeys("stephen linde");
		By Autosuggestedshipto=By.xpath(".//input[contains(@id,'ManagerCheckBox_')][@type='checkbox']");
		Autosug=waittest(Autosuggestedshipto);
		Autosug.click();
		ManagerF.sendKeys(Keys.TAB);*/
		ATab=driver.findElement(Accounting);
		pagescrollup(ATab);
		ATab=elementToBeClickable(driver, Accounting);
		ATab.click();
	}
	public void Accountingdetials(String CurrencyData){
		currency1=driver.findElement(Currency);
		Sc= new Select(currency1);
		Sc.selectByValue(CurrencyData);
		driver.findElement(Primaryammount).sendKeys("1000");
	}
	public void SaveBtn(String Name){
		pagescrolldown(driver.findElement(Save));
		driver.findElement(Save).click();
		CPopUP=elementToBeClickable(driver, ConfirPopUp);
		if (CPopUP.isDisplayed()==true){
			String Message=driver.findElement(ConfirMessage).getText();
			System.out.println(Message);
			org.testng.Assert.assertTrue(Message.equalsIgnoreCase("User created Successfully"));
		}
		else
		System.out.println(Name +"User created Successfully");
		snap(driver, Name);

	}


}
