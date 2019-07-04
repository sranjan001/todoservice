package com.satya.todoservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository repository;

    public Todo[] getTodos() {

        List<Todo> list = repository.findAll();

        if(list == null || list.size() == 0)
            return new Todo[0];
        else
            return list.toArray(new Todo[0]);
    }
}
