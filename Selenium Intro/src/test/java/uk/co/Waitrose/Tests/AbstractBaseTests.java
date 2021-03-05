package uk.co.Waitrose.Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AbstractBaseTests {

    public static WebDriver webDriver;

    @BeforeAll
    public static void setupClass() {
        WebDriverManager.chromedriver().clearDriverCache().setup();
    }

    @BeforeEach
    public void setupWebDriver() {
        webDriver = new ChromeDriver();
        webDriver.get("https://www.waitrose.com/");
    }

//    @AfterEach
//    public void tearDown() {
//        webDriver.quit();
//    }
}
