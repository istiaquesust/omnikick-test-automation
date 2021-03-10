package _test_cases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import pages._signin_signup.SigninPage;
import pages.broadcasts.ListPage;
import pages.broadcasts.ContentPage;
import pages.broadcasts.HtmlEditorPage;
import pages.broadcasts.RecipientsPage;
import pages.broadcasts.SettingsPage;
import pages.summary.SummaryPage;
import setup.DriverSetup;

public class SendBroadcastTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		//Load config.properties file to read data
		File src = new File("./properties/config.properties");
		FileInputStream fis = new FileInputStream(src);
		Properties pro = new Properties();
		pro.load(fis);	
		
		//Driver Setup
		DriverSetup setup = new DriverSetup();
		WebDriver driver = setup.initDriver(pro.getProperty("BROWSER_NAME"));		
		
		//Signin
		SigninPage signin = new SigninPage(driver);
		signin.verifySigninPage();
		signin.setUserName(pro.getProperty("USER_NAME"));
		signin.setPassword(pro.getProperty("PASSWORD"));
		signin.clickSigninButton();
		
		//verify login
		SummaryPage summary = new SummaryPage(driver);
		summary.verifySummaryPage();
		
		ListPage broadcastList = new ListPage(driver);
		broadcastList.naviagteToBroadcast();
		broadcastList.verifyBroadcastPage();
		broadcastList.createBroadcast();
		
		//set Recipients
		RecipientsPage recipients = new RecipientsPage(driver);
		recipients.verifyRecipientsPage();
		recipients.clickSaveRecipientsButton();
		recipients.verifyRecipientsSaved();
		
		//content
		recipients.goToContentPage();
		ContentPage content = new ContentPage(driver);
		content.verifyContentPage();
		content.clickChannel();
		content.addEmailHtmlEditor();
		
		//configure broadcast email
		HtmlEditorPage htmlEditor = new HtmlEditorPage(driver);
		htmlEditor.verifyHtmlEditorPage();
		htmlEditor.setEmailSubject(pro.getProperty("BROADCAST_EMAIL_SUBJECT"));
		htmlEditor.setEmailBody(pro.getProperty("BROADCAST_EMAIL_BODY"));
		htmlEditor.clickSave();
		htmlEditor.verifySave();
		
		//send broadcast
		content.goToSettingsPage();
		SettingsPage broadcastSettings = new SettingsPage(driver);
		broadcastSettings.verifyPage();
		broadcastSettings.clickScheduleMessagestoSend();
		broadcastSettings.sendImmediately();

		//driver.quit();
	}

}
