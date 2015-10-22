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
	

	@Test(priority = 0)
	public void loginTest() {
		LoginPage loginPage = navigate(mainUrl);
		loginPage.setLogin(login);
		loginPage.setPassword(password);
	
		MainPage mainPage = loginPage.clickSubmitBtn();
		
	
	
	
	
	
	
	
	}
}


//MailTest1997@mail.ru Qwerty123