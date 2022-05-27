package com.vtiger.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sdet34l1.genericLibrary.WebDriverUtility;

public class CreateNewCampaignPage 
{
	 //@FindBy(xpath="//input[@name='campaignname']")
	 //private WebElement campaignNameTxt;
	 
	 @FindBy(name="campaignname")
	 private WebElement campaignNameTxt;

	 
	 @FindBy(xpath="//input[@title='Save [Alt+S]']")
	 private WebElement saveBtn;

	 @FindBy(xpath="(//img[@src='themes/softed/images/select.gif'])[1]")
	 private WebElement searchProductLookUpImg;
	
	 @FindBy(id="dtlview_Campaign Name")
	 private WebElement actualCampaignName;
	 
	 @FindBy(xpath="//span[@id=\"dtlview_Product\"]")
	 private WebElement actualProductName;
		

	 public CreateNewCampaignPage(WebDriver driver)
	  {
		  PageFactory.initElements(driver, this);
	  }
		
	  public void enterCampaignNameandSave(String campaignName ) 
	  {
		  campaignNameTxt.sendKeys(campaignName);
		  saveBtn.click();
	  }
	  public WebElement getCampaignNameTxt() 
	  {
		 return campaignNameTxt;
	  }
	
	  public void enterCampaignNameAndSwitchTosearchProduct(String campaignName,WebDriver driver ) 
	  {
		  campaignNameTxt.sendKeys(campaignName);
		  searchProductLookUpImg.click();
	  }
	  public void saveCampaign() 
	  {
		  saveBtn.click();
	  }
	public WebElement getActualCampaignName()
	{
		return actualCampaignName;
	}
	public WebElement getActualProductName()
	{
		return actualProductName;
	}
}
