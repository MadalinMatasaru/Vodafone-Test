package com.vdf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	WebDriver driver;

	By balanceElement = By.className("prepaidLandingInflate");
	By balanceValue = By.tagName("span");
	By balanceLabel = By.tagName("p");

	public LandingPage(WebDriver driver) {

		this.driver = driver;

	}

	public WebElement getBalanceElement() {
		return driver.findElement(balanceElement);
	}

	public String getBalanceLabel() {
		return getBalanceElement().findElement(balanceLabel).getText();
	}

	public String getBalanceValue() {
		String[] labelSplit = getBalanceLabel().split(":");
		return labelSplit[1].replace("€", "");
	}

	public String getBalanceText() {
		int index = getBalanceLabel().indexOf(":");
		return getBalanceLabel().substring(0, index + 1);
	}

	public boolean isNumericalValue() {
		try {
			Double.parseDouble(getBalanceValue());
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
