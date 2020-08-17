package pages.slice;

import config.DriverContainer;
import elements.Button;
import org.openqa.selenium.By;
import pages.BasePage;

public class SliceHeader extends BasePage {
    {
        driver = DriverContainer.getInstance().getDriver();
    }

    private Button userSettings = new Button(By.linkText("SETTINGS"), driver);
    private Button ordersTab = new Button(By.cssSelector("[class=tabs] > [class*=orders]"), driver);


    public SliceOrders openOrders() {
        ordersTab.click();
        return createInstance(SliceOrders.class);
    }

    public SliceAccountSettings openSettings() {
        userSettings.click();
        return createInstance(SliceAccountSettings.class);
    }

}
