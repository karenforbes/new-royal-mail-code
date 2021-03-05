package uk.gov.dwp.automation.PageObjectChallenge;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BrowseBenefitPage {

    private WebDriver webDriver;

    public BrowseBenefitPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    /*This is the next page we land on and you always need to ensure you have landed on the right page so you do this
    by selecting one of the elements on the page as shown below
     */

    public String getPageTitle() {
        //if this comes back with cookies may need to change the by to By.CSS, By .ID, By.Name etc
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        //use selectors hub to find the path name of the element
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(@class,\"js-heading\")]"))).getText();
    }

    public BrowseBenefitPage selectUCLink(String linkText) {
        webDriver.findElement(By.xpath("//H3[text()=\"" + linkText + "\"]")).click();
        //this is returning itself. It represents the current instance odf the class we are in
        return this;
    }

    public String getUCPageSubTitle(String linkText) {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[normalize-space()=\"" + linkText + "\"]"))).getText();
    }

    public UniversalCreditPage selectUniversalCredit (String linkText) {
        webDriver.findElement(By.xpath("//a[contains(@href, \"" + linkText + "\")]")).click();
        return new UniversalCreditPage (webDriver);

    }
    public BrowseBenefitPage selectTCLink(String linkText) {
        webDriver.findElement(By.xpath("//h3[normalize-space()=\"" + linkText + "\"]")).click();
        return this;
    }
    public String getTCPageSubTitle(String linkText) {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[normalize-space()=\"" + linkText + "\"]"))).getText();
    }
      public TaxCreditCalculatorPage selectTaxCreditsCalculator (String linkText) {
        webDriver.findElement(By.xpath("//a[normalize-space()= \"" + linkText + "\"]")).click();
        return new TaxCreditCalculatorPage (webDriver);

    }

}

