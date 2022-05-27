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
import com.vtiger.objectRepository.CreateNewProductPage;
import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.LoginPage;
import com.vtiger.objectRepository.ProductPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProductTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		JavaUtility jl=new JavaUtility();
		FileUtility fileUtility=new FileUtility();
		ExcelUtility excelUtility=new ExcelUtility();
		WebDriverUtility webDriverUtility=new WebDriverUtility();
		
		fileUtility.openPropertyFile(IConstantPath.PROPERTYPATH);
		Long longTimeOut=jl.stringToLong(fileUtility.getDataFromProperty("timeout"));
		WebDriver driver=null;
		String productname="Vtiger"+jl.getRandomNumber(1000);
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
		LoginPage loginpage=new LoginPage(driver);
		HomePage homepage=new HomePage(driver);
        ProductPage productPage=new ProductPage(driver);
        CreateNewProductPage createNewProductPage=new CreateNewProductPage(driver);
		loginpage.loginAction(fileUtility.getDataFromProperty("username"), fileUtility.getDataFromProperty("password"));
		
		homepage.clickOnProduct(driver);
		productPage.clickOnCreateProduct(driver);
		createNewProductPage.enterProductNameAndsave(productname);
		homepage.signout(driver);
		webDriverUtility.quit(driver);
	}

}
