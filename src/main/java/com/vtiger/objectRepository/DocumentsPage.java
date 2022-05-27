package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DocumentsPage 
{
	@FindBy(xpath="//img[@src=\"themes/softed/images/btnL3Add.gif\"]")
	 private WebElement createNewDocumentImg;
	 

	 
	 public DocumentsPage(WebDriver driver)
	  {
		  PageFactory.initElements(driver, this);
	  }
		
	  public void clickOnCreateDocument() 
	  {
		  createNewDocumentImg.click();
	  }



}
