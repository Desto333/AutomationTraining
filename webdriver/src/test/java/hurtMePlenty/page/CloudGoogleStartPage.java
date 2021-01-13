package hurtMePlenty.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CloudGoogleStartPage extends AbstractPage {
    private static final String HOMEPAGE_URL = "https://cloud.google.com/";

    public CloudGoogleStartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@name='q']")
    private WebElement searchInput;

    public CloudGoogleStartPage openStartPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public CloudGoogleSearchResultPage sendSearchRequestFromStartPage(String searchRequest) {
        searchInput.click();
        searchInput.sendKeys(searchRequest + Keys.ENTER);
        return new CloudGoogleSearchResultPage(driver);
    }
}
