package pages.amazon;

import config.DriverContainer;
import elements.Button;
import elements.Input;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class Amazon {
    {//upd
        driver = DriverContainer.getInstance().getDriver();
    }

    private WebDriver driver;
    private Input searchInput = new Input(By.id("twotabsearchtextbox"), driver);
    private Button signInBtn = new Button(By.xpath("//*[contains(text(), 'Sign in to see')]"), driver);
    private Button submitButton = new Button(By.cssSelector("[type=submit]"), driver);
    private Button checkoutButton = new Button(By.cssSelector("#type"), driver);
    private Button firstItemBtn = new Button(By.cssSelector("[cel_widget_id*=SEARCH_RESULTS] div[class*='sg-col']"), driver);
    private Button buyNowBtn = new Button(By.cssSelector("#one-click-button"), driver);
    private Input ebookTitleInput = new Input(By.cssSelector("[id*=productTitle]"), driver);


    public Amazon open() {
        driver.get("https://www.amazon.com");
        signInBtn.waitForAppears();
        return this;
    }

    public Amazon search(String item) {
        searchInput.enter(item);
        searchInput.waitUntilMatches(item);
        submitButton.click();
        return this;
    }

    public Amazon selectFirstItem() {
        firstItemBtn.click();
        return this;
    }

    public Amazon buyNowBtn() {
        buyNowBtn.click();
        return this;
    }

    public String getTitle() {
        return ebookTitleInput.getText();

    }
}
