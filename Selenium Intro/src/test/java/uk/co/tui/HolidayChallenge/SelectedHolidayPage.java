package uk.co.tui.HolidayChallenge;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectedHolidayPage {

    private WebDriver webDriver;

    public SelectedHolidayPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String confirmHolidaySelected (String linkText) {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()=\"" + linkText + "\"]"))).getText();
    }

    public CustomiseHolidayPage selectHolidayToBook(String linkText) {
       // webDriver.findElement(By.xpath("//div[contains(@class, \"ProgressbarNavigation__summaryButton\")]/*/button")).click();
        webDriver.findElement(By.xpath("//button[normalize-space()=\"" + linkText + "\"]")).click();
        return new CustomiseHolidayPage(webDriver);
    }

}
