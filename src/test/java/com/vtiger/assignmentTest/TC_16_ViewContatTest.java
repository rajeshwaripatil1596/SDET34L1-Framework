package com.vtiger.assignmentTest;

import java.io.IOException;
import java.util.List;

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

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_16_ViewContatTest extends BaseClass {
	@Test
	public  void tC_16_ViewContatTest() throws IOException {

		ContactPage contactPage=new ContactPage(driver);
		homepage.clickOnContactLink(driver);
		contactPage.clickOnLastViewedIcon();
		for(WebElement element:contactPage.getLastViewedContacts())
		{System.out.println(element.getText());}
		contactPage.clickOnCloseLastViewedListIcon();
	}
}
