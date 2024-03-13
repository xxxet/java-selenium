package rest.command;

import kong.unirest.core.HttpResponse;
import kong.unirest.core.Unirest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeleteRequest<T> implements Request {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final T obj;
    private final String url;
    private HttpResponse response;


    public DeleteRequest(String url, T obj) {
        this.url = url;
        this.obj = obj;
    }

    @Override
    public void execute() {
        logger.info("delete(), {}, {}", url, obj.toString());
        response = Unirest.delete(url).headers(headers).asObject(obj.getClass());
        printResponse(response);
    }

    public HttpResponse<T> getResponse() {
        return response;
    }
}
