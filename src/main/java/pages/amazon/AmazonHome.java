package pages.amazon;

import elements.Button;
import elements.Input;
import org.openqa.selenium.By;
import pages.BasePage;

public class AmazonHome extends BasePage {

    private final Input searchInput = new Input(By.id("twotabsearchtextbox"));
    private final Button signInBtn = new Button(By.xpath("//*[contains(text(), 'Hello, sign in')]"));
    private final Button submitButton = new Button(By.cssSelector("[type=submit]"));




    public AmazonHome open() {
        driver.get("https://www.amazon.com");
        signInBtn.waitForAppears();
        return this;
    }

    public AmazonResults search(String item) {
        searchInput.enter(item);
        searchInput.waitUntilMatches(item);
        submitButton.click();
        return new AmazonResults();
//        return DaggerDriverComponent.create().buildAmazonResults();
    }
}

