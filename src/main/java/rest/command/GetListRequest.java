package rest.command;

import kong.unirest.core.GenericType;
import kong.unirest.core.HttpResponse;
import kong.unirest.core.Unirest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.function.Supplier;

public class GetListRequest implements Request {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final String url;
    private final GenericType<List> respType;
    private HttpResponse response;


    public GetListRequest(String url, Supplier<GenericType> respType) {
        this.url = url;
        this.respType = respType.get();
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

    public HttpResponse getResponse() {
        return response;
    }
}
