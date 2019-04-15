package com.vdf.tests;

//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//public class TestCase {
//	 public static void main(String[] args) {
//		 String exePath = "D:\\chromedriver.exe";
//		 System.setProperty("webdriver.chrome.driver", exePath);
//		 WebDriver driver = new ChromeDriver();
//		 driver.get("http://toolsqa.com/automation-practice-form/");
//		 }
//}

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.vdf.pages.LandingPage;
import com.vdf.pages.LoginPage;
import com.vdf.utility.BrowserFactory;

public class LoginTest {

	WebDriver driver;

	LoginPage loginPage;
	LandingPage landingPage;

	@BeforeTest

	public void beforeMethod() {
//		String exePath = "D:\\chromedriver.exe";
//		System.setProperty("webdriver.chrome.driver", exePath);
//		driver = new ChromeDriver();
		driver = new BrowserFactory().getBrowser("Chrome");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.vodafone.com.mt/home");
	}

	@AfterMethod

	public void afterMethod() {

		driver.quit();

	}

	@Test(priority = 0)
	public void test() {

		// Create Login Page object

		loginPage = new LoginPage(driver);

		// login to application

		loginPage.login("testqa2", "Voda1234");

		// Verify landing page redirect

		String landingPageURL = driver.getCurrentUrl();
		Assert.assertTrue(landingPageURL.equals("https://www.vodafone.com.mt/myVodafone-postpaid"));

		// Create Landing Page object
		landingPage = new LandingPage(driver);

		// Verify text box exists with given text
		Assert.assertTrue(landingPage.getBalanceText().equals("My Pending Balance is :"));

		// Verify balance is in numerical format
		Assert.assertTrue(landingPage.isNumericalValue());

	}
}