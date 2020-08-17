package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

public class Button extends Element {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public Button(By selector, WebDriver driver) {
        super(selector, driver);
    }

    public void click() {
        logger.info("click(),  locator: {}", locator);
        elementShould(ExpectedConditions.visibilityOfElementLocated(locator))
                .click();
    }

    public void clickExists() {
        logger.info("clickExists(),  locator: {}", locator);
        elementShould(ExpectedConditions.presenceOfElementLocated(locator))
                .click();
    }

    public void waitForDisappear() {
        logger.info("waitForDisappear(),  locator: {}", locator);
        waitUntil(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public void waitForAppears() {
        logger.info("waitForDisappear(),  locator: {}", locator);
        waitUntil(ExpectedConditions.elementToBeClickable(locator));
    }


    public void waitForAttributeNotPresent(String attr) {
        logger.info("waitForAttributeNotPresent(),  locator: {}", locator);
        waitUntil(attributeNotBePresent(locator, attr));
    }

    public void waitForAttribute(String attr) {
        logger.info("waitForAttribute(),  locator: {}", locator);
        waitUntil(attributeToBePresent(locator, attr));
    }

    public void clickOnVisible() {
        logger.info("clickOnVisible(),  locator: {}", locator);
        List<WebElement> elements = driver.findElements(locator);
        elements.removeIf(it -> it.isDisplayed() == false);
        elements.get(0).click();
    }
}
