package com.vtiger.organisationTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import com.sdet34l1.genericLibrary.BaseClass;
import com.sdet34l1.genericLibrary.FileUtility;
import com.sdet34l1.genericLibrary.IConstantPath;
import com.sdet34l1.genericLibrary.JavaUtility;
import com.sdet34l1.genericLibrary.WebDriverUtility;
import com.vtiger.objectRepository.CreateNewOrganization;
import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.LoginPage;
import com.vtiger.objectRepository.OrganizationPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationTest extends BaseClass
{
	@Test(groups="sanity")
	public  void createOrganizationTest() throws IOException {

		OrganizationPage  organizationPage=new OrganizationPage(driver);
		CreateNewOrganization createNewOrganization=new CreateNewOrganization(driver);
		String orgname="Abc"+randomNumber;
		homepage.clickOnOrganization(driver);
        organizationPage.clickOnCreateOrganization(driver);
		createNewOrganization.enterAccountNameAndsave(orgname);
		Jutil.assertionUsingEquals(orgname, createNewOrganization.getExpectedOrgaName().getText());

	}
}
