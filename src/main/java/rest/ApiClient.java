package rest;


import config.TestConfig;
import kong.unirest.core.GenericType;
import kong.unirest.core.HttpResponse;
import kong.unirest.core.JsonNode;
import kong.unirest.core.Unirest;
import org.aeonbits.owner.ConfigFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rest.models.TodoModel;

import java.util.Map;
import java.util.function.Supplier;

public class ApiClient {
    private final String endpoint;
    private final Map<String, String> headers;
    private final String url;
    protected TestConfig config = ConfigFactory.create(TestConfig.class);
    private HttpResponse response;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public ApiClient(String endpoint) {
        this.endpoint = endpoint;
        this.url = config.restBaseURL() + endpoint;
        headers = Map.of("accept", "application/json",
                "Content-Type", "application/json");
    }

    public void get(Supplier<GenericType> respType) {
        logger.info("get(), {}, {}", endpoint);
        response = Unirest.get(url)
                .headers(headers).asObject(respType.get()).ifFailure(response -> onFailure((HttpResponse<?>) response));
    }


    public void post(Object obj, Class clazz) {
        logger.info("post(), {}, {}", url, obj.toString());
        response = Unirest.post(url).headers(headers).
                body(obj).asObject(clazz).ifFailure(response -> onFailure((HttpResponse<?>) response));
    }

    public void put(Object obj, Class clazz, int id) {
        var urlid = url + "/" + id;
        logger.info("put(), {}, {}", urlid, obj.toString());
        response = Unirest.put(urlid).headers(headers).
                body(obj).asObject(clazz).ifFailure(response -> onFailure((HttpResponse<?>) response));
    }

    public void delete(int id, Class clazz) {
        var urlid = url + "/" + id;
        logger.info("delete(), {}", urlid);
        response = Unirest.delete(urlid).headers(headers).asObject(clazz);
    }

    private void onFailure(HttpResponse<?> response) {
        logger.error("Status code: {}", response.getStatus());
        throw new APIException(String.format("Bad error code %s on %s \nresponse: %s %s",
                response.getStatus(),
                response.getRequestSummary().asString(),
                response.getParsingError(),
                response.getBody()));
    }

    public void printResponse() {
        logger.info("Response: {}, {}", response.getStatus(), response.getRequestSummary().asString());
    }

    public HttpResponse<?> getResponse() {
        return response;
    }
}
