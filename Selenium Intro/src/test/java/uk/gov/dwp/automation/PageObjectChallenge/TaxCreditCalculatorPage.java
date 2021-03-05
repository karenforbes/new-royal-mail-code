package uk.gov.dwp.automation.PageObjectChallenge;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TaxCreditCalculatorPage {

    private WebDriver webDriver;

    //constructor
    public TaxCreditCalculatorPage(WebDriver webdriver) {
        this.webDriver = webdriver;
    }

    public String getPageTitle() {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[normalize-space()='Tax credits calculator']"))).getText();
    }

    public ActualTaxCreditCalculatorPage selectStartNow() {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        webDriver.findElement(By.xpath("//a[normalize-space()='Start now']")).click();
        return new ActualTaxCreditCalculatorPage(webDriver);
         }
}



