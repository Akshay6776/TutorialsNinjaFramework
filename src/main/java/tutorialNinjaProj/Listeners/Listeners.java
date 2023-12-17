package tutorialNinjaProj.Listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import tutorialNinjaProj.ExtentReport.ExtentReport;
import tutorialNinjaProj.Utilities.MyUtilities;

public class Listeners implements ITestListener{

	ExtentReports extentReport;
	ExtentTest extentTest;
	
	@Override
	public void onStart(ITestContext context) {
		try {
			extentReport = ExtentReport.generateExtentReports();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		extentTest = extentReport.createTest(result.getName());
		extentTest.log(Status.INFO,result.getName()+"Started Execution");
	}
	
	
	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.log(Status.INFO,result.getName()+"Test Executed Successfully");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		
		WebDriver driver = null;
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String screenShotPath = MyUtilities.getScreenShots(driver,result.getTestName());
		
		extentTest.addScreenCaptureFromPath(screenShotPath);
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.FAIL, result.getName()+"Test Execution Failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.SKIP,result.getName()+"Test Skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
	
	}


	@Override
	public void onFinish(ITestContext context) {
		extentReport.flush();
		
		String pathOfExentReport = "C:\\Users\\HP\\eclipse-workspace\\TutoialNinjaProj\\reports\\extentReport.html";
		File extentReport = new File(pathOfExentReport);
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
