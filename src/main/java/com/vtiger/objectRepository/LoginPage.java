package com.vtiger.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.sdet34l1.genericLibrary.FileUtility;

//create class as webpage name and make it as public
public class LoginPage

{
	//declare all the elements and specify the access specifer as private
	@FindBy(name="user_name")
	private WebElement userNameTxt;

	@FindBy(name="user_password")
	private WebElement passwordTxt;

//	@FindBy(how=How.NAME, using="user_password")
//	private WebElement passwordTxt;

	@FindBy(id="submitButton")
	private WebElement loginBtn;
	
	//initialize the driver address to all the elements through constructor and make it as public
	public LoginPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	//buiseness library
	public void loginAction(String username,String password)
	{
		userNameTxt.sendKeys(username);
		passwordTxt.sendKeys(password);
		loginBtn.click();
	}
	
	
}
