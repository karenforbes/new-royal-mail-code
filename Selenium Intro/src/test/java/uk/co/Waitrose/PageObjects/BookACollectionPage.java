package uk.co.Waitrose.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BookACollectionPage extends AbstractBasePage {

    public BookACollectionPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String confirmBookACollectionPage(String text) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[normalize-space()= \"" + text + "\"]"))).getText();
    }

    public BookACollectionPage selectGroceries (String tickBox) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[normalize-space()= \"" + tickBox + "\"]"))).click();
        return this;
    }

    public ChooseAStorePage navigateToChooseAStorePage (String linkText) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()= \"" + linkText + "\"]"))).click();
        return new ChooseAStorePage(webDriver);
    }

}
