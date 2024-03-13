package rest.command;

import kong.unirest.core.HttpResponse;
import kong.unirest.core.Unirest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PutRequest<T> implements Request {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final T obj;
    private final String url;
    private HttpResponse response;


    public PutRequest(String url, T obj) {
        this.url = url;
        this.obj = obj;
    }

    @Override
    public void execute() {
        logger.info("put(), {}, {}", url, obj.toString());
        response = Unirest.put(url).headers(headers).
                body(obj)
                .asObject(obj.getClass())
                .ifFailure(this::onFailure);
        printResponse(response);
    }

    public HttpResponse<T> getResponse() {
        return response;
    }
}
