package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {
    protected WebDriver driver;
    protected final int WAIT_TIMEOUT_SECONDS = 15;
    protected abstract AbstractPage openPage();
    protected final Logger logger = LogManager.getRootLogger();

    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitUntilWebElementIsFoundByXpath(String xpath) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(driver -> driver.findElement(By.xpath(xpath)));
    }

    public void waitUntilWebElementIsClickable(WebElement element) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(element));
    }
}