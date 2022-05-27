package com.sdet34l1.genericLibrary;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	public Workbook book;
	/** 
	 * This method is used to open the excel sheet
	 * @param filePath
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public  void openExcel(String filePath) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(filePath);
		book=WorkbookFactory.create(fis);
	}
	/**
	 * This method is used to fetch the data from excel sheet
	 * @param sheetname
	 * @param rowNumber
	 * @param cellNumber
	 * @return
	 */
	public  String getDataFromExcel(String sheetname, int rowNumber, int cellNumber)
	{
		String data=book.getSheet(sheetname).getRow(rowNumber).getCell(cellNumber).getStringCellValue();
		return data;
	}
	/**
	 * This method is used to fetch multiple data
	 * @param sheetname
	 * @return
	 */
	public  Object[][] getmultipleDataFromExcel(String sheetname)
	{
		Sheet sheet = book.getSheet(sheetname);
		Object[][] arr=new Object[sheet.getLastRowNum()+1][sheet.getRow(0).getLastCellNum()];
		for(int i=0; i<=sheet.getLastRowNum(); i++)
		{
			for(int j=0; j<sheet.getRow(i).getLastCellNum(); j++)
			{
				arr[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();
				
			}
		}
		return arr;
	}


	/**
	 * This method is used to store the data to the excel sheet
	 * @param sheetname
	 * @param rowNumber
	 * @param cellNumber
	 * @param value
	 */
	public  void setDatatoExcel(String sheetname, int rowNumber, int cellNumber, String value)
	{
		book.getSheet(sheetname).getRow(rowNumber).createCell(cellNumber).setCellValue(value);
	}
	public  void writeDatatoExcel(String path) throws IOException
	{
		FileOutputStream fos=new FileOutputStream(path);
		book.write(fos);
	}
	/**
	 * This method is used to close the excel sheet
	 * @throws IOException
	 */
	public  void closeExcel() throws IOException
	{
		book.close();
	}


}
