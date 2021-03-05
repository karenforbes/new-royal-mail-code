package uk.co.tui.HolidayChallenge;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AllBeachHolidaysPage {


    private WebDriver webDriver;

    public AllBeachHolidaysPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String confirmAllBeachHolidaysPage() {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        //The xpath needed expressing like this as there are 2 H2's on the page. It is selecting the first one.
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='bestfor']//h2[1]"))).getText();
    }

    public LuxuryHolidaysPage navigateToLuxuryHolidaysPage() {
        webDriver.findElement(By.xpath("//a[@id='BestFor:Luxury']//div[@class='pseudo-container']")).click();
        return new LuxuryHolidaysPage(webDriver);
    }
}
