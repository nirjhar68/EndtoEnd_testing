package com.framework_from_scratch.Page_Objectd;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.framework_form_scratch.base.Base;

public class HomePageClass extends Base {

	public WebDriver webDriver;

	public HomePageClass(WebDriver driver) {
		this.webDriver = driver;
	}

	By login = By.xpath("//nav[@class='pull-right']/ul/li[4]/a/span");
	By featuredCourses = By.cssSelector(".text-center>h2");

	public WebElement getLogin() {
		return this.webDriver.findElement(login);
	}

	public WebElement getFeaturedText() {
		return this.webDriver.findElement(featuredCourses);
	}

}
