package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    final String rentCostResultXpath = "//b[contains(text(),'Total Estimated Cost')]";
    @FindBy(xpath = rentCostResultXpath)
    private WebElement rentCostResult;

    @FindBy(xpath = "//button[contains(text(),'Email Estimate')]")
    private WebElement emailEstimateButton;

    final String emailYourEstimateFormXpath = "//form[@name='emailForm']";
    @FindBy(xpath = emailYourEstimateFormXpath)
    private WebElement emailYourEstimateForm;

    @FindBy(xpath = "//input[@id='input_477']")
    private WebElement emailInputField;

    @FindBy(xpath = "//button[contains(text(),'Send Email')]")
    private WebElement sendEmailButton;

    public String getRentCostFromGooglePage() throws InterruptedException {
        waitUntilWebElementIsFoundByXpath(outerIFrameXpath);
        driver.switchTo().frame(outerIFrame);
        waitUntilWebElementIsFoundByXpath(innerIFrameXpath);
        driver.switchTo().frame(innerIFrame);
        waitUntilWebElementIsFoundByXpath(rentCostResultXpath);
        emailEstimateButton.click();
        waitUntilWebElementIsFoundByXpath(emailYourEstimateFormXpath);
        String emailAddressToSendResults = TenMinuteMailPage.EXCHANGER.exchange("");
        emailInputField.sendKeys(emailAddressToSendResults);
        sendEmailButton.click();
        return rentCostResult.getText().replace("Total Estimated Cost: ", "")
                .replace(" per 1 month", "");
    }

    private void waitUntilWebElementIsFoundByXpath(String xpath) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(driver -> driver.findElement(By.xpath(xpath)));
    }
}
