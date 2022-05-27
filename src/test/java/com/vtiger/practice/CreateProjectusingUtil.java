package com.vtiger.practice;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;
import com.sdet34l1.genericLibrary.DataBaseUtility;
import com.sdet34l1.genericLibrary.ExcelUtility;
import com.sdet34l1.genericLibrary.FileUtility;
import com.sdet34l1.genericLibrary.IConstantPath;
import com.sdet34l1.genericLibrary.JavaUtility;
import com.sdet34l1.genericLibrary.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProjectusingUtil {

	public static void main(String[] args) throws SQLException, IOException {
		JavaUtility jutil=new JavaUtility();
		int num=jutil.getRandomNumber(1000);
		FileUtility fileUtility=new FileUtility();
		ExcelUtility excelUtility=new ExcelUtility();
		WebDriverUtility webDriverUtility=new WebDriverUtility();
		DataBaseUtility dataBaseUtility=new DataBaseUtility();
		
		fileUtility.openPropertyFile(IConstantPath.RMG_YANTRA_PROPERTYPATH);
		excelUtility.openExcel(IConstantPath.RMG_YANTRA_EXCELPATH);
		String projectname = excelUtility.getDataFromExcel("projects", 2, 1)+num;
		String createdBy = excelUtility.getDataFromExcel("projects", 2, 2);
		excelUtility.closeExcel();
		
		dataBaseUtility.openDBConnection(IConstantPath.DB_Url+fileUtility.getDataFromProperty("DBName"), fileUtility.getDataFromProperty("DBusername"), fileUtility.getDataFromProperty("DBpassword"));
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		webDriverUtility.browserSetting(10, driver);
		driver.get("http://localhost:8084/");
		driver.findElement(By.id("usernmae")).sendKeys(fileUtility.getDataFromProperty("rmgusername"),Keys.TAB,fileUtility.getDataFromProperty("rmgpassword"),Keys.ENTER);
		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		driver.findElement(By.className("material-icons")).click();
		driver.findElement(By.cssSelector("[name='projectName']")).sendKeys(projectname);
		driver.findElement(By.name("createdBy")).sendKeys(createdBy);
	    WebElement projectstatus=driver.findElement(By.xpath("//label[text()='Project Status ']/../select"));
	    webDriverUtility.initilizeSelectClass(projectstatus);
	    webDriverUtility.selectDropdownByVisibleText("On Goging");
	    driver.findElement(By.xpath("//input[@value='Add Project']")).click();
	    
	     dataBaseUtility.getDataFromDataBase("select * from project;","project_name" );
	     boolean status = dataBaseUtility.validateDataInDataBase("select * from project;", "project_name",projectname); 
	    if(status)
	    {
	    	System.out.println("TC Pass");
	    }else {
	    	System.out.println("TC Fail");
	    }

	    dataBaseUtility.closeDBConnection();
	    webDriverUtility.quit(driver);
        }
	}


