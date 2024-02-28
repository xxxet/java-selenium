package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:testconfig.properties")
public interface TestConfig extends Config {
    int timeout();

    String browser();

    String restLoginURL();

    String restBaseURL();

    String clientName();

    String clientSecret();

    String clientId();
}
