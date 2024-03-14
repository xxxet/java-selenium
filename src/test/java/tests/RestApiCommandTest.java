package tests;

import kong.unirest.core.HttpResponse;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rest.command.TodoCommandService;
import rest.models.TodoModel;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RestApiCommandTest {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
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
        var resp = todoServ.putTodo(updatedFirst);
        assertThat(resp.getBody()).usingRecursiveComparison().isEqualTo(updatedFirst);
    }


    @Test
    public void postTodo() {
        var todoServ = new TodoCommandService();
        TodoModel todo = new TodoModel(1, null, "some  text", false);
        var resp = todoServ.postTodo(todo);
        assertThat(resp.getBody()).usingRecursiveComparison().ignoringFields("id").isEqualTo(todo);
    }

    @Test
    public void delete() {
        var todoServ = new TodoCommandService();
        TodoModel todo = new TodoModel(1, 1, "some  text", false);
        HttpResponse<TodoModel> createdTodo = todoServ.postTodo(todo);
        todoServ.deleteTodo(createdTodo.getBody());
    }
}
