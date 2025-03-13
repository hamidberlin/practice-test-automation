package com.practicetestautomation.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.practicetestautomation.pages.HomePage;
import com.practicetestautomation.pages.LoginPage;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestLoginParameterizedSeleniumFirefox {

    // WebDriver-Instanz und Wartezeit
    private WebDriver driver;
    private WebDriverWait wait;
    private String username;
    private String password;
    private String expectedMessage;

    // Testdaten für verschiedene Login-Szenarien
    @Parameterized.Parameters
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][] {
            { "student", "Password123", "Logged In Successfully" },
            { "incorrectUser", "Password123", "Your username is invalid!" },
            { "student", "incorrectPassword", "Your password is invalid!" }
        });
    }

    // Konstruktor für die Zuweisung der Testdaten
    public TestLoginParameterizedSeleniumFirefox(String username, String password, String expectedMessage) {
        this.username = username;
        this.password = password;
        this.expectedMessage = expectedMessage;
    }

    // Setup-Methode: Initialisierung des Browsers
    @Before
    public void setUp() throws Exception {
        System.out.println("Initialisiere Webdriver");
        System.setProperty("webdriver.gecko.driver", "/opt/homebrew/bin/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    // Teardown-Methode: Schließen des Browsers
    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    // Der eigentliche Login-Test
    @Test
    public void testLoginScenario() {
        System.out.println("Starte parametrisierten Login-Test für Benutzer: " + username);
        
        HomePage homePage = new HomePage(driver);
        homePage.ClickPracticeButton(); // Navigation zur Übungsseite
        
        LoginPage loginPage = new LoginPage(driver);
        loginPage.btnLoginPageAnklicken(); // Aufruf der Login-Seite
        
        loginPage.zugangsdatenEingeben(username, password); // Eingabe der Zugangsdaten
        loginPage.btnSubmitAnklicken(); // Klick auf den Login-Button
        
        // Validierung der Login-Ergebnisse
        if (expectedMessage.equals("Logged In Successfully")) {
            String erfolgsMeldung = loginPage.statusMeldungAuslesen();
            assertTrue("Login sollte erfolgreich sein", erfolgsMeldung.contains(expectedMessage));
            loginPage.logOutAnklicken(); // Logout nach erfolgreichem Login
            System.out.println("Positiver Login-Test bestanden");
        } else {
            // Fehlermeldung bei falschem Benutzernamen
            if (expectedMessage.contains("username")) {
                String invalidUsernameMeldung = loginPage.invalidUsernameElement();
                assertEquals(expectedMessage, invalidUsernameMeldung);
                System.out.println("Negativer Test für falschen Benutzernamen bestanden");
            } else {
                // Fehlermeldung bei falschem Passwort
                String invalidPasswordMeldung = loginPage.invalidPasswordElement();
                assertEquals(expectedMessage, invalidPasswordMeldung);
                System.out.println("Negativer Test für falsches Passwort bestanden");
            }
        }
    }
}
