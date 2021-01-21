package test;

import page.PasteBinHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateNewPasteAtPasteBinTest {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Programs\\Selenium\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void createNewPasteAtPasteBin() {
        new PasteBinHomePage(driver)
                .openPage()
                .pasteCode("Hello from WebDriver")
                .setPasteExpirationTime("10 Minutes")
                .pasteNameOrTitle("helloweb")
                .submitInput();
    }

    @AfterMethod
    public void browserShutDown() {
        driver.quit();
        driver = null;
    }
}
