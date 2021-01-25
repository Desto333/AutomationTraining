package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CloudGoogleCalculationResultPage extends AbstractPage {

    public CloudGoogleCalculationResultPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    final String outerIFrameXpath = "//iframe[starts-with(@name,'goog_')]";
    @FindBy(xpath = outerIFrameXpath)
    private WebElement outerIFrame;

    final String innerIFrameXpath = "//iframe[starts-with(@id,'myFrame')]";
    @FindBy(xpath = innerIFrameXpath)
    private WebElement innerIFrame;

    final String rentCostResultXpath = "//b[contains(text(),'Total Estimated Cost')]";
    @FindBy(xpath = rentCostResultXpath)
    private WebElement rentCostResult;

    @Override
    public CloudGoogleCalculationResultPage openPage() {
        return this;
    }

    public String getRentCostFromGooglePage() {
        waitUntilWebElementIsFoundByXpath(outerIFrameXpath);
        driver.switchTo().frame(outerIFrame);
        waitUntilWebElementIsFoundByXpath(innerIFrameXpath);
        driver.switchTo().frame(innerIFrame);
        waitUntilWebElementIsFoundByXpath(rentCostResultXpath);
        logger.info("Received estimated cost of configuration");
        return rentCostResult.getText().replace("Total Estimated Cost: ", "")
                .replace(" per 1 month", "");
    }
}