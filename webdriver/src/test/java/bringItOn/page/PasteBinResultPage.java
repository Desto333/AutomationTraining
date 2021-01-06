package bringItOn.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PasteBinResultPage extends AbstractPage {

    public PasteBinResultPage(WebDriver driver) {
        super(driver);
    }

    public PasteBinResultPage checkPageTitle(String expectedResultPageTitle) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.titleContains(" - Pastebin.com"));
        String actualResultPageTitle = driver.getTitle().replace(" - Pastebin.com", "");
        Assert.assertEquals(actualResultPageTitle, expectedResultPageTitle);
        return this;
    }

    public PasteBinResultPage checkSyntaxHighlighting(String expectedSyntaxHighlighting) {
        String actualSyntaxHighlighting = driver
                .findElement(By.xpath("//div[@class='left']//a[@class='btn -small h_800']")).getText();
        Assert.assertEquals(actualSyntaxHighlighting, expectedSyntaxHighlighting);
        return this;
    }

    public void checkPastedCode(String filePath) {
        String actualText = driver.findElement(By.tagName("textarea")).getText();
        StringBuilder stringBuilder = new StringBuilder();

        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNext()) {
                stringBuilder.append(scanner.nextLine()).append("\n");
            }
            String expectedText = stringBuilder.substring(0, stringBuilder.length() - 1);
            Assert.assertEquals(actualText, expectedText);
        } catch (FileNotFoundException e) {
            System.out.println("File is not found. Please, check filepath.");
        }
    }
}
