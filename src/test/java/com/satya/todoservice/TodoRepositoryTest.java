package com.satya.todoservice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.fail;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TodoRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private TodoRepository todoRepository;

    private Todo[] todos;

    @Before
    public void setup() {
        Todo todo1 = Todo.builder().id(1L).description("First task").build();
        Todo todo2 = Todo.builder().id(2L).description("First task").build();
        Todo todo3 = Todo.builder().id(3L).description("First task").build();
        Todo todo4 = Todo.builder().id(4L).description("First task").build();
        Todo todo5 = Todo.builder().id(5L).description("First task").build();

        todos = new Todo[]{todo1, todo2, todo3, todo4, todo5};

        testEntityManager.persist(todo1);
        testEntityManager.persist(todo2);
        testEntityManager.persist(todo3);
        testEntityManager.persist(todo4);
        testEntityManager.persist(todo5);

    }

    @Test
    public void when_get_all_then_return_all_todos() {
        List<Todo> actualTodos = todoRepository.findAll();

        Assert.assertEquals(5, actualTodos.size());
        Assert.assertEquals(todos, actualTodos.toArray(new Todo[0]));
    }
}
