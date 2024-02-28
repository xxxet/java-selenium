package rest;


import config.TestConfig;
import kong.unirest.core.HttpResponse;
import kong.unirest.core.JsonNode;
import kong.unirest.core.Unirest;
import org.aeonbits.owner.ConfigFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.RestAuthorization;

import java.util.HashMap;
import java.util.Map;

public class ApiClient {
    private final String endpoint;
    private final Map<String, String> headers;
    protected TestConfig config = ConfigFactory.create(TestConfig.class);
    private HttpResponse<JsonNode> response;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public ApiClient(String endpoint) {
        this.endpoint = endpoint;
        headers = Map.of("accept", "application/json",
                "Content-Type", "application/json");
    }

    public void get() {
        logger.info("get(), {}, {}", endpoint);
            response = Unirest.get(config.restBaseURL() + endpoint).headers(headers).
                    asJson().ifFailure(response -> onFailure(response));
    }

    protected void put(Object obj) {
        logger.info("put(), {}, {}", endpoint, obj.toString());
    }

    protected void post(Object obj) {
        logger.info("post(), {}, {}", endpoint, obj.toString());
        response = Unirest.post(config.restBaseURL() + endpoint).headers(headers).
                body(obj).asJson().ifFailure(response -> onFailure(response));
    }

    protected void delete() {
        logger.info("delete(), {}, {}", endpoint);
    }

    private void onFailure(HttpResponse<JsonNode> response) {
        logger.error("Status code: {}", response.getStatus());
        throw new APIException(String.format("Bad error code %s on %s \nresponse: %s", response.getStatus(), response.getRequestSummary().asString(), response.getBody().toString()));
    }

    public HttpResponse<JsonNode> getResponse() {
        return response;
    }
}
