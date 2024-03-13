package rest.services;

import kong.unirest.core.GenericType;
import kong.unirest.core.HttpResponse;
import rest.ApiClient;
import rest.models.TodoModel;

import java.util.List;

public class TodoService {
    public static final String endpoint = "/todos";
    private final ApiClient apiClient;

    public TodoService() {
        apiClient = new ApiClient(endpoint);
    }

    public HttpResponse<List<TodoModel>> getTodos() {
        apiClient.get(() -> new GenericType<List<TodoModel>>() {
        });
        return (HttpResponse<List<TodoModel>>) apiClient.getResponse();
    }

    public HttpResponse<TodoModel> postTodo(TodoModel todo) {
        apiClient.post(todo, TodoModel.class);
        return (HttpResponse<TodoModel>) apiClient.getResponse();
    }

    public HttpResponse<TodoModel> putTodo(TodoModel todo) {
        apiClient.put(todo, TodoModel.class, todo.id());
        apiClient.printResponse();
        return (HttpResponse<TodoModel>) apiClient.getResponse();
    }

    public HttpResponse<List<TodoModel>> deleteTodo(TodoModel todo) {
        apiClient.delete(todo.id(), TodoModel.class);
        apiClient.printResponse();
        return (HttpResponse<List<TodoModel>>) apiClient.getResponse();
    }
}
