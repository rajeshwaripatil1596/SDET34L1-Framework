package com.sdet34l1.genericLibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {

		   public Connection connection;
		  public Statement statement;
		 /**
		  * This method is used to open the database connection an initialize the connection and statement
		  * @param dBUrl
		  * @param dBUsername
		  * @param dBPassword
		  * @throws SQLException
		  */
		 public  void openDBConnection(String dBUrl,String dBUsername,String dBPassword) throws SQLException 
		 {
			 Driver driver=new Driver();
			 DriverManager.registerDriver(driver);
			 connection=DriverManager.getConnection(dBUrl, dBUsername, dBPassword);
			 statement=connection.createStatement();
			 	 
		 }
		 /**
		  * This method is used to get the data from Data Base
		  * @param query
		  * @param columnName
		  * @return
		  * @throws SQLException
		  */
		 public  ArrayList<String> getDataFromDataBase(String query,String columnName) throws SQLException
		 {
			 ArrayList<String> list=new ArrayList<>();
			ResultSet result = statement.executeQuery(query);
			 while(result.next())
			 {
				 list.add(result.getString(columnName));
			 }
			 return list;
		 }
		 /**
		  * This method is used to validate the data in the Database
		  * @param query
		  * @param columnName
		  * @param expectedData
		  * @return
		  * @throws SQLException
		  */
        public  boolean validateDataInDataBase(String query,String columnName,String expectedData ) throws SQLException 
		 {
			 ArrayList<String> list = getDataFromDataBase(query, columnName);
			 boolean flag=false;
			 for(String actualData:list)
			 {
				 if(actualData.equalsIgnoreCase(expectedData))
				 {
					 flag=true;
					 break;
				 }
			 }
			 return flag;
			 
		 }
        /**
         * This method is used to set the data i Database
         * @param query
         * @throws SQLException
         */
		public  void setDataInDataBase(String query) throws SQLException
		{
			int result = statement.executeUpdate(query);
			if(result>=1)
			{
				System.out.println("Data entered/modified successfully");
			}
		}
		 /**
		  * This method is used to close the Data base connection
		  */
		public  void closeDBConnection() {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println(e.getMessage());
				System.out.println("while closing the DataBase connection we got exception");
			}
		}
		 
	}


