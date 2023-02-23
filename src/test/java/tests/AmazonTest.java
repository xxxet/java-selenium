package tests;

import config.DaggerPageComponent;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AmazonTest {


    @Test
    public void amazon_search_0() {
        System.out.println("amazon_search_0() start => " + Thread.currentThread().getName());
        DaggerPageComponent.create().amazonHome()
                .open();
        System.out.println("amazon_open_0() stop => " + Thread.currentThread().getName());
    }

    @Test
    public void amazon_open_1() {
        System.out.println("amazon_open_1() start => " + Thread.currentThread().getName());
        DaggerPageComponent.create().amazonHome()
                .open();
        System.out.println("amazon_open_1() stop => " + Thread.currentThread().getName());
    }

    @Test
    public void amazon_open_2() {
        System.out.println("amazon_open_2() start => " + Thread.currentThread().getName());
        DaggerPageComponent.create().amazonHome()
                .open();
        System.out.println("amazon_open_2() stop => " + Thread.currentThread().getName());
    }

    @Test
    public void amazon_open_3() {
        System.out.println("amazon_open_3() start => " + Thread.currentThread().getName());
        DaggerPageComponent.create().amazonHome()
                .open();
        System.out.println("amazon_open_3() stop => " + Thread.currentThread().getName());
    }

    @Test
    public void amazon_open_4() {
        System.out.println("amazon_open_4() start => " + Thread.currentThread().getName());
        DaggerPageComponent.create().amazonHome()
                .open();
        System.out.println("amazon_open_4() stop => " + Thread.currentThread().getName());
    }
}
