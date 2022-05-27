package com.vtiger.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContactPage 
{
	@FindBy(name="lastname")
	private WebElement lastNameTxt;

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	@FindBy(xpath="(//img[@src='themes/softed/images/select.gif'])[1]")
	private WebElement orgNameLookupImg;

	@FindBy(xpath="//input[@title=\"Clear\"]")
	private WebElement clearOrgImg;

	@FindBy(xpath="//*[@class=\"dvHeaderText\"]")
	private WebElement confirmationText;

	@FindBy(xpath="//input[@name=\"donotcall\"]")
	private WebElement donotCallCheckBox;

	@FindBy(xpath="//input[@name=\"emailoptout\"]")
	private WebElement emailoptOutCheckBox;

	@FindBy(xpath="//input[@name=\"reference\"]")
	private WebElement referenceCheckBox;

	@FindBy(xpath="//input[@name=\"notify_owner\"]")
	private WebElement notifyMeCheckBox;

	@FindBy(id="mouseArea_Organization Name")
	private WebElement expectedOrganization;

	@FindBy(xpath="//span[@id='dtlview_Last Name']")
	private WebElement expectedContactName;

	@FindBy(xpath="//a[@href='javascript:window.close();']")
	private WebElement closeBtn;

	public CreateNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getexpectedOrganization() 
	{
		return expectedOrganization;	  
	}
	public WebElement getexpectedContactName() 
	{
		return expectedContactName;	  
	}


	public WebElement getLastName() 
	{
		return lastNameTxt;	  

	}
	public void enterLastName(String lastName) 
	{
		lastNameTxt.sendKeys(lastName);	  

	}
	public WebElement getConfirmationText() {
		return confirmationText;
	}
	public WebElement getdonotCallCheckBox() {
		return donotCallCheckBox;
	}
	public WebElement getemailoptOutCheckBox() {
		return emailoptOutCheckBox;
	}
	public WebElement getReferenceCheckBox() {
		return referenceCheckBox;
	}
	public WebElement getNotifyMeCheckBox() {
		return notifyMeCheckBox;
	}
	public WebElement getcloseBtn() {
		
		return closeBtn;
	}
	
	public void clickOnClearOrg() 
	{
		clearOrgImg.click();
	}
	public void saveContact() 
	{
		saveBtn.click();
	}
	public void clickOnOrgNameImg() 
	{
		orgNameLookupImg.click();
	}


}
