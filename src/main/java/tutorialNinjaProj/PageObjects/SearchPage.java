package tutorialNinjaProj.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

	WebDriver driver;
	
	public SearchPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
//	driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(data.getProperty("searchproductname"));
//	driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
//	
//	String productName = driver.findElement(By.xpath("//div[@class='caption']//a")).getText();
	

	@FindBy(xpath="(//div[@class='caption']//a)")
	private WebElement SearchProductName;
	
//	String errorMessage = driver.findElement(By.xpath("//div[@id='content']/p[2]")).getText();
	@FindBy(xpath="//div[@id='content']/p[2]")
	private WebElement SearchErrorMessage;
	
	
	public String getSearchedProductName() 
	{
		String SerProductName = SearchProductName.getText();
		return SerProductName;
	}
	
	public String getSearchedErrorMessage() 
	{
		String SerErrorMessage = SearchErrorMessage.getText();
		return SerErrorMessage;
	}
	
}
