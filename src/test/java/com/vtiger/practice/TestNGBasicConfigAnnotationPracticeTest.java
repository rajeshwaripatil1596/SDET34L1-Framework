package com.vtiger.practice;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class TestNGBasicConfigAnnotationPracticeTest
 
{
	@BeforeSuite
	public void beforSuite1Test()
	{
		Reporter.log("beforesuite1",true);
	}
	@AfterSuite
	public void afterSuite1Test()
	{
		Reporter.log("aftersuite1",true);
	}
	@BeforeClass
	public void beforClass1Test()
	{
		Reporter.log("beforeclass1",true);
	}
	@AfterClass
	public void afterClass1Test()
	{
		Reporter.log("afterclass1",true);
	}
	@BeforeTest
	public void beforeTest1Test()
	{
		Reporter.log("beforetest1",true);
	}
	@AfterTest
	public void afterTest1Test()
	{
		Reporter.log("aftertest1",true);
	}
	@BeforeMethod
	public void beforeMethod1Test()
	{
		Reporter.log("beforemethod1",true);
	}
	@BeforeMethod
	public void beforeMethod2Test()
	{
		Reporter.log("beforemethod2",true);
	}
	@AfterMethod
	public void afterMethod1Test()
	{
		Reporter.log("aftertest1",true);
	}

}
