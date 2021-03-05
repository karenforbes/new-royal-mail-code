package uk.co.Waitrose.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DeliverySlotPage extends AbstractBasePage {

    public DeliverySlotPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String confirmDeliverySlotPage(String text) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[normalize-space()=\"" + text + "\"]"))).getText();
    }

    public HomeDeliverySelectionPage chooseHomeDelivery(String linkText) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()=\"" + linkText + "\"]"))).click();
        return new HomeDeliverySelectionPage(webDriver);
    }


  }
