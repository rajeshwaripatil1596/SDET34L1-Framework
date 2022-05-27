package com.vtiger.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewProductPage 
{
	 @FindBy(xpath="//input[@name='productname']")
	 private WebElement productNameTxt;
	 
	 @FindBy(xpath="//input[@title='Save [Alt+S]']")
	 private WebElement saveBtn;
	 
	 	

	 public CreateNewProductPage(WebDriver driver)
	  {
		  PageFactory.initElements(driver, this);
	  }
		
	  public void enterProductNameAndsave(String productname ) 
	  {
		  productNameTxt.sendKeys(productname);
		  saveBtn.click();
	  }


}
