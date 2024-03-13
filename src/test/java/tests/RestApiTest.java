package tests;

import kong.unirest.core.HttpResponse;
import org.junit.jupiter.api.Test;
import rest.models.TodoModel;
import rest.services.TodoService;
import java.util.List;

public class RestApiTest {

    @Test
    public void getTodos() {
        TodoService todoServ = new TodoService();
        HttpResponse<List<TodoModel>> todos = todoServ.getTodos();
        List<String> titles = todos.getBody().stream()
                .map(TodoModel::title)
                .toList();
        for (String title : titles) {
            System.out.println(title);
        }
    }

    @Test
    public void putTodo() {
        TodoService todoServ = new TodoService();
        HttpResponse<List<TodoModel>> todos = todoServ.getTodos();
        var first = todos.getBody().getFirst();
        var updatedFirst = new TodoModel(first.userId(), first.id(), first.title() + "UPD", first.completed());
        todoServ.putTodo(updatedFirst);
    }


    @Test
    public void postTodo() {
        TodoService todoServ = new TodoService();
        TodoModel todo = new TodoModel(1, 1, "some  text", false);
        todoServ.postTodo(todo);
    }

    @Test
    public void delete() {
        TodoService todoServ = new TodoService();
        TodoModel todo = new TodoModel(1, 1, "some  text", false);
        HttpResponse<TodoModel> createdTodo = todoServ.postTodo(todo);
        todoServ.deleteTodo(createdTodo.getBody());
    }
}
