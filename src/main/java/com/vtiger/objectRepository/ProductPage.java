package com.vtiger.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage 
{
	 @FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	 private WebElement createProductImg;
	 

	 public ProductPage(WebDriver driver)
	  {
		  PageFactory.initElements(driver, this);
	  }
		
	  public void clickOnCreateProduct(WebDriver driver) 
	  {
		  createProductImg.click();
	  }


}
