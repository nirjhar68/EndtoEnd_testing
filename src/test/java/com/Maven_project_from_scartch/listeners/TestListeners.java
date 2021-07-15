package com.Maven_project_from_scartch.listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.framework_form_scratch.base.Base;
import com.framework_form_scratch.base.ExtentReporterNG;

public class TestListeners extends Base implements ITestListener {

	ExtentReports extent = ExtentReporterNG.getReportObject();
	ExtentTest test;

	// In case of the parallel testing we will have to make the ExtentTest thread
	// safe
	// We can create an instance of the ThreadLocal class and set the instance of
	// the ExtentTest to its thread pool.
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

	public void onTestSuccess(ITestResult result) {
		System.out.println("The test was successful! " + "The test method is " + result.getName());
		extentTest.get().log(Status.PASS, "Test Passed");
	}

	public void onTestFailure(ITestResult result) {
		WebDriver webDriver = null;

		String testMethodName = result.getMethod().getMethodName();
		System.out.println("The test failed @ " + result.getMethod());
		extentTest.get().fail(result.getThrowable());

		try {
			// To Access the field where the test failed
			// And send the driver object to the screenshot
			webDriver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("webDriver")
					.get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			// To get the screenshot on failure and show it on the index.html report
			extentTest.get().addScreenCaptureFromPath(getScreenshotPath(testMethodName, webDriver), result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}

	public void onFinish(ITestContext context) {
		extent.flush();
	}
}
