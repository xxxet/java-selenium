package pages;


import config.DaggerElementComponent;
import config.ElementComponent;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class BasePage {


    protected final ElementComponent.Builder elBuilder;

    {
        elBuilder = DaggerElementComponent.builder();
    }

    protected WebDriver driver;
    protected String savedHandle;


    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void saveHandle() {
        savedHandle = driver.getWindowHandle();
    }

    public void switchToSavedHandle() {
        driver.switchTo().window(savedHandle);
    }

    protected void switchToHandle(String handle) {
        driver.switchTo().window(handle);
    }

    public <T> T openNewTab(Class<T> clazz) {
        saveHandle();

        Set<String> before = driver.getWindowHandles();
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.open()");
        Set<String> after = driver.getWindowHandles();

        after.removeAll(before);
        if (after.size() > 1)
            throw new RuntimeException("Failed to switch tab, more than 1 handles found, " + after);
        String handle = after.iterator().next();
        switchToHandle(handle);

        return createInstance(clazz);
    }

    protected <T> T createInstance(Class<T> clazz) {
        try {
            return clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException("Failed to create instance of " + clazz.getName());
        }

    }
}
