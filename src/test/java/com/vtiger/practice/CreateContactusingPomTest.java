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
import com.vtiger.objectRepository.ContactPage;
import com.vtiger.objectRepository.CreateNewContactPage;
import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactusingPomTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		JavaUtility Jutil = new JavaUtility();
		int num = Jutil.getRandomNumber(1000);
		FileUtility fileUtility=new FileUtility();
		ExcelUtility excelUtility=new ExcelUtility();
		WebDriverUtility webDriverUtility=new WebDriverUtility();
		fileUtility.openPropertyFile(IConstantPath.PROPERTYPATH);
		long LongTimeOut = Jutil.stringToLong(fileUtility.getDataFromProperty("timeout"));
		excelUtility.openExcel(IConstantPath.EXCELPATH);
		String last_name=excelUtility.getDataFromExcel("Contact", 2, 1)+num;
		
		WebDriver driver=null;
		//open the browser
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
	    webDriverUtility.browserSetting(LongTimeOut, driver);
	    LoginPage loginpage=new LoginPage(driver);
	    HomePage homepage=new HomePage(driver);
	    ContactPage contactPage=new ContactPage(driver);
	    CreateNewContactPage createNewContactPage=new CreateNewContactPage(driver);
	    
	    loginpage.loginAction(fileUtility.getDataFromProperty("username"), fileUtility.getDataFromProperty("password"));
	    Jutil.assertionUsingIfContains(driver.getTitle(), "Home");	    
	    if(driver.getTitle().contains("Home"))
		{
			excelUtility.setDatatoExcel("Contact", 7, 14, "Homepage displayed");
			excelUtility.setDatatoExcel("Contact", 7, 15, "Pass");
		}
		
	    homepage.clickOnContactLink(driver);
		if(driver.getTitle().contains("Contacts"))
		{
			excelUtility.setDatatoExcel("Contact", 8, 14, "Contact displayed");
			excelUtility.setDatatoExcel("Contact", 8, 15, "Pass");
		}
		contactPage.clickOnCreateContact(driver);
		if(driver.getTitle().contains("Contacts"))
		{
			excelUtility.setDatatoExcel("Contact", 9, 14, "Create Contact page displayed");
			excelUtility.setDatatoExcel("Contact", 9, 15, "Pass");
		}
		
		createNewContactPage.enterLastName(last_name);
		
		excelUtility.setDatatoExcel("Contact", 10, 14, last_name);
		createNewContactPage.saveContact();
		Jutil.printStatement(driver.getTitle());
		
		if(driver.getTitle().contains("Contacts"))
		{
			excelUtility.setDatatoExcel("Contact", 11, 14, "Contact Information page displayed");
			excelUtility.setDatatoExcel("Contact", 11, 15, "Pass");
		}
		
		String expname=driver.findElement(By.xpath("//span[@id='dtlview_Last Name']")).getText();
		
		if(last_name.equals(expname))
		{
			Jutil.printStatement("Contact Created Successfully");
			excelUtility.setDatatoExcel("Contact", 12, 14, "Contact Created Successfully");
			excelUtility.setDatatoExcel("Contact", 12, 15, "Pass");
		}
		else
		{
			Jutil.printStatement("Contact Creation Failed");
		}
		webDriverUtility.WaitUntillElementClickable(driver, LongTimeOut, homepage.getadministartorIcon());
		homepage.signout(driver);
		
		/*if(driver.getTitle().contains("vtiger CRM"))
		{
			ExcelUtility.setDatatoExcel("Contact", 13, 14, "Login page displayed");
			ExcelUtility.setDatatoExcel("Contact", 13, 15, "Pass");
		}*/
		
		Thread.sleep(2000);
		excelUtility.writeDatatoExcel(IConstantPath.EXCELPATH);
		excelUtility.closeExcel();
		webDriverUtility.quit(driver);	}


	}


