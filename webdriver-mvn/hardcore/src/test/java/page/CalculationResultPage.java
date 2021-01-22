package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CalculationResultPage extends AbstractPage {
    private static final String TEN_MINUTE_MAIL_URL = "https://10minutemail.com/";

    public CalculationResultPage(WebDriver driver) {
        super(driver);
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

    public String getRentCostFromGooglePage() throws InterruptedException {
        waitUntilWebElementIsFoundByXpath(outerIFrameXpath);
        driver.switchTo().frame(outerIFrame);
        waitUntilWebElementIsFoundByXpath(innerIFrameXpath);
        driver.switchTo().frame(innerIFrame);
        waitUntilWebElementIsFoundByXpath(rentCostResultXpath);
        return rentCostResult.getText().replace("Total Estimated Cost: ", "")
                .replace(" per 1 month", "");
    }
}