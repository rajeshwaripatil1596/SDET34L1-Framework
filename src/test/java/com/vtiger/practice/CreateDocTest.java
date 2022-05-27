package com.vtiger.practice;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateDocTest
{	public static void main(String[] args) throws InterruptedException

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

driver.findElement(By.xpath("//a[text()=\"Documents\"]")).click();

driver.findElement(By.xpath("//img[@title=\"Create Document...\"]")).click();

driver.findElement(By.xpath("//input[@name=\"notes_title\"]")).sendKeys("title"+num);
Thread.sleep(2000);
driver.switchTo().frame(0);
driver.findElement(By.xpath("//body[@class=\"cke_show_borders\"]")).sendKeys("ghsdjbjhaknkbjkikhfdgjjmmnbb");
driver.findElement(By.xpath("//body[@class=\"cke_show_borders\"]")).sendKeys(Keys.CONTROL+"a");
driver.switchTo().defaultContent();
driver.findElement(By.xpath("//a[@title=\"Bold\"]")).click();
driver.findElement(By.xpath("//a[@title=\"Italic\"]")).click();
driver.findElement(By.xpath("//input[@name=\"filename\"]")).sendKeys("C://Users//ACER//Desktop//Patil//Generics.txt");
driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();

Actions action = new Actions(driver);
WebElement ele = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
action.moveToElement(ele).perform();
WebElement logout = driver.findElement(By.xpath("//a[text()=\"Sign Out\"]"));
logout.click();

}
	
}
