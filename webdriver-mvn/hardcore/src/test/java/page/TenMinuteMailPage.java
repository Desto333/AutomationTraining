package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

public class TenMinuteMailPage extends AbstractPage {
    private static final String TEN_MINUTE_MAIL_URL = "https://10minutemail.com/";
    public static final Exchanger<String> EXCHANGER = new Exchanger<>();

    public TenMinuteMailPage(WebDriver driver) {
        super(driver);
    }

    final String copyAddressButtonXpath = "//span[@class='copy_icon']";
    @FindBy(xpath = copyAddressButtonXpath)
    private WebElement copyAddressButton;

    final String emailMessageWithPriceEstimateXpath
            = "//div[@class='mail_message']//span[contains(text(),'Google Cloud Platform Price Estimate')]";
    @FindBy(xpath = emailMessageWithPriceEstimateXpath)
    private WebElement emailMessageWithPriceEstimate;

    final String emailPriceEstimateResultsXpath = "//table[@class='quote']//td//h3";
    @FindBy(xpath = emailPriceEstimateResultsXpath)
    private List<WebElement> emailPriceEstimateResults;

    final String bodyGoogleCloudXpath = "//body[@type='marketing']";
    @FindBy(xpath = bodyGoogleCloudXpath)
    private WebElement bodyGoogleCloud;

    @FindBy(xpath = "//button[contains(text(),'Email Estimate')]")
    private WebElement emailEstimateButton;

    final String emailYourEstimateFormXpath = "//form[@name='emailForm']";
    @FindBy(xpath = emailYourEstimateFormXpath)
    private WebElement emailYourEstimateForm;

    @FindBy(xpath = "//input[@id='input_477']")
    private WebElement emailInputField;

    @FindBy(xpath = "//button[contains(text(),'Send Email')]")
    private WebElement sendEmailButton;

    final String outerIFrameXpath = "//iframe[starts-with(@name,'goog_')]";
    @FindBy(xpath = outerIFrameXpath)
    private WebElement outerIFrame;

    final String innerIFrameXpath = "//iframe[starts-with(@id,'myFrame')]";
    @FindBy(xpath = innerIFrameXpath)
    private WebElement innerIFrame;

    public String getPriceEstimateFromEmail() throws IOException, UnsupportedFlavorException {
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get(TEN_MINUTE_MAIL_URL);
        waitUntilWebElementIsFoundByXpath(copyAddressButtonXpath);
        copyAddressButton.click();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        String emailAddress = (String) Toolkit.getDefaultToolkit()
                .getSystemClipboard().getData(DataFlavor.stringFlavor);
        driver.switchTo().window(tabs.get(0));
        waitUntilWebElementIsFoundByXpath(outerIFrameXpath);
        driver.switchTo().frame(outerIFrame);
        waitUntilWebElementIsFoundByXpath(innerIFrameXpath);
        driver.switchTo().frame(innerIFrame);
        waitUntilWebElementIsClickable(emailEstimateButton);
        emailEstimateButton.click();
        waitUntilWebElementIsFoundByXpath(emailYourEstimateFormXpath);
        emailInputField.sendKeys(emailAddress);
        waitUntilWebElementIsClickable(sendEmailButton);
        sendEmailButton.click();
        driver.switchTo().window(tabs.get(1));
        waitUntilWebElementIsFoundByXpath(emailMessageWithPriceEstimateXpath);
        emailMessageWithPriceEstimate.click();
        waitUntilWebElementIsFoundByXpath(emailPriceEstimateResultsXpath);
        return emailPriceEstimateResults.get(1).getText();
    }
}
