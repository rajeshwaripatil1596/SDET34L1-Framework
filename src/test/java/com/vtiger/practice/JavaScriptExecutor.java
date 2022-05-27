package com.vtiger.practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.sdet34l1.genericLibrary.ExcelUtility;
import com.sdet34l1.genericLibrary.FileUtility;
import com.sdet34l1.genericLibrary.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutor {
    @Test
	public  void javaScriptExecutor() throws IOException {
    	FileUtility fileUtility=new FileUtility();
		ExcelUtility excelUtility=new ExcelUtility();
		WebDriverUtility webDriverUtility=new WebDriverUtility();
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		webDriverUtility.initializeJS(driver);
		driver.manage().window().maximize();
		webDriverUtility.navigateApplicatonthroughJS("http://localhost:8888/");
		webDriverUtility.enterDatathroughJS(driver.findElement(By.name("user_name")), "admin");
		webDriverUtility.enterDatathroughJS(driver.findElement(By.name("user_password")), "root");
		webDriverUtility.clickThroughJS(driver.findElement(By.id("submitButton")));
		webDriverUtility.scrolTillElement(driver.findElement(By.xpath("//b[contains(.,'Upcoming Activities']")));
	    String fileName = new JavaScriptExecutor().getClass().getName();
	    webDriverUtility.takeScreenShot(driver, fileName);
	    Reporter.log("taken screenshot ");
	
	}

}
