package com.vtiger.practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sdet34l1.genericLibrary.ExcelUtility;
import com.sdet34l1.genericLibrary.FileUtility;
import com.sdet34l1.genericLibrary.IConstantPath;
import com.sdet34l1.genericLibrary.WebDriverUtility;

public class TestNGPractice  
{
	@Test(dataProvider="fetchMultipleData")
	public void testNGPractice(String username, String password)
	{
		Reporter.log(username+"  "+password,true);
	}

	@DataProvider
	public Object[][] fetchMultipleData() throws EncryptedDocumentException, IOException
	{
		ExcelUtility excelUtility=new ExcelUtility();
		
		excelUtility.openExcel(IConstantPath.EXCELPATH);
		return excelUtility.getmultipleDataFromExcel("Multipledata");
	}
	
//@DataProvider
//public Object[][] dataProvider()
//{
//	Object[][] data=new Object[4][2];
//	data[0][0]="username";
//	data[0][1]="password";
//	
//	data[1][0]="username1";
//	data[1][1]="password1";
//
//	data[2][0]="username2";
//	data[2][1]="password2";
//
//	data[3][0]="username3";
//	data[3][1]="password3";
//
//	return data;
//}



}
