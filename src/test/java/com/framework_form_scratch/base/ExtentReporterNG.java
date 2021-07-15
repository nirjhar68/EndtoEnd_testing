package com.framework_form_scratch.base;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;

public class ExtentReporterNG {

	static ExtentReports extentReports;

	public static ExtentReports getReportObject() {
		String reportPath = "D:\\Eclipse Work Place\\Maven_Project_From_scratch\\reports\\index.html";
		ExtentSparkReporter eSReporter = new ExtentSparkReporter(reportPath);
		eSReporter.config().setReportName("Project from scratch reports");
		eSReporter.config().setDocumentTitle("Test results");

		extentReports = new ExtentReports();
		extentReports.attachReporter(eSReporter);
		extentReports.setSystemInfo("Tester", "Muhammad Chowdhury");
		
		return extentReports;
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void initialDemo() {
		extentReports.createTest("Initial DEMO");
		System.setProperty("webdriver.chrome.driver", "D:\\Eclipse Work Place\\chromedriver.exe");
		WebDriver chromeWebDriver = new ChromeDriver();
		chromeWebDriver.manage().window().maximize();
		chromeWebDriver.get("http://rahulshettyacademy.com");
		chromeWebDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		// To notify the test is complete and the report will be generated with the
		// passed/failed results.
		extentReports.flush();

		// Now we can run the test as TestNG and check if the reports folder is created
		// or not.
		// Get the path of the index.hmlt file from the reports folder and past that to
		// the web browser. check the report.
	}

}
