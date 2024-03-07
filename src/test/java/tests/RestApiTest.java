package tests;

import kong.unirest.core.*;

import org.junit.jupiter.api.Test;
import rest.models.TodoModel;
import rest.services.TodoService;

import java.util.List;
import java.util.stream.Collectors;

public class RestApiTest {

    @Test
    public void getTodos() {
//        Unirest.config().setObjectMapper(new JacksonObjectMapper());
//        Unirest.config().setObjectMapper(new ObjectMapper() {
//            com.fasterxml.jackson.databind.ObjectMapper mapper
//                    = new com.fasterxml.jackson.databind.ObjectMapper();
//
//            public String writeValue(Object value) {
//                try {
//                    return mapper.writeValueAsString(value);
//                } catch (JsonProcessingException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//
//            public <T> T readValue(String value, Class<T> valueType) {
//                try {
//                    return mapper.readValue(value, valueType);
//                } catch (JsonProcessingException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        });
        TodoService todoServ = new TodoService();
        HttpResponse<List<TodoModel>> todos = todoServ.getTodos();
        List<String> titles = todos.getBody().stream().map(it -> it.getTitle())
                .collect(Collectors.toList());
        for (String title : titles) {
            System.out.println(title);
        }


        return;
    }

    @Test
    public void putTodo() {
        TodoService todoServ = new TodoService();
        HttpResponse<List<TodoModel>> todos = todoServ.getTodos();
        var first = todos.getBody().get(0);
        first.setTitle(first.getTitle() + "UPD");
        todoServ.putTodo(first);
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
        HttpResponse<TodoModel> createdTodo =  todoServ.postTodo(todo);
        todoServ.deleteTodo(createdTodo.getBody());
    }
}
