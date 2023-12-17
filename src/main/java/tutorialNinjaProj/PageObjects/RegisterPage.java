package tutorialNinjaProj.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tutorialNinjaProj.Utils.Utilities;

public class RegisterPage {

	WebDriver driver;
	
	public RegisterPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
//	driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys(Utilities.generateRandomString(6,10));
//	driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys(Utilities.generateRandomString(8,12));
//	driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(Utilities.generateRandomString(6,10)+"@gmail.com");
//	driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys(Utilities.generatePhoneNumber());
//	driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(prop.getProperty("validpassword"));
//	driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys(prop.getProperty("validpassword"));
//	driver.findElement(By.xpath("//input[@name='agree']")).click();
//	driver.findElement(By.xpath("//input[@value='Continue']")).click();
	
//	String errorMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
	
	@FindBy(xpath="//input[@id='input-firstname']")
	private WebElement firstnameField;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	private WebElement lastnameField;
	
	@FindBy(xpath="//input[@id='input-email']")
	private WebElement emailField;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	private WebElement telePhoneField;
	
	@FindBy(xpath="//input[@id='input-password']")
	private WebElement passwordField;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	private WebElement confirmPasswordField;
	
	@FindBy(xpath="//input[@name='agree']")
	private WebElement policyCheckBox;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continueRegisterButton;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement registerErrorMessage;
	
	//String privacyPolicyMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement registerPolicyErrorMessage;
	
	//String firstNameErrorMessage = driver.findElement(By.xpath("(//div[@class='text-danger'])[1]")).getText();
	@FindBy(xpath="(//div[@class='text-danger'])[1]")
	private WebElement registerfirstNameErrorMessage;
	
	//String lastNameErrorMessage = driver.findElement(By.xpath("(//div[@class='text-danger'])[2]")).getText();
	@FindBy(xpath="(//div[@class='text-danger'])[2]")
	private WebElement registerlastNameErrorMessage;
	
	@FindBy(xpath="(//div[@class='text-danger'])[3]")
	private WebElement registeremailErrorMessage;
	
	@FindBy(xpath="(//div[@class='text-danger'])[4]")
	private WebElement registertelePhoneErrorMessage;
	
	@FindBy(xpath="(//div[@class='text-danger'])[5]")
	private WebElement registerpasswordErrorMessage;
	
	
	
	public ConformationPage registerAccountByProvidingCredintils(String RegFirstName,String RegLastName,String RegEmail,String RegTelNo,
			String RegPassword) 
	{
		firstnameField.sendKeys(RegFirstName);
		lastnameField.sendKeys(RegLastName);
		emailField.sendKeys(RegEmail);
		telePhoneField.sendKeys(RegTelNo);
		passwordField.sendKeys(RegPassword);
		confirmPasswordField.sendKeys(RegPassword);
		policyCheckBox.click();
		continueRegisterButton.click();
		ConformationPage conformationPage = new ConformationPage(driver);
		return conformationPage;
		
	}
	
	public String getRegisterErrorMessage() 
	{
		String regErrorMessage= registerErrorMessage.getText();
		return regErrorMessage;
	}
	
	public void clickContinumRegisterButton() 
	{
		continueRegisterButton.click();
	}
	
	public String getRegisterPolicyErrorMessage() 
	{
		String regPolicyErrorMessage= registerPolicyErrorMessage.getText();
		return regPolicyErrorMessage;
	}
	
	public String getRegisterFirstErrorMessage() 
	{
		String regFirstErrorMessage= registerfirstNameErrorMessage.getText();
		return regFirstErrorMessage;
	}
	
	public String getRegisterLastErrorMessage() 
	{
		String regLastErrorMessage= registerlastNameErrorMessage.getText();
		return regLastErrorMessage;
	}
	
	public String getRegisterEmailErrorMessage() 
	{
		String regEmailErrorMessage= registeremailErrorMessage.getText();
		return regEmailErrorMessage;
	}
	
	public String getRegisterTelePhoneErrorMessage() 
	{
		String regTelePhoneErrorMessage= registertelePhoneErrorMessage.getText();
		return regTelePhoneErrorMessage;
	}
	
	public String getRegisterPasswordErrorMessage() 
	{
		String regPasswordErrorMessage= registerpasswordErrorMessage.getText();
		return regPasswordErrorMessage;
	}
}
