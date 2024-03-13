package tests;

import kong.unirest.core.HttpResponse;
import org.junit.jupiter.api.Test;
import rest.command.TodoCommandService;
import rest.models.TodoModel;

import java.util.List;

public class RestApiCommandTest {

    @Test
    public void getTodos() {
        var todoServ = new TodoCommandService();
        var todos = todoServ.getTodos();
        List<String> titles = todos.getBody().stream().map(TodoModel::title).toList();
        for (String title : titles) {
            System.out.println(title);
        }
    }

    @Test
    public void putTodo() {
        var todoServ = new TodoCommandService();
        HttpResponse<List<TodoModel>> todos = todoServ.getTodos();
        var first = todos.getBody().getFirst();
        var updatedFirst = new TodoModel(first.userId(), first.id(), first.title() + "UPD", first.completed());
        todoServ.putTodo(updatedFirst);
    }


    @Test
    public void postTodo() {
        var todoServ = new TodoCommandService();
        TodoModel todo = new TodoModel(1, 1, "some  text", false);
        todoServ.postTodo(todo);
    }

    @Test
    public void delete() {
        var todoServ = new TodoCommandService();
        TodoModel todo = new TodoModel(1, 1, "some  text", false);
        HttpResponse<TodoModel> createdTodo = todoServ.postTodo(todo);
        todoServ.deleteTodo(createdTodo.getBody());
    }
}
