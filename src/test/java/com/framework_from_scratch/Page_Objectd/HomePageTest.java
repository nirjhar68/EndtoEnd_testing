package com.framework_from_scratch.Page_Objectd;

import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.framework_form_scratch.base.Base;

public class HomePageTest extends Base {

	public WebDriver webDriver;
	public static Logger log = org.apache.logging.log4j.LogManager.getLogger(Base.class.getName());

	@BeforeTest
	public void initializeTest() throws FileNotFoundException, IOException {
		webDriver = initializeWebDriver();
		webDriver.get("http://www.qaclickacademy.com/");
		log.info("Ran @BeforeTest");
	}

	@Test
	public void homePageNavigation() throws InterruptedException {

		HomePageClass homePage = new HomePageClass(webDriver);
		String featuredText = homePage.getFeaturedText().getText();
		Assert.assertEquals(featuredText, "FEATURED COURSES");
		log.info("Successfully fetched the featured text.");

		Thread.sleep(2000);
		homePage.getLogin().click();
		Assert.assertTrue(true);
		log.info("Clicked on the login button.");
	}

	@Test
	public void navbarVisibility() {
		HomePageClass homePage = new HomePageClass(webDriver);
		// Fail The test
		// The driver will try to find something on the wrong url
		webDriver.findElement(By.xpath("//ul[contains(@class, 'navbar-right')]")).click();

	}

	@AfterTest
	public void closeTest() {
		webDriver.close();
	}
}