package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.log4testng.Logger;

public class MainPage {
	
	final static Logger logger = Logger.getLogger(LoginPage.class);

	private WebDriver driver;
	
	@FindBy(how = How.CLASS_NAME, using="b-toolbar__btn__text b-toolbar__btn__text_pad")
	private WebElement writeNewMail;
	
	@FindBy(how = How.CLASS_NAME, using="js-input compose__labels__input")
	private WebElement inputSendName;
	
	@FindBy(how = How.CLASS_NAME, using="compose__header__field")
	private WebElement inputThemе;
	
	@FindBy(how = How.ID, using="tinymce")
	private WebElement inputText;
	
	@FindBy(how = How.CLASS_NAME, using="b-toolbar__btn__text")
	private WebElement btnSendMail;
	
	
	
	
	public MainPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	
	public MainPage writeNewMail(){
		writeNewMail.click();
		return this;
	}
	
	public MainPage inputSendName(String sendName){
		inputSendName.clear();
		inputSendName.sendKeys(sendName);
		return this;
		
	}
	
	
	public MainPage inputTheme(String theme){
		inputThemе.clear();
		inputThemе.sendKeys(theme);
		return this;
		
	}
	
	public MainPage inputText(String text){
		inputText.clear();
		inputText.sendKeys(text);
		return this;
		
	}
	
	
	

}
