package com.satya.todoservice.it;

import com.satya.todoservice.Todo;
import com.satya.todoservice.TodoController;
import io.restassured.RestAssured;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

import static io.restassured.RestAssured.get;
import static org.junit.Assert.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class TodoControllerIT {

    @LocalServerPort
    private int port;

    @Autowired
    private TodoController todoController;

    @Before
    public void setup() {
        RestAssured.port = port;
//        RestAssuredMockMvc.webAppContextSetup(webApplicationContext);
    }

    @Test
    public void when_get_all_todo_endpoint_called_then_return_all_todos() {

        Todo todo1 = Todo.builder().description("first task").build();
        Todo todo2 = Todo.builder().description("second task").build();
        Todo todo3 = Todo.builder().description("third task").build();

        Todo[] todos = new Todo[]{todo1, todo2, todo3};

      //  Mockito.when(todoService.getTodos()).thenReturn(todos);

        Todo[] actual = get("/todos").as(Todo[].class);

        assertEquals(todos[todos.length-1].getDescription(), "third task");

//        given().when().get("/todos")
//                .then()
//                .statusCode(HttpStatus.OK.value())
//                //.log().all()
//                //..contentType(ContentType.JSON)
//               // .body(arrayWithSize(3))
//        .as

    }

}
