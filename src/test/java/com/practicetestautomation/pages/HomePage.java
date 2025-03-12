package com.practicetestautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage {
	
	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(css = "#menu-item-20 > a:nth-child(1)")
	private WebElement practiceButton;

	@FindBy(tagName = "h1")
	private WebElement practice;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		PageFactory.initElements(driver, this);
	}

	public void ClickPracticeButton() {
		practiceButton.click();
	}

	public String statusMeldungAuslesen() {
		wait.until(ExpectedConditions.visibilityOf(practice)); // Warte auf die Sichtbarkeit
		return practice.getText();
	}
}
