package rest.command;

import kong.unirest.core.HttpResponse;
import kong.unirest.core.Unirest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetRequest<T> implements Request {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final T respType;
    private final String url;
    private HttpResponse response;


    public GetRequest(String url, T respType) {
        this.url = url;
        this.respType = respType;
    }

    @Override
    public void execute() {
        logger.info("GET, {}", url);
        response = Unirest.get(url)
                .headers(headers)
                .asObject(respType.getClass())
                .ifFailure(this::onFailure);
        printResponse(response);
    }

    public HttpResponse<T> getResponse() {
        return response;
    }
}
