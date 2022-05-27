package com.vtiger.campaignTest;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import com.sdet34l1.genericLibrary.BaseClass;
import com.sdet34l1.genericLibrary.ExcelUtility;
import com.sdet34l1.genericLibrary.FileUtility;
import com.sdet34l1.genericLibrary.IConstantPath;
import com.sdet34l1.genericLibrary.JavaUtility;
import com.sdet34l1.genericLibrary.WebDriverUtility;
import com.vtiger.objectRepository.CampaignPage;
import com.vtiger.objectRepository.CreateNewCampaignPage;
import com.vtiger.objectRepository.CreateNewProductPage;
import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.LoginPage;
import com.vtiger.objectRepository.ProductPage;
import com.vtiger.objectRepository.SearchProductPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampaignwithProductTest extends BaseClass {
@Test(groups="regression")

	public  void createCampaignwithProductTest() throws InterruptedException, IOException {
		String campaign_name=excelUtility.getDataFromExcel("Contact", 2, 1)+randomNumber;
		String product_name=excelUtility.getDataFromExcel("Product", 2, 1)+randomNumber;
			
		ProductPage productPage=new ProductPage(driver);
		CreateNewProductPage createNewProductPage=new CreateNewProductPage(driver);
		CampaignPage campaignPage=new CampaignPage(driver);
		CreateNewCampaignPage createNewCampaignPage=new CreateNewCampaignPage(driver);
		SearchProductPage searchProductPage=new SearchProductPage(driver);
		
		homepage.clickOnProduct(driver);
		productPage.clickOnCreateProduct(driver);
		createNewProductPage.enterProductNameAndsave(product_name);
		webDriverUtility.WaitUntillElementClickable(driver, longTimeOut, homepage.getMoreDropdown());
		homepage.clickOnCampaign(driver);
		campaignPage.clickOnCreateCampaign(driver);
		
		createNewCampaignPage.enterCampaignNameAndSwitchTosearchProduct(campaign_name,driver);
		searchProductPage.SelectProduct(driver, product_name);
		webDriverUtility.switchToWindowBasedOnTitle(driver, "Campaigns");
		createNewCampaignPage.saveCampaign();
		
		Jutil.assertionUsingIfElse(createNewCampaignPage.getActualCampaignName().getText(), campaign_name, "Camapign with Product");
		Jutil.assertionUsingIfElse(createNewCampaignPage.getActualProductName().getText(), product_name, " ");


	}

}
