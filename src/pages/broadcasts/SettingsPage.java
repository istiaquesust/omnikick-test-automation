package pages.broadcasts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.HandleElement;
import utils.HandleElementByJS;

public class SettingsPage {
	
	WebDriver driver;
	HandleElement handleElement;
	HandleElementByJS handleElementByJS;
	
	
	public SettingsPage(WebDriver driver)
	{
        this.driver = driver;
      	handleElement = new HandleElement(driver);
      	handleElementByJS = new HandleElementByJS(driver);
    }		

	public void verifyPage()
	{
		By verify_html_editor_page_locator = By.xpath("//h1[text()='Settings']");
		handleElement.waitVisibilityOf(verify_html_editor_page_locator);
	}
	
	public void goToRecipientsPage() 
	{
		By recipients_locator = By.linkText("RECIPIENTS");
		handleElementByJS.scrollAndClick(recipients_locator);
	}
	
	public void goToContentPage() 
	{
		By content_locator = By.linkText("CONTENT");
		handleElementByJS.scrollAndClick(content_locator);
	}
	
	public void goToSettingsPage() 
	{
		By recipients_locator = By.linkText("SETTINGS");
		handleElementByJS.scrollAndClick(recipients_locator);
	}	
	
	public void clickScheduleMessagestoSend() 
	{
		By schedule_messages_to_send_locator = By.xpath("//button[contains(.,'Schedule Messages to Send…')]");
		handleElement.clickOn(schedule_messages_to_send_locator);
	}
	
	public void sendImmediately() 
	{
		//verify pop-up appearance
		By verify_delivery_settings_locator = By.xpath("//h5[text()='Delivery Settings']");
		handleElement.waitVisibilityOf(verify_delivery_settings_locator);
		
		//click on send
		By send_broadcast_locator = By.xpath("//button[contains(.,'Send Broadcast')]");
		handleElement.clickOn(send_broadcast_locator);
		
	}


}
