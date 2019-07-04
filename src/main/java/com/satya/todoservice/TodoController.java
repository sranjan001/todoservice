package com.satya.todoservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping(value = "/todos", produces = "application/json")
    public Todo[] getAllTodos() {

        return todoService.getTodos();
    }

    @GetMapping
    public String hello() {
        return "hello";
    }

}
