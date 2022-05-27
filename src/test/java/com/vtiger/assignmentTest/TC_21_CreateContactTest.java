package com.vtiger.assignmentTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import com.sdet34l1.genericLibrary.BaseClass;
import com.sdet34l1.genericLibrary.ExcelUtility;
import com.sdet34l1.genericLibrary.FileUtility;
import com.sdet34l1.genericLibrary.IConstantPath;
import com.sdet34l1.genericLibrary.JavaUtility;
import com.sdet34l1.genericLibrary.WebDriverUtility;
import com.vtiger.objectRepository.ContactPage;
import com.vtiger.objectRepository.CreateNewContactPage;
import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.LoginPage;
import com.vtiger.objectRepository.SearchorganizationPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_21_CreateContactTest extends BaseClass{
	@Test
	public  void tC_21_CreateContact() throws InterruptedException, EncryptedDocumentException, IOException
	{
		ExcelUtility excelUtility=new ExcelUtility();
		WebDriverUtility webDriverUtility=new WebDriverUtility();
		String lastname = excelUtility.getDataFromExcel("Contact",4,2)+randomNumber;

		ContactPage contactPage=new ContactPage(driver);
		CreateNewContactPage createNewContactPage=new CreateNewContactPage(driver);
		SearchorganizationPage searchorganizationPage=new SearchorganizationPage(driver);
		homepage.clickOnContactLink(driver);
		contactPage.clickOnCreateContact(driver);
		createNewContactPage.enterLastName(lastname);
		createNewContactPage.clickOnOrgNameImg();
		Thread.sleep(1000);
		webDriverUtility.switchToWindowBasedOnTitle(driver,"Organization");
		String organisationName=searchorganizationPage.getfirstMatchingOrgLink().getText();
		Jutil.printStatement(organisationName);
		createNewContactPage.getcloseBtn().click();
		Thread.sleep(1000);
		webDriverUtility.switchToWindowBasedOnTitle(driver,"Contact");
		createNewContactPage.clickOnClearOrg();
		Thread.sleep(1000);
		createNewContactPage.saveContact();
		String confirmationmessage=createNewContactPage.getConfirmationText().getText();
		Jutil.printStatement(confirmationmessage);
		Jutil.assertionUsingIfContains(confirmationmessage, lastname);
		if(confirmationmessage.contains(lastname))
		{
			Jutil.printStatement("Contact cretaed successfully with correct data");
		}else {
			Jutil.printStatement("Contact is not cretaed with correct data");

		}

	}

}
