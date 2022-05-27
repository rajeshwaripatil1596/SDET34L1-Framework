package com.sdet34l1.genericLibrary;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {

		/**
		 * This method is used to open the property file and load the file
		 * @param path
		 * @throws IOException 
		 */
		public Properties property=null;
		public  void openPropertyFile(String filepath) throws IOException
		{
			FileInputStream fis=new FileInputStream(filepath);
			property=new Properties();
			property.load(fis);
		}
		/**
		 * This method is used to fetch data from the property file
		 * @return
		 */
		public  String getDataFromProperty(String key)
		{
			String value=property.getProperty(key);
			return value;
		}

}
