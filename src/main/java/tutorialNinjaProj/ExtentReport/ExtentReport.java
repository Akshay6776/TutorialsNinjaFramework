package tutorialNinjaProj.ExtentReport;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {
	
	
	public static ExtentReports generateExtentReports() throws IOException 
	{
		ExtentReports extentReports = new ExtentReports();
		File ExtentReport = new File("C:\\Users\\HP\\eclipse-workspace\\TutoialNinjaProj\\reports\\extentReport.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(ExtentReport);
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("TutoialNinja Test Results");
		sparkReporter.config().setDocumentTitle("TN Automation Report");
		sparkReporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
		extentReports.attachReporter(sparkReporter);
		
		Properties configProp = new Properties();
		File configPropFile = new File("C:\\Users\\HP\\eclipse-workspace\\TutoialNinjaProj\\src\\main\\java\\tutorialNinjaProj\\Config\\Conifg.properties");
		FileInputStream fisProp = new FileInputStream(configPropFile);
		configProp.load(fisProp);
		extentReports.setSystemInfo("Application url", configProp.getProperty("url"));
		extentReports.setSystemInfo("Browser Name", configProp.getProperty("browser"));
		extentReports.setSystemInfo("Valid Email", configProp.getProperty("validemail"));
		extentReports.setSystemInfo("Valid Password", configProp.getProperty("validpassword"));
		extentReports.setSystemInfo("Operating System", System.getProperty("os.name"));
		extentReports.setSystemInfo("User Name", System.getProperty("user.name"));
		extentReports.setSystemInfo("Java Version",System.getProperty("java.version"));
		
		return extentReports;
	}

}
