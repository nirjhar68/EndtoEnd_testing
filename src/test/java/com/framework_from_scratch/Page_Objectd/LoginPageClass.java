package com.framework_from_scratch.Page_Objectd;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.framework_form_scratch.base.Base;

public class LoginPageClass extends Base{

	public WebDriver webDriver;

	public LoginPageClass(WebDriver driver) {
		this.webDriver = driver;
	}

	By userId = By.id("user_email");
	By password = By.id("user_password");
	By loginButton = By.name("commit");

	public WebElement getUserId() {
		return webDriver.findElement(userId);
	}

	public WebElement getPassword() {
		return webDriver.findElement(password);
	}

	public WebElement getSubmitButton() {
		return webDriver.findElement(loginButton);
	}

}
