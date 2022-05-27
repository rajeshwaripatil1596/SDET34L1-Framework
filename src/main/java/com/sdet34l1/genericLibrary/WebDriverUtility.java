package com.sdet34l1.genericLibrary;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	public WebDriverWait wait;
	public JavascriptExecutor jse;
	public JavaUtility javaUtility;
	FileUtility fileUtility=new FileUtility();
	public Actions act;
	public  Select select;
	/**
	 * This method is used to navigate the application
	 * @param driver
	 * @param url
	 */
	public  void navigateApp(WebDriver driver,String url)
	{
		driver.get(url);
	}
	/**
	 * This method is used to maximize the browser
	 * @param driver
	 */
	public  void maximizeBrowser(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 * This method is used to implicit wait till page load
	 * @param longTimeOut
	 * @param driver
	 */
	public  void waitTillPageLoad(long longTimeOut,WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(longTimeOut,TimeUnit.SECONDS);
	}
	/**
	 * This method is used to maximize the browser and implicit wait
	 * @param longTimeOut
	 * @param driver
	 */
	public  void browserSetting(long longTimeOut,WebDriver driver)
	{
		maximizeBrowser(driver);
		waitTillPageLoad(longTimeOut,driver);
	}
	/**
	 * This method is used to initilize the actions class
	 * @param driver
	 */
	public  void initilizeActions(WebDriver driver)
	{
		act=new Actions(driver);
	}
	/**
	 * This method is used to mouse hover element
	 * @param driver
	 * @param wb
	 */
	public  void mouseHoverOnTheElement(WebElement wb, WebDriver driver)
	{
		act=new Actions(driver);
		act.moveToElement(wb).perform();
	}
	/**
	 * This method is used to double click on webpage
	 * @param driver
	 */
	public  void doubleClick(WebDriver driver) 
	{
		act=new Actions(driver);
		act.doubleClick().perform();
	}
	/**
	 * This method is used to double click on Webelement
	 * @param driver
	 * @param element
	 */
	public  void doubleClick(WebDriver driver,WebElement element) 
	{
		act=new Actions(driver);

		act.doubleClick(element).perform();
	}


	/**
	 * This method is used to quit the browser
	 * @param driver
	 */
	public  void quit(WebDriver driver)
	{
		driver.quit();
	}
	/**
	 * 
	 * @param driver
	 * @param timeOut
	 */
	public  void explicitWait(WebDriver driver,long timeOut) 
	{
		wait=new WebDriverWait(driver,timeOut);
	}
	/**
	 * This method is used to web driver wait
	 * @param driver
	 * @param timeOut
	 */
	public  void explicitWaitUsingVisibleText(WebDriver driver,long timeOut,WebElement element) 
	{
		wait=new WebDriverWait(driver,timeOut);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * WaitUntillElementClickable
	 * @param driver
	 * @param timeOut
	 * @param element
	 */
	public  void WaitUntillElementClickable(WebDriver driver,long timeOut,WebElement element) 
	{
		wait=new WebDriverWait(driver,timeOut);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * This method is used to switch window the window based on title
	 * @param driver
	 * @param current_id
	 * @param partialText
	 */
	public  void switchToWindowBasedOnTitle(WebDriver driver,String partialText)
	{
		Set<String> allid=driver.getWindowHandles();
		for(String id:allid)
		{
			driver.switchTo().window(id);
			if(driver.getTitle().contains(partialText))
			{
				break;
			}
		}
	}
	public  void switchToChildWindowBasedOnTitle(WebDriver driver,String partialText)
	{
		Set<String> allid=driver.getWindowHandles();
		Iterator<String> it = allid.iterator();
		while(it.hasNext())
		{
			String wID = it.next();
			driver.switchTo().window(wID);
			String currentWindowTitle = driver.getTitle();
			if(driver.getTitle().contains(partialText))
			{
				break;
			}

		}	
	}

	/**
	 * This method is used to switch to the frame using element address
	 * @param wb
	 * @param driver
	 */
	public  void switchToFrame(WebElement wb, WebDriver driver)
	{
		driver.switchTo().frame(wb);
	}
	/**
	 * This method is used to switch to the frame using index
	 * @param index
	 * @param driver
	 */
	public  void switchToFrame(int index, WebDriver driver)
	{
		driver.switchTo().frame(index);
	}
	/**
	 * 
	 * @param nameOrId
	 * @param driver
	 */
	public  void switchToFrame(String nameOrId, WebDriver driver)
	{
		driver.switchTo().frame(nameOrId);
	}

	/**
	 * This method is used to switch to main frame
	 * @param driver
	 */
	public  void switchToMainFrame(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	/**
	 * This method is used to switch to parent frame
	 * @param driver
	 */
	public  void switchToParentFrame(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}
	/**
	 * This method is used to initilize the select class object
	 * @param element
	 */
	public  void initilizeSelectClass(WebElement element)
	{
		select=new Select(element);
	}
	/**
	 * This method is used to select value from dropdown using value
	 * @param element
	 * @param value
	 */
	public  void selectDropdownByValue(String value)
	{
		select.selectByValue(value);
	}
	/**
	 * This method is used to select value from dropdown using index
	 * @param index
	 */
	public  void selectDropdownByIndex(int index)
	{
		select.selectByIndex(index);
	}
	/**
	 * This method is used to select value from dropdown using visible text
	 * @param value
	 */
	public  void selectDropdownByVisibleText(String value)
	{
		select.selectByVisibleText(value);
	}
	/**
	 * This method is used to switch and accept alert
	 * @param driver
	 */
	public  void alertAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	/**
	 * This method is used to switch and dismiss alert
	 * @param driver
	 */
	public  void alertDismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	/**
	 * This method is used to switch to alert and get text
	 * @param driver
	 * @return
	 */
	public  String getalertText(WebDriver driver)
	{
		return  driver.switchTo().alert().getText();
	}
	/**
	 * 
	 * @param driver
	 * @param data
	 */
	public  void alertSendData(WebDriver driver,String data)
	{
		driver.switchTo().alert().sendKeys(data);
	}
	/**
	 * 
	 * @param driver
	 */
	public  void initializeJS(WebDriver driver) {
		jse=(JavascriptExecutor)driver;
	}
	/**
	 * 
	 * @param element
	 * @param data
	 */
	public  void enterDatathroughJS(WebElement element,String data)
	{
		jse.executeScript("arguments[0].value=arguments[1]", element, data);
	}
	/**
	 * 
	 * @param element
	 */
	public  void clickThroughJS(WebElement element)
	{
		jse.executeScript("arguments[0].click()", element);
	}
	/**
	 * 
	 * @param url
	 */
	public  void navigateApplicatonthroughJS(String url)
	{
		jse.executeScript("window.location=arguments[0]", url);
	}
	/**
	 * 
	 * @param height
	 */
	public  void scrollToSpecifiedHeight(String height)
	{
		jse.executeScript("window.scrollBy(0,"+height+")");
	}
	/**
	 * 
	 */
	public  void scrollToBottom()
	{
		jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	/**
	 * 
	 * @param element
	 */
	public  void scrolTillElement(WebElement element)
	{
		jse.executeScript("arguments[0].scrollIntoView()",element);
	}
	/**
	 * 
	 * @param driver
	 * @param filename
	 * @return 
	 * @throws IOException
	 */
	public  String takeScreenShot(WebDriver driver, String filename ) throws IOException {
		javaUtility=new JavaUtility();
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		new File("./screenshots"+".png");
		File dst = new File("./screenshot/"+filename+"_"+javaUtility.dateTimeFormat()+".png");
		FileUtils.copyFile(src, dst);
		return dst.getAbsolutePath();

	}
	public  String selectAllusingKeys()
	{
		return Keys.CONTROL+"a";
	}


}
