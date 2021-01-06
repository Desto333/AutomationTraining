package bringItOn.test;

import bringItOn.page.PasteBinHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateNewPasteAtPasteBinScript {
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
                .pasteCodeFromFile("src/test/java/bringItOn/code.dat")
                .setSyntaxHighLighting("Bash")
                .setPasteExpirationTime("10 Minutes")
                .pasteNameOrTitle("how to gain dominance among developers")
                .submitInput()
                .checkPageTitle("how to gain dominance among developers")
                .checkSyntaxHighlighting("Bash")
                .checkPastedCode("src/test/java/bringItOn/code.dat");
    }

    @AfterMethod
    public void browserShutDown() {
        driver.quit();
        driver = null;
    }
}
