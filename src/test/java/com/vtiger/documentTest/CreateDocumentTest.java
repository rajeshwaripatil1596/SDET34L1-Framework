package com.vtiger.documentTest;

import java.io.IOException;

import org.openqa.selenium.Keys;
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
import com.vtiger.objectRepository.CreateNewDocument;
import com.vtiger.objectRepository.DocumentsPage;
import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateDocumentTest extends BaseClass {
	@Test(groups="sanity")
	public  void createDocumentTest() throws IOException {

		String title=excelUtility.getDataFromExcel("Document", 2, 4)+randomNumber;
		String path=excelUtility.getDataFromExcel("Document", 2, 5);
		String description=excelUtility.getDataFromExcel("Document", 2, 6);

		DocumentsPage documentsPage=new DocumentsPage(driver);
		CreateNewDocument createNewDocument=new CreateNewDocument(driver);
		homepage.clickOnDocument(driver);
		documentsPage.clickOnCreateDocument();
		createNewDocument.enterTitle(title);
		webDriverUtility.switchToFrame(createNewDocument.getFrameElement(), driver);
		createNewDocument.getFrameBorder().sendKeys(description,webDriverUtility.selectAllusingKeys());				
		driver.switchTo().defaultContent();
		createNewDocument.clickOnBold();
		createNewDocument.clickOnI();
		createNewDocument.getChooseFile().sendKeys(path);
		createNewDocument.clickOnSave();


	}

}
