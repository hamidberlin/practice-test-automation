package com.practicetestautomation.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    
    // WebDriver-Instanz für die Interaktion mit der Webseite
    private WebDriver driver;
    private WebDriverWait wait;

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

    // WebElement für die Fehlermeldung bei falschem Login
    @FindBy(xpath = "//div[@id='error']")
    private WebElement invalidUsername;
    
    @FindBy(id = "error")
    private WebElement invalidPassword;

    // WebElement für den Logout-Button
    @FindBy(linkText = "Log out")
    private WebElement logOut;

    // Konstruktor zur Initialisierung der WebDriver-Instanz und PageFactory
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 Sekunden Timeout
        PageFactory.initElements(driver, this);
    }

    // Methode zum Klicken auf den Button zur Login-Seite
    public void btnLoginPageAnklicken() {
        btnLoginPage.click();
    }

    // Methode zur Eingabe der Zugangsdaten
    public void zugangsdatenEingeben(String username, String password) {
        inputUsername.clear();
        inputUsername.sendKeys(username);
        inputPassword.clear();
        inputPassword.sendKeys(password);
    }

    // Methode zum Klicken auf den Submit-Button
    public void btnSubmitAnklicken() {
        btnSubmit.click();
    }

    // Methode zum Auslesen der Statusmeldung nach erfolgreichem Login
    public String statusMeldungAuslesen() {
        wait.until(ExpectedConditions.visibilityOf(statusMeldung));
        return statusMeldung.getText();
    }

    // Methode zum Auslesen der Fehlermeldung bei falschen Login-Daten
    public String invalidUsernameElement() {
        wait.until(ExpectedConditions.visibilityOf(invalidPassword));
        return invalidPassword.getText();
    }
    
    public String invalidPasswordElement() {
        wait.until(ExpectedConditions.visibilityOf(invalidUsername));
        return invalidUsername.getText();
    }
    

    // Methode zum Klicken auf den Logout-Button
    public void logOutAnklicken() {
        wait.until(ExpectedConditions.elementToBeClickable(logOut));
        logOut.click();
    }
}
