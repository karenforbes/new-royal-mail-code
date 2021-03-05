package uk.co.Waitrose.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractBasePage {

    protected WebDriver webDriver;
    protected WebDriverWait wait;

    public AbstractBasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(this.webDriver, 10);
    }

    public String acceptCookies() {
        webDriver.findElement(By.xpath("//button[normalize-space()='Yes, allow all']")).click();
        return null;

    }
}


