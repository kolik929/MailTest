package npr.mail.test;

import org.testng.annotations.Test;

import pageObject.LoginPage;
//import pageObject.MainPage;
import pageObject.MainPage;
import parser.PropertiesLoader;

public class StartMailTest extends BaseTest {
	

	


	@Test(priority = 0)
	public void loginTest() {
		PropertiesLoader p = new PropertiesLoader();
		
		LoginPage loginPage = navigate(p.getProperty("mainUrl"));
		loginPage.setLogin(p.getProperty("login"));
		loginPage.setPassword(p.getProperty("password"));
	
		MainPage mainPage = loginPage.clickSubmitBtn();
		mainPage.writeNewMail();
		mainPage.inputSendName(p.getProperty("sendName"));
		mainPage.inputTheme(p.getProperty("theme"));
		mainPage.inputText(p.getProperty("text"));
		mainPage.sendMail();
		mainPage.clicInBox();
		mainPage.openNewLetter();
		mainPage.checkText(p.getProperty("text"));
		mainPage.clicInBox();
		
	
		mainPage.checkBoxAll();
		mainPage.dellAll();
		
		
		
	
	
	
	
	
	
	
	}
}


//MailTest1997@mail.ru Qwerty123