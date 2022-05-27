package com.vtiger.assignmentTest;

import java.io.IOException;
import java.util.ArrayList;
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
import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_17_ViewCntactTest extends BaseClass {
@Test 
	public  void tC_17_ViewCntactTest() throws IOException {

		ContactPage contactPage=new ContactPage(driver);
		homepage.clickOnContactLink(driver);
		String contactName = driver.findElement(By.xpath("//a[text()=\"Rana212\"]")).getText();
		driver.findElement(By.xpath("//a[text()=\"Rana212\"]")).click();
		System.out.println(contactPage.getContactInfoDisplydMsg().isDisplayed());
		contactPage.clickOnDuplicateBtn();
		contactPage.clickOnSaveBtn();
		homepage.clickOnContactLink(driver);
		ArrayList<String> list=new ArrayList<String>();
		int count=0;
        for(WebElement element:contactPage.getContactList())
		{
			list.add(element.getText());
			Jutil.printStatement(element.getText());
		}
		System.out.println(list.size());
		if(list.contains(contactName))
		{
			count++;
			System.out.println("Same name is displayed in contact page");
		}else {
			System.out.println("Same name is  not displayed in contact page");

		}
		if(count>1)
		{
			System.out.println("Duplicated");

		}

		}

}
