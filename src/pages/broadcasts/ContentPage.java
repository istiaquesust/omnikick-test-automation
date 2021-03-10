package pages.broadcasts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.HandleElement;
import utils.HandleElementByJS;

public class ContentPage {
	
	WebDriver driver;
	HandleElement handleElement;
	HandleElementByJS handleElementByJS;
	
	
	public ContentPage(WebDriver driver)
	{
        this.driver = driver;
      	handleElement = new HandleElement(driver);
      	handleElementByJS = new HandleElementByJS(driver);
    }		

	public void verifyContentPage()
	{
		By verify_contents_page_locator = By.xpath("//h1[text()='Contents']");
		handleElement.waitVisibilityOf(verify_contents_page_locator);
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
	
	public void clickChannel() 
	{
		By channel_locator = By.xpath("//*[contains(text(),'Channel')]");
		handleElement.clickOn(channel_locator);
	}
	
	public void addEmailHtmlEditor() 
	{		
		//verify Select channel appearance
		By verify_channel_locator = By.xpath("//h5[text()='Select Channel']");
		handleElement.waitVisibilityOf(verify_channel_locator);
		
		//click on email
		By email_locator = By.xpath("//*[@class=\"channel-selector-body\"]/div/div[1]");
		handleElement.clickOn(email_locator);
		
		
		//verify Select Editor appearance
		By verify_editor_locator = By.xpath("//h5[text()='Select Editor']");
		handleElement.waitVisibilityOf(verify_editor_locator);
		
		//click on HTML editor
		By html_editor_locator = By.xpath("//*[@class=\"channel-selector-body\"]/div/div[2]");
		handleElement.clickOn(html_editor_locator);
		
		//click on confirm button
		By confirm_button_locator = By.xpath("//button[contains(.,'Confirm')]");
		handleElement.clickOn(confirm_button_locator);
		
	}
}
