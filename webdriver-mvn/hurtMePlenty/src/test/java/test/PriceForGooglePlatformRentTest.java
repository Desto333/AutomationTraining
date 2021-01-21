package test;

import org.testng.Assert;
import page.CalculationResultPage;
import page.CloudGoogleStartPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PriceForGooglePlatformRentTest {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Programs\\Selenium\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void calculatePriceForGooglePlatformRent() {
        CalculationResultPage calculationResultPage = new CloudGoogleStartPage(driver)
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
                .pressAddToEstimateToCalculate();

        Assert.assertTrue(calculationResultPage.getVMClass().equalsIgnoreCase("Regular"));
        Assert.assertTrue(calculationResultPage.getInstanceType().equalsIgnoreCase("n1-standard-8"));
        Assert.assertTrue(calculationResultPage.getDatacenterLocation().equalsIgnoreCase("Taiwan"));
        Assert.assertTrue(calculationResultPage.getLocalSSD().equalsIgnoreCase("2x375 GiB"));
        Assert.assertTrue(calculationResultPage.getCommitmentTerm().equalsIgnoreCase("1 year"));
        Assert.assertEquals(calculationResultPage.getAutomatedRentCost(),
                calculationResultPage.getManualRentCostFromFile("src/test/resources/manualCalculationResult.txt"));
    }

    @AfterMethod
    public void browserShutDown() {
        driver.quit();
        driver = null;
    }
}
