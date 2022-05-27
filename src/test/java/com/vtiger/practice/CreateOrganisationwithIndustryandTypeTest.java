package com.vtiger.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganisationwithIndustryandTypeTest {

	public static void main(String[] args) throws IOException {
	    FileInputStream fis = new FileInputStream("src/test/resources/coomondata.properties");
		Properties prop=new Properties();
		prop.load(fis);
		String Url = prop.getProperty("url");
		String Username = prop.getProperty("username");
		String Password = prop.getProperty("password");
		String Timeout = prop.getProperty("timeout");
		long longtime = Long.parseLong(Timeout);
		String Browser = prop.getProperty("browser");
		Random r=new Random();
		int num=r.nextInt(1000);
		FileInputStream fis1 = new FileInputStream("./src/test/resources/testData.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		String organisation_name = wb.getSheet("Organisation").getRow(4).getCell(1).getStringCellValue()+num;
		wb.close();

		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get(Url);
        driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(longtime, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys(Username);
		driver.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys(Password);
		driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
		driver.findElement(By.xpath("//a[text()=\"Organizations\"]")).click();
		driver.findElement(By.xpath("//img[@title=\"Create Organization...\"]")).click();
		driver.findElement(By.xpath("//input[@name=\"accountname\"]")).sendKeys(organisation_name);
		//driver.findElement(By.xpath("//input[@class=\"crmbutton small save\"]")).click();
		
		WebElement industry=driver.findElement(By.xpath("//select[@name='industry']"));
		Select s=new Select(industry);
		s.selectByValue("Education");
		
		WebElement type=driver.findElement(By.xpath("//select[@name='accounttype']"));
		s=new Select(type);
		s.selectByValue("Press");
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		String exp_orgname=driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
		if(organisation_name.equals(exp_orgname))
		{
			System.out.println("\"Organization created Successfully\"");
		
		}
		Actions action = new Actions(driver);
		WebElement ele = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
		action.moveToElement(ele).perform();
		WebElement logout = driver.findElement(By.xpath("//a[text()=\"Sign Out\"]"));
		logout.click();
		driver.quit();


	}

}
