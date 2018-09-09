package com.smart.qa.testcase;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class AnnotationCheck {
	
	@BeforeSuite
	public void Suit(){
		System.out.println("@BeforeSuite: Suit is run");
	}
	
	@BeforeClass
	public void Class(){
		System.out.println("@BeforeClass: Class is run");
	}
	
	@BeforeMethod
	public void Method(){
		System.out.println("@BeforeMethod: Method is run");
	}
	@BeforeGroups
	public void Group(){
		System.out.println("@BeforeGroups: Group is run");
	}
	@BeforeTest
	public void Test(){
		System.out.println("@BeforeTest: Test is run");
	}
	@org.testng.annotations.Test
	public void Test1(){
		System.out.println("Test : Test1 is run");
	}
	
	@AfterTest
	public void AfterTest1(){
		System.out.println("@AfterTest : Test1 is run");
	}
	
	@AfterGroups
	public void Group1(){
		System.out.println("@AfterGroups: Group is run");
	}
	@AfterMethod
	public void Method1(){
		System.out.println("@@AfterMethod: Method is run");
	}
	@AfterClass
	public void Class1(){
		System.out.println("@@AfterClass: Class is run");
	}
	
	@AfterSuite
	public void Suit1(){
		System.out.println("@@@AfterSuite: Suit is run");
	}
	
	
}
