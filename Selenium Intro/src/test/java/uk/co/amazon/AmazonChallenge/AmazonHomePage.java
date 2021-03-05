package uk.co.amazon.AmazonChallenge;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class AmazonHomePage {

    private WebDriver webDriver;

    public AmazonHomePage (WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String acceptCookies() {
        webDriver.findElement(By.xpath("//input[@id='sp-cc-accept']")).click();
        return null;
    }

    public SearchResultsPage inputSearchForDogTreatsFromHomePage (String linkText, String sendKeys) {
       //webDriver.findElement(By.xpath("//input[@id=\"" + sendKeys + "\"]")).sendKeys();
        webDriver.findElement(By.xpath("//input[@id=\"" + linkText + "\"]")).sendKeys( "\""+ sendKeys + "\"");
        return new SearchResultsPage(webDriver);
    }

    public SearchResultsPage searchForDogTreatsFromHomePage (String linkText) {
        webDriver.findElement(By.xpath("//input[@id=\"" + linkText + "\"]")).click();
        return new SearchResultsPage(webDriver);
    }

    public CustomerServicePage navigateToCustomerServices (String linkText) {
        webDriver.findElement(By.xpath("//div[@id=\"" + linkText + "\"]")).click();
        return new CustomerServicePage(webDriver);
    }
    }

