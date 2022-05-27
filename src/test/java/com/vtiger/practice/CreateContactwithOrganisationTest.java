package com.vtiger.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactwithOrganisationTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		Random r=new Random();
		int num=r.nextInt(1000);
		FileInputStream fis = new FileInputStream("./src/test/resources/testData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String lastname = wb.getSheet("Contact").getRow(2).getCell(1).getStringCellValue()+num;
		wb.close();
	    FileInputStream fis1 = new FileInputStream("src/test/resources/commondata.properties");
		Properties prop=new Properties();
		prop.load(fis1);
		String Url = prop.getProperty("url");
		String Username = prop.getProperty("username");
		String Password = prop.getProperty("password");
		String Timeout = prop.getProperty("timeout");
		long longtime = Long.parseLong(Timeout);
		String Browser = prop.getProperty("browser");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get(Url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(longtime, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys(Username);
		driver.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys(Password);
		driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
		driver.findElement(By.xpath("//a[text()=\"Contacts\"]")).click();
		driver.findElement(By.xpath("//img[@title=\"Create Contact...\"]")).click();
		driver.findElement(By.xpath("//input[@name=\"lastname\"]")).sendKeys(lastname);
		driver.findElement(By.xpath("//input[@class=\"crmButton small save\"]")).click();
		String actual=lastname;
		String expected = driver.findElement(By.xpath("//span[@id=\"dtlview_Last Name\"]")).getText();
		if(actual.equals(expected)) {
			System.out.println("Correct last name");
		}else {
			System.out.println("Incorrect last name");
		}
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@title=\"Duplicate [Alt+U]\"]")));
		Actions action = new Actions(driver);
		WebElement ele = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
		action.moveToElement(ele).perform();
		WebElement logout = driver.findElement(By.xpath("//a[text()=\"Sign Out\"]"));
		logout.click();
		driver.quit();


	}

}
