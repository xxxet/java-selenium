package config;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverContainer {
    private static DriverContainer instance;

    private TestConfig config = ConfigFactory.create(TestConfig.class);

    private static WebDriver driver;


    public  WebDriver getDriver() {
        return driver;
    }

    public static synchronized DriverContainer getInstance() {
        if (instance == null) {
            Runtime.getRuntime().addShutdownHook(new Thread() {
                public void run() { driver.close(); }
            });

            instance = new DriverContainer();
            instance.createWebDriver();
        }
        return instance;
    }

    private void createWebDriver() {
        switch (config.browser()) {
            case "chrome":
                chromeSetup();
                break;

            default:
                throw new UnsupportedOperationException("Unsupported browser, try chrome");

        }
    }

    private void chromeSetup() {
        ChromeDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }

}
