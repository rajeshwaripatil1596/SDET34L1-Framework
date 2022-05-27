package com.vtiger.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactusingPropertyfileTest {
 @Test
	public  void createContactusingPropertyfileTest() throws IOException {
		WebDriver driver=null;
		FileInputStream fis = new FileInputStream("src/test/resources/commondata.properties");
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
		switch(Browser)
		{
		case "chrome":
			WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			 driver=new FirefoxDriver();
			break;
		default:
			System.out.println("please specify the proper browser key");
			WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver();
			break;
		}
		driver.get(Url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(longtime, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys(Username);
		driver.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys(Password);
		driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
		driver.findElement(By.xpath("//a[text()=\"Contacts\"]")).click();
		driver.findElement(By.xpath("//img[@title=\"Create Contact...\"]")).click();
		driver.findElement(By.xpath("//input[@name=\"lastname\"]")).sendKeys("Rana"+num);
		driver.findElement(By.xpath("//input[@class=\"crmButton small save\"]")).click();
		String actual="Rana"+num;
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

	}

}
