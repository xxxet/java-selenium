package rest.services;

import kong.unirest.core.HttpResponse;
import kong.unirest.core.JsonNode;
import rest.ApiClient;

public class TodoService {
    public static final String endpoint = "/todos";
    private final ApiClient apiClient;

    public TodoService(){
        apiClient = new ApiClient(endpoint);
    }

    public HttpResponse<JsonNode> getTodos(){
        apiClient.get();
        return apiClient.getResponse();
    }
}
