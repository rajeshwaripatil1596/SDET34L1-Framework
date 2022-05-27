package com.vtiger.practice;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

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

public class CreateDocumentTest {

	public static void main(String[] args) throws IOException {
				JavaUtility jl=new JavaUtility();
				FileUtility fileUtility=new FileUtility();
				ExcelUtility excelUtility=new ExcelUtility();
				WebDriverUtility webDriverUtility=new WebDriverUtility();
				
				fileUtility.openPropertyFile(IConstantPath.PROPERTYPATH);
				Long longTimeOut=jl.stringToLong(fileUtility.getDataFromProperty("timeout"));
				
				excelUtility.openExcel(IConstantPath.EXCELPATH);
				String title=excelUtility.getDataFromExcel("Document", 2, 4)+jl.getRandomNumber(1000);
				String path=excelUtility.getDataFromExcel("Document", 2, 5);
				String description=excelUtility.getDataFromExcel("Document", 2, 6);
				excelUtility.closeExcel();

				WebDriver driver=null;
				switch(fileUtility.getDataFromProperty("browser"))
				{
					case "chrome":
						WebDriverManager.chromedriver().setup();
						driver=new ChromeDriver();
						break;
					case "edge":
						WebDriverManager.edgedriver().setup();
						driver=new EdgeDriver();
						break;
				}
				String url = fileUtility.getDataFromProperty("url");

				webDriverUtility.navigateApp(driver,url);
				webDriverUtility.browserSetting(longTimeOut, driver);
				LoginPage loginpage=new LoginPage(driver);
				HomePage homePage=new HomePage(driver);
				DocumentsPage documentsPage=new DocumentsPage(driver);
				CreateNewDocument createNewDocument=new CreateNewDocument(driver);
				loginpage.loginAction(fileUtility.getDataFromProperty("username"), fileUtility.getDataFromProperty("password"));
				homePage.clickOnDocument(driver);
				documentsPage.clickOnCreateDocument();
				createNewDocument.enterTitle(title);
				webDriverUtility.switchToFrame(createNewDocument.getFrameElement(), driver);
				createNewDocument.getFrameBorder().sendKeys(description,Keys.CONTROL+"a");				
				//WebDriverUtility.switchToMainFrame(driver);
				driver.switchTo().defaultContent();
				createNewDocument.clickOnBold();
				createNewDocument.clickOnI();
				createNewDocument.getChooseFile().sendKeys(path);
				createNewDocument.clickOnSave();
				//String exp_title=driver.findElement(By.xpath("//span[@id='dtlview_Title']")).getText();
				//jl.assertionUsingEquals(title, exp_title);
				homePage.signout(driver);
                webDriverUtility.quit(driver);

                
	}

}
