package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

public class Input extends Element {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Inject
    public Input(WebDriver driver, By locator) {
        super(driver, locator);
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
