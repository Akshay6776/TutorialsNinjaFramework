package tutorialNinjaProj.Tests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import tutorialNinjaProj.Baseclass.BaseClass;
import tutorialNinjaProj.PageObjects.ConformationPage;
import tutorialNinjaProj.PageObjects.HomePage;
import tutorialNinjaProj.PageObjects.RegisterPage;
import tutorialNinjaProj.Utils.Utilities;

public class RegisterAccountTest extends BaseClass{
	
	public RegisterAccountTest() throws IOException 
	{
		super();
	}
	
	public WebDriver driver;
	RegisterPage registerPage;
	
	@BeforeMethod
	public void setUp() 
	{
		driver = initilizeBrowserAndLaunchApplication();
//		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
//		driver.findElement(By.xpath("(//a[normalize-space()='Register'])[1]")).click();
		HomePage homePage = new HomePage(driver);
		registerPage = homePage.getToRegisterPage();
	}
	
		
	@Test(priority=1)
	public void verifyRegisteringAccountWithMandatoryFields() throws InterruptedException 
	{
//		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys(Utilities.generateRandomString(6,10));
//		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys(Utilities.generateRandomString(8,12));
//		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(Utilities.generateRandomString(6,10)+"@gmail.com");
//		driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys(Utilities.generatePhoneNumber());
//		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(prop.getProperty("validpassword"));
//		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys(prop.getProperty("validpassword"));
//		driver.findElement(By.xpath("//input[@name='agree']")).click();
//		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		//RegisterPage registerPage = new RegisterPage(driver);
		ConformationPage conformationPage = registerPage.registerAccountByProvidingCredintils(Utilities.generateRandomString(6,10),Utilities.generateRandomString(6,10),
				Utilities.generateRandomString(6,10)+"@gmail.com",Utilities.generatePhoneNumber(),prop.getProperty("validpassword"));
		
		
//		String confirmationMessage = driver.findElement(By.xpath("//div[@id='content']/p[1]")).getText();
		//ConformationPage conformationPage = new ConformationPage(driver);
		String confirmationMessage = conformationPage.getRegisterConformationMessage();
		Assert.assertEquals(confirmationMessage, data.getProperty("RegisterConfirmationmessage"));

	}
	
	@Test(priority=2)
	public void verifyRegisteringAccountWithAlreadyExistingCredentils() throws InterruptedException 
	{
//		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys(Utilities.generateRandomString(6,10));
//		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys(Utilities.generateRandomString(8,12));
//		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(prop.getProperty("validemail"));
//		driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys(Utilities.generatePhoneNumber());
//		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(prop.getProperty("validpassword"));
//		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys(prop.getProperty("validpassword"));
//		driver.findElement(By.xpath("//input[@name='agree']")).click();
//		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		registerPage.registerAccountByProvidingCredintils(Utilities.generateRandomString(6,10),Utilities.generateRandomString(6,10),
				prop.getProperty("validemail"),Utilities.generatePhoneNumber(),prop.getProperty("validpassword"));

				
		//String errorMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		String errorMessage = registerPage.getRegisterErrorMessage();
		
		Assert.assertEquals(errorMessage, data.getProperty("RegisterErrormessage"));

	}
	
	@Test(priority=3)
	public void verifyRegisteringAccountWithOutFillingAnyFillds() 
	{
		//driver.findElement(By.xpath("//input[@value='Continue']")).click();
		registerPage.clickContinumRegisterButton();
		
		//String privacyPolicyMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		String privacyPolicyMessage = registerPage.getRegisterPolicyErrorMessage();
		Assert.assertEquals(privacyPolicyMessage, data.getProperty("RegisterPrivacypolicymessage"));
		
		//String firstNameErrorMessage = driver.findElement(By.xpath("(//div[@class='text-danger'])[1]")).getText();
		String firstNameErrorMessage = registerPage.getRegisterFirstErrorMessage();
		Assert.assertEquals(firstNameErrorMessage, data.getProperty("RegisterFirstnameerrormessage"));
		
		//String lastNameErrorMessage = driver.findElement(By.xpath("(//div[@class='text-danger'])[2]")).getText();
		String lastNameErrorMessage = registerPage.getRegisterLastErrorMessage();
		Assert.assertEquals(lastNameErrorMessage, data.getProperty("RegisterLastnameerrormessage"));
		
		//String emailErrorMessage = driver.findElement(By.xpath("(//div[@class='text-danger'])[3]")).getText();
		String emailErrorMessage = registerPage.getRegisterEmailErrorMessage();
		Assert.assertEquals(emailErrorMessage, data.getProperty("RegisterEmailerrormessage"));
		
		//String telePhoneErrorMessage = driver.findElement(By.xpath("(//div[@class='text-danger'])[4]")).getText();
		String telePhoneErrorMessage = registerPage.getRegisterTelePhoneErrorMessage();
		Assert.assertEquals(telePhoneErrorMessage, data.getProperty("RegisterTelephoneerrormessage"));
		
		//String passwordErrorMessage = driver.findElement(By.xpath("(//div[@class='text-danger'])[5]")).getText();
		String passwordErrorMessage = registerPage.getRegisterPasswordErrorMessage();
		Assert.assertEquals(passwordErrorMessage, data.getProperty("RegisterPassworderrormessage"));
		
	}

}
