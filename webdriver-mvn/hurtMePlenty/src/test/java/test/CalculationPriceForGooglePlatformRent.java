package test;

import page.CloudGoogleStartPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CalculationPriceForGooglePlatformRent {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Programs\\Selenium\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void calculatePriceForGooglePlatformRent() {
        new CloudGoogleStartPage(driver)
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
                .checkVMClassCompliance("Regular")
                .checkInstanceTypeCompliance("n1-standard-8")
                .checkDatacenterLocationCompliance("Taiwan")
                .checkLocalSSDCompliance("2x375 GiB")
                .checkCommitmentTermCompliance("1 year")
                .checkRentCostEquality();
    }

    @AfterMethod
    public void browserShutDown() {
        driver.quit();
        driver = null;
    }
}
