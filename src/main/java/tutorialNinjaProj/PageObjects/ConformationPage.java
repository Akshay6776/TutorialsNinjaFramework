package tutorialNinjaProj.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConformationPage {

	WebDriver driver;
	
	public ConformationPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
//	String confirmationMessage = driver.findElement(By.xpath("//div[@id='content']/p[1]")).getText();
	
	@FindBy(xpath="//div[@id='content']/p[1]")
	 private WebElement registercongirmationMesage;
	
	
	public String getRegisterConformationMessage() 
	{
		String regConfirmationMessage = registercongirmationMesage.getText();
		return regConfirmationMessage;
	}
	
	
}
