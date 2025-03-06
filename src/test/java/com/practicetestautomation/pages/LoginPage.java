package com.practicetestautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	// WebDriver-Instanz für die Interaktion mit der Webseite
	private WebDriver driver;

	// WebElement für den Login-Button, um auf die Login-Seite zu gelangen
	@FindBy(linkText = "Test Login Page")
	private WebElement btnLoginPage;

	// WebElement für das Eingabefeld des Benutzernamens
	@FindBy(id = "username")
	private WebElement inputUsername;

	// WebElement für das Eingabefeld des Passworts
	@FindBy(id = "password")
	private WebElement inputPassword;

	// WebElement für den Button, der den Login-Vorgang abschließt
	@FindBy(id = "submit")
	private WebElement btnSubmit;

	// WebElement für die Statusmeldung (z. B. Erfolgsnachricht nach dem Login)
	@FindBy(tagName = "h1")
	private WebElement statusMeldung;

	// WebElement für den Logout-Button, um sich aus dem System abzumelden
	@FindBy(linkText = "Log out")
	private WebElement logOut;

	// Konstruktor, der den WebDriver übergibt und die WebElemente initialisiert
	public LoginPage(WebDriver driver) {
	    super();  // Ruft den Konstruktor der Oberklasse auf (optional, falls benötigt)
	    this.driver = driver;  // Weist den WebDriver zu
	    PageFactory.initElements(driver, this);  // Initialisiert die WebElemente mit dem WebDriver
	}

	// Methode zum Klicken auf den Login-Page-Button, der zur Login-Seite führt
	public void btnLoginPageAnklicken() {
	    btnLoginPage.click();  // Klickt auf den Button
	}

	// Methode zur Eingabe der Anmeldedaten (Benutzername und Passwort)
	public void zugangsdatenEingeben(String username, String password) {
	    inputUsername.sendKeys("student");  // Eingeben des Benutzernamens
	    inputPassword.sendKeys("Password123");  // Eingeben des Passworts
	}

	// Methode zum Klicken des Submit-Buttons, um den Login abzuschließen
	public void btnSubmitAnklicken() {
	    btnSubmit.click();  // Klickt auf den Submit-Button
	}

	// Methode zum Auslesen der Statusmeldung auf der Login-Seite
	public String statusMeldungAuslesen() {
	    return statusMeldung.getText();  // Gibt den Text der Statusmeldung zurück
	}

	// Methode zum Klicken des Logout-Buttons, um sich aus dem System abzumelden
	public void logOutAnklicken() {
	    logOut.click();  // Klickt auf den Logout-Button
	}
}
