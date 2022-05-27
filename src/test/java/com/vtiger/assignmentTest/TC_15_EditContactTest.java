package com.vtiger.assignmentTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import com.sdet34l1.genericLibrary.BaseClass;
import com.sdet34l1.genericLibrary.FileUtility;
import com.sdet34l1.genericLibrary.IConstantPath;
import com.sdet34l1.genericLibrary.JavaUtility;
import com.sdet34l1.genericLibrary.WebDriverUtility;
import com.vtiger.objectRepository.ContactPage;
import com.vtiger.objectRepository.CreateNewContactPage;
import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_15_EditContactTest extends BaseClass {
	@Test
	public  void TC_15_Edit_ContactTest() throws IOException, InterruptedException {

		ContactPage contactPage=new ContactPage(driver);
		CreateNewContactPage createNewContactPage=new CreateNewContactPage(driver);
		homepage.clickOnContactLink(driver);
		 String contactName =contactPage.getFirstContact().getText();
		 contactPage.getFirstContact().click();
		contactPage.clickOnEditBtn();
		Jutil.printStatement(contactPage.getEditcontactInfoDisplydMsg().getText());
		createNewContactPage.getLastName().clear();
		Thread.sleep(2000);
		createNewContactPage.enterLastName("Raana"+randomNumber);
		createNewContactPage.saveContact();
		homepage.clickOnContactLink(driver);
		for(WebElement element:contactPage.getContactList())
		{Jutil.printStatement(element.getText());
		
		if(element.getText().equals(contactPage.getUpdatedName().getText()))
		{
			System.out.println("edit information updated successfully");

		}
		}
	}

}
