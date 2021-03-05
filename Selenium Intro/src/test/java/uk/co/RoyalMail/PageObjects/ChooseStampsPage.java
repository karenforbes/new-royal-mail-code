package uk.co.RoyalMail.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import uk.co.Waitrose.PageObjects.AbstractBasePage;

public class ChooseStampsPage extends AbstractBasePage {


    public ChooseStampsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public ChooseStampsPage confirmChooseStampsPage(String linkText) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space()=\"" + linkText + "\"]"))).getText();
        return this;
    }

    public ChooseStampsPage selectTypeOfStamps(String linkText) {
        //webDriver.findElement(By.xpath("//a[@class='widget__button action button_1 primary']")).click();
        webDriver.findElement(By.xpath("//span[normalize-space()=\"" + linkText + "\"]")).click();
        return this;
    }

    public StampsToBePurchasedPage selectStampsToPurchase(String linkText) {
        webDriver.findElement(By.xpath("//img[@alt=\"" + linkText + "\"]")).click();
        return new StampsToBePurchasedPage (webDriver);
    }
}