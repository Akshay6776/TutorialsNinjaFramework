package tutorialNinjaProj.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {

	WebDriver driver;
	
	public AccountPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
//	WebElement account = driver.findElement(By.xpath("(//div[@id='content']/ul/li/a)[1]"));
	
	@FindBy(xpath="//a[normalize-space()='Edit your account information']")
	 private WebElement webElementaccount;
	
	
	public boolean getdisplayStatusOfAccountElement() 
	{
		boolean displayStatus  = webElementaccount.isDisplayed();
		return displayStatus;
	}
	
	
}
