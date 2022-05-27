package com.vtiger.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sdet34l1.genericLibrary.WebDriverUtility;

public class HomePage 
{
	@FindBy(linkText="More")
	private WebElement moreDropdown;

	//  @FindBy(xpath="//a[@href=\"javascript:;\"]")
	//  private WebElement moreDropdown;

	@FindBy(xpath="//a[@name='Campaigns']")
	private WebElement campaignsTab;

	@FindBy(xpath="//img[@src=\"themes/softed/images/user.PNG\"]")
	private WebElement administartorIcon;

	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signOutLink;

	@FindBy(linkText="Products")
	private WebElement productLink;

	@FindBy(linkText="Documents")
	private WebElement documentsLink;


	@FindBy(xpath="//a[text()='Contacts']")
	private WebElement contactLink;

	@FindBy(xpath="//a[text()='Organizations']")
	private WebElement organizationsLink;


	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getMoreDropdown() 
	{
		return moreDropdown;
	}
	public WebElement getadministartorIcon() 
	{
		return administartorIcon;
	}

	public void clickOnCampaign(WebDriver driver) 
	{
		WebDriverUtility webdriverutility=new WebDriverUtility();
		webdriverutility.mouseHoverOnTheElement(moreDropdown,driver);
		campaignsTab.click();
	}
	public void clickOnProduct(WebDriver driver) 
	{
		productLink.click();
	}
	public void clickOnDocument(WebDriver driver) 
	{
		documentsLink.click();
	}
	public void clickOnOrganization(WebDriver driver) 
	{
		organizationsLink.click();
	}


	public void clickOnContactLink(WebDriver driver) 
	{
		contactLink.click();
	}
	public void signout(WebDriver driver) {
		WebDriverUtility webdriverutility=new WebDriverUtility();
		webdriverutility.mouseHoverOnTheElement(administartorIcon,driver);
		//administartorIcon.click();
		signOutLink.click();
	}


}
