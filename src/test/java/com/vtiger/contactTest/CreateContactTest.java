package com.vtiger.contactTest;

import java.io.IOException;

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

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

public class CreateContactTest extends BaseClass {
@Test(groups="sanity")
@Description("Description:- CreateContactTest")
@Epic("Epic:- CreateContactTest")
@Story("Story:- CreateContactTest")
@Step("Step:- CreateContactTest")
@Severity(SeverityLevel.BLOCKER)
public void createContactTest() throws IOException, InterruptedException {
	String last_name=excelUtility.getDataFromExcel("Contact", 2, 1)+randomNumber;
	
	ContactPage contactPage=new ContactPage(driver);
    CreateNewContactPage createNewContactPage=new CreateNewContactPage(driver);
    
    homepage.clickOnContactLink(driver);
	contactPage.clickOnCreateContact(driver);
	createNewContactPage.enterLastName(last_name);
	createNewContactPage.saveContact();
	Jutil.printStatement(driver.getTitle());
		
	if(last_name.equals(createNewContactPage.getexpectedContactName().getText()))
	{
		Jutil.printStatement("Contact Created Successfully");
			}
	else
	{
		Jutil.printStatement("Contact Creation Failed");
	}
	
}

}
