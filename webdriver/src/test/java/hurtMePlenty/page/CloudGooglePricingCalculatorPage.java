package hurtMePlenty.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CloudGooglePricingCalculatorPage extends AbstractPage {
    public CloudGooglePricingCalculatorPage(WebDriver driver) {
        super(driver);
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

    @FindBy(xpath = "//md-option[@value='free']")
    private WebElement freeDebianOSOption;

    @FindBy(xpath = "//md-select[@placeholder='VM Class']")
    private WebElement machineClassDropDownMenu;

    @FindBy(xpath = "//md-option[@id='select_option_78']//div[@class='md-text']")
    private WebElement regularOption;

    @FindBy(xpath = "//md-select[@placeholder='Series']")
    private WebElement seriesDropDownMenu;

    @FindBy(xpath = "//md-option[@id='select_option_188']//div[@class='md-text ng-binding']")
    private WebElement n1Option;

    @FindBy(xpath = "//md-select[@placeholder='Instance type']")
    private WebElement machineTypeDropDownMenu;

    @FindBy(xpath = "//md-option[@id='select_option_360']//div")
    private WebElement n1Standart8Option;

    @FindBy(xpath = "//md-checkbox//div[contains(text(),'Add GPUs')]")
    private List<WebElement> checkboxAddGPUs;

    @FindBy(xpath = "//md-select[@placeholder='Number of GPUs']")
    private WebElement numberOfGPUsDropDownMenu;

    @FindBy(xpath = "//md-option[@id='select_option_399']//div[@class='md-text ng-binding']")
    private WebElement oneGPUOption;

    @FindBy(xpath = "//md-select[@placeholder='GPU type']")
    private WebElement GPUTypeDropDownMenu;

    @FindBy(xpath = "//md-option[@id='select_option_406']//div[@class='md-text ng-binding']")
    private WebElement teslaV100Option;

    @FindBy(xpath = "//md-select[@placeholder='Local SSD']")
    private WebElement localSSDDropDownMenu;

    @FindBy(xpath = "//md-option[@id='select_option_381']//div[@class='md-text ng-binding']")
    private WebElement twoBy375GbOption;

    @FindBy(xpath = "//md-select[@placeholder='Datacenter location']")
    private WebElement dataCenterLocationDropDownMenu;

    @FindBy(xpath = "//md-option[@id='select_option_206']//div[@class='md-text ng-binding']")
    private WebElement taiwanOption;

    @FindBy(xpath = "//md-select[@placeholder='Committed usage']")
    private WebElement commitedUsageDropDownMenu;

    @FindBy(xpath = "//md-option[@id='select_option_97']//div[@class='md-text']")
    private WebElement oneYearOption;

    @FindBy(xpath = "//button[@class='md-raised md-primary cpc-button md-button md-ink-ripple']")
    private List<WebElement> addToEstimateButtons;

    public CloudGooglePricingCalculatorPage activateComputeEngineSection() {
        waitUntilWebElementIsFoundByXpath(outerIFrameXpath);
        driver.switchTo().frame(outerIFrame);
        waitUntilWebElementIsFoundByXpath(innerIFrameXpath);
        driver.switchTo().frame(innerIFrame);
        waitUntilWebElementIsClickable(computeEngineButton);
        computeEngineButton.click();
        return this;
    }

    public CloudGooglePricingCalculatorPage enterNumberOfInstances(int numberOfInstances) {
        waitUntilWebElementIsFoundByXpath(numberOfInstancesFieldXpath);
        numberOfInstancesField.sendKeys(String.valueOf(numberOfInstances));
        return this;
    }

    public CloudGooglePricingCalculatorPage chooseOperatingSystemSoftware() {
        waitUntilWebElementIsClickable(operatingSystemSoftwareDropDownMenu);
        operatingSystemSoftwareDropDownMenu.click();
        waitUntilWebElementIsClickable(freeDebianOSOption);
        freeDebianOSOption.click();
        return this;
    }

    public CloudGooglePricingCalculatorPage chooseVMClass() {
        waitUntilWebElementIsClickable(machineClassDropDownMenu);
        machineClassDropDownMenu.click();
        waitUntilWebElementIsClickable(regularOption);
        regularOption.click();
        return this;
    }

    public CloudGooglePricingCalculatorPage chooseSeriesAndMachineType() {
        waitUntilWebElementIsClickable(seriesDropDownMenu);
        seriesDropDownMenu.click();
        waitUntilWebElementIsClickable(n1Option);
        n1Option.click();
        waitUntilWebElementIsClickable(machineTypeDropDownMenu);
        machineTypeDropDownMenu.click();
        waitUntilWebElementIsClickable(n1Standart8Option);
        n1Standart8Option.click();
        return this;
    }

    public CloudGooglePricingCalculatorPage addGPUs() {
        waitUntilWebElementIsClickable(checkboxAddGPUs.get(0));
        checkboxAddGPUs.get(0).click();
        waitUntilWebElementIsClickable(numberOfGPUsDropDownMenu);
        numberOfGPUsDropDownMenu.click();
        waitUntilWebElementIsClickable(oneGPUOption);
        oneGPUOption.click();
        waitUntilWebElementIsClickable(GPUTypeDropDownMenu);
        GPUTypeDropDownMenu.click();
        waitUntilWebElementIsClickable(teslaV100Option);
        teslaV100Option.click();
        return this;
    }

    public CloudGooglePricingCalculatorPage chooseLocalSSD() {
        waitUntilWebElementIsClickable(localSSDDropDownMenu);
        localSSDDropDownMenu.click();
        waitUntilWebElementIsClickable(twoBy375GbOption);
        twoBy375GbOption.click();
        return this;
    }

    public CloudGooglePricingCalculatorPage chooseDataCenterLocation() {
        waitUntilWebElementIsClickable(dataCenterLocationDropDownMenu);
        dataCenterLocationDropDownMenu.click();
        waitUntilWebElementIsClickable(taiwanOption);
        taiwanOption.click();
        return this;
    }

    public CloudGooglePricingCalculatorPage setCommitedUsagePeriod() {
        waitUntilWebElementIsClickable(commitedUsageDropDownMenu);
        commitedUsageDropDownMenu.click();
        waitUntilWebElementIsClickable(oneYearOption);
        oneYearOption.click();
        return this;
    }

    public CalculationResultPage pressAddToEstimateToCalculate() {
        waitUntilWebElementIsClickable(addToEstimateButtons.get(0));
        addToEstimateButtons.get(0).click();
        driver.switchTo().defaultContent();
        return new CalculationResultPage(driver);
    }

    public void waitUntilWebElementIsFoundByXpath(String xpath) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(driver -> driver.findElement(By.xpath(xpath)));
    }

    public void waitUntilWebElementIsClickable(WebElement element) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(element));
    }
}