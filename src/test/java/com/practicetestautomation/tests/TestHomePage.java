package com.practicetestautomation.tests;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.practicetestautomation.pages.HomePage;
import com.practicetestautomation.pages.LoginPage;


public class TestHomePage {
	
	private WebDriver driver;
	
	@Before
	public void setUp() throws Exception {
		System.out.println("Initialisiere Webdriver");
		System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://practicetestautomation.com/");
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void testHomePage() {
	    System.out.println("Starte Test HomePage");

	    // Arrange: Initialisierung der HomePage-Objekts
	    // Hier wird das HomePage-Objekt mit dem WebDriver initialisiert. Der WebDriver wird verwendet, um auf die Website zuzugreifen.
	    HomePage homepage = new HomePage(driver);
	            
	    // Act: Durchführung der Aktion - Klicke auf den 'Practice' Button auf der Homepage
	    // Diese Methode klickt auf den "Practice"-Button auf der Homepage, um zur nächsten Seite zu navigieren.
	    homepage.ClickPracticeButton();

	    // Assert: Überprüfe die erfolgreiche Navigation auf die "Practice"-Seite
	    // Wir lesen den Text des H1-Tags auf der Seite aus und prüfen, ob er "Practice" enthält, um sicherzustellen, dass wir auf der richtigen Seite sind.
	    String erfolgsMeldung = homepage.statusMeldungAuslesen();
	    assertTrue("Die Erfolgsnachricht sollte 'Practice' enthalten", erfolgsMeldung.contains("Practice"));

	    // Weiter zu LoginPage: Initialisiere die LoginPage
	    // Jetzt, da wir auf der "Practice"-Seite sind, wollen wir zur Login-Seite weitergehen. Wir initialisieren ein LoginPage-Objekt.
	    LoginPage loginPage = new LoginPage(driver);
	    // Klicke auf den Button, der zur Login-Seite führt
	    loginPage.btnLoginPageAnklicken();

	    // Gebe die Zugangsdaten auf der Login-Seite ein
	    // Wir simulieren die Eingabe eines Benutzernamens und Passworts. Die Daten hier sind hardcodiert (kann später für eine bessere Lösung angepasst werden).
	    loginPage.zugangsdatenEingeben("student", "Password123");

	    // Klicke auf den Submit-Button, um sich anzumelden
	    loginPage.btnSubmitAnklicken();

	    // Assert: Überprüfe, ob der Login erfolgreich war
	    // Nachdem wir den Login abgeschlossen haben, überprüfen wir, ob die Erfolgsmeldung den Text "Logged In Successfully" enthält.
	    String statusMeldung = loginPage.statusMeldungAuslesen();
	    assertTrue(statusMeldung.contains("Logged In Successfully"));

	    // LogOut: Melde dich aus
	    // Nach dem erfolgreichen Login klicken wir auf den "Log out"-Button, um den Logout-Vorgang zu starten.
	    loginPage.logOutAnklicken();
	}
		
}
