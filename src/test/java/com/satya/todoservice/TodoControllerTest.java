package com.satya.todoservice;

import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import org.mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class TodoControllerTest {

//    @Autowired
//    private MockMvc mockMvc;

    @LocalServerPort
    private int port;


    @MockBean
    private TodoService todoService;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setup() {
        RestAssured.port = port;
//        RestAssuredMockMvc.webAppContextSetup(webApplicationContext);
    }


    @Test
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

    }

    @Test
    public void testHello() {
        given().when().get("/")
                .then()
                .statusCode(HttpStatus.OK.value());
    }
}
