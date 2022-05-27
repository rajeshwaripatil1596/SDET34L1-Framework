package com.vtiger.campaignTest;

import java.io.IOException;

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
import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;
public class CreateCampaignTest extends BaseClass {
	public String campaign_name;
	public CampaignPage campaignPage;
	public CreateNewCampaignPage createNewCampaignPage;
	@Test(groups="sanity")
	public void createCampaignTest() throws IOException 
	{
		campaign_name=excelUtility.getDataFromExcel("Campaign", 2, 1)+randomNumber;		
		campaignPage=new CampaignPage(driver);
		createNewCampaignPage=new CreateNewCampaignPage(driver);		
		homepage.clickOnCampaign(driver);
		campaignPage.clickOnCreateCampaign(driver);
		createNewCampaignPage.enterCampaignNameandSave(campaign_name);
	}
}
