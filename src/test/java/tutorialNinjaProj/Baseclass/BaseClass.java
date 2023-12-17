package tutorialNinjaProj.Baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	
WebDriver driver;
public Properties prop;
public Properties data;


	public BaseClass() throws IOException 
	{
		prop = new Properties();
		File propFile = new File("C:\\Users\\HP\\eclipse-workspace\\TutoialNinjaProj\\src\\main\\java\\tutorialNinjaProj\\Config\\Conifg.properties");
		FileInputStream fis = new FileInputStream(propFile);
		prop.load(fis);
		
		data = new Properties();
		File dataFile = new File("C:\\Users\\HP\\eclipse-workspace\\TutoialNinjaProj\\src\\main\\java\\tutorialNinjaProj\\Testdata\\TestData.properties");
		FileInputStream fisdata = new FileInputStream(dataFile);
		data.load(fisdata);
		
	}
	
	

	public WebDriver initilizeBrowserAndLaunchApplication() 
	{
		String browserName = prop.getProperty("browser");
		
		if (browserName.equalsIgnoreCase("chrome")) 
		{
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) 
		{
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get(prop.getProperty("url"));	
		return driver;
	}
	
	@AfterMethod
	public void closeDriver() 
	{
		driver.quit();
	}


}
