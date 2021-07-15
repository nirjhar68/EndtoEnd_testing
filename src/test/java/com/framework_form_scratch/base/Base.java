package com.framework_form_scratch.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {

	// Initialize the WebDriver
	// The web driver should be initialized dynamically. Therefore, we need to
	// extract data from another external file.
	public WebDriver webDriver;
	public Properties externalProperties;

	public WebDriver initializeWebDriver() throws FileNotFoundException, IOException {

		externalProperties = new Properties();
		externalProperties.load(new FileInputStream(
				"D:\\Eclipse Work Place\\Maven_Project_From_scratch\\src\\test\\java\\com\\framework_form_scratch\\base\\data.properties"));
		if (externalProperties.getProperty("browser").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\Eclipse Work Place\\chromedriver.exe");
			webDriver = new ChromeDriver();
		} else if (externalProperties.getProperty("browser").equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:\\Eclipse Work Place\\geckodriver.exe");
			webDriver = new FirefoxDriver();
		} else {
			System.setProperty("webdriver.edge.driver", "D:\\Eclipse Work Place\\msedgedriver.exe");
			webDriver = new EdgeDriver();
		}
		webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		webDriver.manage().window().maximize();
		return webDriver;
	}

	public String getTheURL() throws FileNotFoundException, IOException {
		String URL = "";
		externalProperties = new Properties();
		externalProperties.load(new FileInputStream(
				"D:\\Eclipse Work Place\\Maven_Project_From_scratch\\src\\test\\java\\com\\framework_form_scratch\\base\\data.properties"));
		URL = externalProperties.getProperty("url");
		return URL;

	}

	public String getScreenshotPath(String testCaseName, WebDriver webDriver) throws IOException {
		TakesScreenshot sc = (TakesScreenshot) webDriver;
		File source = sc.getScreenshotAs(OutputType.FILE);
		org.apache.commons.io.FileUtils.copyFile(source, new File(
				"D:\\Eclipse Work Place\\Maven_Project_From_scratch\\reports\\Screenshot\\" + testCaseName + ".png"));
		
		// Return the path of the screenshot
		String imagePath = "D:\\Eclipse Work Place\\Maven_Project_From_scratch\\reports\\Screenshot\\" + testCaseName + ".png";
		return imagePath;
	}
}
