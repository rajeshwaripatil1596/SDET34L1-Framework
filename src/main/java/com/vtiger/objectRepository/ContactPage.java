package com.vtiger.objectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage 
{
	 @FindBy(xpath="//img[@src=\"themes/softed/images/btnL3Add.gif\"]")
	 private WebElement createContactImg;

	 @FindBy(xpath="//img[@alt=\"Last Viewed\"]")
	 private WebElement lastViewedIcon;

	 @FindBy(xpath="//td[@class=\"trackerList small\"]")
	 private List<WebElement> lastViewedContacts;
	 
	 @FindBy(xpath="//*[@title=\"Contacts\"]")
	 private List<WebElement> contactList;

	 @FindBy(xpath="(//img[@src=\"themes/images/close.gif\"])[2]")
	 private WebElement closeLastViewedListIcon;
	 
	 @FindBy(xpath="//*[@class=\"dvInnerHeader\"]")
	 private WebElement contactInfoDisplydMsg;
	 
	 @FindBy(xpath="//*[@title=\"Duplicate [Alt+U]\"]")
	 private WebElement duplicateBtn;

	 @FindBy(xpath="//*[@title=\"Edit [Alt+E]\"]")
	 private WebElement editBtn;

	 @FindBy(xpath="//*[@title=\"Save [Alt+S]\"]")
	 private WebElement saveBtn;
	 
	 @FindBy(xpath="//*[@class=\"lvtHeaderText\"]")
	 private WebElement editcontactInfoDisplydMsg;
	
	 @FindBy(id="mouseArea_Last Name")
	 private WebElement updatedName;

	 @FindBy(xpath="//a[@title='Contacts']")
	 private WebElement firstContact;
     
	 public ContactPage(WebDriver driver)
	  {
		  PageFactory.initElements(driver, this);
	  }
		
	  public void clickOnCreateContact(WebDriver driver) 
	  {
		  createContactImg.click();
	  }
	  public WebElement getUpdatedName() 
	  {
		  return updatedName;
	  }
	  public WebElement getFirstContact() 
	  {
		  return firstContact;
	  }
	  
	  public void clickOnCloseLastViewedListIcon() 
	  {
		  closeLastViewedListIcon.click();
	  }
	  public void clickOnSaveBtn() 
	  {
		  saveBtn.click();
	  }

	  public void clickOnDuplicateBtn() 
	  {
		  duplicateBtn.click();
	  }
	  public void clickOnEditBtn() 
	  {
		  editBtn.click();
	  }
	  
	  public void clickOnLastViewedIcon() 
	  {
		  lastViewedIcon.click();
	  }
	  public WebElement getContactInfoDisplydMsg() 
	  {
	  return contactInfoDisplydMsg;
	  }
	  public WebElement getEditcontactInfoDisplydMsg() 
	  {
	  return editcontactInfoDisplydMsg;
	  }

	  
	  public List<WebElement> getLastViewedContacts() 
	  {
	  return lastViewedContacts;
	  }
	  public List<WebElement> getContactList() 
	  {
	  return contactList;
	  }
	  
	  

}
