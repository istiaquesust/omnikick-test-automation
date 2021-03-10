package pages.broadcasts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.HandleElement;
import utils.HandleElementByJS;

public class RecipientsPage {
	
	WebDriver driver;
	HandleElement handleElement;
	HandleElementByJS handleElementByJS;
	
	
	public RecipientsPage(WebDriver driver)
	{
        this.driver = driver;
      	handleElement = new HandleElement(driver);
      	handleElementByJS = new HandleElementByJS(driver);
    }
	
	public void verifyRecipientsPage()
	{
		By verify_recipients_page_locator = By.xpath("//h1[text()='Recipients']");
		handleElement.waitVisibilityOf(verify_recipients_page_locator);
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
	
	public void clickSaveRecipientsButton() 
	{		
		//scroll to Save Recipients button
		By save_recipients_btn_locator = By.xpath("//*[contains(text(), 'Save Recipients')]");
		handleElementByJS.scrollIntoViewAndClick(save_recipients_btn_locator);
	}

	public void verifyRecipientsSaved()
	{
		By verify_recipients_page_locator = By.xpath("//h2[text()='Subscribers']");
		handleElement.waitVisibilityOf(verify_recipients_page_locator);
	}
}