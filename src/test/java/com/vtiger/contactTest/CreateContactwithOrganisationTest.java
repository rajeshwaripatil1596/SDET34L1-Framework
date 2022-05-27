package com.vtiger.contactTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.sdet34l1.genericLibrary.BaseClass;
import com.sdet34l1.genericLibrary.ExcelUtility;
import com.sdet34l1.genericLibrary.FileUtility;
import com.sdet34l1.genericLibrary.IConstantPath;
import com.sdet34l1.genericLibrary.JavaUtility;
import com.sdet34l1.genericLibrary.WebDriverUtility;
import com.vtiger.objectRepository.ContactPage;
import com.vtiger.objectRepository.CreateNewContactPage;
import com.vtiger.objectRepository.CreateNewOrganization;
import com.vtiger.objectRepository.OrganizationPage;
import com.vtiger.objectRepository.SearchorganizationPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactwithOrganisationTest extends BaseClass {
	@Test(groups="regression")
	public  void createContactwithOrganisationTest() throws EncryptedDocumentException, IOException, InterruptedException {

		String lastname = excelUtility.getDataFromExcel("Contact",4,2)+randomNumber;
		String organisationName = excelUtility.getDataFromExcel("Organisation",4,1)+randomNumber;
		OrganizationPage organizationPage=new OrganizationPage(driver);
		CreateNewOrganization createNewOrganization=new CreateNewOrganization(driver);
		ContactPage contactPage=new ContactPage(driver);
		CreateNewContactPage createNewContact=new CreateNewContactPage(driver);
		SearchorganizationPage searchOrganizationPage=new SearchorganizationPage(driver);
		
		homepage.clickOnOrganization(driver);
		organizationPage.clickOnCreateOrganization(driver);
		createNewOrganization.enterAccountNameAndsave(organisationName);
		
		webDriverUtility.explicitWaitUsingVisibleText(driver, longTimeOut, createNewOrganization.getExpectedOrgaName());	
		homepage.clickOnContactLink(driver);
		contactPage.clickOnCreateContact(driver);
		
		createNewContact.enterLastName(lastname);
		createNewContact.clickOnOrgNameImg();
		searchOrganizationPage.SelectOrganization(driver, organisationName);
		webDriverUtility.switchToWindowBasedOnTitle(driver,"Contact");
		createNewContact.saveContact();
		Jutil.printStatement(createNewContact.getexpectedOrganization().getText());

	}

}
