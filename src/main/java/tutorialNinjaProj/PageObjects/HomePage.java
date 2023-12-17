package tutorialNinjaProj.PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	WebDriver driver;
	
	public HomePage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
//	driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
//	driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();
//	driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
//	driver.findElement(By.xpath("(//a[normalize-space()='Register'])[1]")).click();
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	private WebElement accountButton;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	private WebElement loginButton;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	private WebElement RegisterButton;
	
	@FindBy(xpath="//input[@placeholder='Search']")
	private WebElement SearchField;
	
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
	private WebElement SearchButton;

	
	
	public LoginPage getToLopginPage() 
	{
		accountButton.click();
		loginButton.click();
		LoginPage loginPage = new LoginPage(driver);
		return loginPage;
	}
	
	public RegisterPage getToRegisterPage() 
	{
		accountButton.click();
		RegisterButton.click();
		RegisterPage registerPage = new RegisterPage(driver);
		return registerPage;
	}
	
	public SearchPage searchProduct(String productName) 
	{
		SearchField.sendKeys(productName);
		SearchButton.click();
		SearchPage searchPage = new  SearchPage(driver);
		return searchPage;
	}
	
	public SearchPage clicksearchButton() 
	{
		SearchButton.click();
		SearchPage searchPage = new  SearchPage(driver);
		return searchPage;
	}
}
