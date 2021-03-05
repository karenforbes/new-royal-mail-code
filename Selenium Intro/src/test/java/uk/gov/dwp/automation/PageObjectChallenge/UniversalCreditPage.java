package uk.gov.dwp.automation.PageObjectChallenge;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UniversalCreditPage {

    private WebDriver webDriver;

    //constructor
    public UniversalCreditPage(WebDriver webdriver) {
        this.webDriver = webdriver;
    }

    public String getPageTitle() {
        //if this comes back with cookies may need to change the by to By.CSS, By .ID, By.Name etc
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[normalize-space()='Universal Credit']"))).getText();
    }
    public UniversalCreditPage selectEligibility (String linkText) {
        webDriver.findElement(By.xpath("//a[normalize-space()=\"" + linkText + "\"]")).click();
        return this;
        }

    public String getUCSubTitle() {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[normalize-space()='Eligibility']"))).getText();
    }


}
