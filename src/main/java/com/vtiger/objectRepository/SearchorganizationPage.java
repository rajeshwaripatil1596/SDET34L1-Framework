package com.vtiger.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sdet34l1.genericLibrary.WebDriverUtility;

public class SearchorganizationPage{


	 @FindBy(xpath="//input[@id='search_txt']")
	  private WebElement searchTxt;
	  
	 @FindBy(xpath="//input[@type='button']")
	  private WebElement searchBtn;
	 
	 @FindBy(xpath="//a[@href='javascript:window.close();']")
	  private WebElement firstMatchingOrgLink;

	  
	  public SearchorganizationPage(WebDriver driver)
	  {
		  PageFactory.initElements(driver, this);
	  }
	  
		public WebElement getfirstMatchingOrgLink() 
		{
			return firstMatchingOrgLink;
		}
	  public void SelectOrganization(WebDriver driver,String organizationName) 
	  {
		  WebDriverUtility webDriverUtility=new WebDriverUtility();
		  webDriverUtility.switchToWindowBasedOnTitle(driver, "Organization");
		  searchTxt.sendKeys(organizationName);
		  searchBtn.click();
		  driver.findElement(By.xpath("//*[@href=\"javascript:window.close();\"]")).click();
		
		  //driver.findElement(By.xpath("//a[.,='"+productName+"']")).click();
	  }
}
