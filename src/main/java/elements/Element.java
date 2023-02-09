package elements;

import com.google.common.base.Function;
import config.TestConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Optional;
import java.util.regex.Pattern;

public abstract class Element {
    protected TestConfig config = ConfigFactory.create(TestConfig.class);

    protected WebDriver driver;
    protected By locator;

    public Element(By locator, WebDriver driver) {
        this.driver = driver;
        this.locator = locator;
    }

    protected <V> V waitUntil(Function<? super WebDriver, V> condition) {
        return (new WebDriverWait(driver, Duration.ofSeconds(config.timeout()))).until(condition);
    }

    protected <V> V waitUntil(Function<? super WebDriver, V> condition, int timeout) {
        return (new WebDriverWait(driver, Duration.ofSeconds(config.timeout()))).until(condition);
    }

    protected <V> V elementShould(Function<? super WebDriver, V> condition) {
        return waitUntil(condition, config.timeout());
    }


    public static ExpectedCondition<Boolean> attributeToBePresent(final By locator,
                                                                  final String attribute) {
        return driver -> Optional.ofNullable(driver.findElement(locator).getAttribute(attribute)).isPresent();
    }

    public static ExpectedCondition<Boolean> attributeNotBePresent(final By locator,
                                                                   final String attribute) {
        return driver -> driver.findElement(locator).getAttribute(attribute) == null;
    }


    public static ExpectedCondition<Boolean> valueMatchesPattern(final By locator, final Pattern pattern) {
        return new ExpectedCondition<Boolean>() {
            private String currentValue = null;

            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    currentValue = driver.findElement(locator).getAttribute("value");
                    return pattern.matcher(currentValue).find();
                } catch (Exception e) {
                    return false;
                }
            }

            @Override
            public String toString() {
                return String
                        .format("text found by %s to match pattern \"%s\". Current text: \"%s\"",
                                locator, pattern.pattern(), currentValue);
            }
        };

    }

    public static ExpectedCondition<Boolean> valueMatches(final By locator, final String value) {
        return new ExpectedCondition<Boolean>() {
            private String currentValue = null;

            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    currentValue = driver.findElement(locator).getAttribute("value");
                    return value.equals(currentValue);
                } catch (Exception e) {
                    return false;
                }
            }

            @Override
            public String toString() {
                return String.format("text found by %s to match \"%s\". Current text: \"%s\"",
                        locator, value, currentValue);
            }
        };

    }
}
