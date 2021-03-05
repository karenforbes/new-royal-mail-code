package uk.co.RoyalMail.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GoogleHomePage extends ObjectBasePage {

    public GoogleHomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public GoogleHomePage acceptGoogleCookies() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[src^='https://consent.google.com']")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='introAgreeButton']"))).click();
        return this;
    }

    public GoogleHomePage confirmGoogleHomePage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='Google']"))).getText();
        return this;
    }

    public GoogleHomePage inputSearchForRoyalMail(String sendKeys) {
        webDriver.findElement(By.xpath("//input[@title='Search']")).sendKeys(sendKeys + Keys.ENTER);
        return this;
    }

    public GoogleHomePage confirmSearchResults(String linkText) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),\"" + linkText + "\")]"))).getText();
        return this;
    }

    public RoyalMailHomePage navigateToRoyalMailHomePage(String linkText) {
        webDriver.findElement(By.xpath("//span[normalize-space()=\"" + linkText + "\"]")).click();
        return new RoyalMailHomePage (webDriver);
    }
}
