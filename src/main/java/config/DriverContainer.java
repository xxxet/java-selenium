package config;

import dagger.Module;
import dagger.Provides;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

@Module
public class DriverContainer {
    private WebDriver driver;
    {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> driver.quit()));
    }

    private final TestConfig config = ConfigFactory.create(TestConfig.class);


    public WebDriver getDriver() {
        return driver;
    }

    @Provides
    public static WebDriver getInstance() {
        return _threadLocal.get().getDriver();
    }


    private static final ThreadLocal<DriverContainer> _threadLocal =
            ThreadLocal.withInitial(() -> {
                var dc = new DriverContainer();
                dc.createWebDriver();
                return dc;
            });


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
