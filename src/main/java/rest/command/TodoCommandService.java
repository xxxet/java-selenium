package rest.command;

import config.TestConfig;
import kong.unirest.core.GenericType;
import kong.unirest.core.HttpResponse;
import org.aeonbits.owner.ConfigFactory;
import rest.models.TodoModel;

import java.util.List;

public class TodoCommandService {
    public static final String ENDPOINT = "/todos";
    protected final TestConfig config = ConfigFactory.create(TestConfig.class);
    private final String url;

    public TodoCommandService() {
        this.url = config.restBaseURL() + ENDPOINT;
    }

    public HttpResponse<List<TodoModel>> getTodos() {
        var getListOfTodos = new GetListRequest(url, () -> new GenericType<List<TodoModel>>() {
        });
        getListOfTodos.execute();
        return (HttpResponse<List<TodoModel>>) getListOfTodos.getResponse();
    }

    public HttpResponse<TodoModel> postTodo(TodoModel todo) {
        var postR = new PostRequest<>(url, todo);
        postR.execute();
        return postR.getResponse();
    }

    public HttpResponse<TodoModel> getTodo(TodoModel todo) {
        var getR = new GetRequest<>(url + "/" + todo.id(), todo);
        return getR.getResponse();
    }

    public HttpResponse<TodoModel> putTodo(TodoModel todo) {
        var putR = new PutRequest<>(url + "/" + todo.id(), todo);
        putR.execute();
        return putR.getResponse();
    }

    public HttpResponse<TodoModel> deleteTodo(TodoModel todo) {
        var deleteR = new DeleteRequest<>(url, todo);
        deleteR.execute();
        return deleteR.getResponse();
    }
}
