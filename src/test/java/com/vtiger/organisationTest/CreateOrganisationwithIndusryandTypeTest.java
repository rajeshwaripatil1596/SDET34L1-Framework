package com.vtiger.organisationTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
import com.vtiger.objectRepository.CreateNewOrganization;
import com.vtiger.objectRepository.OrganizationPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganisationwithIndusryandTypeTest extends BaseClass{
	@Test(groups="regression")
	public  void createOrganisationwithIndusryandTypeTest() throws IOException 
	{
		String organization_name=excelUtility.getDataFromExcel("Organisation", 4, 1)+randomNumber;
		OrganizationPage  organizationPage=new OrganizationPage(driver);
		CreateNewOrganization createNewOrganization=new CreateNewOrganization(driver);
		if(driver.getCurrentUrl().endsWith("module=Home"))
		{
			excelUtility.setDatatoExcel("Organisation", 4, 18, "Homepage displayed");
			excelUtility.setDatatoExcel("Organisation", 4, 19, "Pass");
		}
		homepage.clickOnOrganization(driver);
		organizationPage.clickOnCreateOrganization(driver);
		createNewOrganization.enterAccountName(organization_name);
		webDriverUtility.initilizeSelectClass(createNewOrganization.getIndustrydropdown());
		webDriverUtility.selectDropdownByValue("Education");
		webDriverUtility.initilizeSelectClass(createNewOrganization.getTypedropdown());
		webDriverUtility.selectDropdownByValue("Press");
		createNewOrganization.clickOnsave();
		String exp_orgname=createNewOrganization.getcreateorganizationconfirmationmsg().getText();
		Jutil.assertionUsingEquals(organization_name, exp_orgname);
		excelUtility.writeDatatoExcel(IConstantPath.EXCELPATH);
	}

}
