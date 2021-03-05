package uk.co.tui.HolidayChallenge;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LuxuryDealsPage {

    private WebDriver webDriver;

    public LuxuryDealsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String confirmLuxuryDealsPage(String linkText) {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()=\"" + linkText + "\"]"))).getText();
    }

       public LuxuryDealsPage selectSortCriteria(String linkText) {
        webDriver.findElement(By.xpath("//div[@class=\"select-dropdown\"]")).click();
        webDriver.findElement(By.xpath("//li[normalize-space()=\"" + linkText + "\"]")).click();
        return this;
    }

    public String confirmResultsHaveFiltered(String linkText) {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()=\"" + linkText + "\"]"))).getText();
    }

    public SelectedHolidayPage selectHoliday(String linkText) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        //All this is saying is try line 36 and if an exception is thrown keep trying line 39 until the test passes
        try {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()=\"" + linkText + "\"]"))).click();
        } catch(Exception e) {
            Thread.sleep(5000);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()=\"" + linkText + "\"]"))).click();
        }
        return new SelectedHolidayPage(webDriver);
    }
    }




