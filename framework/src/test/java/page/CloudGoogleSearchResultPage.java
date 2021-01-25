package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CloudGoogleSearchResultPage extends AbstractPage {


    @Override
    public CloudGoogleSearchResultPage openPage() {
        return this;
    }

    public CloudGoogleSearchResultPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public CloudGooglePricingCalculatorPage followTheLinkNamed(String linkName) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(By.linkText(linkName)));
        driver.findElement(By.linkText(linkName)).click();
        logger.info("Received search result. Followed the link: " + linkName);
        return new CloudGooglePricingCalculatorPage(driver);
    }
}