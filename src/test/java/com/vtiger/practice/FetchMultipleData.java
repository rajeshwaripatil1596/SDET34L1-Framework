package com.vtiger.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.sdet34l1.genericLibrary.IConstantPath;

public class FetchMultipleData {

	public static void main(String[] args) throws EncryptedDocumentException, IOException
	{
       FileInputStream fis=new FileInputStream(IConstantPath.EXCELPATH);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet("Multipledata");
		Object[][] arr=new Object[sheet.getLastRowNum()+1][sheet.getRow(0).getLastCellNum()];
		for(int i=0; i<=sheet.getLastRowNum(); i++)
		{
			for(int j=0; j<sheet.getRow(i).getLastCellNum(); j++)
			{
				arr[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();
				System.out.print(arr[i][j]);
			}
		System.out.println("");
		}
		
	}

}
