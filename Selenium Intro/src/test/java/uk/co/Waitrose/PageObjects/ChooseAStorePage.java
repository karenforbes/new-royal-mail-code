package uk.co.Waitrose.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ChooseAStorePage extends AbstractBasePage {


    public ChooseAStorePage(WebDriver webDriver) {
        super(webDriver);
    }

    public String confirmChooseAStorePage(String text) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()= \"" + text + "\"]"))).getText();
    }

    public ChooseAStorePage chooseAStore() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/div[3]/div/p"))).click();
        return this;
    }

        public boolean lookForAvailableSlot (String targetDeliveryDate) {
            List<WebElement> availableSlots = webDriver.findElements(By.xpath("//button/i[contains(@class, \"Success\")]"));
            for(WebElement availableSlot : availableSlots) {
                if(availableSlot.getAttribute("aria-label").contains(targetDeliveryDate)) {
                    availableSlot.click();
                    return true;
                }
            }
            return false;
        }

    public ChooseAStorePage selectGroceriesLink() {
        //webDriver.findElement(By.xpath("//div/div/div/header/div[2]/div[2]/div/div/div/div/div/div/section/button"));
        webDriver.findElement(By.xpath("//button[text()=\"Groceries\"]"));
        return this;
    }

}

