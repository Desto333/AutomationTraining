package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CloudGoogleStartPage extends AbstractPage {
    private static final String GOOGLE_CLOUD_URL = "https://cloud.google.com/";

    public CloudGoogleStartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    final String searchInputXpath = "//input[@name='q']";
    @FindBy(xpath = searchInputXpath)
    private WebElement searchInput;

    @Override
    public CloudGoogleStartPage openPage() {
        driver.navigate().to(GOOGLE_CLOUD_URL);
        logger.info("Opened page " + GOOGLE_CLOUD_URL);
        return this;
    }

    public CloudGoogleSearchResultPage sendSearchRequestFromStartPage(String searchRequest) {
        waitUntilWebElementIsFoundByXpath(searchInputXpath);
        searchInput.click();
        searchInput.sendKeys(searchRequest + Keys.ENTER);
        logger.info("Sent search request: " + searchRequest);
        return new CloudGoogleSearchResultPage(driver);
    }
}