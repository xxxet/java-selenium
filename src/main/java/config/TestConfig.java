package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:testconfig.properties")
public interface TestConfig extends Config {
    int timeout();

    String browser();
}
