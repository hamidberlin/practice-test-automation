package com.practicetestautomation.tests;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.practicetestautomation.pages.HomePage;
import com.practicetestautomation.pages.LoginPage;

public class TestNegativePassword {
	
	private WebDriver driver;
	
	@Before
	public void setUp() throws Exception {
		System.out.println("Initialisiere Webdriver");
		System.setProperty("webdriver.gecko.driver", "/opt/homebrew/bin/geckodriver");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://practicetestautomation.com/");
	}

	@After
	public void tearDown() throws Exception {
//		driver.quit(); // Browser schließen
	}

	@Test
	public void testNegativePassword() {
	    System.out.println("Starte Test Negative Password");
	    
	    
	    HomePage homePage = new HomePage(driver);
	    homePage.ClickPracticeButton();
	    
	    LoginPage loginpage = new LoginPage(driver);
	    loginpage.btnLoginPageAnklicken();
	    
	    loginpage.zugangsdatenEingeben("student", "incorrectPassword");
	    loginpage.btnSubmitAnklicken();
	    
	    String invalidPasswordMeldung = loginpage.invalidPasswordAuslesen();
	    assertEquals("Your password is invalid!", invalidPasswordMeldung);   
	    
	    
	    
	}
	

}
