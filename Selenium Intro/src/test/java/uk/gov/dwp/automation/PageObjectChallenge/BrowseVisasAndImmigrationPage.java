package uk.gov.dwp.automation.PageObjectChallenge;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowseVisasAndImmigrationPage {

    private WebDriver webDriver;

    public BrowseVisasAndImmigrationPage(WebDriver webdriver) {
        this.webDriver = webdriver;
    }

    public String getBrowseVisasAndImmigrationPageTitle() {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Browse:')]"))).getText();
    }

    public BrowseVisasAndImmigrationPage selectTravellingToUKLink (String linkText) {
        webDriver.findElement(By.xpath("//h3[normalize-space()='\"" + linkText + "\"]")).click();
        //note needed here
        return this;
    }
    public String getBrowseTravellingToTheUKPageTitle() {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[normalize-space()='Browse: Travelling to the UK']"))).getText();
    }
    }

