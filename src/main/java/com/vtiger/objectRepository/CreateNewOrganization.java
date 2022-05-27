package com.vtiger.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOrganization 
{
	@FindBy(xpath="//input[@name='accountname']")
	private WebElement accountNameTxt;

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	@FindBy(xpath="//select[@name='industry']")
	private WebElement industrydropdown;

	@FindBy(xpath="//select[@name='accounttype']")
	private WebElement typedropdown;
	
	@FindBy(xpath="//span[@id='dtlview_Organization Name']")
	private WebElement createorganizationconfirmationmsg;
	
    @FindBy(xpath="//a[@href='index.php?module=Contacts&action=index']")
	private WebElement contactaction;

   // class="dvHeaderText"
    @FindBy(xpath="//span[@id='dtlview_Organization Name']")
	private WebElement expectedOrgaName;


    public CreateNewOrganization(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getIndustrydropdown() 
	{
		return industrydropdown;
	}
	public WebElement getAccountNameTxt() 
	{
		return accountNameTxt;
	}
	
	
	public WebElement getExpectedOrgaName() 
	{
	return expectedOrgaName;
	}
	public WebElement getcreateorganizationconfirmationmsg() 
	{
	
	return createorganizationconfirmationmsg;
	}
	public WebElement getContactaction() 
	{
		return contactaction;
	}
	public WebElement getTypedropdown() 
	{
		return typedropdown;
	}

	public void enterAccountName(String organizationname ) 
	{
		accountNameTxt.sendKeys(organizationname);
	}
	public void enterAccountNameAndsave(String organizationname ) 
	{
		accountNameTxt.sendKeys(organizationname);
		saveBtn.click();
	}

	public void clickOnsave() 
	{
		saveBtn.click();
	}
}
