package rest.command;

import kong.unirest.core.GenericType;
import kong.unirest.core.HttpResponse;
import kong.unirest.core.Unirest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetListRequest<T> implements Request {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final String url;
    private final GenericType<T> respType;
    private HttpResponse<T> response;


    public GetListRequest(String url, GenericType<T> respType) {
        this.url = url;
        this.respType = respType;
    }

    @Override
    public void execute() {
        logger.info("get(), {}", url);
        response = Unirest.get(url)
                .headers(headers)
                .asObject(respType)
                .ifFailure(this::onFailure);
        printResponse(response);
    }

    public HttpResponse<T> getResponse() {
        return response;
    }
}
