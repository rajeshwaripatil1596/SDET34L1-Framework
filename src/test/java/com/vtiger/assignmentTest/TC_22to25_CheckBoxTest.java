package com.vtiger.assignmentTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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

public class TC_22to25_CheckBoxTest extends BaseClass{
@Test
	public  void tC_22to25_CheckBoxTest() throws InterruptedException, EncryptedDocumentException, IOException {
		String lastname = excelUtility.getDataFromExcel("Contact",4,2)+randomNumber;
		ContactPage contactPage=new ContactPage(driver);
		CreateNewContactPage createNewContactPage=new CreateNewContactPage(driver);
		homepage.clickOnContactLink(driver);
		contactPage.clickOnCreateContact(driver);
		createNewContactPage.enterLastName(lastname);
       //verify do not call check box
		if(createNewContactPage.getdonotCallCheckBox().isEnabled())
		{
			Jutil.printStatement("Do not call check box is enabled");
		}else {
			Jutil.printStatement("Do not call check box is not enabled");}
		//verify emailoptout check box
		if(createNewContactPage.getemailoptOutCheckBox().isEnabled())
		{
			Jutil.printStatement("emailoptout check box is enabled");
		}else {
			Jutil.printStatement("emailoptout check box is not enabled");}
		//verify reference check box
		if(createNewContactPage.getReferenceCheckBox().isEnabled())
			{
					Jutil.printStatement("reference check box is enabled");
	}else {
		Jutil.printStatement("reference check box is not enabled");
		}
		//verify notify owner check box
		if(createNewContactPage.getNotifyMeCheckBox().isEnabled())
					{
							Jutil.printStatement("notify owner check box is enabled");
		}else {
				Jutil.printStatement("notify owner check box is not enabled");
				}
				
		createNewContactPage.saveContact();	
		String confirmationmessage = createNewContactPage.getConfirmationText().getText();
		Jutil.printStatement(confirmationmessage);
		
		if(confirmationmessage.contains(lastname))
		{Jutil.printStatement("Contact cretaed successfully with correct data");}else {
			Jutil.printStatement("Contact is not cretaed with correct data");}
			}
}
