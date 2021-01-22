package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CloudGoogleSearchResultPage extends AbstractPage {

    public CloudGoogleSearchResultPage(WebDriver driver) {
        super(driver);
    }

    public CloudGooglePricingCalculatorPage followTheLinkNamed(String linkName) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(By.linkText(linkName)));
        driver.findElement(By.linkText(linkName)).click();
        return new CloudGooglePricingCalculatorPage(driver);
    }
}