package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.PasteBinHomePage;
import page.PasteBinResultPage;

public class CreateNewPasteAtPasteBinTest {
    private WebDriver driver;


    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Programs\\Selenium\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void createNewPasteAtPasteBin() {
        PasteBinResultPage resultPage = new PasteBinHomePage(driver)
                .openPage()
                .pasteCodeFromFile("src/test/resources/code.dat")
                .setSyntaxHighLighting("Bash")
                .setPasteExpirationTime("10 Minutes")
                .pasteNameOrTitle("how to gain dominance among developers")
                .submitInput();

        Assert.assertEquals(resultPage.getTitle(), "how to gain dominance among developers");
        Assert.assertEquals(resultPage.getSyntaxHighlighting(), "Bash");
        Assert.assertEquals(resultPage.getPastedCode()
                , resultPage.expectedCodeFromFile("src/test/resources/code.dat"));
    }

    @AfterMethod
    public void browserShutDown() {
        driver.quit();
        driver = null;
    }
}
