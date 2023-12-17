package tutorialNinjaProj.Tests;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.testng.Assert;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import tutorialNinjaProj.Baseclass.BaseClass;
import tutorialNinjaProj.PageObjects.AccountPage;
import tutorialNinjaProj.PageObjects.HomePage;
import tutorialNinjaProj.PageObjects.LoginPage;
import tutorialNinjaProj.Utils.Utilities;

public class LoginTest extends BaseClass{
	
	public WebDriver driver;
	LoginPage loginPage;
	
	public LoginTest() throws IOException 
	{
		super();
	}
	
	@BeforeMethod
	public void setup() throws IOException 
	{
		driver = initilizeBrowserAndLaunchApplication();
		HomePage homePage = new HomePage(driver);
		loginPage = homePage.getToLopginPage();
//		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
//		driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();
	
	}
	
	
	@Test(priority = 1,dataProvider="validCredentialsSupplier")
	public void verifyLoginWithValidCredentils(String email,String password) 
	{
		//LoginPage loginPage = new LoginPage(driver);
		AccountPage accountPage = loginPage.provideCredintilsAndloginToAccount(email, password);
//		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(email);
//		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(password);
//		driver.findElement(By.xpath("//input[@value='Login']")).click();
		//AccountPage accountPage = new AccountPage(driver);
		boolean displayStat = accountPage.getdisplayStatusOfAccountElement();
		//WebElement account = driver.findElement(By.xpath("(//div[@id='content']/ul/li/a)[1]"));
		
		Assert.assertTrue(displayStat);
		
	}
	
	@Test(priority = 2)
	public void verifyLoginWithInvalidCredentils() 
	{		
//		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(Utilities.generateRandomString(6,10)+"@gmail.com");
//		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(Utilities.generateRandomString(6,10));
//		driver.findElement(By.xpath("//input[@value='Login']")).click();
		loginPage.provideCredintilsAndloginToAccount(Utilities.generateRandomString(6,10)+"@gmail.com", Utilities.generateRandomString(6,10));
		
		String alertMessage = loginPage.getAllertMessage();
		
		Assert.assertEquals(alertMessage, data.getProperty("LoginErrorMessager"));
	
		
	}
	
	@Test(priority = 3)
	public void verifyLoginWithInvalidEmailandValiedPassword() 
	{		
//		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(Utilities.generateRandomString(6,10)+"@gmail.com");
//		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(prop.getProperty("validpassword"));
//		driver.findElement(By.xpath("//input[@value='Login']")).click();
		loginPage.provideCredintilsAndloginToAccount(Utilities.generateRandomString(6,10)+"@gmail.com", prop.getProperty("validpassword"));
		
		//String alertMessage = driver.findElement(By.cssSelector(".alert-dismissible")).getText();
		String alertMessage = loginPage.getAllertMessage();
		
		Assert.assertEquals(alertMessage, data.getProperty("LoginErrorMessager"));

		
	}
	
	
	@Test(priority = 4)
	public void verifyLoginWithValidEmailandInvaliedPassword() 
	{		
//		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(Utilities.generateRandomString(6,10)+"@gmail.com");
//		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(Utilities.generateRandomString(6,10));
//		driver.findElement(By.xpath("//input[@value='Login']")).click();
		loginPage.provideCredintilsAndloginToAccount(Utilities.generateRandomString(6,10)+"@gmail.com", Utilities.generateRandomString(6,10));

		//String alertMessage = driver.findElement(By.cssSelector(".alert-dismissible")).getText();
		String alertMessage = loginPage.getAllertMessage();
		
		Assert.assertEquals(alertMessage, data.getProperty("LoginErrorMessager"));
		
	}
	
	

	@Test(priority = 5)
	public void verifyLoginWithoutProvidingCredentils() 
	{
		//driver.findElement(By.xpath("//input[@value='Login']")).click();
		loginPage.clickactualLoginButton();
		//String alertMessage = driver.findElement(By.cssSelector(".alert-dismissible")).getText();
		String alertMessage = loginPage.getAllertMessage();
		
		Assert.assertEquals(alertMessage, data.getProperty("LoginErrorMessager"));
		
	}
	
	@DataProvider(name="validCredentialsSupplier")
	public Object[][] supplyTestData() throws IOException
	{
		Object data[][] = Utilities.getTestDataFromExcell("Sheet1");
		return data;
	}


}
