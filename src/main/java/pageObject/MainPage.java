package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.log4testng.Logger;

public class MainPage {
	
	final static Logger logger = Logger.getLogger(LoginPage.class);

	private WebDriver driver;
	
	
	
	
	
	
	
	public MainPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	
	

}
