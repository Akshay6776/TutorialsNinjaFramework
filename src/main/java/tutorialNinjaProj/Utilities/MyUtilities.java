package tutorialNinjaProj.Utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class MyUtilities {

	
	public static String getScreenShots(WebDriver driver,String testName) 
	{
		File srcScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenShotPath = "C:\\Users\\HP\\eclipse-workspace\\TutoialNinjaProj\\Screenshots\\"+testName+".png";
		try {
			FileHandler.copy(srcScreenshot, new File(screenShotPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return screenShotPath;
		
	}
	
	
	
	
}
