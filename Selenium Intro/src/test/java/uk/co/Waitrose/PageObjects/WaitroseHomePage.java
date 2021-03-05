package uk.co.Waitrose.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class WaitroseHomePage extends AbstractBasePage {

    public WaitroseHomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public RegisterAccountPage navigateToRegisterAccountPage(String linkText) {
        webDriver.findElement(By.xpath("//a[normalize-space()=\"" + linkText + "\"]")).click();
        return new RegisterAccountPage(webDriver);
    }

    public SignInPage navigateToSignInPage(String linkText) {
        webDriver.findElement(By.xpath("//a[normalize-space()=\"" + linkText + "\"]")).click();
        return new SignInPage(webDriver);
    }

    public WaitroseHomePage confirmWaitroseHomePageFollowingSignIn() {
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[2]/div[2]/header/span[1]/*[local-name()='svg']/*[1]"))).getText();
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[2]/div[2]/header/span[1]/*[local-name()='svg']/title[@Waitrose and Partners]"))).getText();
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//title[@Waitrose and Partners]"))).getText();
        return this;
         }

    public DeliverySlotPage navigateToBookASlotPage () {
        //wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[data-test='slot-button-desktop']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section/div[2]/div/div/a/span"))).click();
        return new DeliverySlotPage(webDriver);
    }

}


