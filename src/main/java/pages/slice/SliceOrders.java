package pages.slice;

import config.DriverContainer;
import elements.Input;
import org.openqa.selenium.By;
import pages.BasePage;
import pages.slice.interfaces.Header;

public class SliceOrders extends BasePage implements Header {
    {
        driver = DriverContainer.getInstance().getDriver();
    }
    private SliceHeader header = new SliceHeader();
    private Input merchantTitle = new Input(By.cssSelector("[class=merchant]"), driver);
    private Input statusTitle = new Input(By.cssSelector("[class=statusMain]"), driver);
    private Input descriptionTitle = new Input(By.cssSelector("[class=items]"), driver);


    public String getMerchant() {
        return merchantTitle.getText();
    }

    public String getStatus() {
        return statusTitle.getText();
    }

    public String getDescription() {
        return descriptionTitle.getText();
    }

    public SliceHeader header(){
        return header;
    }

}
