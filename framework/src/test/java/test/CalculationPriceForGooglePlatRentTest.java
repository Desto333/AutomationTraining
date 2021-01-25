package test;

import model.PlatformConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.CloudGoogleStartPage;
import page.TenMinuteMailPage;
import service.PlatformConfigurationCreator;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class CalculationPriceForGooglePlatRentTest extends CommonConditions {

    @Test
    public void compareGooglePageAndEmailResults() throws IOException, UnsupportedFlavorException {
        PlatformConfiguration testConfig = PlatformConfigurationCreator.createTestConfiguration();
        String resultGooglePage = new CloudGoogleStartPage(driver)
                .openPage()
                .sendSearchRequestFromStartPage(testConfig.getSearchRequest())
                .followTheLinkNamed(testConfig.getSearchRequest())
                .activateComputeEngineSection()
                .enterNumberOfInstances(testConfig.getNumberOfInstances())
                .chooseOperatingSystemSoftware(testConfig.getOperatingSystem())
                .chooseVMClass(testConfig.getVmClass())
                .chooseSeriesAndMachineType(testConfig.getSeries(), testConfig.getMachineType())
                .addGPUs(testConfig.isAddGPUs(), testConfig.getNumberOfGPU(), testConfig.getTypeGPU())
                .chooseLocalSSD(testConfig.getLocalSSD())
                .chooseDataCenterLocation(testConfig.getLocationOfDatacenter())
                .setCommittedUsagePeriod(testConfig.getCommittedUsagePeriod())
                .pressAddToEstimateToCalculate()
                .getRentCostFromGooglePage();

        String resultEmail = new TenMinuteMailPage(driver).getPriceEstimateFromEmail();

        Assert.assertEquals(resultEmail, resultGooglePage);
    }
}