package uk.co.RoyalMail.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import uk.co.Waitrose.PageObjects.AbstractBasePage;

public class StampsToBePurchasedPage extends AbstractBasePage {


    public StampsToBePurchasedPage(WebDriver webDriver) {
        super(webDriver);
    }


    public StampsToBePurchasedPage confirmBuyFoolHorsePage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-ui-id='page-title-wrapper']"))).getText();
        //span[@data-ui-id='page-title-wrapper'] From Karen's selector
        //"//span[@class='base']" From my selector
        return this;
    }


    public StampsToBePurchasedPage findQuantityField(String sendKeys) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='qty']"))).sendKeys(Keys.DELETE + "\"" + sendKeys + "\"");
        // webDriver.findElement(By.xpath("\"//input[@id='qty']\"")).sendKeys("\""+ sendKeys + "\"");
        return this;

    }

    public StampsToBePurchasedPage addToBasket() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='product-addtocart-button']//span[contains(text(),'Add to basket')]"))).click();
        return this;
    }

    public StampsToBePurchasedPage checkOut() {
       // WebDriverWait wait = new WebDriverWait(this.webDriver, 2);
        webDriver .findElement(By.xpath("//a[@class='action primary viewcart']")).click();
        return this;
        //public StamrchasedPagepsToBePu findQuantityField() {
        //    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='qty']"))).sendKeys(Keys.DELETE);
        //  return this; wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt
    }
}