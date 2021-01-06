package bringItOn.page;

import bringItOn.conditions.CustomConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PasteBinHomePage extends AbstractPage {
    private static final String HOMEPAGE_URL = "https://pastebin.com";

    public PasteBinHomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "postform-text")
    private WebElement codeField;

    @FindBy(xpath = "//select[@id='postform-format']//..//span[@id='select2-postform-format-container']")
    private WebElement syntaxHighlightingDropDownMenu;

    @FindBy(xpath = "//select[@id='postform-expiration']//..//..//span[@id='select2-postform-expiration-container']")
    private WebElement pasteExpirationDropDownMenu;

    @FindBy(id = "postform-name")
    private WebElement nameOrTitleField;

    @FindBy(xpath = "//button[@class='btn -big']")
    private WebElement createNewPasteButton;

    public PasteBinHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(CustomConditions.jQueryAJAXsCompleted());
        return this;
    }

    public PasteBinHomePage pasteCodeFromFile(String filePath) {
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNext()) {
                codeField.sendKeys(scanner.nextLine() + "\n");
            }
        } catch (FileNotFoundException e) {
            System.err.println("File is not found. Please, check filepath.");
        }
        return this;
    }

    public PasteBinHomePage setSyntaxHighLighting(String value) {
        syntaxHighlightingDropDownMenu.click();

        StringBuilder xPath = new StringBuilder();
        xPath.append("//ul[@id='select2-postform-format-results']//..//li[contains(text(),'")
                .append(value.trim()).append("')]");
        driver.findElements(By.xpath(xPath.toString())).get(0).click();
        return this;
    }

    public PasteBinHomePage setPasteExpirationTime(String value) {
        pasteExpirationDropDownMenu.click();

        StringBuilder xPath = new StringBuilder();
        xPath.append("//ul[@id='select2-postform-expiration-results']//..//li[contains(text(),'")
                .append(value.trim()).append("')]");
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
