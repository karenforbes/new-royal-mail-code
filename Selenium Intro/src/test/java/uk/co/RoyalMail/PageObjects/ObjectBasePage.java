package uk.co.RoyalMail.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ObjectBasePage {

    protected WebDriver webDriver;
    protected WebDriverWait wait;

    public ObjectBasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(this.webDriver, 10);
    }

    public String acceptCookies() {
        webDriver.findElement(By.xpath("//button[normalize-space()='Accept']")).click();
        return null;

    }
}


