package utils;


import config.TestConfig;
import kong.unirest.core.Unirest;
import org.aeonbits.owner.ConfigFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class RestAuthorization {
    private static RestAuthorization restAuth = null;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    protected final TestConfig config = ConfigFactory.create(TestConfig.class);
    private String authToken;

    public static RestAuthorization getRestAuth() {
        if (restAuth == null) {
            restAuth = new RestAuthorization();
            restAuth.generateApiAuthToken();
        }
        return restAuth;
    }

    public void generateApiAuthToken() {
        authToken = Unirest.post(config.restLoginURL())
                .header("Content-Type", "application/json")
                .body(Map.of("clientName", config.clientName(), "clientId", config.clientId(),
                        "clientSecret", config.clientSecret()))
                .asJson().getBody().getObject().getString("accessToken");
        logger.info("generateAuthToken(),  authtoken: {}", authToken);
    }


    public String getAuthToken() {
        return authToken;
    }
}
