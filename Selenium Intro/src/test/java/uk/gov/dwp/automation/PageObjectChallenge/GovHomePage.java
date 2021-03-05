package uk.gov.dwp.automation.PageObjectChallenge;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class GovHomePage {

        private WebDriver webDriver;



    //constructor
    //this is assigning the private class WebDriver webdriver here
        public GovHomePage(WebDriver webdriver) {
        this.webDriver = webdriver;
    }

    public String acceptCookies() {
        webDriver.findElement(By.xpath("//button['Cookie banner accepted']")).click();
        return null;
    }
       /*this method allows me to click any link on the gov.uk home page - need to ask why a[text]. Is it because
        every link on the page is a and if it wasn't you would need another webdriver.findElement here?
         */
        /*when a function triggers navigation to another page it should also tell us which page it is navigating too
        by using a return
        */
        /*The next line is saying this is what I want to do (BrowseGovSupportPages) and this is how I want to do it
        (selectLinkFromPage). This is reusable as it is generic and not specific to a particular link and the test in
        another class tells this method/function which link to click i.e benefits
        */
        public BrowseBenefitPage selectLinkFromPage (String linkText){
            webDriver.findElement(By.xpath("//a[text()=\"" + linkText + "\"]")).click();
            return new BrowseBenefitPage(webDriver);

    }
        public BrowseVisasAndImmigrationPage selectVisasAndImmigrationLink(String linkText) {
            webDriver.findElement(By.xpath("//h3[@class='home-services__heading']//a[@class='govuk-link'][normalize-space()=\"" + linkText + "\"]")).click();
            return new BrowseVisasAndImmigrationPage(webDriver);
    }

}