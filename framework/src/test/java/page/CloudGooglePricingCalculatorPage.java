package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CloudGooglePricingCalculatorPage extends AbstractPage {

    public CloudGooglePricingCalculatorPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    final String outerIFrameXpath = "//iframe[starts-with(@name,'goog_')]";
    @FindBy(xpath = outerIFrameXpath)
    private WebElement outerIFrame;

    final String innerIFrameXpath = "//iframe[@id='myFrame']";
    @FindBy(xpath = innerIFrameXpath)
    private WebElement innerIFrame;

    @FindBy(xpath = "//md-tab-item//div[text()='Compute Engine']")
    private WebElement computeEngineButton;

    final String numberOfInstancesFieldXpath = "//input[@id='input_63']";
    @FindBy(xpath = numberOfInstancesFieldXpath)
    private WebElement numberOfInstancesField;

    @FindBy(xpath = "//md-select[@id='select_76']")
    private WebElement operatingSystemSoftwareDropDownMenu;

    @FindBy(xpath = "//md-select[@placeholder='VM Class']")
    private WebElement machineClassDropDownMenu;

    @FindBy(xpath = "//md-select[@placeholder='Series']")
    private WebElement seriesDropDownMenu;

    @FindBy(xpath = "//md-select[@placeholder='Instance type']")
    private WebElement machineTypeDropDownMenu;

    @FindBy(xpath = "//md-checkbox//div[contains(text(),'Add GPUs')]")
    private List<WebElement> checkboxAddGPUs;

    final String numberOfGPUsDropDownMenuXpath = "//md-select[@placeholder='Number of GPUs']";
    @FindBy(xpath = numberOfGPUsDropDownMenuXpath)
    private WebElement numberOfGPUsDropDownMenu;

    @FindBy(xpath = "//md-select[@placeholder='GPU type']")
    private WebElement GPUTypeDropDownMenu;

    @FindBy(xpath = "//md-select[@placeholder='Local SSD']")
    private WebElement localSSDDropDownMenu;

    @FindBy(xpath = "//md-select[@placeholder='Datacenter location']")
    private WebElement dataCenterLocationDropDownMenu;

    @FindBy(xpath = "//md-select[@placeholder='Committed usage']")
    private WebElement committedUsageDropDownMenu;

    @FindBy(xpath = "//button[@class='md-raised md-primary cpc-button md-button md-ink-ripple']")
    private List<WebElement> addToEstimateButtons;

    @Override
    public CloudGooglePricingCalculatorPage openPage() {
        return this;
    }

    public CloudGooglePricingCalculatorPage activateComputeEngineSection() {
        waitUntilWebElementIsFoundByXpath(outerIFrameXpath);
        driver.switchTo().frame(outerIFrame);
        waitUntilWebElementIsFoundByXpath(innerIFrameXpath);
        driver.switchTo().frame(innerIFrame);
        waitUntilWebElementIsClickable(computeEngineButton);
        computeEngineButton.click();
        logger.info("Activated Compute Engine section");
        return this;
    }

    public CloudGooglePricingCalculatorPage enterNumberOfInstances(String numberOfInstances) {
        waitUntilWebElementIsFoundByXpath(numberOfInstancesFieldXpath);
        numberOfInstancesField.sendKeys(String.valueOf(numberOfInstances));
        logger.info("Entered number of instances: " + numberOfInstances);
        return this;
    }

    public CloudGooglePricingCalculatorPage chooseOperatingSystemSoftware(String operatingSystem) {
        waitUntilWebElementIsClickable(operatingSystemSoftwareDropDownMenu);
        operatingSystemSoftwareDropDownMenu.click();
        WebElement OSOption = driver.findElement(By.xpath("//md-option//div[contains(text(),'"
                + operatingSystem + "')]"));
        waitUntilWebElementIsClickable(OSOption);
        OSOption.click();
        logger.info("Choose Operating System: " + operatingSystem);
        return this;
    }

    public CloudGooglePricingCalculatorPage chooseVMClass(String vmClass) {
        waitUntilWebElementIsClickable(machineClassDropDownMenu);
        machineClassDropDownMenu.click();
        WebElement vmClassOption = driver
                .findElement(By.xpath("//div[@id='select_container_81']//div[contains(text(),'" + vmClass + "')]"));
        waitUntilWebElementIsClickable(vmClassOption);
        vmClassOption.click();
        logger.info("Choose VM Class: " + vmClass);
        return this;
    }

    public CloudGooglePricingCalculatorPage chooseSeriesAndMachineType(String series, String machineType) {
        waitUntilWebElementIsClickable(seriesDropDownMenu);
        seriesDropDownMenu.click();
        WebElement seriesOption = driver.findElement
                (By.xpath("//div[@id='select_container_89']//md-option//div[contains(text(),'" + series + "')]"));
        waitUntilWebElementIsClickable(seriesOption);
        seriesOption.click();
        logger.info("Choose series: " + series);
        waitUntilWebElementIsClickable(machineTypeDropDownMenu);
        machineTypeDropDownMenu.click();
        WebElement machineTypeOption = driver.findElement
                (By.xpath("//div[@id='select_container_91']//md-option//div[contains(text(),'" + machineType + "')]"));
        waitUntilWebElementIsClickable(machineTypeOption);
        machineTypeOption.click();
        logger.info("Choose Machine type: " + machineType);
        return this;
    }

    public CloudGooglePricingCalculatorPage addGPUs(String addGPUs, String numberOfGPU, String typeOfGPU) {
        if (Boolean.parseBoolean(addGPUs)) {
            waitUntilWebElementIsClickable(checkboxAddGPUs.get(0));
            checkboxAddGPUs.get(0).click();
            logger.info("Clicked Add GPUs checkbox");
            waitUntilWebElementIsClickable(numberOfGPUsDropDownMenu);
            numberOfGPUsDropDownMenu.click();
            WebElement numberOfGPUsOption = driver.findElement(By
                    .xpath("//div[@id='select_container_395']//md-option[@value='" + numberOfGPU + "']"));
            waitUntilWebElementIsClickable(numberOfGPUsOption);
            numberOfGPUsOption.click();
            logger.info("Choose number of GPUs: " + numberOfGPU);
            waitUntilWebElementIsClickable(GPUTypeDropDownMenu);
            GPUTypeDropDownMenu.click();
            WebElement typeGPUOption = driver.findElement(By
                    .xpath("//div[@id='select_container_397']//div[contains(text(),'" + typeOfGPU + "')]"));
            waitUntilWebElementIsClickable(typeGPUOption);
            typeGPUOption.click();
            logger.info("Choose GPU type: " + typeOfGPU);
        } else {
            logger.info("No GPUs added");
        }
        return this;
    }

    public CloudGooglePricingCalculatorPage chooseLocalSSD(String localSSD) {
        waitUntilWebElementIsClickable(localSSDDropDownMenu);
        localSSDDropDownMenu.click();
        WebElement localSSDOption = driver.findElement(By
                .xpath("//div[@id='select_container_356']//div[contains(text(),'" + localSSD + "')]"));
        waitUntilWebElementIsClickable(localSSDOption);
        localSSDOption.click();
        logger.info("Choose Local SSD: " + localSSD);
        return this;
    }

    public CloudGooglePricingCalculatorPage chooseDataCenterLocation(String locationOfDatacenter) {
        waitUntilWebElementIsClickable(dataCenterLocationDropDownMenu);
        dataCenterLocationDropDownMenu.click();
        WebElement dataCenterLocationOption = driver.findElement(By
                .xpath("//div[@id='select_container_93']//div[contains(text(),'" + locationOfDatacenter + "')]"));
        waitUntilWebElementIsClickable(dataCenterLocationOption);
        dataCenterLocationOption.click();
        logger.info("Choose Datacenter location: " + locationOfDatacenter);
        return this;
    }

    public CloudGooglePricingCalculatorPage setCommittedUsagePeriod(String committedUsagePeriod) {
        waitUntilWebElementIsClickable(committedUsageDropDownMenu);
        committedUsageDropDownMenu.click();
        WebElement committedUsageOption = driver.findElement(By
                .xpath("//div[@id='select_container_100']//div[contains(text(),'" + committedUsagePeriod + "')]"));
        waitUntilWebElementIsClickable(committedUsageOption);
        committedUsageOption.click();
        logger.info("Choose Committed usage period: " + committedUsagePeriod);
        return this;
    }

    public CloudGoogleCalculationResultPage pressAddToEstimateToCalculate() {
        waitUntilWebElementIsClickable(addToEstimateButtons.get(0));
        addToEstimateButtons.get(0).click();
        driver.switchTo().defaultContent();
        logger.info("Pressed Estimate button to get the price");
        return new CloudGoogleCalculationResultPage(driver);
    }
}