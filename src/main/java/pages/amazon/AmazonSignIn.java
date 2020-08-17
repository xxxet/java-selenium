package pages.amazon;

import config.DriverContainer;
import org.openqa.selenium.WebDriver;

public class AmazonSignIn {
    private WebDriver driver;


    {
        driver = DriverContainer.getInstance().getDriver();
    }

}
