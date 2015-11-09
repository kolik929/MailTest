package npr.mail.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import pageObject.LoginPage;

public class BaseTest {

	 protected WebDriver driver;
	
	
	@BeforeTest
	public void startBrowser() {
		System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
		this.driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@AfterTest(alwaysRun = true)
	public void closeBrowser() {
		try{
			Thread.sleep(5000);
		} catch (InterruptedException e) {}
		driver.quit();
	}
	
	public LoginPage navigate(String url) {
		driver.get(url);
		return new LoginPage(driver);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
