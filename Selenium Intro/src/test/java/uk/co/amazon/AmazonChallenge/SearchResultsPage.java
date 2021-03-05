package uk.co.amazon.AmazonChallenge;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsPage {

    private WebDriver webDriver;

    public SearchResultsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

//    public String confirmSearchResultsPage () {
//       WebDriverWait wait = new WebDriverWait(webDriver, 10);
//       return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='a-size-medium']"))).getText();
//    }

    public String confirmAvCustomerReviewSection (String linkText) {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()=\"" + linkText + "\"]"))).getText();

    }
    public SearchResultsPage filterResultsByBestRating (String linkText) {
        webDriver.findElement(By.xpath("//i[@class=\"" + linkText + "\"]")).click();
        return this;
            }

    public String confirmRatingFilter (String linkText) {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class=\"" + linkText + "\"]"))).getText();
    }

    public SearchResultsPage filterResultsByLowestPrice (String linkText) {
       webDriver.findElement(By.xpath("//span[contains(text(),\"" + linkText + "\")]")).click();
        return this;   }

    public String confirmPriceFilter () {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Any Price')]"))).getText();
    }


}

