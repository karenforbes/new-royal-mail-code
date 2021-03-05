package uk.co.amazon.AmazonChallenge;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SuspiciousActivityResultsPage {

    private WebDriver webDriver;

    public SuspiciousActivityResultsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String confirmSuspiciousActivityResultsPage (String linkText) {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),\"" + linkText + "\")]"))).getText();
    }

    public SuspiciousActivityResultsPage inputSearchForSuspiciousActivity (String linkText, String sendKeys) {
        webDriver.findElement(By.xpath("//input[@id=\"" + linkText + "\"]")).sendKeys( "\""+ sendKeys + "\"" + Keys.ENTER + "\"");
        return new SuspiciousActivityResultsPage(webDriver);
    }

    public String confirmSearchForSuspiciousActivity (String linkText) {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),\"" + linkText + "\")]"))).getText();
    }
}

