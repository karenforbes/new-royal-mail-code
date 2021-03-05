package uk.co.Waitrose.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomeDeliverySelectionPage extends AbstractBasePage {

    public HomeDeliverySelectionPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String confirmHomeDeliverySelectionPage(String text) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[normalize-space()=\"" + text + "\"]"))).getText();
    }

    public BookACollectionPage noSlotsBookACollection() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div/div/div/div/section/div/p/a"))).click();
        return new BookACollectionPage(webDriver);

    }
}



