package com.sdet34l1.genericLibrary;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.WebElement;

public class JavaUtility {
	/**
	 * This method is used to convert string value to long datatype
	 * @param value
	 * @return
	 */
		public long stringToLong(String value) {
			return Long.parseLong(value);
		}
		/**
		 * This method is used to generate random numbers
		 * @param limit
		 * @return
		 */
		public int getRandomNumber(int limit)
		{
			Random r=new Random();
			return r.nextInt(limit);
		}
		/**
		 * This method is used  to print the message
		 * @param message
		 */
		public void printStatement(String message)
		{
			System.out.println(message);
		}
		/**
		 * This method is used to check the assertion
		 * @param actualResult
		 * @param expectedResult
		 * @param testCase
		 */
		public void assertionUsingIfElse(String actualResult, String expectedResult, String testCase)
		{
			if(actualResult.equalsIgnoreCase(expectedResult))
			{
			System.out.println(testCase+"created successfully");
			System.out.println("Pass");
			}
		}
		public void assertionUsingIfContains(String actualResult,  String contentString)
		{
			if(actualResult.contains(contentString))
			{
				System.out.println("Pass");

			}
		}
		public void assertionUsingEquals(String value, String exp_value)
		{
			if(value.equalsIgnoreCase(exp_value))
			{
			System.out.println("Created successfully");
			}
			else
			{
				System.out.println("Creation failed");
			}
			
		}
		public void customWait(WebElement element,long polingTime,int duration)
		{
			int count=0;
			while(count<=duration)
			{
				try {
					element.click();
					break;
					} catch (Exception e) {
					try {
						Thread.sleep(polingTime);
						count++;
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		
		}
		public  String  dateTimeFormat() {
			return new SimpleDateFormat("yyyy_MM_dd_HH_mm_sss").format(new Date());
		}

	
}
