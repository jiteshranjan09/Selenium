package com.smart.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;
import com.smart.qa.util.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prob;
	static int timeer =60000;

	public TestBase(){
		try {
			prob = new Properties();
			FileInputStream ip = new FileInputStream("D:\\Jitesh\\Automation\\MV\\SMART_CBT\\src\\main\\java\\com\\smart\\qa\\config\\Config.properties");
			prob.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void Lanuchchromedriver() {
		String BrowserName = prob.getProperty("Browser");

		if (BrowserName.equalsIgnoreCase("Chrome")){
			System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if (BrowserName.equalsIgnoreCase("IE")){
			System.setProperty("webdriver.InternetExplorer.driver", "C:\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		else if (BrowserName.equalsIgnoreCase("Firefox")){
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_loadtime, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.Page_WaitTime, TimeUnit.SECONDS);
		driver.get(prob.getProperty("URL"));
	}


	@SuppressWarnings("deprecation")
	public static WebElement waittest(final By Loc){

		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.pollingEvery(10, TimeUnit.SECONDS);
		wait.withTimeout(10, TimeUnit.SECONDS);
		wait.ignoring(NoSuchElementException.class);
		WebElement foo = wait.until(new Function<WebDriver, WebElement>() {

			public WebElement apply(WebDriver driver) {

				return driver.findElement(Loc);

			}
		});
		
		return foo;


	}
	public static void pagescrolldown(WebElement ele){
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true);",ele);
		//jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		//scroll(0,100)
	}
	public static void pagescrollup(WebElement ele){
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true);",ele);
		jse.executeScript("scroll(0,0)");
	}
	public static WebElement elementToBeClickable(WebDriver dr, By loc){
		WebDriverWait wait1 = new WebDriverWait(dr,timeer);
		WebElement a = wait1.until(ExpectedConditions.visibilityOfElementLocated(loc));
		WebElement b = wait1.until(ExpectedConditions.elementToBeClickable(a));
		return b;
	}
	public static void snap(WebDriver driver,String FileName){
		try {
			TakesScreenshot Screen=(TakesScreenshot)driver;
			File Source = Screen.getScreenshotAs(OutputType.FILE);
			org.apache.commons.io.FileUtils.copyFile(Source, new File("./ScreenShot"+FileName+".png"));
			System.out.println("Screenshot Taken");
		} catch (Exception e) {
			System.out.println("Error Handling Message"+e.getMessage());
		}
	}

}
