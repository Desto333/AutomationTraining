package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
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

    public TenMinuteMailPage createEmailAddress() throws IOException, UnsupportedFlavorException, InterruptedException {
        driver.get(TEN_MINUTE_MAIL_URL);
        waitUntilWebElementIsFoundByXpath(copyAddressButtonXpath);
        copyAddressButton.click();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        String emailAddress = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
        EXCHANGER.exchange(emailAddress);
        return this;
    }

    public String getPriceEstimateFromEmail() {
        waitUntilWebElementIsFoundByXpath(emailMessageWithPriceEstimateXpath);
        emailMessageWithPriceEstimate.click();
        waitUntilWebElementIsFoundByXpath(emailPriceEstimateResultsXpath);
        return emailPriceEstimateResults.get(1).getText();
    }

    private void waitUntilWebElementIsFoundByXpath(String xpath) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(driver -> driver.findElement(By.xpath(xpath)));
    }
}
