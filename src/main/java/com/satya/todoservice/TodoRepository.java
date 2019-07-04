package com.satya.todoservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("todoRepository")
public interface TodoRepository extends JpaRepository<Todo, Long> {

    public List<Todo> findAll();
}
