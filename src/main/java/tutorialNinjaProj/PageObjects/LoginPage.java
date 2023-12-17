package tutorialNinjaProj.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
//	driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(email);
//	driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(password);
//	driver.findElement(By.xpath("//input[@value='Login']")).click();
//	String alertMessage = driver.findElement(By.cssSelector(".alert-dismissible")).getText();

	
	@FindBy(xpath="//input[@id='input-email']")
	private WebElement emailField;
	
	@FindBy(xpath="//input[@id='input-password']")
	private WebElement passwordFiled;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement accountLoginButton;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement alertMessage;
	
	
	
	public AccountPage provideCredintilsAndloginToAccount(String emailText,String passwordText) 
	{
		emailField.sendKeys(emailText);
		passwordFiled.sendKeys(passwordText);
		accountLoginButton.click();
		AccountPage accountPage = new AccountPage(driver);
		return accountPage;
	}
	
	public String getAllertMessage() 
	{
		String errorallertMessage = alertMessage.getText();
		return errorallertMessage;

	}
	
	public void clickactualLoginButton() 
	{
		accountLoginButton.click();
	}
	
	
	
	
}
