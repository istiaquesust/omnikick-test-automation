package pages.broadcasts;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.HandleElement;

public class ListPage {

	WebDriver driver;
	File src;
	FileInputStream fis;
	Properties pro;
	HandleElement handleElement;
	
	
	public ListPage(WebDriver driver) throws IOException
	{
        this.driver = driver;
        //Load config.properties file to read data
      	src = new File("./properties/config.properties");
      	fis = new FileInputStream(src);
      	pro = new Properties();
      	pro.load(fis);	
      	
      	handleElement = new HandleElement(driver);
    }
	
	public void naviagteToBroadcast() 
	{
		String broadcastURL = "https://v2.omnikick.com/broadcasts?status=sent";
		driver.navigate().to(broadcastURL);
	}
	
	public void verifyBroadcastPage()
	{
		By verify_broadast_page_locator = By.xpath("//h2[text()='Broadcasts']");
		handleElement.waitVisibilityOf(verify_broadast_page_locator);
	}	

	public void createBroadcast() 
	{				
		//click on "New Broadcast" button
		By new_broadcast_btn_locator = By.cssSelector(".btn-primary");
		handleElement.clickOn(new_broadcast_btn_locator);
		
		//Name the broadcast
		By broadcast_name_input_locator = By.xpath("//form/div/input");
		String broadcastName = pro.getProperty("BROADCAST_NAME");
		handleElement.waitVisibilityAndSendKeysOf(broadcast_name_input_locator, broadcastName);
		
		//click on create button
		By create_btn_locator = By.xpath("//*[contains(text(), 'Create')]");
		handleElement.clickOn(create_btn_locator);	
	}
}
