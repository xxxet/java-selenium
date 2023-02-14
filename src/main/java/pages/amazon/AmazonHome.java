package pages.amazon;

import elements.Button;
import elements.Input;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

import javax.inject.Inject;

public class AmazonHome extends BasePage {

    private final Input searchInput = elBuilder.locator(By.id("twotabsearchtextbox")).build().buildInput();
    private final Button signInBtn = elBuilder.locator(By.xpath("//*[contains(text(), 'Hello, sign in')]")).build().buildButton();
    private final Button submitButton = elBuilder.locator(By.cssSelector("[type=submit]")).build().buildButton();

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
        return new AmazonResults(driver);
    }
}

