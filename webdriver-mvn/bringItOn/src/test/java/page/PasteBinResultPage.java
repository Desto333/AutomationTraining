package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PasteBinResultPage extends AbstractPage {

    public PasteBinResultPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.titleContains(" - Pastebin.com"));
        return driver.getTitle().replace(" - Pastebin.com", "");
    }

    public String getSyntaxHighlighting() {
        return driver.findElement(By.xpath("//div[@class='left']//a[@class='btn -small h_800']")).getText();
    }

    public String getPastedCode() {
        return driver.findElement(By.tagName("textarea")).getText();
    }

    public String expectedCodeFromFile(String filePath) {
        StringBuilder stringBuilder = new StringBuilder();
        String expectedText = "";
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNext()) {
                stringBuilder.append(scanner.nextLine()).append("\n");
            }
            expectedText = stringBuilder.substring(0, stringBuilder.length() - 1);
        } catch (FileNotFoundException e) {
            System.out.println("File is not found. Please, check filepath.");
        }
        return expectedText;
    }
}
