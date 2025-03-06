# Practice Test Automation Project

##Projektübersicht
Dieses Projekt automatisiert Tests für die Website [Practice Test Automation](https://practicetestautomation.com) mit Java, Selenium, dem Page Object Pattern und Cucumber. Die Tests simulieren typische User-Szenarien, einschließlich positiver und negativer Login-Tests.

##Projektstruktur
$tests # Testklassen (JUnit/Cucumber) │  │  └──    stepdefinitions # Cucumber-Schrittdefinitionen └──    resources # Konfigurations- und Feature-Dateien


##Aktuelle Tests
- **Login Test (positiv)**: Prüft, ob die Anmeldung mit gültigen Anmeldedaten erfolgreich ist.  
- **Login Test (negativ - Benutzername)**: Prüft die Fehlermeldung bei falschem Benutzernamen.  
- **Login Test (negativ - Passwort)**: Prüft die Fehlermeldung bei falschem Passwort.

##Technologien
- **Java**  
- **Selenium WebDriver**  
- **JUnit**  
- **Cucumber**  
- **Maven**  

##Setup & Ausführen der Tests
1. Repository klonen:  
```bash
git clone https://github.com/DEIN_GITHUB_USERNAME/SeleniumTestFramework.git


2. Projekt in Eclipse oder IntelliJ öffnen
3. Abhängigkeiten installieren:
mvn clean install

4.Tests ausführen:
mvn test

Weiterentwicklung:
Testabdeckung erweitern (z. B. Navigation, Formulare)
Fehler-Handling verbessern
CI/CD-Integration (z. B. GitHub Actions)
