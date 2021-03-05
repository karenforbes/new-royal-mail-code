package uk.gov.dwp.automation.PageObjectChallenge;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActualTaxCreditCalculatorPage {

    private WebDriver webDriver;

    public ActualTaxCreditCalculatorPage (WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    public String getPageTitle(String linkText) {
        //if this comes back with cookies may need to change the by to By.CSS, By .ID, By.Name etc
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        //use selectors hub to find the path name of the element
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[normalize-space()=\"" + linkText + "\"]"))).getText();
    }
}
