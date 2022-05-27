package com.vtiger.productTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import com.sdet34l1.genericLibrary.BaseClass;
import com.sdet34l1.genericLibrary.FileUtility;
import com.sdet34l1.genericLibrary.IConstantPath;
import com.sdet34l1.genericLibrary.JavaUtility;
import com.sdet34l1.genericLibrary.WebDriverUtility;
import com.vtiger.objectRepository.CreateNewProductPage;
import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.LoginPage;
import com.vtiger.objectRepository.ProductPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProductTest extends BaseClass 
{
	@Test(groups="sanity")

	public  void createProduct1Test() throws IOException {
		String productname="Vtiger"+randomNumber;
		ProductPage productPage=new ProductPage(driver);
        CreateNewProductPage createNewProductPage=new CreateNewProductPage(driver);
		homepage.clickOnProduct(driver);
		productPage.clickOnCreateProduct(driver);
		createNewProductPage.enterProductNameAndsave(productname);
		}

																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																							

}
