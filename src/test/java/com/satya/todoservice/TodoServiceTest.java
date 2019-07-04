package com.satya.todoservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(MockitoJUnitRunner.class)
public class TodoServiceTest {

    @InjectMocks
    @Autowired
    private TodoService service;

    @Mock
    private TodoRepository repository;

    @Test
    public void when_request_for_get_all_todos_then_return_todos() {
        Todo todo1 = Todo.builder().id(1L).description("first task").build();
        Todo todo2 = Todo.builder().id(2L).description("second task").build();
        Todo todo3 = Todo.builder().id(3L).description("third task").build();

        List<Todo> todos = new ArrayList<>();
        todos.add(todo1);
        todos.add(todo2);
        todos.add(todo3);

        Mockito.when(repository.findAll()).thenReturn(todos);
        Todo[] actualTodos = service.getTodos();

        assertEquals(todos.toArray(new Todo[0]), actualTodos);
    }
}
