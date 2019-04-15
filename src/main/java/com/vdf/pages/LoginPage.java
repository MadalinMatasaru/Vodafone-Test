package com.vdf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;

	By userName = By.xpath("//*[contains(@id, 'txtUsername_txtInput')]");// By.id("[id*=txtUsername_txtInput]");

	By password = By.xpath("//*[contains(@id, 'txtPassword_txtInput')]");// By.id("[id*=txtPassword_txtInput]");

	By signInButton = By.xpath("//*[contains(@id, 'ResponsiveLogin_btnLogin')]");// By.id("[id*=ResponsiveLogin_btnLogin]");

	public LoginPage(WebDriver driver) {

		this.driver = driver;

	}

	// Set user name in textbox

	public void setUserName(String strUserName) {

		driver.findElement(userName).sendKeys(strUserName);

	}

	// Set password in password textbox

	public void setPassword(String strPassword) {

		driver.findElement(password).sendKeys(strPassword);

	}

	// Click on login button

	public void clickLogin() {

		driver.findElement(signInButton).click();

	}

	public void login(String strUserName, String strPasword) {

		// Fill user name

		this.setUserName(strUserName);

		// Fill password

		this.setPassword(strPasword);

		// Click Login button

		this.clickLogin();
	}

}
