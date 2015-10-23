package npr.mail.test;

import org.testng.annotations.Test;

import pageObject.LoginPage;
//import pageObject.MainPage;
import pageObject.MainPage;

public class StartMailTest extends BaseTest {
	
	private String mainUrl = "http://mail.ru";
	private String login = "MailTest1997";
	private String password = "Qwerty123";
	private String domain = "@mail.ru";
	
	private String sendName = login+domain;
	private String theme = "Как дела?";
	private String text = "Скоро буду в городе, встречайте!";


	@Test(priority = 0)
	public void loginTest() {
		LoginPage loginPage = navigate(mainUrl);
		loginPage.setLogin(login);
		loginPage.setPassword(password);
	
		MainPage mainPage = loginPage.clickSubmitBtn();
		mainPage.writeNewMail();
		mainPage.inputSendName(sendName);
		mainPage.inputTheme(theme);
		mainPage.inputText(text);
		mainPage.sendMail();
		mainPage.clicInBox();
		mainPage.isMailSendet(theme);
		mainPage.checkBoxAll();
		mainPage.dellAll();
		
		
		
	
	
	
	
	
	
	
	}
}


//MailTest1997@mail.ru Qwerty123