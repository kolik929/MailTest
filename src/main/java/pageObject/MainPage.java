package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.log4testng.Logger;

public class MainPage {
	
	final static Logger logger = Logger.getLogger(LoginPage.class);

	private WebDriver driver;
	
	@FindBy(how = How.XPATH, using=".//*[@id='b-toolbar__left']//span")
	private WebElement writeNewMail;
	
	@FindBy(how = How.XPATH, using=".//*[@id='compose__header__content']//textarea[2]")
	private WebElement inputSendName;
	
	
	//.//*[@class='compose__header__field'][@name='Subject']
	@FindBy(how = How.XPATH, using=".//*[@class='compose__header__field']")
	private WebElement inputThemе;
	
	@FindBy(how = How.XPATH, using=".//body")
	private WebElement inputText;
	
	@FindBy(how = How.XPATH, using=".//*[@id='b-toolbar__right']/div/div/div[2]/div[1]/div/span")
	private WebElement btnSendMail;
	
	@FindBy(how = How.XPATH, using=".//*[@id='b-nav_folders']//span[contains(.,'Входящие')]")
	private WebElement btnInBox;
	
	@FindBy(how = How.CSS, using=".b-datalist__item__addr:contains('Test Test')")
	private WebElement inBoxTheme;
	
	@FindBy(how = How.CSS, using="div.b-dropdown.b-dropdown_selectAll > div.b-dropdown__ctrl")
	private WebElement checkBoxAllMail;
	@FindBy(how = How.XPATH, using="//div[@id='b-toolbar__right']//a/span[contains(.,'Выделить')]")
	private WebElement checkBoxAllMail2;
	
	
	@FindBy(how = How.XPATH, using=".//*[@id='b-toolbar__right']//span[contains(.,'Удалить')][1]")
	private WebElement dellAll;
	
	public MainPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	
	public MainPage writeNewMail(){
		logger.info("Нажимаем кнопку новое письмо ");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(writeNewMail));
		writeNewMail.click();
		return this;
	}
	
	public MainPage inputSendName(String sendName){
		logger.info("Вводим получателя ");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(writeNewMail));
		inputSendName.clear();
		inputSendName.sendKeys(sendName);
		return this;
		
	}
	
	
	public MainPage inputTheme(String theme){
		logger.info("Вводим тему ");
		inputThemе.clear();
		inputThemе.sendKeys(theme);
		return this;
		
	}
	
	public MainPage inputText(String text){
		logger.info("Вводим текст ");
		driver.switchTo().frame((WebElement) driver.findElement(By.xpath(".//iframe[contains(@id,'compose')]")));

		logger.info("Переключились между фреймами ");
		inputText.clear();
		inputText.sendKeys(text);
		
		driver.switchTo().defaultContent();
		return this;
		
	}
	
	public MainPage sendMail(){
		logger.info("Кликаем отправить ");
		btnSendMail.click();
		return this;
	}
	
	public MainPage clicInBox(){
		logger.info("Переходим во вкладку входящие ");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(btnInBox));
		btnInBox.click();
		return this;
	}
	
	
	
	
	public MainPage isMailSendet(String text){
		
		logger.info("Проверяем наличие писма ");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(inBoxTheme));
		if (inBoxTheme.getText().contains(text)){
		System.out.println("Письмо пришло");	
		}else{
			System.out.println("Письмо не пришло!");
		}
		
		return this;
	}
	
	
	public MainPage checkBoxAll(){
		logger.info("Отмечаем чек боксами все письма ");
//		WebDriverWait wait = 
				new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.elementToBeClickable(checkBoxAllMail));
//		new Select(checkBoxAllMail).selectByVisibleText("Выделить все письма");
		logger.info("Пытаемся раскрыть выпадающий список ");		
		checkBoxAllMail.click();
		logger.info("Пытаемся выбрать элемент выпадающего списка");	
		new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.elementToBeClickable(checkBoxAllMail2));
		try {
		checkBoxAllMail2.click();
			}catch(org.openqa.selenium.StaleElementReferenceException e){
		
			}
		
				
//		if (checkBoxAllMail.isSelected()){
//			System.out.println("все отмечено");;
//		}else {
//			checkBoxAll();
//		}
		
		
		return this;
	}
	
	
	public MainPage dellAll(){
		logger.info("Удаляем выбранные письма ");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(dellAll));
		dellAll.click();
		return this;
	}

}
