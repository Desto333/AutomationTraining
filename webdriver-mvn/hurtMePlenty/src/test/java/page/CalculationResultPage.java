package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.BufferedReader;
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

    public String getVMClass() {
        waitUntilWebElementIsFoundByXpath(outerIFrameXpath);
        driver.switchTo().frame(outerIFrame);
        waitUntilWebElementIsFoundByXpath(innerIFrameXpath);
        driver.switchTo().frame(innerIFrame);
        waitUntilWebElementIsFoundByXpath(vmClassResultXpath);
        return vmClassResult.getText().split("VM class: ")[1];
    }

    public String getInstanceType() {
        return instanceTypeResult.getText().split("Instance type: ")[1];
    }

    public String getDatacenterLocation() {
        return datacenterLocationResult.getText().split("Region: ")[1];
    }

    public String getLocalSSD() {
        return localSSDResult.getText().split("Total available local SSD space ")[1];
    }

    public String getCommitmentTerm() {
        return commitmentTermResult.getText().split("Commitment term: ")[1];
    }

    public String getAutomatedRentCost() {
        return rentCostResult.getText();
    }

    public String getManualRentCostFromFile(String filePath) {
        String manualRentCost = "";
        try (BufferedReader reader = new BufferedReader(
                new FileReader(filePath))) {
            manualRentCost = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return manualRentCost;
    }
}
