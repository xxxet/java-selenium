package tests;

import kong.unirest.core.HttpResponse;
import kong.unirest.core.JsonNode;
import org.junit.jupiter.api.Test;
import rest.services.TodoService;

public class RestApiTest {

    @Test
    public void getTodos(){
        TodoService todoServ = new TodoService();
        HttpResponse<JsonNode> todos = todoServ.getTodos();
        return;
    }
}
