package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HandleElementByJS {
	WebDriver driver;
	WebElement we;
	
	public HandleElementByJS(WebDriver driver)
	{
        this.driver = driver;
    }
	
	public void scrollIntoViewAndClick(By locator) 
	{
		try 
		{
			JavascriptExecutor je = (JavascriptExecutor) driver;
			WebElement we = driver.findElement(locator);
			je.executeScript("arguments[0].scrollIntoView(true);", we);
			we.click();
		}
		catch(NoSuchElementException e) 
		{
			System.out.println("Element not found : " + e);
		}
	}
	
	public void scrollAndClick(By locator) 
	{
		try 
		{
			JavascriptExecutor je = (JavascriptExecutor) driver;
			WebElement we = driver.findElement(locator);
			je.executeScript("arguments[0].click();", we);
		}
		catch(NoSuchElementException e) 
		{
			System.out.println("Element not found : " + e);
		}
		
	}
}
