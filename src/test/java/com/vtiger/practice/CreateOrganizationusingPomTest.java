package com.vtiger.practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.sdet34l1.genericLibrary.ExcelUtility;
import com.sdet34l1.genericLibrary.FileUtility;
import com.sdet34l1.genericLibrary.IConstantPath;
import com.sdet34l1.genericLibrary.JavaUtility;
import com.sdet34l1.genericLibrary.WebDriverUtility;
import com.vtiger.objectRepository.CreateNewOrganization;
import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.LoginPage;
import com.vtiger.objectRepository.OrganizationPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationusingPomTest 
{
	public static void main(String[] args) throws IOException {
		
	JavaUtility jl=new JavaUtility();

	FileUtility fileUtility=new FileUtility();
	ExcelUtility excelUtility=new ExcelUtility();
	WebDriverUtility webDriverUtility=new WebDriverUtility();
	fileUtility.openPropertyFile(IConstantPath.PROPERTYPATH);
	Long longTimeOut=jl.stringToLong(fileUtility.getDataFromProperty("timeout"));
	
	WebDriver driver=null;
	switch(fileUtility.getDataFromProperty("browser"))
	{
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			break;
	}
	String url = fileUtility.getDataFromProperty("url");

	webDriverUtility.navigateApp(driver,url);
	webDriverUtility.browserSetting(longTimeOut, driver);
	LoginPage loginage=new LoginPage(driver);
	HomePage homePage=new HomePage(driver);
	OrganizationPage  organizationPage=new OrganizationPage(driver);
	CreateNewOrganization createNewOrganization=new CreateNewOrganization(driver);
	String orgname="Abc"+jl.getRandomNumber(100);
	loginage.loginAction(fileUtility.getDataFromProperty("username"), fileUtility.getDataFromProperty("password"));
	homePage.clickOnOrganization(driver);
	organizationPage.clickOnCreateOrganization(driver);
	
	createNewOrganization.enterAccountNameAndsave(orgname);
	
	String expname=driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
	
	jl.assertionUsingEquals(orgname, expname);
	homePage.signout(driver);
	webDriverUtility.quit(driver);


	}
}
