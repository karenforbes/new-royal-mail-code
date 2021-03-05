package uk.co.RoyalMail.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RoyalMailHomePage extends ObjectBasePage {

    public RoyalMailHomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public String confirmRoyalMailHomePage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[normalize-space()='Track an Item']"))).getText();
    }

    public ChooseStampsPage navigateToChooseStampsPage(String linkText) {
        webDriver.findElement(By.xpath("//a[normalize-space()=\"" + linkText + "\"]")).click();
        return new ChooseStampsPage (webDriver);

    }
}
