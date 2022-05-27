package com.vtiger.practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.sdet34l1.genericLibrary.ExcelUtility;
import com.sdet34l1.genericLibrary.FileUtility;
import com.sdet34l1.genericLibrary.IConstantPath;
import com.sdet34l1.genericLibrary.JavaUtility;
import com.sdet34l1.genericLibrary.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampaignusingUtilityTest {

	public static void main(String[] args) throws IOException {
		JavaUtility Jutil=new JavaUtility();
		WebDriverUtility webDriverUtility=new WebDriverUtility();
		FileUtility fileUtility=new FileUtility();
		ExcelUtility excelUtility=new ExcelUtility();
		fileUtility.openPropertyFile(IConstantPath.PROPERTYPATH);
		excelUtility.openExcel(IConstantPath.EXCELPATH);
		Long longTimeOut=Jutil.stringToLong(fileUtility.getDataFromProperty("timeout"));
		String campaign_name=excelUtility.getDataFromExcel("Campaign", 2, 1)+Jutil.getRandomNumber(1000);
		excelUtility.closeExcel();
		
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
		
		driver.findElement(By.name("user_name")).sendKeys(fileUtility.getDataFromProperty("username"));
		driver.findElement(By.name("user_password")).sendKeys(fileUtility.getDataFromProperty("password"));
		driver.findElement(By.id("submitButton")).click();
		
		WebElement wb=driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']"));
		
		webDriverUtility.initilizeActions(driver);
		webDriverUtility.mouseHoverOnTheElement(wb,driver);
		
		driver.findElement(By.xpath("//a[@name='Campaigns']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		driver.findElement(By.xpath("//input[@name='campaignname']")).sendKeys(campaign_name);
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		WebElement wb1=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		webDriverUtility.initilizeActions(driver);
		webDriverUtility.mouseHoverOnTheElement(wb1,driver);
		
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
		webDriverUtility.quit(driver);

	}

}
