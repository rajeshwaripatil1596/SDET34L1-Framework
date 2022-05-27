package com.vtiger.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewDocument 
{
	 @FindBy(name="notes_title")
	 private WebElement documentTitleTxt;
     
	 @FindBy(xpath="//iframe[@title='Rich text editor, notecontent, press ALT 0 for help.']")
	 private WebElement frameElement;
	 
	 @FindBy(xpath="//body[@class='cke_show_borders']")
	 private WebElement frameBorder;
	 
	 @FindBy(xpath="//a[@id='cke_5']")
	 private WebElement boldLetter;
	 
	 @FindBy(xpath="//a[@id='cke_6']")
	 private WebElement iILetter;
	 
	 @FindBy(xpath="//input[@name='filename']")
	 private WebElement chooseFile;
	 
	 @FindBy(xpath="//b[.='File Information']/../../following-sibling::tr[4]//input[@title='Save [Alt+S]']")
	 private WebElement saveBtn;
	
	 public CreateNewDocument(WebDriver driver)
	  {
		  PageFactory.initElements(driver, this);
	  }
	 public WebElement getChooseFile() 
	  {
		 return chooseFile;
	  }
		
	  public void enterTitle(String title ) 
	  {
		  documentTitleTxt.sendKeys(title);
	  }
	  public void clickOnSave() 
	  {
		  saveBtn.click();
	  }
	  public void clickOnBold() 
	  {
		  boldLetter.click();
	  }
	  public void clickOnI() 
	  {
		  iILetter.click();
	  }
	  public WebElement getFrameElement() 
	  {
		 return frameElement;
	  }
	  public WebElement getFrameBorder() 
	  {
		 return frameBorder;
	  }
	  


}
