package rest.command;

import kong.unirest.core.HttpResponse;
import kong.unirest.core.JsonNode;
import kong.unirest.core.Unirest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeleteRequest implements Request {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final String url;
    private HttpResponse<JsonNode> response;


    public DeleteRequest(String url) {
        this.url = url;
    }

    @Override
    public void execute() {
        logger.info("delete(), {}", url);
        response = Unirest.delete(url).headers(headers).asJson();
        printResponse(response);
    }

    public HttpResponse<JsonNode> getResponse() {
        return response;
    }
}
