package uk.co.Waitrose.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SignInPage extends AbstractBasePage {

    public SignInPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String confirmSignInPage(String text) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[normalize-space()=\"" + text + "\"]"))).getText();
    }

    public SignInPage inputEmail(String sendKeys) {
        webDriver.findElement(By.xpath("//input[@id='email']")).sendKeys(sendKeys);
        return this;
    }

    public WaitroseHomePage inputPassword(String sendKeys) {
        webDriver.findElement(By.xpath("//input[@id='password']")).sendKeys(sendKeys, Keys.ENTER);
        return new WaitroseHomePage(webDriver);

    }
    }

