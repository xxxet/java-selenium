package pages.slice;

import config.DriverContainer;
import elements.Button;
import org.openqa.selenium.By;
import pages.BasePage;
import pages.slice.interfaces.Header;

public class SliceBootstrap extends BasePage implements Header {

    {
        driver = DriverContainer.getInstance().getDriver();
    }

    private SliceHeader header = new SliceHeader();
    private Button continueButton = new Button(By.cssSelector("[class*=continue]"), driver);

    public SliceBootstrap clickContinue() {
        continueButton.click();
        return this;
    }

    public SliceHeader header(){
        return header;
    }


}
