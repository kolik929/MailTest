package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.log4testng.Logger;

public class LoginPage {

	final static Logger logger = Logger.getLogger(LoginPage.class); 

	private WebDriver driver;
	
	@FindBy(how = How.NAME, using="userName")
	private WebElement loginInput;
	
	@FindBy(how = How.NAME, using="password")
	private WebElement passwordInput;
	

	@FindBy(how = How.NAME, using = "login")
	private WebElement submitBtn;
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public LoginPage setLogin(String login) {
		logger.info("В поле User Name вводим "+login);
		loginInput.clear();
		loginInput.sendKeys(login);
		return this;
	}
	
	public LoginPage setPassword(String password) {
		logger.info("В поле Password вводим "+password);
		passwordInput.clear();
		passwordInput.sendKeys(password);
		return this;
	}

//	public MainPage clickSubmitBtn() {
//		logger.info("Нажимаем Sign-In");
//		submitBtn.click();
//		return new MainPage(driver);
//	}	
	
	public LoginPage isNamePagePresented() {
		logger.info("Проверяем что перешли на страницу Welcome: Mercury Tours ");

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.titleContains("Welcome: Mercury Tours"));
	
		Assert.assertEquals(driver.getTitle(), "Welcome: Mercury Tours", "Осуществлен перед на другую страницу");
	
		return this;
		
		}
}
