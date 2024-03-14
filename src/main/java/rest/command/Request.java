package rest.command;

import kong.unirest.core.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rest.APIException;

import java.util.Map;

public interface Request {
    Logger logger = LoggerFactory.getLogger(Request.class);

    Map<String, String> headers = Map.of("accept", "application/json",
            "Content-Type", "application/json");

    void execute();


    default void onFailure(HttpResponse<?> response) {
        logger.error("Status code: {}", response.getStatus());
        throw new APIException(String.format("Bad error code %s on %s \nresponse: %s %s",
                response.getStatus(),
                response.getRequestSummary().asString(),
                response.getParsingError(),
                response.getBody()));
    }


    default void printResponse(HttpResponse<?> response) {
        logger.info("Response: {}, {}", response.getStatus(), response.getRequestSummary().asString());
    }

}
