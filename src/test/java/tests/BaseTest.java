package tests;

import org.junit.jupiter.api.extension.RegisterExtension;

public class BaseTest {
    @RegisterExtension
    public  ScreenshotWatcher watcher = new ScreenshotWatcher();
}
