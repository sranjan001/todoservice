package com.satya.todoservice.it;

import com.satya.todoservice.Todo;
import com.satya.todoservice.TodoController;
import com.satya.todoservice.TodoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.get;
import static org.junit.Assert.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class TodoControllerIT {

    @Autowired
    private TodoController todoController;

    public void setup() {
        Todo todo1 = Todo.builder().id(5L).description("first task").build();
        Todo todo2 = Todo.builder().id(6L).description("second task").build();
        Todo todo3 = Todo.builder().id(7L).description("third task").build();

        Todo[] todos = new Todo[]{todo1, todo2, todo3};


    }

   /* @Test
    public void when_get_all_todo_endpoint_called_then_return_all_todos() {

        Todo todo1 = Todo.builder().id(5L).description("first task").build();
        Todo todo2 = Todo.builder().id(6L).description("second task").build();
        Todo todo3 = Todo.builder().id(7L).description("third task").build();

        Todo[] todos = new Todo[]{todo1, todo2, todo3};

        Mockito.when(todoService.getTodos()).thenReturn(todos);

        Todo[] actual = get("/todos").as(Todo[].class);

        for(Todo todo: actual)
            System.out.println(todo);

        assertEquals(todos, actual);

//        given().when().get("/todos")
//                .then()
//                .statusCode(HttpStatus.OK.value())
//                //.log().all()
//                //..contentType(ContentType.JSON)
//               // .body(arrayWithSize(3))
//        .as

    }*/

}
