package tutorialNinjaProj.Tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import tutorialNinjaProj.Baseclass.BaseClass;
import tutorialNinjaProj.PageObjects.HomePage;
import tutorialNinjaProj.PageObjects.SearchPage;

public class SearchTest extends BaseClass{
	
	public WebDriver driver;
	HomePage homePage;
	
	
	public SearchTest() throws IOException 
	{
		super();
	}
	
	@BeforeMethod
	public void setup() 
	{
		driver = initilizeBrowserAndLaunchApplication();
		homePage = new HomePage(driver);
	}
	
	@Test(priority=1)
	public void verifySearchWithValidProduct() 
	{
		//homePage = new HomePage(driver);
//		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(data.getProperty("searchproductname"));
//		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();

		SearchPage searchPage = homePage.searchProduct(data.getProperty("Searchproductname"));
		
		//searchPage = new  SearchPage(driver);
		//String productName = driver.findElement(By.cssSelector("div[class='caption'] h4 a")).getText();
		String productName =searchPage.getSearchedProductName();
		Assert.assertEquals(productName, data.getProperty("Searchproductname"));
		
		
	}
	
	@Test(priority=2)
	public void verifySearchWithNonExistingProduct() 
	{
		//homePage = new HomePage(driver);
//		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(data.getProperty("invaliedproductsearch"));
//		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
		SearchPage searchPage = homePage.searchProduct(data.getProperty("invaliedproductsearch"));
		//searchPage = new  SearchPage(driver);
//		String errorMessage = driver.findElement(By.xpath("//div[@id='content']/p[2]")).getText();
		String errorMessage = searchPage.getSearchedErrorMessage();
		Assert.assertEquals(errorMessage, data.getProperty("searcherrormessage"));
	
	}
	
	@Test(priority=3)
	public void verifySearchWithNotProvidingAnyProductName() 
	{
		//HomePage homePage = new HomePage(driver);
		//driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
		SearchPage searchPage = homePage.clicksearchButton();
		//String errorMessage = driver.findElement(By.xpath("//div[@id='content']/p[2]")).getText();
		//SearchPage searchPage = new  SearchPage(driver);
		String errorMessage = searchPage.getSearchedErrorMessage();
		Assert.assertEquals(errorMessage, data.getProperty("searcherrormessage"));
	
	}

}
