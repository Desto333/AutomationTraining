package page;

import conditions.CustomConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PasteBinHomePage extends AbstractPage {
    private static final String HOMEPAGE_URL = "https://pastebin.com";

    public PasteBinHomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "postform-text")
    private WebElement codeField;

    @FindBy(xpath = "//select[@id='postform-expiration']//..//..//span[@id='select2-postform-expiration-container']")
    private WebElement pasteExpirationDropDownMenu;

    @FindBy(xpath = "//ul[@id='select2-postform-expiration-results']//..//li[contains(text(),'10 Minutes')]")
    private WebElement expirationTimeOption;

    @FindBy(id = "postform-name")
    private WebElement nameOrTitleField;

    @FindBy(xpath = "//button[@class='btn -big']")
    private WebElement createNewPasteButton;

    public PasteBinHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(CustomConditions.jQueryAJAXsCompleted());
        return this;
    }

    public PasteBinHomePage pasteCode(String code) {
        codeField.sendKeys(code);
        return this;
    }

    public PasteBinHomePage setPasteExpirationTime(String value) {
        StringBuilder xPath = new StringBuilder();
        xPath.append("//ul[@id='select2-postform-expiration-results']//..//li[contains(text(),'")
                .append(value.trim()).append("')]");
        pasteExpirationDropDownMenu.click();
        driver.findElement(By.xpath(xPath.toString())).click();
        return this;
    }

    public PasteBinHomePage pasteNameOrTitle(String nameOrTitle) {
        nameOrTitleField.sendKeys(nameOrTitle);
        return this;
    }

    public PasteBinResultPage submitInput() {
        createNewPasteButton.click();
        return new PasteBinResultPage(driver);
    }
}
