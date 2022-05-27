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

public class CreateOrganisationusingUtils {

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
		driver.get(fileUtility.getDataFromProperty("url"));
		
		String orgname="Abc"+jl.getRandomNumber(100);
		driver.findElement(By.name("user_name")).sendKeys(fileUtility.getDataFromProperty("username"),Keys.TAB,fileUtility.getDataFromProperty("password"),Keys.ENTER);
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgname);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String expname=driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
		jl.assertionUsingEquals(orgname, expname);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		webDriverUtility.quit(driver);

	}

}
