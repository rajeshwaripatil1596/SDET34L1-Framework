package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage
{
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	 private WebElement createOrganizationImg;
	 

	 public OrganizationPage(WebDriver driver)
	  {
		  PageFactory.initElements(driver, this);
	  }
		
	  public void clickOnCreateOrganization(WebDriver driver) 
	  {
		  createOrganizationImg.click();
	  }


}
