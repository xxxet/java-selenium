package pages.amazon;

import config.DaggerPageComponent;
import elements.Button;
import elements.Input;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

import javax.inject.Inject;

public class AmazonHome extends BasePage {

    private final Input searchInput = elBuilder.locator(By.id("twotabsearchtextbox")).build().input();
    private final Button signInBtn = elBuilder.locator(By.xpath("//*[contains(text(), '12Hello, sign in')]")).build().button();
    private final Button submitButton = elBuilder.locator(By.cssSelector("[type=submit]")).build().button();

    @Inject
    public AmazonHome(WebDriver driver) {
        super(driver);
    }


    public AmazonHome open() {
        driver.get("https://www.amazon.com");
        signInBtn.waitForAppears();
        return this;
    }

    public AmazonResults search(String item) {
        searchInput.enter(item);
        searchInput.waitUntilMatches(item);
        submitButton.click();
        return DaggerPageComponent.create().amazonResults();
    }
}

