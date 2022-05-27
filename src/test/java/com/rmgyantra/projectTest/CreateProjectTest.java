package com.rmgyantra.projectTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProjectTest {

	
	public static void main(String[] args) throws InterruptedException, SQLException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8084");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Random r=new Random();
		int num=r.nextInt(10000);
		String projectname="Abc"+num;
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra",Keys.TAB,"rmgy@9999",Keys.ENTER);
		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		driver.findElement(By.className("material-icons")).click();
		driver.findElement(By.cssSelector("[name='projectName']")).sendKeys(projectname);
		driver.findElement(By.name("createdBy")).sendKeys("Deepak");
	    WebElement projectstatus=driver.findElement(By.xpath("//label[text()='Project Status ']/../select"));
	    Select s=new Select(projectstatus);
	    s.selectByVisibleText("On Goging");
	    driver.findElement(By.xpath("//input[@value='Add Project']")).click();
	    
	    Connection connection=null;
		try {
		Driver driver1=new Driver();
		DriverManager.registerDriver(driver1);
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
		Statement statement=connection.createStatement();
		ResultSet result=statement.executeQuery("select * from project;");
		while(result.next())
		{
			if(result.getString(4).equals(projectname))
				System.out.println("Project Created Successfully");
		}}
		finally {
		connection.close();}
		driver.close();
	}
}
