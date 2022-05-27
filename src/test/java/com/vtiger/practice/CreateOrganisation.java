package com.vtiger.practice;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganisation {

	public static void main(String[] args) 
	{
		Random r=new Random();
		int num=r.nextInt(1000);
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys("root");
		driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
		driver.findElement(By.xpath("//a[text()=\"Organizations\"]")).click();
		driver.findElement(By.xpath("//img[@title=\"Create Organization...\"]")).click();
		driver.findElement(By.xpath("//input[@name=\"accountname\"]")).sendKeys("Ranna"+num);
		driver.findElement(By.xpath("//input[@class=\"crmbutton small save\"]")).click();
		String actual="Ranna"+num;
		String expected = driver.findElement(By.xpath("//span[@id=\"dtlview_Organization Name\"]")).getText();
		if(actual.equals(expected)) {
			System.out.println("Correct organisation name");
		}else {
			System.out.println("Incorrect organisation name");
		}
		Actions action = new Actions(driver);
		WebElement ele = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
		action.moveToElement(ele).perform();
		WebElement logout = driver.findElement(By.xpath("//a[text()=\"Sign Out\"]"));
		logout.click();

		
		

		
	}

}
