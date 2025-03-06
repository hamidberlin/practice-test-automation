package com.practicetestautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Die HomePage-Klasse repräsentiert die Startseite der Webanwendung
public class HomePage {
	
	// WebDriver-Instanz für die Interaktion mit der Webseite
	private WebDriver driver;
	
	// WebElement für den Practice-Button, mit dem die Practice-Seite aufgerufen wird
	@FindBy(css = "#menu-item-20 > a:nth-child(1)")
	private WebElement practiceButton;
	
	// WebElement für das <h1>-Tag, um die Erfolgsmeldung (z. B. "Practice") anzuzeigen
	@FindBy(tagName = "h1")
	private WebElement practice;

	// Konstruktor, der den WebDriver übergibt und die WebElemente initialisiert
	public HomePage(WebDriver driver) {
		super();  // Ruft den Konstruktor der Oberklasse auf (optional, falls benötigt)
		this.driver = driver;  // Setzt den WebDriver
		PageFactory.initElements(driver, this);  // Initialisiert die WebElemente mit dem WebDriver
	}
	
	// Methode zum Klicken des Practice-Buttons, um zur Practice-Seite zu navigieren
	public void ClickPracticeButton() {
		practiceButton.click();  // Klickt auf den Practice-Button
	}
	
	// Methode zum Auslesen der Statusmeldung, die in einem <h1>-Tag auf der Seite angezeigt wird
	public String statusMeldungAuslesen() {
		return practice.getText();  // Gibt den Text des <h1>-Elements zurück
	}
}