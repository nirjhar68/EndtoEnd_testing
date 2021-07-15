package com.framework_from_scratch.Page_Objectd;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.framework_form_scratch.base.Base;

public class LoginPageTest extends Base {

	public WebDriver webDriver;
	public static Logger log = org.apache.logging.log4j.LogManager.getLogger(Base.class.getName());

	@BeforeTest
	public void initializeTest() throws FileNotFoundException, IOException {
		webDriver = initializeWebDriver();
		webDriver.get("https://rahulshettyacademy.com/sign_in/");
		log.info("Driver initialized in the LoginPageTester");
	}

	@Test(dataProvider = "getData")
	public void testLoginPage(String userName, String password) {

		LoginPageClass loginPage = new LoginPageClass(webDriver);

		loginPage.getUserId().sendKeys(userName);
		loginPage.getPassword().sendKeys(password);
		loginPage.getSubmitButton().click();
		log.info("Succssluffly send the keys to the user name and the password section.");

	}

	@DataProvider
	public Object[][] getData() {

		Object[][] data = new Object[2][2];
		data[0][0] = "userNumberOne@practice.com";
		data[0][1] = "127834hf0b19827g3vb";
		data[1][0] = "userNumberTwo@practice.com";
		data[1][1] = "vn-237b-1237-123dsfa";

		return data;

	}

	@AfterTest
	public void closeTest() {
		webDriver.close();
	}
}
