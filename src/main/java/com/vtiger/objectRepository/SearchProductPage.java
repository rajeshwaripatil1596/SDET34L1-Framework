package com.vtiger.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sdet34l1.genericLibrary.WebDriverUtility;

public class SearchProductPage 
{
	 @FindBy(xpath="//input[@id='search_txt']")
	  private WebElement searchTxt;
	  
	 @FindBy(xpath="//input[@type='button']")
	  private WebElement searchBtn;
	  
	  public SearchProductPage(WebDriver driver)
	  {
		  PageFactory.initElements(driver, this);
	  }
	  
		
	  public void SelectProduct(WebDriver driver,String productName) 
	  {
		  WebDriverUtility webDriverUtility=new WebDriverUtility();
		  webDriverUtility.switchToWindowBasedOnTitle(driver, "Products");
		  searchTxt.sendKeys(productName);
		  searchBtn.click();
		  driver.findElement(By.xpath("//*[@href=\"javascript:window.close();\"]")).click();
		
		  //driver.findElement(By.xpath("//a[.,='"+productName+"']")).click();
	  }
	
	}
