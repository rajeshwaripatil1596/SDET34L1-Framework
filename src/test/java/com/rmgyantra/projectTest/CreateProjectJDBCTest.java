package com.rmgyantra.projectTest;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.mysql.cj.jdbc.Driver;
import com.sdet34l1.genericLibrary.DataBaseUtility;
import com.sdet34l1.genericLibrary.ExcelUtility;
import com.sdet34l1.genericLibrary.FileUtility;
import com.sdet34l1.genericLibrary.IConstantPath;
import com.sdet34l1.genericLibrary.JavaUtility;
import com.sdet34l1.genericLibrary.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProjectJDBCTest {

	
	public static void main(String[] args) throws SQLException, IOException {
		JavaUtility jutil=new JavaUtility();
		FileUtility fileUtility=new FileUtility();
		ExcelUtility excelUtility=new ExcelUtility();
		DataBaseUtility dataBaseUtility=new DataBaseUtility();
		WebDriverUtility webDriverUtility=new WebDriverUtility();
		int num=jutil.getRandomNumber(1000);
		fileUtility.openPropertyFile(IConstantPath.RMG_YANTRA_PROPERTYPATH);
		excelUtility.openExcel(IConstantPath.RMG_YANTRA_EXCELPATH);
		
		dataBaseUtility.openDBConnection(IConstantPath.DB_Url, fileUtility.getDataFromProperty("DBusername"), fileUtility.getDataFromProperty("DBpassword"));
		String projectId="TY_PROJ_0"+num;
		String projectName="Abc"+num;
		
		dataBaseUtility.setDataInDataBase("insert into project values('"+projectId+"','Deepak','28/04/2022','"+projectName+"','On Going',3);");
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8084");
		webDriverUtility.browserSetting(10, driver);
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra",Keys.TAB,"rmgy@9999",Keys.ENTER);
		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		dataBaseUtility.validateDataInDataBase(projectName, projectId, projectName);
		List<WebElement> listOfProject=driver.findElements(By.xpath("//table//tbody/tr/td[2]"));
		for(WebElement project:listOfProject)
		{
			if(project.getText().equalsIgnoreCase(projectName))
			{
				System.out.println("Project name present in GUI");
				break;
			}
		}
		dataBaseUtility.closeDBConnection();
		driver.quit();
	}
}