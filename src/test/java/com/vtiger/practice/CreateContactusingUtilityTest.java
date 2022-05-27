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

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactusingUtilityTest {

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
		// navigate to application
		String url = fileUtility.getDataFromProperty("url");

	    webDriverUtility.navigateApp(driver,url);
		//maximise browser and implicitly wait
	    webDriverUtility.browserSetting(LongTimeOut, driver);
	    driver.findElement(By.name("user_name")).sendKeys(fileUtility.getDataFromProperty("username"),Keys.TAB,fileUtility.getDataFromProperty("password"),Keys.ENTER);
		if(driver.getTitle().contains("Home"))
		{
			excelUtility.setDatatoExcel("Contact", 4, 19, "Homepage displayed");
			excelUtility.setDatatoExcel("Contact", 4, 20, "Pass");
		}
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		if(driver.getTitle().contains("Contacts"))
		{
			excelUtility.setDatatoExcel("Contact", 5, 19, "Contact displayed");
			excelUtility.setDatatoExcel("Contact", 5, 20, "Pass");
		}
	    
		driver.findElement(By.xpath("//img[@title=\"Create Contact...\"]")).click();
		if(driver.getTitle().contains("Contacts"))
		{
			excelUtility.setDatatoExcel("Contact", 6, 19, "Create Contact page displayed");
			excelUtility.setDatatoExcel("Contact", 6, 20, "Pass");
		}
		
		driver.findElement(By.xpath("//input[@name=\"lastname\"]")).sendKeys(last_name);
		
		excelUtility.setDatatoExcel("Contact", 7, 17, last_name);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Jutil.printStatement(driver.getTitle());
		
		if(driver.getTitle().contains("Contacts"))
		{
			excelUtility.setDatatoExcel("Contact", 7, 19, "Contact Information page displayed");
			excelUtility.setDatatoExcel("Contact", 7, 20, "Pass");
		}
		
		String expname=driver.findElement(By.xpath("//span[@id='dtlview_Last Name']")).getText();
		if(last_name.equals(expname))
		{
			Jutil.printStatement("Contact Created Successfully");
			//ExcelUtility.setDatatoExcel("Contact", 8, 19, "Contact Created Successfully");
			//ExcelUtility.setDatatoExcel("Contact", 8, 20, "Pass");
		}
		else
		{
			Jutil.printStatement("Contact Creation Failed");
		}
		
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
		if(driver.getTitle().contains("vtiger CRM"))
		{
			//ExcelUtility.setDatatoExcel("Contact", 9, 19, "Login page displayed");
			//ExcelUtility.setDatatoExcel("Contact", 9, 20, "Pass");
		}
		
		Thread.sleep(2000);
		excelUtility.writeDatatoExcel(IConstantPath.EXCELPATH);
		excelUtility.closeExcel();
		webDriverUtility.quit(driver);	}

}
