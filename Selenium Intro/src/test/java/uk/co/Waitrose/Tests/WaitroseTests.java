package uk.co.Waitrose.Tests;

import org.junit.jupiter.api.Test;
import uk.co.Waitrose.PageObjects.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class WaitroseTests extends AbstractBaseTests {


    @Test
    public void signUpForAnAccount() throws InterruptedException {
        //webDriver.get("https://www.waitrose.com/");
        WaitroseHomePage waitroseHomePage = new WaitroseHomePage(webDriver);
        waitroseHomePage.acceptCookies();
        RegisterAccountPage registerAccountPage = waitroseHomePage.navigateToRegisterAccountPage("Register");
        assertThat("", registerAccountPage.confirmRegisterAccount("Register"), is(("REGISTER")));
        registerAccountPage.selectTitle()
                .inputFirstName("Gemma")
                .inputLastName("Jones")
                .inputContactNumber("07729745852")
                .findAddress("pr254zb")
                .continueToCompleteRegistration();
        assertThat("", registerAccountPage.confirmAccountAccepted(), is(("4 Murray Street")));

    }

    @Test
    public void selectASlot() throws InterruptedException {
        WaitroseHomePage waitroseHomePage = new WaitroseHomePage(webDriver);
        waitroseHomePage.acceptCookies();
        SignInPage signInPage = waitroseHomePage.navigateToSignInPage("Sign in");
        assertThat("", signInPage.confirmSignInPage("Sign in"), is(("SIGN IN")));
        signInPage.inputEmail("kforbes201017@gmail.com")
                .inputPassword("windmill1");
        //assertThat("", waitroseHomePage.confirmWaitroseHomePageFollowingSignIn(), is("WAITROSE AND PARTNERS"));
        DeliverySlotPage deliverySlotPage = waitroseHomePage.navigateToBookASlotPage();
        assertThat("", deliverySlotPage.confirmDeliverySlotPage("Choose your shopping method"), is(("Choose your shopping method")));
        HomeDeliverySelectionPage homeDeliverySelectionPage = deliverySlotPage.chooseHomeDelivery("Choose home delivery");
        assertThat("", homeDeliverySelectionPage.confirmHomeDeliverySelectionPage("Choose your slot"), is(("Choose your slot")));
        BookACollectionPage bookACollectionPage = homeDeliverySelectionPage.noSlotsBookACollection();
        assertThat("", bookACollectionPage.confirmBookACollectionPage("What are you shopping for?"), is(("WHAT ARE YOU SHOPPING FOR?")));
        bookACollectionPage.selectGroceries("Groceries");
        ChooseAStorePage chooseAStorePage = bookACollectionPage.navigateToChooseAStorePage("Continue");
        assertThat("", chooseAStorePage.confirmChooseAStorePage("Choose a store for collection"), is(("Choose a store for collection")));
        chooseAStorePage.chooseAStore();
        chooseAStorePage.lookForAvailableSlot("Monday 22nd March 6pm - 7pm");
            //String lookForAvailableSlot =  "Monday 22nd March 6pm - 7pm";
//            boolean lookForAvailableSlot = false;
//            while (lookForAvailableSlot) {
//                if (webDriver.findElements(By.xpath("//button/i[contains(@class, \"Success\")]")).size() == 0)
//                    webDriver.findElement(By.id("later")).click();
//                } else {
//                    continue;
//                }
//                break;
//            }
//            chooseAStorePage.selectGroceriesLink();
        }
    }




//    @Test
//    public void testScratch() {
//        String targetDeliveryDate = "Tuesday 3rd March";
//        boolean foundSlot = false;
//        while(foundSlot) {
//            if(webDriver.findElements(By.xpath("//button/i[contains(@class, \"Success\")]")).size() == 0) {
//                webDriver.findElement(By.id("nextPage")).click();
//            }
//            if(findSlot(targetDeliveryDate)) break;
//        }
//    }
//    private boolean findSlot(String targetDate) {
//        List<WebElement> availableSlots = webDriver.findElements(By.xpath("//button/i[contains(@class, \"Success\")]"));
//        for(WebElement availableSlot : availableSlots) {
//            if(availableSlot.getAttribute("aria-label").contains(targetDate)) {
//                availableSlot.click();
//                return true;
//            }
//        }
//        return false;
//    }