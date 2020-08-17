package pages.slice;

import config.DriverContainer;
import elements.Button;
import org.openqa.selenium.By;
import pages.BasePage;

public class SliceAccountSettings extends BasePage {
    {
        driver = DriverContainer.getInstance().getDriver();
    }

    private Button deactivateAccButton = new Button(By.cssSelector("[class=negative]"), driver);
    private Button confirmDeactivate = new Button(By.xpath("//button[text()='DEACTIVATE ACCOUNT NOW']"), driver);

    public void deactivateAccount(){
        deactivateAccButton.click();
        confirmDeactivate.click();
    }

}
