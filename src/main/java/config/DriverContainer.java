package config;

import dagger.Provides;
import dagger.Module;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

@Module
public class DriverContainer {
    private static DriverContainer instance;

    private final TestConfig config = ConfigFactory.create(TestConfig.class);

    private static WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    @Provides
    public static synchronized WebDriver getInstance() {
        if (instance == null) {
            Runtime.getRuntime().addShutdownHook(new Thread(() -> driver.quit()));
            instance = new DriverContainer();
            instance.createWebDriver();
        }
        return instance.getDriver();
    }

    private void createWebDriver() {
        if (config.browser().equals("chrome")) {
            chromeSetup();
        } else {
            throw new UnsupportedOperationException("Unsupported browser, try chrome");
        }
    }

    private void chromeSetup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }
}
