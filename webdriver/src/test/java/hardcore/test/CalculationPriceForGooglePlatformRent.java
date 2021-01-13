package hardcore.test;

import hardcore.page.CloudGoogleStartPage;
import hardcore.page.TenMinuteMailPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CalculationPriceForGooglePlatformRent {
    private WebDriver driver1;
    private WebDriver driver2;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Programs\\Selenium\\chromedriver.exe");
        driver1 = new ChromeDriver();
        driver2 = new ChromeDriver();
    }

    @Test
    public void compareGooglePageAndEmailResults() throws InterruptedException, ExecutionException {
        ExecutorService exec = Executors.newCachedThreadPool();
        Future<String> resultFromGooglePage = exec.submit(this::calculatePriceForGooglePlatformRent);
        Future<String> resultFromEmail = exec.submit(this::receiveResultToEmail);
        exec.shutdown();
        Assert.assertEquals(resultFromEmail.get(), resultFromGooglePage.get());
    }

    public String calculatePriceForGooglePlatformRent() throws InterruptedException {
        return new CloudGoogleStartPage(driver1)
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
    }

    public String receiveResultToEmail() throws IOException, UnsupportedFlavorException, InterruptedException {
        return new TenMinuteMailPage(driver2)
                .createEmailAddress()
                .getPriceEstimateFromEmail();
    }

    @AfterMethod
    public void browsersShutDown() {
        driver1.quit();
        driver2.quit();
        driver1 = null;
        driver2 = null;
    }
}
