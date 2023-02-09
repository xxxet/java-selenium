package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Input extends Element {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public Input(By selector, WebDriver driver) {
        super(selector, driver);
    }

    public void enter(String text) {
        logger.info("enter(),  locator: {}, enter {}", locator, text);
        elementShould(ExpectedConditions.elementToBeClickable(locator))
                .sendKeys(text);
    }

    public String getText() {
        logger.info("getText(),  locator: {}", locator);
        return elementShould(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }

    public void waitUntilMatches(String value) {
        logger.info("waitUntilMatches() value: {},  locator: {}", locator, value);
        waitUntil(valueMatches(locator, value), config.timeout());
    }

}
