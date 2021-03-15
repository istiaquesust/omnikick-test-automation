package pages.broadcasts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.HandleElement;

public class HtmlEditorPage {
	
	WebDriver driver;
	HandleElement handleElement;
	//HandleElementByJS handleElementByJS;
	
	
	public HtmlEditorPage(WebDriver driver)
	{
        this.driver = driver;
      	handleElement = new HandleElement(driver);
      	//handleElementByJS = new HandleElementByJS(driver);
    }		

	public void verifyHtmlEditorPage()
	{
		By verify_html_editor_page_locator = By.xpath("//h1[text()='Email Editor']");
		handleElement.waitVisibilityOf(verify_html_editor_page_locator);
	}
	
	public void setEmailSubject(String email_subject)
	{
		By email_subject_locator = By.className("form-control");
		handleElement.sendKeysOn(email_subject_locator, email_subject);
	}
	
	public void setEmailBody(String email_body)
	{
		By email_subject_locator = By.xpath("//form/div/div[2]/div/div/div[2]/div/p");
		handleElement.sendKeysOn(email_subject_locator, email_body);
	}
	
	public void clickSave()
	{
		By save_button_locator = By.xpath("//button[contains(.,'Save')]");
		handleElement.clickOn(save_button_locator);
	}
	
	public void verifySave()
	{
		By verify_save_locator = By.xpath("//div[contains(.,'Successfully saved!')]");
		handleElement.waitVisibilityOf(verify_save_locator);
	}
	
	
}


