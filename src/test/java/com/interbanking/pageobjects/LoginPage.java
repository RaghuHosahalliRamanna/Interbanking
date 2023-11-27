package com.interbanking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	// Declaration
	@FindBy(xpath = "//input[@name='uid']")
	private WebElement usn;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement pwd;

	@FindBy(xpath = "//input[@name='btnLogin']")
	private WebElement loginbutton;
	
	@FindBy(xpath = "//a[normalize-space()='Log out']")
	private WebElement logoutbutton;

	// Initialization
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Utilization
	public void usn(String usname) {
		usn.sendKeys(usname);
	}

	public void pwd(String password) {
		pwd.sendKeys(password);
	}
	
	public void loginbutton()
	{
		loginbutton.click();
	}
	
	public void logoutbutton()
	{
		logoutbutton.click();
	}

}
