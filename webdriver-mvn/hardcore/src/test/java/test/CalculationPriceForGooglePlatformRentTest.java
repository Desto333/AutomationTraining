package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.CloudGoogleStartPage;
import page.TenMinuteMailPage;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class CalculationPriceForGooglePlatformRentTest {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Programs\\Selenium\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void compareGooglePageAndEmailResults() throws InterruptedException, ExecutionException, IOException, UnsupportedFlavorException {
        String resultGooglePage = new CloudGoogleStartPage(driver)
                .openStartPage()
                .sendSearchRequestFromStartPage("Google Cloud Platform Pricing Calculator")
                .followTheLinkNamed("Google Cloud Platform Pricing Calculator")
                .activateComputeEngineSection()
                .enterNumberOfInstances(4)
                .chooseOperatingSystemSoftware()
                .chooseVMClass()
                .chooseSeriesAndMachineType()
                .addGPUs()
                .chooseLocalSSD()
                .chooseDataCenterLocation()
                .setCommitedUsagePeriod()
                .pressAddToEstimateToCalculate()
                .getRentCostFromGooglePage();

        String resultEmail = new TenMinuteMailPage(driver).getPriceEstimateFromEmail();

        Assert.assertEquals(resultEmail, resultGooglePage);
    }

    @AfterMethod
    public void browsersShutDown() {
        driver.quit();
        driver = null;
    }

}
