package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.CloudGoogleStartPage;
import page.TenMinuteMailPage;

public class PagesAvailabilityTest extends CommonConditions{

    @Test
    public void checkAllPagesAvailable() {
        new CloudGoogleStartPage(driver).openPage();
        Assert.assertEquals(driver.getTitle(), "Cloud Computing Services  |  Google Cloud");
        new TenMinuteMailPage(driver).openPage();
        Assert.assertEquals(driver.getTitle(), "10 Minute Mail - Free Anonymous Temporary email " +
                "- 10 Minute Mail - Free Anonymous Temporary email");
    }
}
