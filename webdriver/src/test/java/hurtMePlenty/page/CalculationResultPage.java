package hurtMePlenty.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CalculationResultPage extends AbstractPage {

    public CalculationResultPage(WebDriver driver) {
        super(driver);
    }

    final String outerIFrameXpath = "//iframe[starts-with(@name,'goog_')]";
    @FindBy(xpath = outerIFrameXpath)
    private WebElement outerIFrame;

    final String innerIFrameXpath = "//iframe[starts-with(@id,'myFrame')]";
    @FindBy(xpath = innerIFrameXpath)
    private WebElement innerIFrame;

    final String vmClassResultXpath = "//md-card-content[@id='resultBlock']//md-list-item//div[contains(text(),'VM class')]";
    @FindBy(xpath = vmClassResultXpath)
    private WebElement vmClassResult;

    @FindBy(xpath = "//md-card-content[@id='resultBlock']//md-list-item//div[contains(text(),'Instance type:')]")
    private WebElement instanceTypeResult;

    @FindBy(xpath = "//md-card-content[@id='resultBlock']//md-list-item//div[contains(text(),'Region:')]")
    private WebElement datacenterLocationResult;

    @FindBy(xpath = "//md-card-content[@id='resultBlock']//md-list-item//div[contains(text(),'Total available local SSD space')]")
    private WebElement localSSDResult;

    @FindBy(xpath = "//md-card-content[@id='resultBlock']//md-list-item//div[contains(text(),'Commitment term: ')]")
    private WebElement commitmentTermResult;

    @FindBy(xpath = "//b[contains(text(),'Total Estimated Cost')]")
    private WebElement rentCostResult;

    public CalculationResultPage checkVMClassCompliance(String expectedVMClass) {
        waitUntilWebElementIsFoundByXpath(outerIFrameXpath);
        driver.switchTo().frame(outerIFrame);
        waitUntilWebElementIsFoundByXpath(innerIFrameXpath);
        driver.switchTo().frame(innerIFrame);
        waitUntilWebElementIsFoundByXpath(vmClassResultXpath);
        String actualVMClass = vmClassResult.getText().split("VM class: ")[1];
        Assert.assertTrue(actualVMClass.equalsIgnoreCase(expectedVMClass));
        return this;
    }

    public CalculationResultPage checkInstanceTypeCompliance(String expectedInstanceType) {
        String actualInstanceType = instanceTypeResult.getText().split("Instance type: ")[1];
        Assert.assertTrue(actualInstanceType.equalsIgnoreCase(expectedInstanceType));
        return this;
    }

    public CalculationResultPage checkDatacenterLocationCompliance(String expectedDatacenterLocation) {
        String actualDatacenterLocation = datacenterLocationResult.getText().split("Region: ")[1];
        Assert.assertTrue(actualDatacenterLocation.equalsIgnoreCase(expectedDatacenterLocation));
        return this;
    }

    public CalculationResultPage checkLocalSSDCompliance(String expectedLocalSSDSpace) {
        String actualLocalSSDSpace = localSSDResult.getText().split("Total available local SSD space ")[1];
        Assert.assertTrue(actualLocalSSDSpace.equalsIgnoreCase(expectedLocalSSDSpace));
        return this;
    }

    public CalculationResultPage checkCommitmentTermCompliance(String expectedCommitmentTerm) {
        String actualCommitmentTerm = commitmentTermResult.getText().split("Commitment term: ")[1];
        Assert.assertTrue(actualCommitmentTerm.equalsIgnoreCase(expectedCommitmentTerm));
        return this;
    }

    public void checkRentCostEquality() {
        try (BufferedReader reader = new BufferedReader(
                new FileReader("src/test/java/hurtMePlenty/manualCalculationResult.txt"))) {
            String automatedRenCost = rentCostResult.getText();
            String manualRentCost = reader.readLine();
            Assert.assertEquals(automatedRenCost, manualRentCost);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void waitUntilWebElementIsFoundByXpath(String xpath) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(driver -> driver.findElement(By.xpath(xpath)));
    }
}
