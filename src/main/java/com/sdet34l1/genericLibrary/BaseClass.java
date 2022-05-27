package com.sdet34l1.genericLibrary;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * This is super class for all the test script classes
 * @author ACER
 *
 */
public class BaseClass {
	
	public  int randomNumber;
	public  JavaUtility Jutil;
	public WebDriverUtility webdriverutility;
	public  WebDriver driver=null;
	public  LoginPage loginpage;
	public  HomePage  homepage;
	public  String user_name;
	public  String password;
	public  Long longTimeOut;
	public FileUtility fileUtility;
	public ExcelUtility excelUtility;
	public WebDriverUtility webDriverUtility;
	public String url;
	public static WebDriver staticDriver;
	public String browser;
	/**
	 * This method is used to connect Excel and Property file connection
	 * @throws IOException
	 */
	@BeforeSuite(groups="baseclass")
	public void beforSuiteTest() throws IOException
	{
		//fileUtility=new FileUtility();
		//fileUtility.openPropertyFile(IConstantPath.PROPERTYPATH);
//		excelUtility=new ExcelUtility();
//		excelUtility.openExcel(IConstantPath.EXCELPATH);
		
	}
	/**
	 * launch browser and browser settings and navigate to application
	 * @throws IOException 
	 */
	@Parameters("browser")
	@BeforeClass(groups="baseclass")
	public void beforeClassTest(/*String browser*/) throws IOException
	{
		fileUtility=new FileUtility();
		fileUtility.openPropertyFile(IConstantPath.PROPERTYPATH);
		excelUtility=new ExcelUtility();
		excelUtility.openExcel(IConstantPath.EXCELPATH);
		
		Jutil=new JavaUtility();
		webDriverUtility=new WebDriverUtility();
		user_name=fileUtility.getDataFromProperty("username");
		password=fileUtility.getDataFromProperty("password");
		 url = fileUtility.getDataFromProperty("url");
		longTimeOut=Jutil.stringToLong(fileUtility.getDataFromProperty("timeout"));
		randomNumber=Jutil.getRandomNumber(1000);
		//
		browser=System.getProperty("browser");
		//url=System.getProperty("url");
		//user_name=System.getProperty("username");
		//password=System.getProperty("password");)
		switch(browser)
		{
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			break;
		default:
			System.out.println("specify the correct browser");
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;

		}
		webDriverUtility.navigateApp(driver, url);  	  
		webDriverUtility.browserSetting(longTimeOut, driver);
		webDriverUtility.explicitWait(driver, longTimeOut);
		staticDriver=driver;
		loginpage=new LoginPage(driver);
		homepage=new HomePage(driver);
	}
	/**
	 * login action
	 */
	@BeforeMethod(groups="baseclass")
	public void beforeMethodTest()
	{
		loginpage.loginAction(user_name, password);
	}
	/**
	 * logout action
	 */
	@AfterMethod(groups="baseclass")
	public void afterMethodTest()
	{
		homepage.signout(driver);
	}
	/**
	 * close the browser
	 */
	@AfterClass(groups="baseclass")
	public void afterClassTest()
	{
		webDriverUtility.quit(driver);
	}
	/**
	 * close Excel
	 * @throws IOException
	 */
	@AfterSuite(groups="baseclass")
	public void afterSuiteTest() throws IOException
	{
		excelUtility.closeExcel();
	}
}
