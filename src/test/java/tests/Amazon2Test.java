package tests;

import config.DaggerPageComponent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)


@ExtendWith(ScreenshotWatcher.class)
public class Amazon2Test {
//    @RegisterExtension
//    static final ScreenshotWatcher watcher = new ScreenshotWatcher();

    @Test
    public void amazon_search_test2_0() {
        System.out.println("amazon_search_test2_0() start => " + Thread.currentThread().getName());
        DaggerPageComponent.create().amazonHome()
                .open();
        System.out.println("amazon_open_test2_0() stop => " + Thread.currentThread().getName());
    }

    @Test
    public void amazon_open_test2_1() {
        System.out.println("amazon_open_test2_1() start => " + Thread.currentThread().getName());
        DaggerPageComponent.create().amazonHome()
                .open();
        System.out.println("amazon_open_test2_1() stop => " + Thread.currentThread().getName());
    }

    @Test
    public void amazon_open_test2_2() {
        System.out.println("amazon_open_test2_2() start => " + Thread.currentThread().getName());
        DaggerPageComponent.create().amazonHome()
                .open();
        System.out.println("amazon_open_test2_2() stop => " + Thread.currentThread().getName());
    }

}
