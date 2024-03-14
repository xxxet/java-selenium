package rest.command;

import config.TestConfig;
import kong.unirest.core.GenericType;
import kong.unirest.core.HttpResponse;
import kong.unirest.core.JsonNode;
import org.aeonbits.owner.ConfigFactory;
import rest.models.TodoModel;
import utils.RandStrings;

import java.util.List;

public class TodoCommandService implements Service {
    public static final String ENDPOINT = "/todos";
    protected final TestConfig config = ConfigFactory.create(TestConfig.class);
    private final String url;

    public TodoCommandService() {
        this.url = config.restBaseURL() + ENDPOINT;
    }

    public HttpResponse<List<TodoModel>> getTodos() {
        GetListRequest<List<TodoModel>> getListOfTodos = new GetListRequest<>(url,
                new GenericType<>() {
                });
        getListOfTodos.execute();
        return getListOfTodos.getResponse();
    }

    public HttpResponse<TodoModel> postTodo(TodoModel todo) {
        PostRequest<TodoModel> postR = new PostRequest<>(url, todo);
        postR.execute();
        return postR.getResponse();
    }

    public HttpResponse<TodoModel> getTodo(TodoModel todo) {
        GetRequest<TodoModel> getR = new GetRequest<>(url + "/" + todo.id(), todo);
        return getR.getResponse();
    }

    public HttpResponse<TodoModel> putTodo(TodoModel todo) {
        PutRequest<TodoModel> putR = new PutRequest<>(url + "/" + todo.id(), todo);
        putR.execute();
        return putR.getResponse();
    }

    public HttpResponse<JsonNode> deleteTodo(TodoModel todo) {
        DeleteRequest deleteR = new DeleteRequest(url + "/" + todo.id());
        deleteR.execute();
        return deleteR.getResponse();
    }

    @Override
    public TodoModel createRandom() {
        var todoModel = new TodoModel(1, 1, RandStrings.getRandom(20), false);
        postTodo(todoModel);
        return todoModel;
    }

}
