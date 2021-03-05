package uk.co.amazon.AmazonChallenge;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomerServicePage {

    private WebDriver webDriver;

    public CustomerServicePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String confirmCustomerServicePage () {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        //This had to be searched like this as there are 2 H1's on the
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1:nth-child(1)"))).getText();
    }

    public SuspiciousActivityResultsPage selectReportSomethingSuspicious (String linkText) {
        webDriver.findElement(By.xpath("//h3[normalize-space()=\"" + linkText + "\"]")).click();
        return new SuspiciousActivityResultsPage(webDriver);
    }
}
